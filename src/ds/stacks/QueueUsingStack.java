package ds.stacks;

public class QueueUsingStack {

	Stack s1 = new Stack();
	Stack s2 = new Stack();

	public boolean enqueue(int x) {
		return s1.push(x);
	}

	public int dequeue() {
		if(s2.tos < 0) {
			while(s1.tos >-1) {
				s2.push(s1.pop());
			}
		}
		return s2.pop();
	}
	
	public static void main(String[] args) {

		QueueUsingStack q = new QueueUsingStack();
		q.enqueue(2);
		q.enqueue(4);
		q.enqueue(7);
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
	}

}
