/*
* PrintQueue Class
* Alex Nunes
* 29/09/2014
* Dalhousie University
* Faculty of Computer Science
*
* An PrintQueue class that keeps a Queue
* of Jobs items
*/
public class PrintQueue {

	//Variables
	private Queue<Jobs> jobs;

	//Constructor
	public PrintQueue() {
		jobs = new Queue<Jobs>();
	}

	//Enqueues a job with the specified owner name and job id
	public void lpr(String owner, int jobId){
		jobs.enqueue(new Jobs(owner, jobId));
	}

	//Prints all the entries in this queue
	public void lpq(){
		if(!jobs.isEmpty()){
			Jobs j = jobs.first();
			boolean end = false;
			System.out.println(j.getJobId()+" - "+j.getOwner());
			while(!end){
				j = jobs.next();
				if(j != null){
					System.out.println(j.getJobId()+" - "+j.getOwner());
				}else{
					end = true;
				}
			}
		}else{
			System.out.println("There are no jobs in the queue.");
		}
	}

	//Removes the active job at the front of the queue if jobId matches, error message otherwise
	public void lprm(int jobId){
		if(jobId == jobs.first().getJobId()){
			jobs.dequeue(jobs.first());
		}else{
			System.out.println("System Error. Job IDs do not match.");
		}
	}

	//Removes all jobs from the queue that have been submitted by the owner
	public void lprmAll(String owner){
		Jobs remove = new Jobs(owner, -1);
		jobs.removeAll(remove);
	}


}
