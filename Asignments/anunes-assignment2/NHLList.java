
public class NHLList {
	private List<PlayerRecord> players;
	
	public NHLList(){
		players = new List<PlayerRecord>();
	}
	
	public void addPlayer(PlayerRecord item){
		players.add(item);
	}
	
	public boolean isEmpty(){
		return players.isEmpty();
	}
	
	public PlayerRecord first(){
		return players.first();
	}
	
	public PlayerRecord next(){
		return players.next();
	}
	
	public void enumerate(){
		players.enumerate();
	}
	
	public void highestPoints(){
	
	}
	
	public String mostPenalties(){
		return null;
	}
	
	public String mvp(){
		return null;
	}
	
	public String mostPromising(){
		return null;
	}

}
