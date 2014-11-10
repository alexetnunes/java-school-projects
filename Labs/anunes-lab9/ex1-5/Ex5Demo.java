/*
 * Ex5Demo Class
 * Alex Nunes
 * 10/11/2014
 * Dalhousie University
 * Faculty of Computer Science
 *
 */
import java.util.Scanner;

public class Ex5Demo {
	public static void main(String[] args) {
		Heap<String> h = new Heap<String>();
		Scanner kbd = new Scanner(System.in);
		String word = "", word2;
		
		System.out.print("Enter a word (when done enter -1): ");
		word = kbd.next();
		
		while(!word.equalsIgnoreCase("-1")){
			h.add(word);
			System.out.print("Enter a word (when done enter -1): ");
			word = kbd.next();
		}
		
		h.enumerate();
		System.out.print("Enter a word to replace and what to replace it with :" );
		word=kbd.next();
		word2=kbd.next();
		h.changePriority(word, word2);
		
		while(!h.isEmpty()){
			System.out.print(h.deleteMax()+" ");
		}
	}

}
