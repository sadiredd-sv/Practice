/*

https://www.geeksforgeeks.org/print-nodes-distance-k-given-node-binary-tree/

*/

class Node {

	int value;
	boolean leftChild, rightChild;
	Node left, right, parent;
	Node(int value) {
		this.value = value;
		left=right=parent=null;
		leftChild=rightChild=false;
	}
}

class AllNodesAtkDistance {
	
	Node root;

	int allNodesAtkDistance(Node n, int k, Node previous) {

		if(n==null)
			return 0;

		if(k==0) {
			System.out.println(n.value);
			return 1;
		}

		if( previous!=null && previous.parent==n )
			return allNodesAtkDistance(n.left, k-1, n) + allNodesAtkDistance(n.right, k-1, n);
		else
			return allNodesAtkDistance(n.parent, k-1, n);
	}

	/* Set the parent node for all the nodes as we traverse. Also, find the target node in the tree */
	void setParentAndFindTargetNode(Node n, int target, Node parent) {

		if(n==null)
			return;
		
		n.parent = parent;

		if(n.value==target)
			System.out.println("Number of nodes at k distance: "+allNodesAtkDistance(n,3, null)); //k=3
		else {
			setParentAndFindTargetNode(n.left, target, n);
			setParentAndFindTargetNode(n.right, target, n);
		}

	}

	public static void main(String args[]) {

		AllNodesAtkDistance tree = new AllNodesAtkDistance();
		tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.right = new Node(22);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);
        //tree.setParentForNodes(tree.root,null);


        tree.setParentAndFindTargetNode(tree.root,14, null);

        /* test parent setting */
        //System.out.println(tree.root.left.right.parent.value);
	}
}
