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
	
	public static void main(String[] args) {
		Stack s = new Stack();
		s.push(2);
		s.push(4);
		s.push(6);
		s.push(8);
		s.pop();
		System.out.println("TOS is :" + s.tos);
	}
}
