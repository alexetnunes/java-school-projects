import java.util.*;
import java.io.*;
public class NHLListDemo {
	public static void main(String[] args) throws IOException {
		//Declare scanner
		Scanner kbd = new Scanner(System.in);

		//take in file
		System.out.print("Enter the filename to read from: ");
		String filename = kbd.nextLine();
		File file = new File(filename);
		Scanner inputFile = new Scanner(file);

		//Declare variables
		NHLList nhlStats = new NHLList();
		String line, value;
		StringTokenizer token;
		int lineCount = 0, characterCount=0;

		/* Loop through adding each word the the ArrayList
		 * Add the word length to characterCount
		 * Add one to the line count after each line
		 */
		while (inputFile.hasNext())
		{	
			PlayerRecord p = new PlayerRecord();
			line = inputFile.nextLine();
			token = new StringTokenizer(line, "\t");
			for(int i = 0; i<9; i++)
			{
				value = token.nextToken();
				if(i == 0 ){p.setName(value);}
				else if (i == 1){p.setPosition(value);}
				else if (i == 2){p.setTeam(value);}
				else if (i == 3){p.setGamesPlayed(Integer.parseInt(value));}
				else if (i == 4){p.setGoals(Integer.parseInt(value));}
				else if (i == 5){p.setAssists(Integer.parseInt(value));}
				else if (i == 6){p.setPenaltyMinutes(Integer.parseInt(value));}
				else if (i == 7){p.setShotsOnGoal(Integer.parseInt(value));}
				else{p.setGameWinners(Integer.parseInt(value));}
			}
			nhlStats.addPlayer(p);
			
		}
		inputFile.close();
		
		/*String output = String.format("\n%-16s%-10s%8s%8s%8s%8s%8s%8s%8s%8s%8s%8s", "Name", "Position", "Team", "GP", "G", "A", "PIM", "SOG", "GWG", "P", "P/G", "PCT");
		System.out.println(output);
		nhlStats.enumerate();*/
		
		System.out.println();
		System.out.println("\nPlayers with highest points and their teams:");
		nhlStats.highestPoints();

		System.out.println("\nMost aggressive players, their teams and their positions:");
		nhlStats.mostPenalties();
		
		System.out.println("\nMost valuable players and their teams:");
		nhlStats.mvp();
	}
}