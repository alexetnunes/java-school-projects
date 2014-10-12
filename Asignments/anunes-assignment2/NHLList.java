import java.util.*;
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
	
	public String mostPromising(){
		return null;
	}

}
