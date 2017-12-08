import java.util.*;

class InorderTraversalUsingStack {

	static List<Integer> list = new ArrayList<Integer>();

	public static void InorderWithStack(Node root) {

		Stack<Node> stack = new Stack<Node>();
		Node current = root;

		while(current!=null || !stack.empty()) {

			if(current!=null){
				stack.push(current);
				current = current.left;
			}
			else {
				current = stack.pop();
				//System.out.println(current.getValue());
				list.add(current.getValue());
				current = current.right;
			}
		}
	}

	public static void main(String args[]) {
		Construct c = new Construct();
		Node root = c.buildTree();
		InorderWithStack(root);
		for(Integer i : list )
			System.out.println(i);
	}
}