package ds.queue;

public class Queue {

	int front, rear, size, capacity;
	int arr[];
	
	public Queue(int capacity) {
		this.capacity = capacity;
		arr = new int[this.capacity];
		this.front = this.size = 0;
		this.rear = capacity-1;
	}
	
	public boolean isEmpty() {
		return (this.size == 0);
	}
	
	public boolean isFull() {
		return (this.size == this.capacity);
	}
	
	public void enqueue(int x) {
		if(this.isFull()) {
			return;
		}
		this.rear = (this.rear+1) % this.capacity;
		arr[this.rear] = x;
		this.size++;
	}	
	
	public int dequeue() {
		if(this.isEmpty()) {
			return 0;
		}else {
		int removedItem = arr[this.front];
		this.front = (this.front +1) % capacity;
		this.size--;
		return removedItem;
		}
	}
	
	public static void main(String[] args) {
		Queue q = new Queue(10);
		q.enqueue(10);
		q.enqueue(30);
		q.enqueue(50);
		System.out.println(q.dequeue());
	}
	
}
