/*
* NHLList Class
* Alex Nunes
* 14/10/2014
* Dalhousie University
* Faculty of Computer Science
*
* This class implements a List of players and
* a List of teams to track and run minor analysis
*/
import java.util.*;
public class NHLList {
	private List<PlayerRecord> players;
	private List<TeamRecord> teams;
	
	//Constructor
	public NHLList(){
		players = new List<PlayerRecord>();
		teams = new List<TeamRecord>();
	}
	
	/* Adds a player to the Players list and
	 * adds a team if necessary. Then adds the players
	 * stats to the corresponding team
	 */
	public void addPlayer(PlayerRecord item){
		players.add(item);
		
		TeamRecord team = new TeamRecord(item.getTeam());
		if(teams.contains(team) < 0){
			teams.add(team);
		}
		
		TeamRecord curr = teams.first();
		while(curr != null){
			if(team.equals(curr)){
				curr.addPIM(item.getPenaltyMinutes());
				curr.addGWG(item.getGameWinners());
			}
			curr = teams.next();
		}
	}
	
	// checks if players is empty
	public boolean isEmpty(){
		return players.isEmpty();
	}
	
	//Gets first player
	public PlayerRecord first(){
		return players.first();
	}
	
	//Gets next player dependent on cursor
	public PlayerRecord next(){
		return players.next();
	}
	
	//Print Players
	public void enumerate(){
		players.enumerate();
	}
	
	//Print Teams
	public void teamsEnumerate(){
		teams.enumerate();
	}
	
	//Get size of players
	public int size(){
		return players.size();
	}
	
	/* Iterates through the players list to determine 
	 * the player with the highest number of points
	 * then prints out their name and team 
	 */
	public void highestPoints(){
		ArrayList<PlayerRecord> highPointPlayers = new ArrayList<PlayerRecord>();
		PlayerRecord highestPoints = players.first();
		PlayerRecord curr = players.next();
		
		while(curr != null){
			if(curr.getPoints() > highestPoints.getPoints()){
				highPointPlayers.clear();
				highestPoints = curr;
				highPointPlayers.add(highestPoints);
			}else if(curr.getPoints() == highestPoints.getPoints()){
				highestPoints = curr;
				highPointPlayers.add(highestPoints);
			}
			curr = players.next();
		}
		
		for(int i=0; i<highPointPlayers.size(); i++){
			System.out.println(highPointPlayers.get(i).getName()+" - "+ highPointPlayers.get(i).getTeam());
		}
	}
	
	/* Iterates through the players list to determine 
	 * the player with the highest number of penalty
	 * minutes then prints out their name, team, and position 
	 */
	public void mostPenalties(){
		ArrayList<PlayerRecord> highPenaltyPlayers = new ArrayList<PlayerRecord>();
		PlayerRecord highestPenalties = players.first();
		PlayerRecord curr = players.next();
		
		while(curr != null){
			if(curr.getPenaltyMinutes() > highestPenalties.getPenaltyMinutes()){
				highPenaltyPlayers.clear();
				highestPenalties = curr;
				highPenaltyPlayers.add(highestPenalties);
			}else if(curr.getPenaltyMinutes() == highestPenalties.getPenaltyMinutes()){
				highestPenalties = curr;
				highPenaltyPlayers.add(highestPenalties);
			}
			curr = players.next();
		}
		
		for(int i=0; i<highPenaltyPlayers.size(); i++){
			System.out.println(highPenaltyPlayers.get(i).getName()+" - "+ highPenaltyPlayers.get(i).getTeam()+" - "+highPenaltyPlayers.get(i).getPosition());
		}
	}
	
	/* Iterates through the players list to determine 
	 * the player with the highest number of gameWinners
	 * then prints out their name and team 
	 */
	public void mvp(){
		ArrayList<PlayerRecord> mvps = new ArrayList<PlayerRecord>();
		PlayerRecord mvp = players.first();
		PlayerRecord curr = players.next();
		
		while(curr != null){
			if(curr.getGameWinners() > mvp.getGameWinners()){
				mvps.clear();
				mvp = curr;
				mvps.add(mvp);
			}else if(curr.getGameWinners() == mvp.getGameWinners()){
				mvp = curr;
				mvps.add(mvp);
			}
			curr = players.next();
		}
		
		for(int i=0; i<mvps.size(); i++){
			System.out.println(mvps.get(i).getName()+" - "+ mvps.get(i).getTeam());
		}
	}
	
