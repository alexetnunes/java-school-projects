import java.math.*;


public class Pair {
	private char letter;
	private int count;
	private double probability;
	private static int total=0;
	
	public Pair(){
		this.count = 0;
	}
	
	public Pair(char letter) {
		this.letter = letter;
		this.count = 0;
	}

	public char getLetter() {
		return letter;
	}

	public void setLetter(char letter) {
		this.letter = letter;
	}

	public static int getTotal() {
		return total;
	}
	
	public void addTotal(){
		total++;
	}

	public int getCount() {
		return count;
	}

	public void addCount(){
		count++;
	}

	
	public double getProbability() {
		return probability;
	}

	public void setProbability(double probability) {
		this.probability = probability;
	}

	public double calcProbability() {
		BigDecimal bd = new BigDecimal((double)count/total);
	    bd = bd.setScale(3, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pair other = (Pair) obj;
		if (letter != other.letter)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return letter + "="+getProbability();
	}
	
	
	
	
	
	
	
	
}
