/*

https://www.geeksforgeeks.org/check-if-a-given-binary-tree-is-sumtree/

 		  26
        /   \
      10     3
    /    \     \
  4      6      3


Linear complexity algorithm:
1. if left and right are leaves, just check if node's value = left + right
2. if not root, check if the node's value = 2 * (left+right)

*/

class Node {

	int data;
	Node left, right;
	Node(int data){
		this.data= data;
		this.left=this.right=null;
	}
}

class CheckIfSumTree {

	Node root;

	int sum(Node n) {

		if(n==null)
			return 0;
		return sum(n.left) + n.data + sum(n.right);
	}


	/* Time Complexity: O(n^2) in worst case */
	boolean checkSumTree(Node n) {

		if( n==null || (n.left==null && n.right==null ))
			return true;

		int leftsum = sum(n.left);
		int rightsum = sum(n.right);

		if( (leftsum+rightsum==n.data) && checkSumTree(n.left) && checkSumTree(n.right) )
			return true;

		return false;
	}


	/* Linear time complexity: O(n) */
	boolean isLeaf(Node n) {

		if(n==null)
			return false;
		if(n.left==null && n.right==null)
			return true;
		return false;
	}

	boolean linearTimeCheckSumTree(Node n) {

		if(n==null || isLeaf(n))
			return true;

		boolean left = linearTimeCheckSumTree(n.left);
		boolean right = linearTimeCheckSumTree(n.right);

		if(left && right) {

			int leftdata=0;
			if(n.left!=null)
				leftdata = n.left.data;
			
			int rightdata = 0;
			if(n.right!=null)
				rightdata = n.right.data;

			if(!isLeaf(n.left))
				leftdata = 2*leftdata;

			if(!isLeaf(n.right))
				rightdata = 2*rightdata;

			return n.data==(leftdata+rightdata);
		}

		return false;

	}

	public static void main(String args[]) {

		CheckIfSumTree tree = new CheckIfSumTree();
     	tree.root = new Node(26);
        tree.root.left = new Node(10);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(6);
        tree.root.right.right = new Node(3);
        System.out.println(tree.linearTimeCheckSumTree(tree.root));
	}
}