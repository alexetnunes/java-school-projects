/*
* QueueDemo Class
* Alex Nunes
* 29/09/2014
* Dalhousie University
* Faculty of Computer Science
*
* A class to demo the queue class
*/
public class QueueDemo {

	public static void main(String[] args) {
		//Create new Queue of type string
		Queue<String> que = new Queue<String>();

		//View empty queue
		System.out.println("Empty:" + que.isEmpty());
		//Fill queue with strings and print
		que.enqueue("One");
		que.enqueue("Two");
		que.enqueue("Three");
		que.enqueue("Four");
		que.enqueue("Five");
		que.print();

		System.out.println();

		//Iterate through the queue and view each item using first and next methods
		System.out.println(que.first());
		System.out.println(que.next());
		System.out.println(que.next());
		System.out.println(que.next());
		System.out.println(que.next());
		System.out.println(que.next());
		System.out.println(que.first());
		System.out.println(que.next());

		// Print size of the queue
		System.out.println("\nSize:" + que.size());

		//Remove an item
		System.out.println();
		que.remove("Five");
		que.print();


		//Dequeue an item
		System.out.println();
		que.dequeue("Three");
		que.print();

		//Print queue info
		System.out.println("\nSize:" + que.size());
		System.out.println("Empty:" + que.isEmpty());

		//Call position of method for existent and non-existent values
		System.out.println("Position of Three: "+ que.positionOf("Three"));
		System.out.println("Position of Four: "+ que.positionOf("Four"));

		//Remove an item
		que.remove("One");
		que.print();

		//Clear the queue
		System.out.println();
		que.clear();
		System.out.println("Empty:" + que.isEmpty());


	}

}
