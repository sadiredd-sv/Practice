import java.io.*;

class Node {
	private int value;
	Node left, right;

	Node(int val){
		this.value = val;
		this.left=null;
		this.right=null;
	}

	public void inorder(){

		if(this==null)
			return;
		if(this.left!=null)
			this.left.inorder();
		System.out.println(this.value);
		if(this.right!=null)
			this.right.inorder();
	}

	public int getValue(){
		return value;
	}
}

class Construct {

	public Node buildTree() {
	Node root = new Node(6);
	root.left = new Node(4);
	root.right = new Node(9);
	root.left.left = new Node(3);
	root.left.right = new Node(5);
	root.right.left = new Node(8);
	root.right.right = new Node(10);
	return root;
	}

}
