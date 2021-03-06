/*
* Queue Class
* Alex Nunes
* 29/09/2014
* Dalhousie University
* Faculty of Computer Science
*
* A Queue class that implements a LinkedList
* and a cursor, FIFO
*/
public class Queue<T> {

	//Variables
	private LinkedList<T> queue;
	private int cursor;

	//Cosntructor
	public Queue() {
		queue = new LinkedList<T>();
		cursor = -1;
	}

	//Adds an item to the end of the queue
	public void enqueue(T item){
		queue.addToEnd(item);
	}

	//Removes the first instance of the requested item
	public T dequeue(T item){
		return(queue.removeAt(queue.indexOf(item)));
	}

	//Returns the size of the queue
	public int size(){
		return queue.size();
	}

	//Checks whether or not the queue is empty
	public boolean isEmpty(){
		return queue.isEmpty();
	}

	//Removes all items from the queue
	public void clear(){
		queue.clear();
	}

	//Returns the first item in the queue
	public T peek(){
		return queue.getFront().getData();
	}

	//Gets the first index of an item
	public int positionOf(T item){
		return queue.indexOf(item);
	}

	//Removes an item from the queue
	public void remove(T item){
		queue.remove(item);
	}

	//Removes all instances of an item from the queue
	public void removeAll(T item){
		queue.removeAll(item);
	}

	//Returns the first item and sets the cursor there
	public T first(){
		cursor = 0;
		return peek();
	}

	//Increase the cursor and return the item
	public T next(){
		cursor++;
		return queue.getAt(cursor);
	}

	//Prints all items in the queue
	public void print(){
		queue.enumerate();
	}
}
