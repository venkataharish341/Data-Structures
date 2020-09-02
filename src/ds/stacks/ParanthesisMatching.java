package ds.stacks;

import java.util.Stack;

public class ParanthesisMatching {


	private int match(String str) {

		Stack<Character> s = new Stack<Character>();

		for(int i=0; i< str.length(); i++) {
			char c = str.charAt(i);
			if(c == '[' || c == '{' || c == '(' ) {
				s.push(c);
			}else {

				if(!s.isEmpty()) {
					if(c == ']') {
						char peekC = s.peek();
						if(peekC == '[') {
							s.pop();
						}
					}else if(c == '}') {
						char peekC = s.peek();
						if(peekC == '{') {
							s.pop();
						}
					}else if(c == ')') {
						char peekC = s.peek();
						if(peekC == '(') {
							s.pop();
						}
					}
				}else {
					return -1;
				}
			}
		}
		
		if(s.isEmpty()) {
			return 1;
		}else {
			return -1;
		}

	}

	public static void main(String[] args) {

		String str = "([()]{}{[()()]()})";
		System.out.println(new ParanthesisMatching().match(str));

	}
}
