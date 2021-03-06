/* 
 * Ex0 Class
 * Alex Nunes
 * 20/10/2014
 * Dalhousie University
 * Faculty of Computer Science
 * 
 * A set of recursive practice questions
 */
import java.util.Scanner;
public class ex0 {
	public static void main(String[] args) {
		System.out.println("Exercise 0A:");
		for(int i=1; i < 21; i++){
			System.out.print(fibonacci(i)+" ");
		}
		
		System.out.println("\n\nExercise 0B:");
		for(int i=1; i < 11; i++){
			System.out.print(factorial(i)+" ");
		}
		
		Scanner kbd = new Scanner(System.in);
		int n,m;
		System.out.println("\n\nExercise 0C:");
		System.out.print("Enter a number: ");
		n = kbd.nextInt();
		System.out.print("Enter a power: ");
		m = kbd.nextInt();
		System.out.print(n+"^"+m+ " = "+ power(n,m)+" ");

	}
	
	//A recursive method to determine the fibonacci number at a given index.
	public static long fibonacci(int n) {
       if(n<=1){
    	   return 1;
       }else{
    	   return fibonacci(n-1)+fibonacci(n-2);
       }
    }
	
	//Factorial
	public static long factorial(long n){
		if(n > 0){
			return n*factorial(n-1);
		}else{
			return 1;
		}
	}
	
	//Power
	public static long power(int n, int m){
		if(m == 0){
			return 1;
		}else{
			return power(n,m-1)*n;
		}
	}
}
