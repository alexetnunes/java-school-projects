import java.io.*;
import java.util.*;
public class HuffmanDemo {
	public static void main(String[] args) throws IOException {
		//Declare scanner
		Scanner kbd = new Scanner(System.in);

		//take in file
		System.out.print("Enter the filename to read from: ");
		String filename = kbd.nextLine();
		File file = new File(filename);
		Scanner inputFile = new Scanner(file);
		String line, word;
		StringTokenizer token;
		ArrayList<Pair> characters = new ArrayList<Pair>();
		
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
		
		for(int h = 0; h < characters.size(); h++){
			double probability = characters.get(h).calcProbability();
			characters.get(h).setProbability(probability);
		}

		
		
		ArrayList<BinaryTree<Pair>> S = new ArrayList<BinaryTree<Pair>>();
		
		for(int i = characters.size(); i > 0; i--){
			Pair temp = characters.remove(smallestIndex(characters));
			BinaryTree<Pair> newBTPair = new BinaryTree<Pair>();
			newBTPair.makeRoot(temp);
			S.add(newBTPair);
		}
		
		double sum = 0;
		
		for(int i=0; i< S.size(); i++){
			System.out.println(i+" " + S.get(i).getData());
		}
			
		ArrayList<BinaryTree<Pair>> T = new ArrayList<BinaryTree<Pair>>();
		
		
		while(S.size() > 0){
			BinaryTree<Pair> sm1, sm2;
			sm1=smallestOfTwoTrees(S,T);
			sm2=smallestOfTwoTrees(S,T);
			
			if(sm1 != null && sm2  != null){
				Pair p = new Pair();
				p.setLetter(' ');
				p.setProbability(sm1.getData().getProbability()+sm2.getData().getProbability());
			}
			
		}
		
		for(int i=0; i< S.size(); i++){
			System.out.println(S.get(i).getData());

		}
		
		for(int i=0; i< T.size(); i++){
			System.out.println(T.get(i).getData());

		}
		
		
		
	}
	
	
	/*
	 * 
	 */
	public static BinaryTree<Pair> smallestOfTwoTrees(ArrayList<BinaryTree<Pair>> list1, ArrayList<BinaryTree<Pair>> list2){
		BinaryTree<Pair> smallest = null;
		if(list1.isEmpty() && list2.isEmpty()){
			return null;
		}else if(list2.isEmpty() && !list1.isEmpty()){
			smallest = list1.remove(BTPairSmallestIndex(list1));
		}else if(list1.isEmpty() && !list2.isEmpty()){
			smallest = list2.remove(BTPairSmallestIndex(list2));
		}else{
			BinaryTree<Pair> small1 = list1.remove(BTPairSmallestIndex(list1));
			BinaryTree<Pair> small2 = list2.remove(BTPairSmallestIndex(list2));
			if(small1.getData().getProbability() < small2.getData().getProbability()){
				smallest=small1;
			}else{
				smallest=small2;
			}
		}
		return smallest;
	}
	
	
	/*
	 * 
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
	 * 
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
}
