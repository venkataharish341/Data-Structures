package ds.linkedlist;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class LinkedList {

	Node head;

	public void pushAtStart(int x){
		Node n = new Node(x);
		if(head == null) {
			head = n;
		}else {
			n.next = head;
			head = n;
		}
	}

	public void pushMiddle(Node prevNode, int x) {
		Node newNode = new Node(x);
		Node traverse = head;
		while(traverse != prevNode) {
			traverse = traverse.next;
		}
		newNode.next = traverse.next;
		traverse.next = newNode;
	}


	public void pushAtEnd(int x) {
		Node n = new Node(x);
		if(this.head == null) {
			head = n;
		}else {
			Node last = head;
			while(last.next != null) {
				last = last.next;
			}
			last.next = n;
		}
	}

	public void deleteNode(int key){
		if(head == null) {
			System.out.println("NO nodes in LL.");
			return;
		}else {
			Node traverse = head;
			if(head.data == key) {
				head = head.next;
			}else {
				while(traverse.next.data != key) {
					traverse = traverse.next;
				}
				traverse.next = traverse.next.next;
			}
		}
	}

	public void printLL() {
		Node last = head;
		while(last != null) {
			System.out.println(last.data);
			last = last.next;
		}
	}

	public int iterativeLength() {
		Node last = head;
		int count = 0;
		if(head == null) {
			System.out.println("Length of LL is Zero.");
		}else {
			while(last != null) {
				count++;
				last =last.next;
			}
		}
		return count;
	}

	public int getLengthRec(Node n) {
		if(n == null) {
			return 0;
		}
		return 1+ getLengthRec(n.next);
	}

	public int recursiveLength() {
		return getLengthRec(head);
	}

	public int getNthNode(int index) {
		Node last = head;
		int count = 1;
		while(count != index) {
			last = last.next;
			count++;
		}
		return last.data;

	}

	public int detectLoop() {
		Node slowPointer = head;
		Node fastPointer = head;

		if(head != null) {
			while(slowPointer != null && fastPointer != null) {
				slowPointer = slowPointer.next;
				fastPointer = fastPointer.next.next;
				if(slowPointer == fastPointer){
					System.out.println("Loop Detected");
					return 1;
				}
			}
		}
		System.out.println("LinkedList is null.");
		return 0;
	}

	public int noOfOccurences(int x){
		Node traverse = head;
		int count = 0;
		while(traverse != null) {
			if(traverse.data == x) {
				count++;
			}
			traverse = traverse.next;
		}

		return count;
	}

	public void removeDuplicatesFromSortedLL(){

		Node current = head;	       
		Node next_next;

		if (head == null)    
			return;

		while (current.next != null) {
			if (current.data == current.next.data) {
				next_next = current.next.next;
				current.next = null;
				current.next = next_next;
			}
			else
				current = current.next;
		}
	}

	public boolean searchLL(Node head, int elem) {


		while(head != null) {
			if(head.data == elem) {
				return true;
			}
			head = head.next;
		}

		return false;
	}

	public int getNthNode(Node head, int n) {
		Node node = head;

		int count = 1;
		while(node!= null) {
			if(count == n) {
				return node.data;
			}
			node = node.next;
			count++;
		}
		return 0;
	}

	public int getNthNodeFromEnd(Node head, int n) {

		Node node = head;
		int count = 0;

		while(node != null) {
			node = node.next;
			count++;
		}

		if(count < n) {
			return 0;
		}

		int nFromStart = count- n + 1;
		node = head;
		count =1;
		while(node != null) {
			if(count == nFromStart) {
				return node.data;
			}
			node = node.next;
			count++;
		}
		return 0;
	}

	public boolean detectLoopHashSet(Node head) {
		Node node = head;

		Set<Node> hSet = new HashSet<Node>();
		while(node!= null) {


			if(hSet.contains(node)) {
				return true;
			}
			hSet.add(node);
			node = node.next;
		}
		return false;

	}

	public Node getMiddleNode(Node head) {
		Node node = head;
		Node slowPointer = node;
		Node fastPointer = node;

		if(node == null) {
			return null;
		}

		while(fastPointer != null && fastPointer.next != null) {
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;
		}

		return slowPointer;

	}

	public int getNoOfOccurences(Node head, int x) {

		if(head == null) {
			return 0;
		}
		Node node = head;
		int count = 0;
		while(node != null) {

			if(node.data == x)
			{ 
				count++;	
			}
			node = node.next;
		}


		return count;
	}

	public boolean get(Node head, Node search) {
		Node node = head;
		if(node == null) {
			return false;
		}else if(node == node.next) {
			return false;
		}else {

			Node prev = node;
			Node curr = node;

			while(node!= null) {

				if(prev.data < search.data && search.data < curr.data) {
					search.next = prev.next;
					prev.next = search;
				}
				node = node.next;

			}


		}
		return false;
	}

	public int getDecimalValue(Node head) {
		Stack<Integer> s = new Stack<Integer>();

		while(head != null){
			s.push(head.data);
			head = head.next;
		}

		int index = 0;
		int result = 0;

		while(!s.empty()){
			result = result + ((int)Math.pow(2,index)* s.pop());
			index++;
		}


		return result;

	}

	public int loopLength(Node head){

		Node slowP = head;
		Node fastP = head;
		boolean flag = false;

		while(fastP != null || fastP.next != null){
			slowP = slowP.next;
			fastP = fastP.next.next;

			if(slowP == fastP){
				flag = true;
				break;
			}
		}

		int count = 0;
		if(flag == true){
			do{
				slowP = slowP.next;
				count++;
			}while(slowP != fastP);
		}

		return count;
	}

	public Node reverseLL(Node head) {

		Node p = head;
		Node q = null;
		Node r = null;

		while(p != null) {
			r = q;
			q = p;
			p = p.next;
			q.next = r;
		}

		head = q;

		return head;
	}

	public Node removeDups(Node node){

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Node head = node;
		Node prev = null;

		while(head != null){
			if(!map.containsKey(head.data)){
				map.put(head.data, 1);
			}else{
				head = head.next;
				prev.next = head;
				continue;
			}

			prev = head;
			head = head.next;
		}

		return node;
	}
	
	public Node removeDupsSortedLL(Node node){
	
		Node head = node;
		Node prev = null;
		
		while(head != null) {
			if(prev != null && head.data == prev.data) {
				head = head.next;
				prev.next = head;
				continue;
			}
			
			prev = head;
			head = head.next;
		}
		
		return node;
		
	}

	public Node mergeLL(Node node1, Node node2) {
		Node first = node1;
		Node second = node2;
			
		return null;
		
	}
	
	public static void main(String[] args) {

		LinkedList ll = new LinkedList();
		ll.pushAtEnd(11);
		ll.pushAtEnd(11);
		ll.pushAtEnd(11);
		ll.pushAtEnd(13);
		ll.pushAtEnd(13);
		ll.pushAtEnd(20);
		
		Node node = ll.removeDupsSortedLL(ll.head);
		
		while(node != null) {
			System.out.println(node.data);
			node = node.next;
		}
	}

}
