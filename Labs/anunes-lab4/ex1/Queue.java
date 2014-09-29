
public class Queue<T> {

	private LinkedList<T> queue;
	private int cursor;
	
	public Queue() {
		queue = new LinkedList<T>();
		cursor = -1;
	}
	
	public void enqueue(T item){
		queue.addToEnd(item);
	}
	
	public T dequeue(T item){
		return(queue.removeAt(queue.indexOf(item)));
	}
	
	public int size(){
		return queue.size();
	}
	
	public boolean isEmpty(){
		return queue.isEmpty();
	}
	
	public void clear(){
		queue.clear();
	}
	
	public T peek(){
		return queue.getFront().getData();
	}
	
	public int positionOf(T item){
		return queue.indexOf(item);
	}
	
	public void remove(T item){
		queue.remove(item);
	}
	
	public T first(){
		return peek();
	}
	
	public T next(){
		cursor++;
		return 
	}
}
