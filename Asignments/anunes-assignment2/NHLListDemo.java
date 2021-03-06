/*
* NHLListDemo Class
* Alex Nunes
* 14/10/2014
* Dalhousie University
* Faculty of Computer Science
*
* Demo Class to show the NHLList, PlayerRecord and
* TeamRecord classes.
*/
import java.util.*;
import java.io.*;
public class NHLListDemo {
	public static void main(String[] args) throws IOException {
		//Declare scanner
		Scanner kbd = new Scanner(System.in);

		//Variables
		int comparisonCount=0;


		//take in file
		System.out.print("Enter the filename to read from: ");
		String filename = kbd.nextLine();
		File file = new File(filename);
		Scanner inputFile = new Scanner(file);

		//Declare variables
		NHLList nhlStats = new NHLList();
		String line, value;
		StringTokenizer token;

		/* Loop through adding each word the the ArrayList
		 * Add the appropriate stats to the player
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
		
		//Print nhlstats table header
		String output = String.format("\n%-16s%-10s%8s%8s%8s%8s%8s%8s%8s%8s%8s%8s", "Name", "Position", "Team", "GP", "G", "A", "PIM", "SOG", "GWG", "P", "P/G", "PCT");
		System.out.println(output);
		//Print nhlstats table
		nhlStats.enumerate();
		comparisonCount++;
		
		//Print player with highest points
		System.out.println();
		System.out.println("\nPlayers with highest points and their teams:");
		nhlStats.highestPoints();
		comparisonCount++;
		
		//Print player with most penalty minutes
		System.out.println("\nMost aggressive players, their teams and their positions:");
		nhlStats.mostPenalties();
		comparisonCount++;
		
		//Print player with most game winning goals
		System.out.println("\nMost valuable players and their teams:");
		nhlStats.mvp();
		comparisonCount++;
		
		//Print player with most shots on goal
		System.out.println("\nMost promising players and their teams:");
		nhlStats.mostPromising();
		comparisonCount++;
		
		// Print team with most penalty minutes
		System.out.println("\nTeams that had the most number of penalty minutes:");
		nhlStats.mostAggressiveTeams();
		comparisonCount++;
		
		//Print team with most game winning goals
		System.out.println("\nTeams that had the most number of game winning goals:");
		nhlStats.mostGWGTeams();
		comparisonCount++;

		//Print team with least game winning goals
		System.out.println("\nTeams that had the least number of game winning goals:");
		nhlStats.leastGWGTeams();
		comparisonCount++;

		System.out.println("\nTotal number of comparisons done by the program: \n" + (comparisonCount * nhlStats.size()));
	}
}
