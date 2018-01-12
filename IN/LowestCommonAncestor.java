/*

https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/

Node f(Node n, Node n1, Node n2) {
	
	if(n==null  )
		return null;

	if(n.value==n1.value || n.value==n2.value)
		return n;
	
	Node left = f(n.left,n1,n2);
	Node right = f(n.right,n1,n2);

	if(left!=null && right!=null)
		return n;
	return (left!=null) ? left : right;
	
}


O(n)


*/

class Node {
	int value;
	Node left, right;
	Node(int data) {
		value=data;
		left=right=null;
	}
}

class LowestCommonAncestor {

	Node root;

	boolean v1,v2;
	
	Node findLCAUtil(Node n, int n1, int n2) {

		if(n==null)
			return null;

		if(n.value==n1) {
			v1=true;
			return n;
		}

		if(n.value==n2) {
			v2=true;
			return n;
		}

		Node left = findLCAUtil(n.left,n1,n2);
		Node right = findLCAUtil(n.right,n1,n2);

		if(left!=null && right!=null)
			return n;
		return left!=null? left : right;
	}

	// To handle cases where n1 or n2 is null
	Node findLCA(int n1, int n2) {

		v1=v2=false;

		Node n = findLCAUtil(root,n1,n2);

		if(v1 && v2)
			return n;

		return null;

	}
	
	public static void main(String args[]) {

		LowestCommonAncestor tree = new LowestCommonAncestor();
		tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        System.out.println("LCA(4, 5) = " +
                            tree.findLCA(4, 5).value);
        System.out.println("LCA(4, 6) = " +
                            tree.findLCA( 4, 6).value);
        System.out.println("LCA(3, 4) = " +
                            tree.findLCA( 3, 4).value);

        Node output = tree.findLCA( 2, 4);
        if(output!=null)
	        System.out.println("LCA(2, 4) = " +output.value);
	    else
	    	System.out.println("No LCA");

	}
}