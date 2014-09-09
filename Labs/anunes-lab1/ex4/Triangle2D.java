/* 
 * Triengle2D Class
 * Alex Nunes
 * 08/09/2014
 * Dalhousie University
 * Faculty of Computer Science
 * 
 * Creates a Triangle2D with 3 Point Objects
 */
public class Triangle2D {
	private Point p1,p2,p3;
	
	public Triangle2D(){
		
	}

	//Constructor
	public Triangle2D(Point p1, Point p2, Point p3) {
		super();
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
	}

	//Getters and Setters
	public Point getP1() {
		return p1;
	}

	public void setP1(Point p1) {
		this.p1 = p1;
	}

	public Point getP2() {
		return p2;
	}

	public void setP2(Point p2) {
		this.p2 = p2;
	}

	public Point getP3() {
		return p3;
	}

	public void setP3(Point p3) {
		this.p3 = p3;
	}
	
	//Determines the area of the Triangle Object
	public double getArea() {
		double s = (p1.findLength(p2)+p2.findLength(p3)+p3.findLength(p1))/2;
		return Math.sqrt(s*(s - p1.findLength(p2))*(s-p2.findLength(p3))*(s-p3.findLength(p1)));
	}
	
	//Determines the perimeter of the Triangle Object
	public double getPerimeter() {
		return p1.findLength(p2)+p2.findLength(p3)+p3.findLength(p1);
	}
	
	//Determines whether a triangle contains a Point using barycentric coordinates
	// http://en.wikipedia.org/wiki/Barycentric_coordinate_system
	public boolean contains(Point p) {
		boolean result = false;
		double a = ((p2.getY() - p3.getY())*(p.getX() - p3.getX()) + (p3.getX() - p2.getX())*(p.getY() - p3.getY())) / 
					((p2.getY() - p3.getY())*(p1.getX() - p3.getX()) + (p3.getX() - p2.getX())*(p1.getY() - p3.getY()));
		double b = ((p3.getY() - p1.getY())*(p.getX() - p3.getX()) + (p1.getX() - p3.getX())*(p.getY() - p3.getY())) /
			       ((p2.getY() - p3.getY())*(p1.getX() - p3.getX()) + (p3.getX() - p2.getX())*(p1.getY() - p3.getY()));;
		double c = 1-a-b;
		
		if(a>0 && b>0 && c>0){
			result = true;
		}
		
		return result;
	}
	
	/*Determines whether this triangle contains another based on the three
	 * Points of the other triangle
	 */
	public boolean contains(Triangle2D t) {
		return (contains(t.getP1()) && contains(t.getP2()) && contains(t.getP3()));
	}
	
	//Prints Area and Perimeter of Triangle
	public String toString() {
		return "Area: "+getArea()+"\nPerimeter: " + getPerimeter(); 
	}
}
