import java.util.*;

class BinaryTreeInVerticalOrder {

	static HashMap<Integer,ArrayList<Integer>> hm = new HashMap<Integer,ArrayList<Integer>>();
	static ArrayList<Integer> al=null;

	static void verticalOrder(Node n, int v){

		if(n==null)
			return;

		if(n.left!=null)
			verticalOrder(n.left,v-1);

		if(hm.get(n.getValue())==null)
			al = new ArrayList<Integer>();
		else
			al = hm.get(v);

		al.add(n.getValue());
		hm.put(v, al);

		if(n.right!=null)
			verticalOrder(n.right,v+1);

	}

	public static void main(String args[]) {
		Construct c = new Construct();
		Node root = c.buildTree();
		verticalOrder(root, 0);
		System.out.println(hm.get(0));
//		for(hm.entrySet())
	}
}