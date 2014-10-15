/*
* PlayerRecord Class
* Alex Nunes
* 14/10/2014
* Dalhousie University
* Faculty of Computer Science
*
* A Player Record class to keep track of a player's
* stats 
*/
import java.text.DecimalFormat;
public class PlayerRecord {
	//Declare variables
	private String name;
	private String position;
	private String team;
	private int gamesPlayed, goals, assists, penaltyMinutes, shotsOnGoal, gameWinners, points;
	private double ppg, pct;
	
	//Constructors
	public PlayerRecord(){
		
	}

	public PlayerRecord(String name, String position, String team,
			int gamesPlayed, int goals, int assists, int penaltyMinutes,
			int shotsOnGoal, int gameWinners) {
		this.name = name;
		this.position = position;
		this.team = team;
		this.gamesPlayed = gamesPlayed;
		this.goals = goals;
		this.assists = assists;
		this.penaltyMinutes = penaltyMinutes;
		this.shotsOnGoal = shotsOnGoal;
		this.gameWinners = gameWinners;
	}
	
	//Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public int getGamesPlayed() {
		return gamesPlayed;
	}

	public void setGamesPlayed(int gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
	}

	public int getGoals() {
		return goals;
	}

	public void setGoals(int goals) {
		this.goals = goals;
	}

	public int getAssists() {
		return assists;
	}

	public void setAssists(int assists) {
		this.assists = assists;
	}

	public int getPenaltyMinutes() {
		return penaltyMinutes;
	}

	public void setPenaltyMinutes(int penaltyMinutes) {
		this.penaltyMinutes = penaltyMinutes;
	}

	public int getShotsOnGoal() {
		return shotsOnGoal;
	}

	public void setShotsOnGoal(int shotsOnGoal) {
		this.shotsOnGoal = shotsOnGoal;
	}

	public int getGameWinners() {
		return gameWinners;
	}

	public void setGameWinners(int gameWinners) {
		this.gameWinners = gameWinners;
	}
	
	
	
	public int getPoints() {
		calcPoints();
		return points;
	}

	public void setPoints() {
		calcPoints();
	}

	public double getPpg() {
		calcPpg();
		return ppg;
	}

	public void setPpg(double ppg) {
		calcPpg();
	}

	public double getPct() {
		calcPct();
		return pct;
	}

	public void setPct(double pct) {
		calcPct();
	}

	//Calculates and sets total points
	public int calcPoints(){
		points = goals + assists;
		return points;
	}
	
	//Calculates and sets total points per game
	public double calcPpg(){
		ppg = (double) calcPoints()/gamesPlayed;
		return ppg;
	}
	
	//Calculates and sets total shooting percentage
	public double calcPct(){
		pct = (double) goals*100.00/shotsOnGoal;
		return pct;
	}
	

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("00.00");
		String output = String.format("\n%-16s%-10s%8s%8s%8s%8s%8s%8s%8s%8s%8s%8s", name, position, team,gamesPlayed, goals, assists, penaltyMinutes, shotsOnGoal, gameWinners,getPoints(), df.format(getPpg()), df.format(getPct()));
		return output;
	}
	
}
