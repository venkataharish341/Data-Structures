package ds.stacks;

public class ReverseString {

	int top;
	static final int MAX = 1000;
	char[] c = new char[MAX];

	ReverseString() {
		top = -1;
	}

	private boolean push(char i) {
		if (top > MAX) {
			System.out.println("Stack Overflown");
			return false;
		} else {

			c[++top] = i;
			return true;
		}

	}

	private char pop() {

		if (top < 0) {
			System.out.println("Stack under flowing");
			return 0;
		} else {
			return c[top--];
		}

	}

	public String reverseString(String str) {
		char []st = new char[MAX];
		int i = 0;
		while (i < str.length()) {
			this.push(str.charAt(i));
		}
		i = this.top;
		while(i > -1){
			st[i] = this.pop();
		}
		return st.toString();
		
	}

	public static void main(String[] args) {
		String str = "Harish";
		ReverseString stack = new ReverseString();
		System.out.println(stack.reverseString(str));

	}

}
