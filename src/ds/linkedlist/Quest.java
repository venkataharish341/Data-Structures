package ds.linkedlist;

public class Quest {


	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.pushAtEnd(1);
		ll.pushAtEnd(2);
		ll.pushAtEnd(3);
		ll.pushAtEnd(4);
		ll.pushAtEnd(5);
		ll.pushAtEnd(6);

		Node slowP = ll.head;
		Node fastP = ll.head;

		if(ll.head != null) {
			while(slowP == fastP) {
				
			}
		}

	}
}
