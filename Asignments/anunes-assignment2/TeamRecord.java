/*
* TeamRecord Class
* Alex Nunes
* 14/10/2014
* Dalhousie University
* Faculty of Computer Science
*
* TeamRecord to keep track of a teams
* Penalty Minutes and Game Winning Goals
*/
public class TeamRecord {
	//Variables
	private String name;
	private int penaltyMinutes, gameWinners;
	
	//Constructors
	public TeamRecord(){
		
	}
	
	public TeamRecord(String name) {
		this.name = name;
		this.penaltyMinutes = 0;
		this.gameWinners = 0;
	}
	
	//Getters and Setters
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getPenaltyMinutes() {
		return penaltyMinutes;
	}


	public void setPenaltyMinutes(int penaltyMinutes) {
		this.penaltyMinutes = penaltyMinutes;
	}


	public int getGameWinners() {
		return gameWinners;
	}


	public void setGameWinners(int gameWinners) {
		this.gameWinners = gameWinners;
	}

	//Add Penalty Minutes to the current value
	public void addPIM(int pim){
		penaltyMinutes += pim;
	}
	
	//Add Game Winning Goals to the current value
	public void addGWG(int gwg){
		gameWinners += gwg;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TeamRecord other = (TeamRecord) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "\nTeamRecord [name=" + name + ", penaltyMinutes="
				+ penaltyMinutes + ", gameWinners=" + gameWinners + "]";
	}
	
	
	
	
	
}
