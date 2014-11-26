/*
 * Process Class
 * Alex Nunes
 * 26/11/2014
 * Dalhousie University
 * Faculty of Computer Science
 *
 * Demo to display a simple search traversal
 * of a non-directional graph
 */
import java.util.*;
import java.io.*;
public class GraphDemo {
	public static void main(String[] args) throws IOException {
		//Declare scanner
		Scanner kbd = new Scanner(System.in);
			
		//take in file and declare variables
		System.out.print("Enter the filename to read from: ");
		String filename = kbd.nextLine();
		File file = new File(filename);
		Scanner inputFile = new Scanner(file);
		String e1,e2;
		int vertices;
		
		//Get vertices and create 2D array
		vertices = Integer.parseInt(inputFile.nextLine());
		int[][]	adjMatrix = new int[vertices][vertices];
		
		//Initialize the array with 0
		for(int i = 0; i<adjMatrix.length; i++){
			for(int j = 0; j<adjMatrix.length; j++){
				adjMatrix[i][j] = 0;
			}
		}
		//Take in edges, assuming that the input file is error-free
		while (inputFile.hasNext())
		{
			e1 = inputFile.nextLine();
			e2 = inputFile.nextLine();
			adjMatrix[e1.charAt(0)-65][e2.charAt(0)-65] = 1;
			adjMatrix[e2.charAt(0)-65][e1.charAt(0)-65] = 1;	
		}
		inputFile.close();
		
		//Print adjMatrix using helper method
		print2D(adjMatrix, vertices);
		System.out.println();
		System.out.println("Graph Traversal: ");
	}
	
	
	// Helper method to print the array.
	public static void print2D(int[][] a, int v){
		System.out.print("  ");
		for(int k = 0; k<v;k++){
			System.out.print(((char)(k+65))+" ");
		}
		System.out.println();
		for(int i = 0; i<a.length; i++){
			System.out.print((char)(i+65) + " ");
			for(int j = 0; j<a.length; j++){
				System.out.print(a[i][j]+ " ");
			}
			System.out.println();
		}
	}

}