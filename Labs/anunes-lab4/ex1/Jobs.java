/*
* Jobs Class
* Alex Nunes
* 29/09/2014
* Dalhousie University
* Faculty of Computer Science
*
* An Job object type that holds a String owner and
* and int JobId
*/
public class Jobs {

	private String owner;
	private int jobId;

	//Constructor
	public Jobs(String owner, int jobId) {
		this.owner = owner;
		this.jobId = jobId;
	}

	//Getters
	public String getOwner(){
		return owner;
	}

	public int getJobId(){
		return jobId;
	}

	//Overriden equals method to check only the owner
	// Used for remove all method.
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jobs other = (Jobs) obj;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		return true;
	}


}
