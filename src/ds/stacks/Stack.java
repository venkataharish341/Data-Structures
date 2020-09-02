package ds.stacks;

public class Stack {

	private static final int MAX = 6;
	int a[] = new int[MAX];
	int tos;

	public Stack() {
		tos = -1;
	}

	public boolean isEmpty() {
		return tos<0;
	}

	public boolean push(int x) {
		if(tos >= MAX-1) {
			System.out.println("Stack is Full");
			return false;
		}else {
			a[++tos] = x;
			return true;
		}
	}

	public int pop() {
		int x = 0;
		if(tos < 0) {
			System.out.println("Stack is Empty");
		}else {
			x =a[tos--];
		}
		return x;
	}

	public void reverseStack(java.util.Stack<Integer> s, int i){
		if(s.isEmpty()) {
			return;
		}
		i = s.pop();
		reverseStack(s, i);
		insertAtBottom(s, i, 0);
	}

	private void insertAtBottom(java.util.Stack<Integer> s, int x, int ele) {
		if(s.isEmpty()) {
			s.push(x);
			return;
		}
		ele = s.pop();
		insertAtBottom(s, x, ele);
		
		s.push(ele);
	}
	
	public void sortStack(java.util.Stack<Integer> s, int x){
		if(s.isEmpty()) {
			return;
		}
		
		x = s.pop();
		sortStack(s, x);
		sort(s, x, 0);
	}

	
	public void sort(java.util.Stack<Integer> s, int x, int ele) {
		if(s.isEmpty()) {
			s.push(x);
			return;
		}
		
		if(s.peek() < x) {
			ele = s.pop();
			sort(s, x, ele);
			s.push(ele);
		}else {
			s.push(x);
		}
		
	}
	
	public static void main(String[] args) {
		java.util.Stack<Integer> s = new java.util.Stack<>();
		s.push(9);
		s.push(4);
		s.push(20);
		s.push(8);

		new Stack().sortStack(s,0);

		while(!s.isEmpty()) {
			System.out.println(s.pop());
		}
	}
}
