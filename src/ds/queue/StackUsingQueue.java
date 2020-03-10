package ds.queue;

public class StackUsingQueue {

	Queue q1 = new Queue(10);
	Queue q2 = new Queue(10);
	
	public void push(int x) {
		q1.enqueue(x);
	}
	
	public int pop() {
		while(q1.size != 1) {
			q2.enqueue(q1.dequeue());
		}
		int removedItem = q1.dequeue();
		Queue temp = q1;
		q1 = q2;
		q2 = temp;
		return removedItem;		
	}
	
	public static void main(String[] args) {
		StackUsingQueue sq = new StackUsingQueue();
		sq.push(10);
		sq.push(20);
		sq.push(30);
		System.out.println(sq.pop());
	}
}
