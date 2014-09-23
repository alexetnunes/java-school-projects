/* 
 * StringMatch Program
 * Alex Nunes
 * 22/09/2014
 * Dalhousie University
 * Faculty of Computer Science
 * 
 * Take in a longer string and a shorter string and check if
 * the shorter string matches any substrings in the longer string.
 */
import java.util.Scanner;
public class StringMatch {
	public static void main(String[] args) {
		//Declare Scanner and variables
		Scanner kbd = new Scanner(System.in);
		String s1, s2, matchedIndices =" ";
		
		//Take in first longer string
		System.out.print("Enter a string s1:");
		s1 = kbd.next();
		
		//Take in Second shorter string
		System.out.print("Enter a string s2:");
		s2 = kbd.next();
		
		//Loop through and compare the substring to the second string for a match
		for(int i=0; i <= s1.length()-s2.length(); i++){
			if(s1.substring(i, i + s2.length()).equalsIgnoreCase(s2)){
				matchedIndices += i+" ";
			}
		}
		
		//Print none of no matched found
		if(matchedIndices.equals(" ")){
			matchedIndices="None";
		}
		
		//Print matched indexes
		System.out.println("Matched Indexes:" + matchedIndices);
	}

}
