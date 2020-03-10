package ds;

public class BasicQueue<A> {

	private A[] data;
	private int front;
	private int rear;
	private int capacity;
	private int size;

	public BasicQueue() {
		this(20);	
	}

	public BasicQueue(int capacity) {
		data = (A[]) new Object[capacity];
		front = size = 0;
		rear = capacity-1;
		this.capacity = capacity;
	}
	public boolean isEmpty() {
		return this.size == 0;
	}

	public boolean isFull() {
		return this.size == this.capacity;
	}

	public void enQueue(A newItem) throws Exception{
		if(this.isFull()) {
			throw new Exception("Cannot add a new item. Queue was full");
		}else {
			this.rear = (this.rear+1) % capacity;
			data[this.rear] = newItem;
			this.size++;
			System.out.println(newItem + " enqueued.");
		}
	}

	public void deQueued() throws Exception{

		if(this.isEmpty()) {
			throw new Exception("Queue is empty.");
		}
		A item = data[front];
		this.front = (this.front +1 )% this.capacity;
		this.size--;
		System.out.println(item + " dequeued.");

	}

	public A front()
	{     
		return (A) this.data[this.front];
	}

	public A rear() {
		return (A) this.data[this.rear];
	}


	public static void main(String[] args) {
		BasicQueue<String> bq = new BasicQueue<String>();
		try {
			bq.enQueue("Hello");
			bq.enQueue("How");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}


}
