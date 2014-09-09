/* 
 * LinearEquation Class
 * Alex Nunes
 * 08/09/2014
 * Dalhousie University
 * Faculty of Computer Science
 * 
 * Creates a LinearEquation object with six doubles
 */
public class LinearEquation {
	private double a,b,c,d,e,f;
	
	public LinearEquation(){
		
	}
	
	//Constructors
	public LinearEquation(double a, double b, double c, double d, double e,
			double f) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.e = e;
		this.f = f;
	}

	//Getters and Setters
	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}

	public double getC() {
		return c;
	}

	public void setC(double c) {
		this.c = c;
	}

	public double getD() {
		return d;
	}

	public void setD(double d) {
		this.d = d;
	}

	public double getE() {
		return e;
	}

	public void setE(double e) {
		this.e = e;
	}

	public double getF() {
		return f;
	}

	public void setF(double f) {
		this.f = f;
	}
	
	// Determines if the equation is Solvable
	public boolean isSolvable() {
		return ((a*d)-(b*c) != 0);
	}
	
	// Gets the X coordinate of the intersection
	public double getX(){
		return ((e*d) - (b*f))/((a*d)-(b*c));
	}
	
	// Gets the Y coordinate of the intersection
	public double getY(){
		return ((a*f) - (e*c))/((a*d)-(b*c));
	}
}
