/*
* Board Class
* Alex Nunes
* 28/09/2014
* Dalhousie University
* Faculty of Computer Science
*
* A board that keeps track of all pieces in play
* by using a 2d array.
*/
public class Board {

	private Piece[][] grid;

	//Constructor
	public Board() {
		grid = new Piece[8][8];
	}

	//Adds a piece to the borad by adding it to the array at its position
	public void addPiece(Piece p, int xpos, int ypos){
		if(grid[xpos][ypos] == null){
			grid[xpos][ypos] = p;
			System.out.println(grid[xpos][ypos]);
		} else {
			System.out.println("That position is not vacant.");
		}
	}

	// Moves a piece on the board by changing it's array location and calling the piece's move method
	public void move(int xpos, int ypos, String direction, int spaces){
		if(grid[xpos][ypos] != null){
			//Calls Piece's move method in the if statement
			if(grid[xpos][ypos].move(direction, spaces)){
				grid[grid[xpos][ypos].getPosition()[0]][grid[xpos][ypos].getPosition()[1]] = grid[xpos][ypos];
				grid[xpos][ypos] = null;
			}
		}
	}

	// Prints out all piece's on the board
	public void displayBoard(){
		for(int i=0; i < grid.length; i++){
			for(int j=0; j<grid.length; j++){
				if(grid[i][j] != null){
					System.out.println(grid[i][j]);
				}
			}
		}
	}
}
