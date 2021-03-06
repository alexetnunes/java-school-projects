/*
* HuffmanDemo
* Alex Nunes
* 04/11/2014
* Dalhousie University
* Faculty of Computer Science
*
* Demo Class to show the Huffman encoding
* and decoding algorithm
* 
* Uses '0' as hold character
*/
import java.io.*;
import java.util.*;
public class HuffmanDemo {
	public static void main(String[] args) throws IOException {
		//Declare scanner
		Scanner kbd = new Scanner(System.in);

		//take in file and declare variables
		System.out.print("Enter the filename to read from: ");
		String filename = kbd.nextLine();
		File file = new File(filename);
		Scanner inputFile = new Scanner(file);
		String line, word;
		StringTokenizer token;
		ArrayList<Pair> characters = new ArrayList<Pair>();
		ArrayList<Pair> chars = new ArrayList<Pair>();

		/*
		 * Take in a can count each non-whitespace character
		 * by adding them to an ArrayList<Pair> increasing its
		 * own count and the total count across all Pairs
		 */
		while (inputFile.hasNext())
		{
			line = inputFile.nextLine();
			token = new StringTokenizer(line, "\t");
			while (token.hasMoreTokens())
			{
				word = token.nextToken().replaceAll("\\s","");
				for(int i = 0; i < word.length(); i++){
					Pair p = new Pair(word.charAt(i));
					if(!characters.contains(p)){
						characters.add(p);
					}
					characters.get(characters.indexOf(p)).addCount();
					characters.get(characters.indexOf(p)).addTotal();
				}
			}
		}
		inputFile.close();

		// Iterate and calculate the probability for each Pair character
		for(int h = 0; h < characters.size(); h++){
			double probability = characters.get(h).calcProbability();
			characters.get(h).setProbability(probability);
		}


		// Declare BinaryTree<Pair> ArrayLists S and T
		ArrayList<BinaryTree<Pair>> S = new ArrayList<BinaryTree<Pair>>();
		ArrayList<BinaryTree<Pair>> T = new ArrayList<BinaryTree<Pair>>();


		/*
		 * Place all characters into a BinaryTree ArrayList
		 * Ordered smallest to largest for debugging purposes
		 */
		for(int i = characters.size(); i > 0; i--){
			Pair temp = characters.remove(smallestIndex(characters));
			BinaryTree<Pair> newBTPair = new BinaryTree<Pair>();
			newBTPair.makeRoot(temp);
			S.add(newBTPair);
			chars.add(temp);
		}


		/*
		 * Find the two smallest probabilities between S and T
		 * and create a small binary tree with combined probability
		 * in the parent then place back in to  T
		 */
		BinaryTree<Pair> sm1, sm2;
		BinaryTree<Pair> a, root = null;
		Pair p;
		while(!S.isEmpty()){
			sm1=smallestOfTwoTrees(S,T);
			sm2=smallestOfTwoTrees(S,T);
			p = new Pair('0');
			a= new BinaryTree<Pair>();
			if(sm1 != null && sm2  != null){
				p.setProbability(sm1.getData().getProbability()+sm2.getData().getProbability());
				a.makeRoot(p);
				a.attachLeft(sm1);
				a.attachRight(sm2);

			}
			if(a != null){
				T.add(a);
				root = a;
			}

		}
		
		/*
		 * Reduce T to one Node to create the root of the Huffman tree
		 */
		while(T.size() > 1){
			sm1=smallestOfTwoTrees(S,T);
			sm2=smallestOfTwoTrees(S,T);
			p = new Pair('0');
			a= new BinaryTree<Pair>();
			if(sm1 != null && sm2  != null){
				p.setProbability(sm1.getData().getProbability()+sm2.getData().getProbability());
				a.makeRoot(p);
				a.attachLeft(sm1);
				a.attachRight(sm2);

			}
			if(a != null){
				T.add(a);
				root = a;
			}

		}

		root.getData().setProbability(1);
		
		//Find encoding and print the table to file
		String[] encoding = findEncoding(root);
		BufferedWriter writer = null;
		File logFile = new File("Huffman.txt");
		writer = new BufferedWriter(new FileWriter(logFile));
		String output = String.format("%-16s%-16s%-16s","Symbol","Probability", "Huffman Code");
		writer.write(output);
		for(int i = 0 ;  i <  chars.size(); i++){
			String rowOutput = String.format("\n%-16s%-16s%-16s",chars.get(i).getValue(),chars.get(i).getProbability(), encoding[(byte)chars.get(i).getValue()]);
			writer.write(rowOutput);
		}
		writer.close();

		System.out.println("Huffman encoding determined.");

		//Encode the inputed text file and write to file
		writer = null;
		logFile = new File("Encoded.txt");
		writer = new BufferedWriter(new FileWriter(logFile));
		file = new File(filename);
		inputFile = new Scanner(file);


		while (inputFile.hasNext())
		{
			line = inputFile.nextLine();
			token = new StringTokenizer(line, "\t");
			while (token.hasMoreTokens())
			{
				word = token.nextToken();
				String encode ="";
				for(int i = 0; i < word.length(); i++){
					if(encoding[(byte)word.charAt(i)]!=null)
						encode  += encoding[(byte)word.charAt(i)];
					else
						encode +="\t";
				}
				writer.write(encode);


			}
			writer.write("\n");
		}
		inputFile.close();
		writer.close();

		System.out.println("Text encoded.");

		//Decode the inputed text file using the huffman tree and write to file
		writer = null;
		logFile = new File("Decoded.txt");
		writer = new BufferedWriter(new FileWriter(logFile));
		file = new File("Encoded.txt");
		inputFile = new Scanner(file);
		String section;


		while (inputFile.hasNext())
		{
			line = inputFile.nextLine();
			token = new StringTokenizer(line, "\t");
			while (token.hasMoreTokens())
			{
				section = token.nextToken();
				String decode ="";
				BinaryTree<Pair> curr = root;
				for(int i = 0; i < section.length(); i++){

					if(section.charAt(i) == '0'){
						curr = curr.getLeft();
					}else if(section.charAt(i) == '1') {
						curr = curr.getRight();
					}

					if(curr.getData().getValue()!='0'){
						decode += curr.getData().getValue();
						curr = root;
					}
				}
				decode +=" ";
				writer.write(decode);


			}
			writer.write("\n");
		}
		inputFile.close();
		writer.close();
		System.out.println("Text decoded.");
	}


