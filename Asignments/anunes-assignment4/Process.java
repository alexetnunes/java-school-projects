/*
 * Process Class
 * Alex Nunes
 * 16/11/2014
 * Dalhousie University
 * Faculty of Computer Science
 *
 * Process class that contains an id,
 * time required, priority, and arrival time
 */
public class Process implements Comparable<Process>{
	//Declare Variables
	private	int	id;
	private	int	timeReqd;
	private	int	priority;
	private	int	timeArrival;
	
	//Constructors
	public Process(){
		
	}
	
	public Process(int id, int timeReqd, int priority, int timeArrival) {
		super();
		this.id = id;
		this.timeReqd = timeReqd;
		this.priority = priority;
		this.timeArrival = timeArrival;
	}
	
	//Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTimeReqd() {
		return timeReqd;
	}

	public void setTimeReqd(int timeReqd) {
		this.timeReqd = timeReqd;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getTimeArrival() {
		return timeArrival;
	}

	public void setTimeArrival(int timeArrival) {
		this.timeArrival = timeArrival;
	}
	
	
	//Method to low time required by one
	public void timeDown(){
		if(this.timeReqd > 0){
			this.timeReqd -= 1;
		}
	}

	
	//ToString
	@Override
	public String toString() {
		return  "("+id + ", "+ timeReqd + ", "+ priority +")";
	}
	
	//Overridden compareTo method for a heap
	@Override
	public int compareTo(Process o) {
		if(this.priority < o.getPriority()){
			return -1;
		}else if(this.priority > o.getPriority()){
			return 1;
		}else{
			return 0;
		}
	}
	
	
	
	
}
