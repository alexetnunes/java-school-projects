/* 
 * Rectangle2D Class
 * Alex Nunes
 * 08/09/2014
 * Dalhousie University
 * Faculty of Computer Science
 * 
 * Demo program for Rectangle2D 
 */
public class Rectangle2DDemo {
	public static void main(String[] args) {
		Rectangle2D r1, r2;
		
		//Create Rectangles
		r1 = new Rectangle2D(2, 2, 5.5, 4.9);
		r2 = new Rectangle2D(4, 5, 10.5, 3.2);
		
		// Print Rectangle 1 and Rectangle 2
		System.out.println("Rectangle 1:\n"+r1);
		System.out.println();
		System.out.println("Rectangle 2:\n"+r2);
		System.out.println();
		
		//Run contains methods and overlaps method
		System.out.println("Does rectangle 1 contain 3,3? " + r1.contains(3, 3));
		System.out.println("Does rectangle 1 contains rectangle 2? "+r1.contains(r2));
		System.out.println("Do rectangle 1 and rectangle 2 overlap? "+r1.overlaps(r2));
		
	}
}
