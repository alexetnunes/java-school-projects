/*
 * Ex1Demo Class
 * Alex Nunes
 * 10/11/2014
 * Dalhousie University
 * Faculty of Computer Science
 *
 */
import java.util.*;

public class Ex1Demo {
	public static void main(String[] args) {
		Heap<String> h = new Heap<String>();
		Scanner kbd = new Scanner(System.in);
		String word = "";
		
		System.out.print("Enter a word (when done enter -1): ");
		word = kbd.next();
		
		while(!word.equalsIgnoreCase("-1")){
			h.add(word);
			System.out.print("Enter a word (when done enter -1): ");
			word = kbd.next();
		}

		
		while(!h.isEmpty()){
			System.out.print(h.deleteMax()+" ");
		}
		
	}

}
