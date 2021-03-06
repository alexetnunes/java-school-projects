/* 
 * SlowPiece Class
 * Alex Nunes
 * 28/09/2014
 * Dalhousie University
 * Faculty of Computer Science
 * 
 * Slow piece class that can only move laft or right one space
 */
import java.util.Arrays;
public class SlowPiece extends Piece {
	
	//Constructors
	public SlowPiece() {
		super();
	}

	public SlowPiece(String name, String colour, int[] position) {
		super(name, colour, position);
	}
	
	// Limits the overridden method to moving one space
	@Override
	public boolean move(String direction, int spaces) {
		spaces = 1;
		return super.move(direction, spaces);
	}

	@Override
	public String toString() {
		return "SlowPiece [Name=" + getName() + ", Colour="
				+ getColour() + ", Position="
				+ Arrays.toString(getPosition()) +"]";
	}	
}
