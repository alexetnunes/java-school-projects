/*
* OrderedListClient Class
* Alex Nunes
* 13/10/2014
* Dalhousie University
* Faculty of Computer Science
*
* Demo Class that reads two lists from text files
* and runs the OrderedList Utility methods on the lists.
* Writes all three list back to text files
*/

import java.io.*;
import java.util.*;
public class OrderedListClient {
	public static void main(String[] args) throws IOException{
		OrderedList<String> list1 = new OrderedList<String>();
		OrderedList<String> list2 = new OrderedList<String>();
		File file1 = new File("list1.txt");
		File file2 = new File("list2.txt");
		Scanner inputFile = new Scanner(file1);

		while (inputFile.hasNext())
		{
			String line = inputFile.nextLine();
			list1.insert(line);
		}

		inputFile = new Scanner(file2);

		while (inputFile.hasNext())
		{
			String line = inputFile.nextLine();
			list2.insert(line);
		}

		OrderedList<String> merged = OrderedListUtility.merge(list1, list2);
		OrderedList<String> intersect = OrderedListUtility.findIntersection(list1, list2);
		OrderedList<String> difference = OrderedListUtility.findDifference(list1, list2);

		BufferedWriter writer = null;

		File logFile = new File("mergedList.txt");
        writer = new BufferedWriter(new FileWriter(logFile));
        for(int i = 0; i<merged.size(); i++){
        	 writer.write(merged.get(i)+"\n");
        }
        writer.close();

        File logFile2 = new File("intersectedList.txt");
        writer = new BufferedWriter(new FileWriter(logFile2));
        for(int i = 0; i<intersect.size(); i++){
        	 writer.write(intersect.get(i)+"\n");
        }
        writer.close();

        File logFile3 = new File("differenceList.txt");
        writer = new BufferedWriter(new FileWriter(logFile3));
        for(int i = 0; i<difference.size(); i++){
        	 writer.write(difference.get(i)+"\n");
        }
        writer.close();
	}
}
