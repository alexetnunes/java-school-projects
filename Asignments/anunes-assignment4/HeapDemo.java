/*
 * HeapDemo Class
 * Alex Nunes
 * 16/11/2014
 * Dalhousie University
 * Faculty of Computer Science
 *
 * Shows how a Heap can queue proceses
 */
import java.io.*;
import java.util.*;
public class HeapDemo {

	public static void main(String[] args) throws IOException {
		//Declare scanner
		Scanner kbd = new Scanner(System.in);
	
		//take in file and declare variables
		System.out.print("Enter the filename to read from: ");
		String filename = kbd.nextLine();
		File file = new File(filename);
		Scanner inputFile = new Scanner(file);
		String line, word;
		StringTokenizer token;
		int holdTime, id, value, timeUnit = 1;
		Process currentProcess = null;
		ArrayList<Process> stored = new ArrayList<Process>();
		Heap<Process> processes = new Heap<Process>();
		
		//Take in hold time
		line = inputFile.nextLine();
		token = new StringTokenizer(line, "\t");
		holdTime = Integer.parseInt(token.nextToken());
		
		//Take in all processes and store them
		while (inputFile.hasNext())
		{
			Process p = new Process();
			line = inputFile.nextLine();
			token = new StringTokenizer(line,"\t");
			for(int i = 0; i<4; i++)
			{
				value = Integer.parseInt(token.nextToken());
				if(i == 0 ){p.setId(value);}
				else if (i == 1){p.setTimeReqd(value);}
				else if (i == 2){p.setPriority(value);}
				else{p.setTimeArrival(value);}
			}
			stored.add(p);
		}
		
		inputFile.close();
		
		//Add all processes to the heap for the current time unit of 1
		for(int j = stored.size()-1; j >= 0; j--){
			if(stored.get(j).getTimeArrival() <= timeUnit){
				processes.add(stored.remove(j));
			}
		}
		
		//Run a process for the highest priority
		while(!processes.isEmpty()){
			//Print time unit and beginning state
			System.out.println("\nTime Unit: " + timeUnit);
			processes.enumerate();
			if(currentProcess==null){
				currentProcess = processes.deleteMax();
			}
			if(timeUnit%holdTime != 0){
				System.out.println("-");
			}else{
				System.out.println(currentProcess);
			}
			
			// Print out middle state of process
			processes.enumerate();
			System.out.println(currentProcess);
			
			//lower current process time
			currentProcess.timeDown();
			
			
			// Add process back if time required isn't 0 and hold time is up
			if(currentProcess.getTimeReqd() > 0 && timeUnit%holdTime == 0){
				processes.add(currentProcess);
			}
			
			//Reset currentProcess if hold time is up or time required is 0
			if(currentProcess.getTimeReqd() == 0||timeUnit%holdTime == 0){
				currentProcess = null;
			}
			
			//Print final phase
			processes.enumerate();
			if(currentProcess == null){
				System.out.println("-");
			}else{
				System.out.println(currentProcess);
			}
			
			
			timeUnit++;
			//Add all processes to the heap for the current time unit
			for(int j = 0; j < stored.size(); j++){
				if(stored.get(j).getTimeArrival() <= timeUnit){
					processes.add(stored.remove(j));
				}
			}
			
		}
		
	}

}
