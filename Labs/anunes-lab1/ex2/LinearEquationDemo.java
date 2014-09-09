/* 
 * LinearEquationDemo
 * Alex Nunes
 * 08/09/2014
 * Dalhousie University
 * Faculty of Computer Science
 * 
 * Demos the LinearEquation class
 */
import java.util.*;
public class LinearEquationDemo {
	public static void main(String[] args) {
		
		//Declare Scanner and variables
		Scanner kbd = new Scanner(System.in);
		double x1,x2,x3,x4,y1,y2,y3,y4;
		
		//Take in coordinates for point 1 and 2
		System.out.print("Enter the end points for the first line segment: ");
		x1 = kbd.nextDouble();
		y1 = kbd.nextDouble();
		x2 = kbd.nextDouble();
		y2 = kbd.nextDouble();
		
		//Take in coordinates for point 3 and 4
		System.out.print("Enter the end points for the second line segment: ");
		x3 = kbd.nextDouble();
		y3 = kbd.nextDouble();
		x4 = kbd.nextDouble();
		y4 = kbd.nextDouble();
		
		//Determine the values for the linear equation
		double a = (y1 - y2);
		double b = (-x1 + x2);
		double c = (y3 - y4);
		double d = (-x3 + x4);
		double e = -y1 * (x1 - x2) + (y1 - y2) * x1;
		double f = -y3 * (x3 - x4) + (y3 - y4) * x3;
		
		//Create Linear Equation object
		LinearEquation le = new LinearEquation(a,b,c,d,e,f);
		
		// Print intersection point if the problem is Solvable
		if(le.isSolvable()){
			System.out.println("The intersecting point is "+le.getX()+", "+le.getY());
		}else{
			System.out.println("This equation is not solvable!");
		}
	}
}
