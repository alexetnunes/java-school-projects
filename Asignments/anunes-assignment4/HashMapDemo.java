/*
 * HashMapDemo Class
 * Alex Nunes
 * 16/11/2014
 * Dalhousie University
 * Faculty of Computer Science
 *
 * Demos a password program that
 * uses two HashMaps<String, String>
 */
import java.util.*;
import java.io.*;
public class HashMapDemo {

	public static void main(String[] args) throws IOException{
		//Declare scanner
		Scanner kbd = new Scanner(System.in);
	
		//take in file and declare variables
		File file = new File("users.txt");
		Scanner inputFile = new Scanner(file);
		String line, name, username, password;
		StringTokenizer token;
		int attempts = 3;
		boolean success = false;
		HashMap<String, String> passwords = new HashMap<String, String>();
		HashMap<String, String> names = new HashMap<String, String>();
		
		//Take in all names, usernames, and passwords and save them to the hashmaps
		while (inputFile.hasNext())
		{
			line = inputFile.nextLine();
			token = new StringTokenizer(line, "\t");
			name = token.nextToken()+" "+ token.nextToken();
			username = token.nextToken().replaceAll("\\s","");
			password = token.nextToken().replaceAll("\\s","");
			passwords.put(username, password);
			names.put(username, name);

		}
		inputFile.close();
		
		/*
		 * Prompt user to enter a username and password 
		 * Check username and password against hashmaps.
		 * 
		 * If username and password match grant user access.
		 * 
		 * If username and password doesn't match -1 from 
		 * attempts and prompt user to try again.
		 * 
		 * If attempts gets to 0, lock the user out.
		 * 
		 */
		while(attempts > 0 && !success){
			System.out.print("Username: ");
			username = kbd.next();
			System.out.print("Password: ");
			password = kbd.next();
			
			if(passwords.containsKey(username) && passwords.get(username).equals(password)){
				success = true;
				System.out.println("\nLogin successful.");
				System.out.println("Welcome, "+ names.get(username) + "!");
			}else{
				attempts--;
				if(attempts > 0){
					System.out.println("\nEither the username or password is incorrect. You have "+ attempts+" more attempts.\n");
				}else{
					System.out.println("Sorry. Incorrect login. Please contact the system administrator.");
				}
			}
		}
	}

}
