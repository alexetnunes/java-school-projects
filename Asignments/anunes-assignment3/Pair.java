import java.math.*;


public class Pair {
	private char value;
	private int count;
	private double probability;
	private static int total=0;
	
	public Pair(){
		this.count = 0;
	}
	
	public Pair(char value) {
		this.value = value;
		this.count = 0;
	}

	public char getValue() {
		return value;
	}

	public void setValue(char value) {
		this.value = value;
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
		if (value != other.value)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return value + "="+getProbability();
	}
	
	
	
	
	
	
	
	
}
