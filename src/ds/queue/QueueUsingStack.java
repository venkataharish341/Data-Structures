package ds.queue;

import java.util.Stack;

public class QueueUsingStack{

	private Stack<Integer> s1;
	private Stack<Integer> s2;

	public QueueUsingStack(){
		s1 = new Stack<>();
		s2 = new Stack<>();
	}


	public void enQueue(int x){

		s1.push(x);

	}

	public int deQueue(){

		if(s2.isEmpty()){
			while(!s1.isEmpty()){
				s2.push(s1.pop());
			}
		}

		return s2.pop();

	}
	
	
	public static void main(String[] args) {
		QueueUsingStack qs = new QueueUsingStack();
		qs.enQueue(1);
		qs.enQueue(2);
		qs.enQueue(3);
		System.out.println(qs.deQueue());
		qs.enQueue(4);
		System.out.println(qs.deQueue());
		System.out.println(qs.deQueue());
		System.out.println(qs.deQueue());
		qs.enQueue(5);
		System.out.println(qs.deQueue());
	}

}
