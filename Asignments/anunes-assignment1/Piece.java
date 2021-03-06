/* 
 * Piece Class
 * Alex Nunes
 * 28/09/2014
 * Dalhousie University
 * Faculty of Computer Science
 * 
 * Master class for  all piece classes to be 
 * used to create a game
 */
import java.util.Arrays;
public class Piece {
	//Variables
	private String name;
	private String colour;
	private	int [] position;
	
	//Constructors
	public Piece() {
		
	}
	
	public Piece(String name, String colour, int[] position) {
		this.name = name;
		this.colour = colour;
		this.position = position;
	}

	//Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public int[] getPosition() {
		return position;
	}

	public void setPosition(int[] position) {
		this.position = position;
	}
	
	// Move method to move a piece left or right on a board a provided number of spaces
	public boolean move(String direction, int spaces){
		boolean success = false;
		if(direction.toLowerCase().equals("left")){
			if(this.getPosition()[0] - spaces >= 0){
				this.getPosition()[0] = this.getPosition()[0] - spaces;
				success = true;
			}
		}else if(direction.toLowerCase().equals("right")){
			if(this.getPosition()[0] + spaces <= 7){
				this.getPosition()[0] = this.getPosition()[0] + spaces;
				success = true;
			}
		}
		if(!success){
			System.out.println("Invalid move.");
		}
		return success;
	}

	public String toString() {
		return "Piece [name = " + name + ", colour = " + colour + ", Position = "
				+ Arrays.toString(position) + "]";
	}
	
	
}
