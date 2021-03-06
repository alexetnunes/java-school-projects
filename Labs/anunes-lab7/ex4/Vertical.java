/* 
 * VerticalClass
 * Alex Nunes
 * 20/10/2014
 * Dalhousie University
 * Faculty of Computer Science
 * 
 * A method to take in an integer
 * parse it to a string and print
 * it vertically
 */
import java.util.Scanner;
public class Vertical {

	public static void main(String[] args) {
		Scanner kbd = new Scanner(System.in);
		int n;
		System.out.print("Enter an integer: ");
		n = kbd.nextInt();
		String num = String.valueOf(Math.abs(n));
		writeVertical(num);

	}
	
	public static void writeVertical(String n){
		if(n.length() >0){
			System.out.println(n.charAt(0));
			writeVertical(n.substring(1, n.length()));
		}
	}

}
