/*let's create a binary tree
	1	//       8
	2	//   5         12
	3	// 2   6    10     17

// BFS:   8 5 12 2 6 10 17



left                         root      right
left of (8)                   8        right of (8)

left(5) 5 right of (5)


preorder: root, left, right
8 5 2 6 12 10 17 


post order: left right root
 2 6 5 10 17 12 8


 f(node) {
	
	if(node==null)
		return;
	f(8.left);
	f(8.right);
	print 8;

 }

 f(8)

2 6 5 10 17 12 8



Traversals:
1. DFS - Depth --- Inorder, Preorder, Postorder
2. BFS - Breadth (level order)





*/


class Node {
	int value;
	Node left;
	Node right;

	Node (int val){
		this.value = val;
		this.left = null;
		this.right = null;
	}

}

class tree {
	public static void main(String args[]) {
		Node root = new Node(8); 
		//                 8
		//       5                   12
		// null     null      null         null
		Node l = new Node(5);
		root.left = l;
		root.right = new Node(12);
	}
}








