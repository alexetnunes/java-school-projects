import java.util.Arrays;


public class SlowPiece extends Piece {
	
	public SlowPiece() {
		super();
	}

	public SlowPiece(String name, String colour, int[] position) {
		super(name, colour, position);
	}

	public void move(int direction) {
		if(direction < 0){
			if(this.getPosition()[0] - 1 >= 0){
				this.getPosition()[0] = this.getPosition()[0] - 1;
			}
		}else{
			if(this.getPosition()[0] + 1 <= 7){
				this.getPosition()[0] = this.getPosition()[0] + 1;
			}
		}
		
		toString();
	}

	@Override
	public String toString() {
		return "SlowPiece [Name=" + getName() + ", Colour="
				+ getColour() + ", Position="
				+ Arrays.toString(getPosition()) +"]";
	}	
}
