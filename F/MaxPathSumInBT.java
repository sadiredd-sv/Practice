/*

https://www.geeksforgeeks.org/find-maximum-path-sum-in-a-binary-tree/


*/

class Node {
	int value;
	Node left, right;
	Node(int data) {
		value=data;
		left=right=null;
	}
}

class MaxPathSumInBT {
	
	Node root;

	int findMaxSum(Node n) {
	
		if(n==null)
			return 0;
		int left = findMaxSumUtil(n.left);
		int right = findMaxSumUtil(n.right);

		return n.value + left + right;
	}

	int findMaxSumUtil(Node n) {
		if(n==null)
			return 0;

		return n.value + Math.max(findMaxSumUtil(n.left), findMaxSumUtil(n.right));
	}

	void printInorder(Node node) 
    {
        if (node == null)
            return;
        printInorder(node.left);
        System.out.print(node.value + " ");
        printInorder(node.right);
    }

	public static void main(String args[]) {
		
		MaxPathSumInBT tree = new MaxPathSumInBT();
       	
       	tree.root = new Node(-10);
        tree.root.left = new Node(-2);
        tree.root.right = new Node(-10);
        tree.root.left.left = new Node(-20);
        tree.root.left.right = new Node(-1);
        tree.root.right.right = new Node(-25);
        tree.root.right.right.left = new Node(3);
        tree.root.right.right.right = new Node(4);

        System.out.println("maximum path sum is : " +
                            tree.findMaxSum(tree.root));
	}
}