	/*
	 * Helper method to determine the smallest probability between two ArrayList<BinaryTree<pair>>
	 */
	public static BinaryTree<Pair> smallestOfTwoTrees(ArrayList<BinaryTree<Pair>> list1, ArrayList<BinaryTree<Pair>> list2){
		BinaryTree<Pair> smallest = null;
		if(!list1.isEmpty() && !list2.isEmpty()){
			BinaryTree<Pair> small1 = list1.get(BTPairSmallestIndex(list1));
			BinaryTree<Pair> small2 = list2.get(BTPairSmallestIndex(list2));
			if(small1.getData().getProbability() <= small2.getData().getProbability()){
				smallest=list1.remove(BTPairSmallestIndex(list1));;
			}else{
				smallest=list2.remove(BTPairSmallestIndex(list2));
			}
		}else if(list2.isEmpty() && !list1.isEmpty()){
			smallest = list1.remove(BTPairSmallestIndex(list1));
		}else if(list1.isEmpty() && !list2.isEmpty()){
			smallest = list2.remove(BTPairSmallestIndex(list2));
		}else{
			return null;
		}
		return smallest;
	}


	/*
	 * Helper method to find the index of the smallest probability
	 * in an ArrayList<BinaryTree<Pair>>
	 */
	public static int BTPairSmallestIndex(ArrayList<BinaryTree<Pair>> list){
		int smallest = 0;
		BinaryTree<Pair> smallestBT = list.get(0);
		for(int i = 1; i < list.size(); i++){
			if(list.get(i).getData().getProbability() < smallestBT.getData().getProbability()){
				smallest = i;
				smallestBT = list.get(i);
			}
		}

		return smallest;
	}
	/*
	 * Helper method to find the smallest probability in
	 * an ArrayList of Pairs
	 */
	public static int smallestIndex(ArrayList<Pair> list){
		int smallest = 0;
		Pair smallestPair = list.get(0);
		for(int i = 1; i < list.size(); i++){
			if(list.get(i).getProbability() < smallestPair.getProbability()){
				smallest = i;
				smallestPair = list.get(smallest);
			}
		}

		return smallest;
	}

	/*
	 * Huffman encoding methods
	 */
	public static void findEncoding(BinaryTree<Pair> t, String[] a, String prefix) {
		if (t.getLeft()==null&& t.getRight()==null)
		{
			a[(byte)(t.getData().getValue())] = prefix;
		} else {
			findEncoding(t.getLeft(), a, prefix+"0");
			findEncoding(t.getRight(), a, prefix+"1");
		}
	}

	public static String[] findEncoding(BinaryTree<Pair> t) {
		String[] result = new String[256]; findEncoding(t, result, "");
		return result;
	}

}
