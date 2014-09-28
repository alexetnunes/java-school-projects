/* 
 * FastPiece Class
 * Alex Nunes
 * 28/09/2014
 * Dalhousie University
 * Faculty of Computer Science
 * 
 * A piece that can move left or right any
 * number of spaces on a board
 */
import java.util.Arrays;
public class FastPiece extends Piece {

	public FastPiece() {
		
	}

	public FastPiece(String name, String colour, int[] position) {
		super(name, colour, position);
	}
	@Override
	public boolean move(String direction, int spaces) {
		return super.move(direction, spaces);
	}

	@Override
	public String toString() {
		return "FastPiece [Name=" + getName() + ", Colour="
				+ getColour() + ", Position="
				+ Arrays.toString(getPosition()) +"]";
	}	
}
