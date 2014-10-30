import java.util.ArrayList;

/*
* Queue Class
* Alex Nunes
* 29/09/2014
* Dalhousie University
* Faculty of Computer Science
*
* A Queue class that implements a queue
* and a cursor, FIFO
*/
public class Queue<T extends Comparable<T>> {

	//Variables
	private ArrayList<T> queue;
	private int cursor;

	//Constructor
	public Queue() {
		queue = new ArrayList<T>();
		cursor = -1;
	}

	//Adds an item to the end of the queue
	public void enqueue(T item){
		queue.add(item);
	}
	
	//Adds an item to inserted into the queue
	public void insert(T item){
		if(queue.isEmpty()){
			queue.add(item);
		}else{
			boolean added = false;
			for(int i = 0; i<queue.size(); i++){
				if(item.compareTo(queue.get(i)) <= 0){
					queue.add((i), item);
					added = true;
					i = queue.size();
				}
			}
			if(!added){
				queue.add(item);
			}
		}
	}

	//Removes the first instance of the requested item
	public T dequeue(T item){
		return(queue.remove(0));
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
		return queue.get(0);
	}

	//Gets the first index of an item
	public int positionOf(T item){
		return queue.indexOf(item);
	}

	//Removes an item from the queue
	public void remove(T item){
		queue.remove(item);
	}


	//Returns the first item and sets the cursor there
	public T first(){
		cursor = 0;
		return queue.get(cursor);
	}

	//Increase the cursor and return the item
	public T next(){
		cursor++;
		return queue.get(cursor);
	}

	//Prints all items in the queue
	public void print(){
		for(int i=0; i<queue.size(); i++){
			System.out.println(queue.get(i));
		}
	}
}
