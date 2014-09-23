import java.util.Arrays;


public class FastFlexible extends FastPiece {

	public FastFlexible() {
		
	}

	public FastFlexible(String name, String colour, int[] position) {
		super(name, colour, position);
	}

	public void move(int direction, String updown) {
		if(updown.equalsIgnoreCase("vertical")){
			if(this.getPosition()[0] + direction >=0 || this.getPosition()[0] + direction <= 7){
				this.getPosition()[0] = this.getPosition()[0] + direction;
			}
		}else if(updown.equalsIgnoreCase("horizontal")){
			super.move(direction);
		}else{
			System.out.println("Please enter a negative or positive integer followed by 'vertical' or 'horizontal'.");
		}
	}

	@Override
	public String toString() {
		return "FastFlexible [Name=" + getName() + ", Colour="
				+ getColour() + ", Position="
				+ Arrays.toString(getPosition()) +"]";
	}
}
