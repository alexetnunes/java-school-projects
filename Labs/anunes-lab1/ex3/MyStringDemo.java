/* 
 * MyString Demo
 * Alex Nunes
 * 08/09/2014
 * Dalhousie University
 * Faculty of Computer Science
 * 
 * Demos the MyString Object and its permute method
 */
import java.util.*;
public class MyStringDemo {
	public static void main(String[] args) {
		//Declare Scanner and variables
		Scanner kbd = new Scanner(System.in);
		String word;
		int num;
		
		//Take in word and number of times to run the permute function
		System.out.print("Enter a word: ");
		word = kbd.nextLine();
		System.out.print("Enter the number of jumbled versions required: ");
		num = kbd.nextInt();
		
		//Create MyString object
		MyString ms = new MyString(word);
		
		//Run and print permute function on ms object
		for(int i = 0; i<num; i++){
			String newWord = ms.permute();
			
			if(word != newWord ){
				System.out.println(newWord);
			}
		}
	}
}
