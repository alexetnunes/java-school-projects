import java.util.*;
import java.io.*;
public class FileReadDemo {
	public static void main(String[] args) throws IOException {
		Scanner kbd = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<String>();
		System.out.print("Enter the filename to read from: ");
		String filename = kbd.nextLine();
		
		File file = new File(filename);
		
		Scanner inputFile = new Scanner(file);
		
		while (inputFile.hasNext())
		{
			String line = inputFile.nextLine();
			sortedInsert(list, line);
			System.out.println(list);
		}
		inputFile.close();
	}
	
	public static void sortedInsert(ArrayList<String> list, String item){
		if(list.isEmpty()){
			list.add(item);
		}else{
			boolean added = false;
			for(int i = 0; i<list.size(); i++){
				if(item.compareTo(list.get(i)) <= 0){
					list.add((i), item);
					added = true;
					i = list.size();
				}
			}
			if(!added){
				list.add(item);
			}
		}
	}
}
