package ds.trees;

public class BinarySearchTree {

	Node root;
	public BinarySearchTree(){
		this.root = null;
	}

	public Node searchRecursive(Node node, int data) {
		if(node == null) {
			return null;
		}else {
			if(node.data == data) {
				return node;
			}else if(data < node.data) {
				return searchRecursive(node.left, data);
			}else {
				return searchRecursive(node.right, data);
			}
		}
	}
	
	public void insert(int data) {
		root = insert(root, data );
	}
	
	public Node insert(Node root, int data) {
		if(root == null) {
			root = new Node(data);
			return root;
		}else {
			if(data < root.data) {
				root.left = insert(root.left, data);
			}else if(data > root.data){
				root.right = insert(root.right, data);
			}
		}
		return root;
	}
	
	public int maxElement(Node root) {
		if(root == null) {
			return -1;
		}else if(root.right == null){
			return root.data;
		}else {
			return maxElement(root.right);
		}
	}



	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(40);
		bst.insert(30);
		bst.insert(50);
		bst.insert(20);
		
		System.out.println(bst.maxElement(bst.root));
	}

}
