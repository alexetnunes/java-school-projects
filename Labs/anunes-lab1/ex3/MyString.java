/* 
 * MyString Class
 * Alex Nunes
 * 08/09/2014
 * Dalhousie University
 * Faculty of Computer Science
 * 
 * Creates a MyString Object with a String
 */
public class MyString {
	private String word;
	
	public MyString() {
		
	}
	
	//Constructor
	public MyString(String word) {
		super();
		this.word = word;
	}

	//Getter and Setters
	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}
	
	// Permute method to jumble the word String
	public String permute(){
		char[] chars = word.toCharArray();
		int[] indexes = new int[chars.length];;
		for(int i = chars.length-1; i > 0 ; i--) {
			int rand = (int)((chars.length-1)*Math.random());
		    char c = chars[rand];
		    chars[rand] = chars[i];
		    chars[i] = c;
		}
		return new String(chars);
	}
}
