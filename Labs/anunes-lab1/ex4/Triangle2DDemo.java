/* 
 * Triangle2D Demo
 * Alex Nunes
 * 08/09/2014
 * Dalhousie University
 * Faculty of Computer Science
 * 
 * Demos the Triangle2D and Point objects
 */
import java.util.*;
public class Triangle2DDemo {
	public static void main(String[] args) {
		
		//Declare Scanner and variables
		Scanner kbd = new Scanner(System.in);
		
		double x,y;
		
		Point p1, p2, p3;
		
		Triangle2D t1, t2;
		
		// Create p1 from user input
		System.out.print("Enter the first point(x,y) for triangle 1: ");
		x = kbd.nextDouble();
		y = kbd.nextDouble();
		p1 = new Point(x,y);
		
		// Create p2 from user input
		System.out.print("Enter the second(x,y) point for triangle 1: ");
		x = kbd.nextDouble();
		y = kbd.nextDouble();
		p2 = new Point(x,y);
		
		// Create p3 from user input
		System.out.print("Enter the third point(x,y) for triangle 1: ");
		x = kbd.nextDouble();
		y = kbd.nextDouble();
		p3 = new Point(x,y);
		
		//Create t1 Triangle object
		t1 = new Triangle2D(p1, p2, p3);
		
		//Print t1
		System.out.println(t1);
		
		//Create a new Point using p1
		System.out.print("Enter a point(x,y): ");
		x = kbd.nextDouble();
		y = kbd.nextDouble();
		p1 = new Point(x,y);
		
		
		//Determine and print whether or not t1 contains p1
		if(t1.contains(p1)){
			System.out.println("The point "+p1+ " is in triangle 1.");
		}else{
			System.out.println("The point "+p1+ " is not in triangle 1.");
		}
		
		// Create new p1 from user input
		System.out.print("Enter the first point(x,y) for triangle 2: ");
		x = kbd.nextDouble();
		y = kbd.nextDouble();
		p1 = new Point(x,y);
		
		// Create new p2 from user input
		System.out.print("Enter the second(x,y) point for triangle 2: ");
		x = kbd.nextDouble();
		y = kbd.nextDouble();
		p2 = new Point(x,y);
		
		// Create new p3 from user input
		System.out.print("Enter the third point(x,y) for triangle 2: ");
		x = kbd.nextDouble();
		y = kbd.nextDouble();
		p3 = new Point(x,y);
		
		//Create t2 Triangle Object
		t2 = new Triangle2D(p1, p2, p3);
		
		//Print t2
		System.out.println(t2);
		
		//Determine and print whether or not t1 contains t2
		if(t1.contains(t2)){
			System.out.println("Triangle 1 contains triangle 2.");
		}else{
			System.out.println("Triangle 1 does not contain triangle 2.");
		}

	}
}
