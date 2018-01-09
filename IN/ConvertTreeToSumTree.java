/*

https://www.geeksforgeeks.org/convert-a-given-tree-to-sum-tree/

				 10
               /      \
         	 -2        6
           /   \      /  \ 
     	  8     -4    7    5

should be changed to

                 20(4-2+12+6)
               /      \
       		4(8-4)      12(7+5)
           /   \      /  \ 
     	 0      0    0    0

 Algorithm:

f(n) {
	
	if(n==null)
	return 0;

	int left = f(n.left);
	int right = f(n.right);
	
	int olddata = n.value;
	n.value = left+right;

	return left+right+old;
}

*/

class Node {
	int value;
	Node left, right;
	Node(int data) {
		value=data;
		left=right=null;
	}
}

class ConvertTreeToSumTree {
	
	Node root;

	int toSumTree(Node n) {
	
		if(n==null)
			return 0;

		int left = toSumTree(n.left);
		int right = toSumTree(n.right);
		int olddata = n.value;
		n.value = left+right;

		return left+right+olddata;
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
		ConvertTreeToSumTree tree = new ConvertTreeToSumTree();
		tree.root = new Node(10);
        tree.root.left = new Node(-2);
        tree.root.right = new Node(6);
        tree.root.left.left = new Node(8);
        tree.root.left.right = new Node(-4);
        tree.root.right.left = new Node(7);
        tree.root.right.right = new Node(5);

        tree.toSumTree(tree.root);

        tree.printInorder(tree.root);
	}
}