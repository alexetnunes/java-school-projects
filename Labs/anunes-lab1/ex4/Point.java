/* 
 * Point Class
 * Alex Nunes
 * 08/09/2014
 * Dalhousie University
 * Faculty of Computer Science
 * 
 * Creates a Point object with two doubles
 */
public class Point {
	private double x,y;
	
	public Point(){
		
	}
	
	//Constructor
	public Point(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	//Getters and Setters
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	//Determines the length between this Point and another Point
	public double findLength(Point another){
		return Math.sqrt((another.getX()-x)*(another.getX()-x)+(another.getY()-y)*(another.getY()-y));
	}
	
	//Prints Point coordinates
	public String toString(){
		return "[" +x +","+ y + "]" ;
	}
	
}
