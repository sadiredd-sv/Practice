/*

https://www.geeksforgeeks.org/boundary-traversal-of-binary-tree/

		  1
	2			3
4	   5	9		10
	8	 11

*/

import java.util.*;

class Node {
	int value;
	Node left,right;

	Node(int value) {
		this.value=value;
		left=right=null;
	}
}

class BoundaryTree {

	Node root;

	void left(Node n ) {

		if(n==null)
			return;

		if(n.left!=null) {
			System.out.println(n.value);
			left(n.left);
		}
		else if(n.right!=null) {
			System.out.println(n.value);
			left(n.right);
		}

	}

	void leaves(Node n) {
		
		if(n==null)
			return;

		if(n.left==null && n.right==null)
			System.out.println(n.value);

		leaves(n.left);
		leaves(n.right);

	}

	void right(Node n) {

		if(n==null)
			return;

		if(n.right!=null) {
			right(n.right);
			System.out.println(n.value);
		}
		else if(n.left!=null) {
			right(n.left);
			System.out.println(n.value);
		}

	}

	void boundary(Node n) {
		left(n.left);
		leaves(n);
		right(n.right);
	}

	public static void main(String args[]) {

		BoundaryTree bt = new BoundaryTree();
		bt.root = new Node(1);
		bt.root.left = new Node(2);
        bt.root.right = new Node(3);
        bt.root.right.left = new Node(9);
        bt.root.right.left.left = new Node(11);
        bt.root.right.right = new Node(10);
        bt.root.left.left = new Node(4);
       	bt.root.left.right = new Node(5);
       	bt.root.left.right.left = new Node(8);

       	bt.boundary(bt.root);

       	//System.out.println(Arrays.toString(bt.hs.toArray()));
	}
}