/*
 * SlowFlexible Class
 * Alex Nunes
 * 28/09/2014
 * Dalhousie University
 * Faculty of Computer Science
 *
 * A slow class that can move 1 space
 * in any direction
 */
import java.util.Arrays;
public class SlowFlexible extends SlowPiece {

	//Constructors
	public SlowFlexible() {

	}

	public SlowFlexible(String name, String colour, int[] position) {
		super(name, colour, position);
	}

	// Move method to move one space in any direction
	public boolean move(String direction, int spaces) {
		spaces = 1;
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
		return "SlowFlexible [Name=" + getName() + ", Colour="
				+ getColour() + ", Position="
				+ Arrays.toString(getPosition()) +"]";
	}


}
