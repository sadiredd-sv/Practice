import java.util.*;

class Node {
	int value;
	Node left, right;

	Node(int value) {
		this.value = value;
		this.left= null;
		this.right=null;
	}
}

class BinaryTreeMaxDepth {

	Node root;

	/* Height of a tree */
	int maxDepth(Node n) {

		if(n==null)
			return 0;

		return 1+Math.max(maxDepth(n.left),maxDepth(n.right));
	}

	void levelOrderTravesal(Node n){

		for(int i=1; i<=maxDepth(n); i++) {
			recursionLevelOrderTraversalUtil(n,i);
			System.out.println();
		}
	}

	/* Recursion - Level Order */
	void recursionLevelOrderTraversalUtil(Node n, int h) {
		
		if(n==null)
			return;
		if(h==1)
			System.out.println(n.value);
		else {
			recursionLevelOrderTraversalUtil(n.left,h-1);
			recursionLevelOrderTraversalUtil(n.right,h-1);
		}
	}
 	
 	/* Iteration - Level Order */
 	void iterationLevelOrder(Node n) {

 		Queue<Node> queue = new LinkedList<Node>();
 		queue.add(n);

 		while(!queue.isEmpty()) {
 			Node dequeued = queue.remove();
 			System.out.println(dequeued.value);
 			if(dequeued.left!=null)
	 			queue.add(dequeued.left);
	 		if(dequeued.right!=null)
 			queue.add(dequeued.right);
 		}
 	}

	public static void main(String args[]) {

		BinaryTreeMaxDepth b = new BinaryTreeMaxDepth();
		b.root = new Node(1);
		b.root.left = new Node(2);
        b.root.right = new Node(3);
        b.root.right.left = new Node(9);
        b.root.right.right = new Node(10);
        b.root.left.left = new Node(4);
       	b.root.left.right = new Node(5);
       	b.root.left.right.left = new Node(8);

       	//System.out.println(b.maxDepth(b.root));

       	System.out.println("Level order using recursion");
       	b.levelOrderTravesal(b.root);
       	System.out.println("Level order using iteration - queue");
       	b.iterationLevelOrder(b.root);
	}
}