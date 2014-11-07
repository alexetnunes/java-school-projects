/*
* BinaryTreeDemo1 Class
* Alex Nunes
* 27/10/2014
* Dalhousie University
* Faculty of Computer Science
*
* Demonstrates the BinaryTreee class
* Methods: getHeight, size, balanced.
*/
import java.util.*;
public class BinaryTreeDemo1 {

	public static void main(String[] args) {
		//Declarte Vairables
		Scanner kbd = new Scanner(System.in);
		String name ="";
		BinaryTree<String> main = new BinaryTree<String>();
		
		System.out.print("Enter a name or done: ");
		name = kbd.next();
		
		//Loop through and add objects
		while(!name.equalsIgnoreCase("done")){
			
			if(main.isEmpty()){
				main.makeRoot(name);
			}else{
				BinaryTree<String> newNode = new BinaryTree<String>();
				newNode.makeRoot(name);
				//Attaches based on whether not not trees are balanced (see method below)
				balancedAttach(main, newNode);
			}
			System.out.print("Enter a name or done: ");
			name = kbd.next();
		}
		
		//Print Info from methods
		System.out.println("\nNumber of Nodes: "+main.size());
		System.out.println("Height of Tree: "+main.getHeight());
		System.out.println("Balanced: "+main.balanced());
		System.out.print("In-Order: ");
		BinaryTree.inorder(main);
		System.out.println();
		System.out.print("Pre-Order: ");
		BinaryTree.preorder(main);
		System.out.println();
		System.out.print("Post-Order: ");
		BinaryTree.postorder(main);
		System.out.println();
		System.out.print("Level Order: ");
		BinaryTree.levelOrder(main);
		
	}
	
	
	/* Balanced attach method that uses recursion to determine the next spot
	 * to add a node and then adds it to create a balanced unordered tree
	 */
	public static void balancedAttach(BinaryTree<String> tree, BinaryTree<String> node){
		if(tree.getLeft()==null){
			tree.attachLeft(node);
		}else if(tree.getRight() == null){
			tree.attachRight(node);
		}else{
			if(tree.getLeft().size() > tree.getRight().size() && tree.getLeft().size() >2){
				balancedAttach(tree.getRight(),node);
			}else{
				balancedAttach(tree.getLeft(),node);
			}
		}
	}

}