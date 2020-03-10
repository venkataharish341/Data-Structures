package ds.doublylinkedlist;

public class DoublyLinkedList {

	Node head;

	public void printDll() {
		Node n = head;
		while (n != null) {
			System.out.println(n.data);
			n = n.next;
		}

	}

	void deleteNode(Node head_ref, Node del) {
		/* base case */
		if (head == null || del == null) {
			return;
		}

		/* If node to be deleted is head node */
		if (head == del) {
			head = del.next;
		}

		/* Change next only if node to be deleted is NOT the last node */
		if (del.next != null) {
			del.next.previous = del.previous;
		}

		/* Change previous only if node to be deleted is NOT the first node */
		if (del.previous != null) {
			del.previous.next = del.next;
		}

		/* Finally, free the memory occupied by del */
		return;
	}

	/*
	 * swap next and prev for all nodes of doubly linked list
	 */
	void reverse() {
		Node temp = null;
		Node current = head;

		while (current != null) {
			temp = current.previous;
			current.previous = current.next;
			current.next = temp;
			current = current.previous;
		}

		/*
		 * Before changing head, check for the cases like empty list and list
		 * with only one node
		 */
		if (temp != null) {
			head = temp.previous;
		}
	}

	public static void main(String[] args) {

		DoublyLinkedList dll = new DoublyLinkedList();
		dll.head = new Node(1);
		Node second = new Node(2);
		dll.head.next = second;
		second.previous = dll.head;
		Node third = new Node(3);
		second.next = third;
		third.previous = second;

		dll.printDll();
		dll.reverse();
		//dll.deleteNode(dll.head, second);
		dll.printDll();
	}

}
