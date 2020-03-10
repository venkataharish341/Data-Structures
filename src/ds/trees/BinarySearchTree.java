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


	public Node searchNonRecursive(Node node, int data) {
		if(node == null) {
			return null;
		}else 
		{
			/*if() {
			}*/	
		}





		return null;
	}



	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.root = new Node(5);
		bst.root.left = new Node(3);
		bst.root.left.left = new Node(2);
		bst.root.left.right = new Node(4);
		bst.root.right = new Node(7);
		bst.root.right.left = new Node(6);
		bst.root.right.right = new Node(8);

		System.out.println(bst.searchRecursive(bst.root, 8).data);
		System.out.println(bst.searchRecursive(bst.root, 8).left);
		System.out.println(bst.searchRecursive(bst.root, 8).right);
	}

}
