/* 
 * AlternateCountDownDemo Class
 * Alex Nunes
 * 20/10/2014
 * Dalhousie University
 * Faculty of Computer Science
 * 
 * A recursive method to count down by
 * twos from a number (evens and odds)
 */
import java.util.Scanner;
public class AlternateCountDownDemo {
	public static void main(String[] args) {
		Scanner kbd = new Scanner(System.in);
		int n;
		System.out.print("Enter a number to countdown from: ");
		n = kbd.nextInt();
		countDown(n);

	}
	
	public static void countDown(int n){
		if(n <= 0){
			System.out.print("Blast Off!");
		}else{
			System.out.print(n+" ");
			countDown(n-2);
		}
	}
}
