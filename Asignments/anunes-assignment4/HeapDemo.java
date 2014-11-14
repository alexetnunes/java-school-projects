
import java.io.*;
import java.util.*;
public class HeapDemo {

	public static void main(String[] args) throws IOException {
		//Declare scanner
		Scanner kbd = new Scanner(System.in);
	
		//take in file and declare variables
		System.out.print("Enter the filename to read from: ");
		String filename = kbd.nextLine();
		File file = new File(filename);
		Scanner inputFile = new Scanner(file);
		String line, word;
		StringTokenizer token;
		int holdTime;
		Heap<Process> processes = new Heap<Process>();
		
		line = inputFile.nextLine();
		token = new StringTokenizer(line, "\t");
		
		
	}

}