	/* Iterates through the players list to determine 
	 * the player with the highest number of shots on goal
	 * then prints out their name and team 
	 */
	public void mostPromising(){
		ArrayList<PlayerRecord> mostPromisingPlayers = new ArrayList<PlayerRecord>();
		PlayerRecord mostPromising = players.first();
		PlayerRecord curr = players.next();
		
		while(curr != null){
			if(curr.getShotsOnGoal() > mostPromising.getShotsOnGoal()){
				mostPromisingPlayers.clear();
				mostPromising = curr;
				mostPromisingPlayers.add(mostPromising);
			}else if(curr.getShotsOnGoal() == mostPromising.getShotsOnGoal()){
				mostPromising = curr;
				mostPromisingPlayers.add(mostPromising);
			}
			curr = players.next();
		}
		
		for(int i=0; i<mostPromisingPlayers.size(); i++){
			System.out.println(mostPromisingPlayers.get(i).getName()+" - "+ mostPromisingPlayers.get(i).getTeam());
		}
	}
	
	/* Iterates through the teams list to determine 
	 * the team with the highest number of penalty
	 * minutes then prints out the team 
	 */
	public void mostAggressiveTeams(){
		ArrayList<TeamRecord> highPIM = new ArrayList<TeamRecord>();
		TeamRecord highestPIM = teams.first();
		TeamRecord curr = teams.next();
		
		while(curr != null){
			if(curr.getPenaltyMinutes() > highestPIM.getPenaltyMinutes()){
				highPIM.clear();
				highestPIM = curr;
				highPIM.add(highestPIM);
			}else if(curr.getPenaltyMinutes() == highestPIM.getPenaltyMinutes()){
				highestPIM = curr;
				highPIM.add(highestPIM);
			}
			curr = teams.next();
		}
		
		for(int i=0; i<highPIM.size(); i++){
			System.out.println(highPIM.get(i).getName());
		}
	}
	
	/* Iterates through the teams list to determine 
	 * the team with the highest number of game
	 * winning goals then prints out the team 
	 */
	public void mostGWGTeams(){
		ArrayList<TeamRecord> highGWG = new ArrayList<TeamRecord>();
		TeamRecord highestGWG = teams.first();
		TeamRecord curr = teams.next();
		
		while(curr != null){
			if(curr.getGameWinners() > highestGWG.getGameWinners()){
				highGWG.clear();
				highestGWG = curr;
				highGWG.add(highestGWG);
			}else if(curr.getGameWinners() == highestGWG.getGameWinners()){
				highestGWG = curr;
				highGWG.add(highestGWG);
			}
			curr = teams.next();
		}
		
		for(int i=0; i<highGWG.size(); i++){
			System.out.println(highGWG.get(i).getName());
		}
	}
	
	/* Iterates through the teams list to determine 
	 * the team with the lowest number of game
	 * winning goals then prints out the team 
	 */
	public void leastGWGTeams(){
		ArrayList<TeamRecord> lowGWG = new ArrayList<TeamRecord>();
		TeamRecord lowestGWG = teams.first();
		TeamRecord curr = teams.next();
		
		while(curr != null){
			if(curr.getGameWinners() < lowestGWG.getGameWinners()){
				lowGWG.clear();
				lowestGWG = curr;
				lowGWG.add(lowestGWG);
			}else if(curr.getGameWinners() == lowestGWG.getGameWinners()){
				lowestGWG = curr;
				lowGWG.add(lowestGWG);
			}
			curr = teams.next();
		}
		
		for(int i=0; i<lowGWG.size(); i++){
			System.out.println(lowGWG.get(i).getName());
		}
	}

}
