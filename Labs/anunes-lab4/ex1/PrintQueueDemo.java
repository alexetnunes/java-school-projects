/*
* PrintQueueDemo Class
* Alex Nunes
* 29/09/2014
* Dalhousie University
* Faculty of Computer Science
*
* An PrintQueueDemo class to run the
* methods of the PrintQueue class
*/
public class PrintQueueDemo {

	public static void main(String[] args) {

		//Declare print queue
		PrintQueue printJobs = new PrintQueue();

		//Populate printJobs with Jobs
		printJobs.lpr("swilliams", 309);
		printJobs.lpr("ronaldinho", 300);
		printJobs.lpr("marionjones", 312);
		printJobs.lpr("swilliams", 267);
		printJobs.lpr("davidh", 135);
		printJobs.lpr("ronaldinho", 301);

		//Print out all jobs
		printJobs.lpq();

		//Try to remove Job 135
		// This is not the first Job
		System.out.println();
		printJobs.lprm(135);

		//Try to remove Job 309
		// This is the first Job
		System.out.println();
		printJobs.lprm(309);
		printJobs.lpq();

		//Remove all jobs that belong to an owner
		System.out.println();
		printJobs.lprmAll("ronaldinho");
		printJobs.lpq();

	}

}
