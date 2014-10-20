/* 
 * SumSquaresClass
 * Alex Nunes
 * 20/10/2014
 * Dalhousie University
 * Faculty of Computer Science
 * 
 * A method to take in an integer
 * and determine the sum of squares
 * up to that number
 */
import java.util.Scanner;
public class SumSquaresDemo {

	public static void main(String[] args) {
		Scanner kbd = new Scanner(System.in);
		int n;
		System.out.print("Enter a number: ");
		n = kbd.nextInt();
		System.out.println("The sum of the squares is "+sumSquare(n));

	}
	
	public static int sumSquare(int n){
		if(n >= 0){
			return (n*n)+sumSquare(n-1);
		}else{
			return 0;
		}
	}

}
