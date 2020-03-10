package ds.expressions;

import java.util.Stack;

public class Expressions {

	private int precedence(char c) {
		switch(c) {
		case '+':
		case '-' : return 1;
		case '*' :
		case '/' : return 2;
		case '^': return 3;
		default: return -1;
		}
	}

	public String convertInfixToPostfix(String exp) {
		StringBuilder result = new StringBuilder();
		char c;
		Stack<Character> stk = new Stack<Character>();

		for(int i=0; i<exp.length(); i++) {
			c = exp.charAt(i);

			if(Character.isLetterOrDigit(c)) {
				result.append(c);
			}else if(c == '(') {
				stk.push(c);
			}else if(c == ')') {
				while(!stk.isEmpty() && stk.peek() != '(') {
					result.append(stk.pop());
				}
				stk.pop();
			}else {
				while(!stk.isEmpty() && precedence(c) <= precedence(stk.peek())) {
					result.append(stk.pop());
				}
				stk.push(c);
			}
		}

		while (!stk.isEmpty()) {
			result.append(stk.pop()); 
		}


		return result.toString();
	}

	public static void main(String[] args) {
		String exp = "a+b*(c^d-e)^(f+g*h)-i"; 
		Expressions ex =new Expressions();

		System.out.println(ex.convertInfixToPostfix(exp)); 
	}
}
