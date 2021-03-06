/*
* FastFlexible Class
* Alex Nunes
* 28/09/2014
* Dalhousie University
* Faculty of Computer Science
*
* A piece that can move left or right any
* number of spaces on a board
*/
import java.util.Arrays;


public class FastFlexible extends FastPiece {

	// Constructors
	public FastFlexible() {

	}

	public FastFlexible(String name, String colour, int[] position) {
		super(name, colour, position);
	}

	// Move method to move a number of spaces in any direction
	@Override
	public boolean move(String direction, int spaces) {
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
		}else if(direction.toLowerCase().equals("down")){
			if(this.getPosition()[1] - spaces >= 0){
				this.getPosition()[1] = this.getPosition()[1] - spaces;
				success = true;
			}
		}else if(direction.toLowerCase().equals("up")){
			if(this.getPosition()[1] + spaces <= 7){
				this.getPosition()[1] = this.getPosition()[1] + spaces;
				success = true;
			}
		}
		if(!success){
			System.out.println("Invalid move.");
		}
		return success;
	}

	@Override
	public String toString() {
		return "FastFlexible [Name=" + getName() + ", Colour="
				+ getColour() + ", Position="
				+ Arrays.toString(this.getPosition()) +"]";
	}
}
