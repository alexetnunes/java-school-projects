/* 
 * MultiplesDemo Class
 * Alex Nunes
 * 20/10/2014
 * Dalhousie University
 * Faculty of Computer Science
 * 
 * A method to take in numbers and
 * the number of multiples to print
 * and print those multiples
 */
import java.util.Scanner;
public class MultiplesDemo {
	public static void main(String[] args) {
		Scanner kbd = new Scanner(System.in);
		int n, m;
		System.out.print("Enter a number: ");
		n = kbd.nextInt();
		System.out.print("Enter the number of multiples: ");
		m = kbd.nextInt();
		multiples(n,m);
	}
	
	public static void multiples(int n, int m){
		if(m > 0){
			multiples(n, m-1);
			System.out.print(n*m+" ");
		}
	}
}
