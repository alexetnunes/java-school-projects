/*
* PracticeMoves Demo Class
* Alex Nunes
* 28/09/2014
* Dalhousie University
* Faculty of Computer Science
*
* A class to practice moves to see how pieces can
* move around a board
*/
import java.util.*;
public class PracticeMoves {

	public static void main(String[] args) {
		
		//Declare Scanner and variables
		Scanner kbd = new Scanner(System.in);
		int spaces;
		String command, direction, primary, secondary, name, colour;
		boolean gameover=false;
		Board game = new Board();
		
		//Prompt user for commands while game has not been exited
		while(!gameover){
			//Declare position and piece variables
			int[] pos = new int[2];
			Piece p;
			
			//Prompt user for command
			System.out.print("Please type a command: ");
			command = kbd.next();
			
			//Determine course of action base on command entered
			if(command.toLowerCase().equals("create")){
				System.out.print("Please enter starting position and piece type: ");
				pos[0] = kbd.nextInt();
				pos[1] = kbd.nextInt();
				primary = kbd.next();
				secondary = kbd.next();

				System.out.print("Please enter a colour and then a name: ");
				colour = kbd.next();
				name  = kbd.next();

				if(primary.equalsIgnoreCase("fast")){
					if(secondary.equalsIgnoreCase("flexible")){
						p = new FastFlexible(name, colour, pos);
					}else {
						p = new FastPiece(name, colour, pos);
					}
				}else{
					if(secondary.equalsIgnoreCase("flexible")){
						p = new SlowFlexible(name, colour, pos);
					}else {
						p = new SlowPiece(name, colour, pos);
					}
				}

				game.addPiece(p, pos[0], pos[1]);


			}else if(command.toLowerCase().equals("move")){
				System.out.print("Please enter the position of the piece to move, a direction, and the number of spaces: ");
				pos[0] = kbd.nextInt();
				pos[1] = kbd.nextInt();
				direction = kbd.next();
				spaces = kbd.nextInt();

				game.move(pos[0], pos[1], direction, spaces);

			}else if(command.toLowerCase().equals("print")){
				game.displayBoard();
			}else if(command.toLowerCase().equals("help")){
				help();
			}else if(command.toLowerCase().equals("exit")){
				gameover = true;
				System.out.println("Thanks for playing!");
			}else{
				System.out.println("Invalid command.");
			}
		}

	}

	// Prints out the commands for the demo
	public static void help(){
		System.out.println("1. create [x-position, y-position, (fast), (flexible)]");
		System.out.println("2. move [x-position, y-position, direction, spaces]");
		System.out.println("3. print [print out the pieces positions]");
		System.out.println("4. help [list commands]");
		System.out.println("5. exit [exit the game]");

	}
}
