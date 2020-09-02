package ds.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

	Node root;

	public BinaryTree(){
		this.root = null;
	}

	public void preOrderTraversal(Node node) {
		if(node == null) {
			return;
		}

		System.out.println(node.data + " ");
		preOrderTraversal(node.left);
		preOrderTraversal(node.right);
	}

	public void inOrderTraversal(Node node) {
		if(node == null) {
			return;
		}

		inOrderTraversal(node.left);
		System.out.println(node.data);
		inOrderTraversal(node.right);
	}

	public void postOrderTraversal(Node node) {
		if(node == null) {
			return;
		}

		postOrderTraversal(node.left);
		postOrderTraversal(node.right);
		System.out.println(node.data);
	}

	public void preOrderNonRecursive(Node node) {

		Stack<Node> s = new Stack<Node>();

		s.push(node);

		while(!s.isEmpty()) {
			Node eNode = s.pop();

			System.out.println(eNode.data);

			if(eNode.right != null) {
				s.push(eNode.right);
			}
			if(eNode.left != null) {
				s.push(eNode.left);
			}
		}

	}

	public void inOrderNonRecursive(Node node) {
		Stack<Node> s = new Stack<Node>();
		Node current = node;

		while (current!= null || s.size() >0) {
			while(current != null) {
				s.push(current);
				current = current.left;
			}
			current = s.pop();
			System.out.println(current.data);
			current = current.right;
		}
	}

	public void levelOrderTraversal(Node node){
		Queue<Node> q = new LinkedList<Node>();
		
		q.add(node);
		while(!q.isEmpty()) {
			Node n = q.poll();
			System.out.println(n.data);
			if(n.left != null) {
				q.add(n.left);
			}
			if(n.right != null) {
				q.add(n.right);
			}
		}
	}

	public int findMax(Node node) {
		int root_val, leftMax, rightMax, max = 0;
		if(node == null) {
			return 0;
		}
		root_val = node.data;
		leftMax = findMax(node.left);
		rightMax = findMax(node.right);

		if(leftMax > rightMax) {
			max = leftMax;
		}else {
			max =rightMax;
		}

		if(max < root_val) {
			max = root_val;
		}

		return max;
	}

	public int findMaxIteration(Node node){
		// Using LevelOrder traversal and observing while deleting from Queue

		if(node == null) {
			return 0;
		}
		Queue<Node> q = new LinkedList<Node>();
		q.add(node);
		Node tempNode;
		int max = node.data;
		while(q.size()>0) {
			tempNode = q.remove();
			if(max< tempNode.data) {
				max = tempNode.data;
			}
			if(tempNode.left != null) {
				q.add(tempNode.left);
			}
			if(tempNode.right != null) {
				q.add(tempNode.right);
			}
		}

		return max;

	}

	public int searchInBinaryTreeRecursion(Node node, int searchData){
		if(node == null) {
			return 0;
		}
		int temp;
		if(node.data == searchData) {
			return 1;
		}else {
			temp = searchInBinaryTreeRecursion(node.left, searchData);
			if( temp == 1) {
				return temp;
			}else {
				return searchInBinaryTreeRecursion(node.right, searchData);
			}
		}	
	}

	public int searchInBinaryTreeIteration(Node node, int searchData) {
		// Using Level Order Traversal
		Queue<Node> q = new LinkedList<Node>();
		Node tempNode;
		q.add(node);
		while(q.size() > 0) {
			tempNode = q.remove();
			if(tempNode.data == searchData) {
				return 1;
			}
			if(tempNode.left != null) {
				q.add(tempNode.left);
			}
			if(tempNode.right != null) {
				q.add(tempNode.right);
			}
		}
		return 0;
	}


	public void insertingIntoBinaryTree(Node node, Node insertNode) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(node);

		Node tempNode;
		boolean inserted = false;
		while(!q.isEmpty()) {
			tempNode = q.remove();

			if(tempNode.left != null) {
				q.add(tempNode.left);
			}
			if(tempNode.right != null) {
				q.add(tempNode.right);
			}

			if(tempNode.left == null && tempNode.right == null && !inserted) {
				tempNode.left = insertNode;
				inserted = true;
			}
		}		
	}

	public int sizeOfBinaryTreeRecursion(Node node) {
		if(node == null) {
			return 0;
		}else {
			return (sizeOfBinaryTreeRecursion(node.left)+ 1 + sizeOfBinaryTreeRecursion(node.right));
		}
	}

	public void levelOrderReversal(Node node) {
		Queue<Node> q = new LinkedList<Node>();
		Stack<Node> s = new Stack<Node>();

		q.add(node);
		Node tempNode;

		while(!q.isEmpty()) {
			tempNode = q.remove();

			s.push(tempNode);
			if(tempNode.right != null) {
				q.add(tempNode.right);
			}
			if(tempNode.left != null) {
				q.add(tempNode.left);
			}
		}

		while(!s.isEmpty()) {
			System.out.println(s.pop().data);
		}
	}

	public Node deleteBinaryTree(Node node) {
		if(node == null) {
			return null;
		}else {
			this.deleteBinaryTree(node.left);
			this.deleteBinaryTree(node.right);
			node = null;
			return node;
		}
	}

	public boolean AreStructurallySameTrees(Node node1, Node node2) {

		if(node1 == null && node2 == null) {
			return true;
		}
		if(node1 == null || node2 == null) {
			return false;
		}

		return ((node1.data == node2.data )&& AreStructurallySameTrees(node1.left, node2.left) && AreStructurallySameTrees(node1.right, node2.right));
	}

	public int getLevel(Node node, int data, int level) {
		if(node == null) {
			return 0;
		}
		if(node.data == data) {
			return level;
		}
		int leve = getLevel(node.left, data, level+1);
		if(leve != 0) {
			return leve;
		}
		leve = getLevel(node.right, data, level+1);
		return leve;
	}

	public int maxElement(Node root) {
		
		if(root == null) {
			return -1;
		}else if(root.left == null){
			if(root.data > maxElement(root.right)) {
				return root.data;
			}else {
				return maxElement(root.right);
			}
		}else if(root.right == null) {
			if(root.data > maxElement(root.left)) {
				return root.data;
			}else {
				return maxElement(root.left);
			}
		}else {
			int max = 0;
			if(maxElement(root.left) > maxElement(root.right)) {
				max = maxElement(root.left);
			}else {
				max = maxElement(root.right);
			}
			
			if(max > root.data) {
				return max;
			}else {
				return root.data;
			}
		}
	}
	
	public void sumPaths(Node node, int paths, int sum) {
	
		if(node == null) {
			return;
		}else {
			
			sum+=node.data;
			sumPaths(node.left, paths, sum);
			sumPaths(node.right, paths, sum);
			
			if(node.left == null && node.right == null) {
				if(sum > 0)
					System.out.println(paths+1);
			}
		}
	}	
	
	
	public void printLeafNodes(Node node) {
		if(node == null) {
			return;
		}
		printLeafNodes(node.left);
		printLeafNodes(node.right);
		if(node.left == null && node.right == null) {
			System.out.println(node.data);
		}
		
	}
	
	public void deepestLeftLeafNode(Node node) {
		
		if(node == null) {
			return;
		}
		
		printLeafNodes(node.left);
		
		if(node.left == null && node.right == null) {
			System.out.println(node.data);
		}
		
	}
	
	
	public void printAllPaths(Node node) {
		int[] arr = new int[1000];
		printEachPath(node, arr, 0);
	}
	
	
	private void printEachPath(Node node, int[] arr, int length) {
		
		if(node == null) {
			return;
		}
		
		arr[length] = node.data;
		length++;
		
		if(node.left == null && node.right == null) {
			printArray(arr, length);
		}else {
			printEachPath(node.left, arr, length);
			printEachPath(node.right, arr, length);
		}
		
	}

	private void printArray(int[] arr, int length) {
		for(int i=0; i< length; i++) {
			System.out.print(arr[i]);
		}
		System.out.println("");
	}
	
	public boolean isFoldable(Node node) {
		if(node == null) {
			return true;
		}
		
		return foldableUtil(node.left, node.right);
		
	}
	
	public boolean foldableUtil(Node node1, Node node2) {
		if(node1 != null && node2 != null) {
			return true;
		}
		if(node1 == null && node2 == null) {
			return true;
		}
		return false;
	}
	

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new Node(1);
		bt.root.left = new Node(2);
		bt.root.right = new Node(3);
		bt.root.left.left = new Node(4);
		bt.root.right.left = new Node(5);
		bt.root.right.right = new Node(8);
		bt.root.right.left.left = new Node(6);
		bt.root.right.left.right = new Node(7);
		bt.root.right.right.left = new Node(9);
		bt.root.right.right.right = new Node(10);
		
		System.out.println(bt.isFoldable(bt.root));
	}

}
