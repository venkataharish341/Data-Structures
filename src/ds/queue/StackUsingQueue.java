package ds.queue;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {

	private Queue<Integer> q1;
	private Queue<Integer> q2;

	public StackUsingQueue() {
		q1 = new LinkedList<Integer>();
		q2 = new LinkedList<Integer>();
	}

	public void push(int x) {
		q1.add(x);
	}

	public int pop() {
		if(q1.isEmpty()) {
			return -1;
		}

		while(!q1.isEmpty() && q1.size() != 1) {
			q2.add(q1.poll());
		}
		int returnInt = q1.poll();		
		Queue<Integer> temp = q1;
		q1= q2;
		q2 = temp;
		return returnInt;
	}


	public static void main(String[] args) {
		StackUsingQueue sq = new StackUsingQueue();
		sq.push(1);
		sq.push(2);
		sq.push(3);
		System.out.println(sq.pop());
		sq.push(4);
		System.out.println(sq.pop());
		System.out.println(sq.pop());
		System.out.println(sq.pop());
	}
}
