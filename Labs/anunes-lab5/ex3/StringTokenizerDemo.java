/*
* StringTokenizerDemo Class
* Alex Nunes
* 07/10/2014
* Dalhousie University
* Faculty of Computer Science
*
* Demonstrates a sorted insert function for
* reading words from a file and produces a
* count of characters, words, and lines
*/
import java.util.*;
import java.io.*;
public class StringTokenizerDemo {
	public static void main(String[] args) throws IOException {

		//Declare scanner
		Scanner kbd = new Scanner(System.in);

		//take in file
		System.out.print("Enter the filename to read from: ");
		String filename = kbd.nextLine();
		File file = new File(filename);
		Scanner inputFile = new Scanner(file);

		//Declare variables
		ArrayList<String> words = new ArrayList<String>();
		String line, word;
		StringTokenizer token;
		int lineCount = 0, characterCount=0;

		/* Loop through adding each word the the ArrayList
		 * Add the word length to characterCount
		 * Add one to the line count after each line
		 */
		while (inputFile.hasNext())
		{
			line = inputFile.nextLine();
			token = new StringTokenizer(line, " ");
				while (token.hasMoreTokens())
				{
					word = token.nextToken();
					characterCount += word.length();
					words.add(word);
				}
			lineCount++;
		}
		inputFile.close();

		//Print info
		System.out.println("The number of characters (no spaces) in the file is: " + characterCount);
		System.out.println("The number of words in the file is: " + words.size());
		System.out.println("The number of lines in the file is: " + lineCount);
	}
}
