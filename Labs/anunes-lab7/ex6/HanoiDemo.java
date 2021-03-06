/* 
 * HanoiDemo Class
 * Alex Nunes
 * 20/10/2014
 * Dalhousie University
 * Faculty of Computer Science
 * 
 * A method to take in a number
 * of discs and produce the number
 * of moves necessary for the Tower of 
 * Hanoi
 */
import java.util.Scanner;
public class HanoiDemo {
	public static long count=0;
	
	public static void moveDiscs(int n, int from, int to, int temp){
		if(n>0){
			moveDiscs(n-1, from, temp, to);
			//System.out.println("Moved disc "+ n + " from peg "+ from+ " to peg "+to);
			moveDiscs(n-1, temp, to ,from);
			count+=1;
		}
	}
	
	public static void main(String[] args) {
		Scanner kbd = new Scanner(System.in);
		int n;
		System.out.print("Enter a number of discs: ");
		n = kbd.nextInt();
		
		long startTime, endTime, executionTime;
		startTime = System.currentTimeMillis();
		moveDiscs(n, 1, 3, 2);
		endTime = System.currentTimeMillis();
		executionTime = endTime - startTime;
		
		System.out.println("Execution Time: "+ executionTime + " ms");
		System.out.println("Number of Moves: "+ count);
	}

}
