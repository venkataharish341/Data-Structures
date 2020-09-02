package ds.stacks;

public class StackWithArray {

	static final int MAX = 1000;
	int top;
	int a[] = new int[MAX];

	StackWithArray() {
		top = -1;
	}
	
	private boolean push(int i) {
		if (top > MAX) {
			System.out.println("Stack Overflown");
			return false;
		} else {

			a[++top] = i;
			return true;
		}

	}

	private int pop() {

		if (top < 0) {
			System.out.println("Stack under flowing");
			return 0;
		} else {
			return a[top--];
		}

	}

	public void printStack() {
		int x;
		x = top;
		while (x > -1) {
			System.out.println(a[x]);
			x = x - 1;
		}

	}

	public static void main(String[] args) {
		
		StackWithArray s = new StackWithArray();
		s.push(10);
		s.push(20);
		s.push(30);
		s.printStack();
		System.out.println(s.pop());

	}

}
