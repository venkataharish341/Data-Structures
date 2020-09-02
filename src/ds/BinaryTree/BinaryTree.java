package ds.BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class Node {
	int data;
	Node left;
	Node right;

	public Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

class Leaf{
	int level;
}

public class BinaryTree {

	private Node root;

	public BinaryTree() {
		this.root = null;
	}

	public int height(Node node){

		if(node == null) {
			return 0;
		}else {
			int x = height(node.left);
			int y = height(node.right);

			if(x > y) {
				return x+1;
			}else {
				return y+1;
			}
		}		
	}

	public int countLeafNodes(Node node){

		if(node == null) {
			return 0;
		}else {
			int x = countLeafNodes(node.left);
			int y = countLeafNodes(node.right);

			if(node.left == null && node.right == null) {
				return x+y+1;
			}else {
				return x+y;
			}
		}
	}

	public boolean isSumTree(Node node) {
		if(node == null) {
			return true;
		}else if(node.left == null && node.right == null){
			return true;
		}else {
			if(node.data == sumOfNodes(node.left) + sumOfNodes(node.right) && 
					isSumTree(node.left) && isSumTree(node.right)) {
				return true;
			}else {
				return false;
			}
		}
	}

	private int sumOfNodes(Node node){

		if(node == null) {
			return 0;
		}else {
			int x = sumOfNodes(node.left);
			int y = sumOfNodes(node.right);
			return x+y+node.data;
		}

	}

	public int sumUncoveredLeft(Node node){
		if(node.left == null && node.right == null) {
			return node.data;
		}
		if(node.left != null) {
			return node.data + sumUncoveredLeft(node.left);
		}else {
			return node.data + sumUncoveredLeft(node.right);
		}
	}
	
	public int sumUncoveredRight(Node node){
		if(node.left == null && node.right == null) {
			return node.data;
		}
		if(node.right != null) {
			return node.data + sumUncoveredRight(node.right);
		}else {
			return node.data + sumUncoveredRight(node.left);
		}
	}
	
	public List<String> btp(Node node){
		
		List<String> arrList  = new ArrayList<String>();
		
		btp(node, new String(), arrList);
		
		return arrList;
	}
	
	public void btp (Node node, String str, List<String> arrList){
		
		if(node == null) {
			return;
		}
		if(node.left == null && node.right == null) {
			str = str + node.data;
			arrList.add(str);
			return;
		}
		
		btp(node.left, str + node.data + " ", arrList);
		btp(node.right, str + node.data + " ", arrList);
		
	}
	
	public void printDuplicateSubTrees(Node root) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		inOrder(root, map);
		
	}
	

	private String inOrder(Node node, Map<String, Integer> map) {
		
		if(node == null) {
			return "";
		}
		String str = "";
		str+= inOrder(node.left, map);
		str+= node.data;
		str+= inOrder(node.right, map);
		
		if(map.containsKey(str) && map.get(str) == 1) {
			System.out.println(str);
		}
		
		if(map.containsKey(str)) {
			map.put(str, map.get(str) + 1);
		}else {
			map.put(str, 1);
		}
		return str;
	}
	
	public String allSubTrees(Node node) {
		
		if(node == null) {
			return "";
		}
		
		String str = allSubTrees(node.left) + node.data + allSubTrees(node.right);
		
		System.out.println(str);
		
		return str;
	}
	
	static int count = 0;
	
	public int countSubTreesWithSumX(Node node, int x) {
		
		if(node == null) {
			return 0;
		}
		
		int sum = countSubTreesWithSumX(node.left, x)+ node.data+
				countSubTreesWithSumX(node.right, x);
		
		if(sum == x) {
			count++;
		}
		
		return sum;
	}
	
	public void printVertical(Node node, int hd, Map<Integer, String> map){
		
		if(node == null) {
			return;
		}
		
		String s = "";
		if(map.containsKey(hd)) {
			s = map.get(hd) + "," + node.data;
		}else {
			s += node.data;
		}
		
		map.put(hd, s);
		
		printVertical(node.left, hd-1, map);
		printVertical(node.right, hd+1, map);
		
	}

	public void printVerticalPost(Node node, int hd, Map<Integer, String> map){
		
		if(node == null) {
			return;
		}
		
		if(node.left == null && node.right == null) {
			return;
		}
		
		printVertical(node.left, hd-1, map);
		printVertical(node.right, hd+1, map);
		
		String s = "";
		if(map.containsKey(hd)) {
			s = map.get(hd) + "," + node.data;
		}else {
			s += node.data;
		}
		
		map.put(hd, s);
	}
	
	public boolean level(Node node, int level, Leaf leaf) {
	
		if(node == null) {
			return true;
		}
		
		if(node.left == null && node.right == null) {
			if(leaf.level == 0) {
				leaf.level = level;
				return true;
			}else {
				if(leaf.level != level) {
					return false;
				}
			}
		}
		
		return level(node.left, level+1, leaf) && 
				level(node.right, level+1, leaf);
		
	}
	
	
	public Node mirrorImage(Node node){
	
		if(node == null) {
			return null;
		}
		
		Node leftChild = mirrorImage(node.left);
		Node rightChild = mirrorImage(node.right);
	
		node.left = rightChild;
		node.right = leftChild;
		
		return node;
	}
	
	public static void main(String[] args) {

		BinaryTree bt = new BinaryTree();
		bt.root = new Node(5);
		bt.root.left = new Node(6);
		bt.root.right = new Node(7);
		bt.root.left.left = new Node(8);
		bt.root.left.right = new Node(9);
		bt.root.right.left = new Node(4);
		bt.root.right.right = new Node(1);

		bt.mirrorImage(bt.root);
		
		bt.allSubTrees(bt.root);
	}
}
