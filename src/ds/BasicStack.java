package ds;

public class BasicStack<X> {

	private X[] data;
	private int stackPointer;

	public BasicStack() {
		data = (X[]) new Object[1000];
		stackPointer = 0;
	}

	public void push(X newItem) {
		data[stackPointer] = newItem;
		stackPointer++;
	}

	public X pop() {
		if(stackPointer == 0) {
			throw new IllegalStateException("No items in stack.");
		}
		return data[--stackPointer];
	}
	
	public boolean contains(X item) {
		return false;
	}
	
	public void printStack() {
		for(int i = 0; i< stackPointer; i++) {
		System.out.println(data[i]);
		}
	}
	
	public static void main(String[] args) {
		BasicStack<String> bs = new BasicStack<String>();
		bs.push("Harish");
		bs.push("Yaswanth");
		bs.printStack();
		
		bs.pop();
		System.out.println();
		bs.printStack();
	}

}
