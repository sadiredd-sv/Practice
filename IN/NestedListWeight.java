/*

https://www.programcreek.com/2014/05/leetcode-nested-list-weight-sum-java/

Given a nested list of integers, return the sum of all integers in the list weighted by their depth.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Example:
Given the list [[1,1],2,[1,1]], return 10. (four 1's at depth 2, one 2 at depth 1)

*/

import java.util.*;

class NestedInteger {
	private List<NestedInteger> list;
	private Integer integer;

	NestedInteger(List<NestedInteger> list) {
		this.list = list;
	}

	NestedInteger(Integer integer) {
		this.integer = integer;
	}

	public boolean isInteger(){
		return integer!=null;
	}

	public Integer getInteger(){
		return integer;
	}

	public List<NestedInteger> getList(){
		return list;
	}
}

class NestedListWeight {

	/* Recursive- Depth Sum */
	public static int calcNestedListWeight(List<NestedInteger> list, int factor) {
		
		if( list==null || list.size()==0 )
			return 0;

		int sum=0;
		
		for(NestedInteger n : list ) {
			if(n.isInteger())
				sum+=n.getInteger()*factor;
			else
				sum+=calcNestedListWeight( n.getList(), factor+1);
		}

		return sum;
	} 

	/* Iterative - Using 2 queues */
	public static int iterativeCalcNestedListWeight(List<NestedInteger> list) {

		if( list==null || list.size()==0 )
			return 0;

		Queue<NestedInteger> queue = new LinkedList<NestedInteger>();
		Queue<Integer> factor = new LinkedList<Integer>();

		for(NestedInteger n : list ){
			queue.add(n);
			factor.add(1);
		}

		int sum=0;
		
		while(!queue.isEmpty()) {
			NestedInteger n = queue.remove(); // or queue.poll() -- throws null when queue is empty. remove() throws exception when Queue is empty.
			int depth = factor.remove();

			if(n.isInteger())
				sum+=n.getInteger()*depth;
			else {
				for(NestedInteger i : n.getList()) {
					queue.add(i); // or queue.offer() -- doesn't throw exception when element can't be added. add() throws exception when element cant be added.
					factor.add(depth+1);
				}
			}
		}

		return sum;

	}

	/* Reverse depth sum :
		http://intgraph.wizmann.tk/Problems/nested-list-reversed-weighted-sum.html
	*/

	public static void main(String args[]) {

		NestedInteger n1 = new NestedInteger(1);
		NestedInteger n2 = new NestedInteger(1);
		List<NestedInteger> l = new ArrayList<NestedInteger>();
		l.add(n1);
		l.add(n2);
		NestedInteger first = new NestedInteger(l);

		NestedInteger second = new NestedInteger(2);
		NestedInteger third = new NestedInteger(l);

		List<NestedInteger> list = new ArrayList<NestedInteger>();
		list.add(first);
		list.add(second);
		list.add(third);

		System.out.println(calcNestedListWeight(list,1));
		System.out.println(iterativeCalcNestedListWeight(list));
	}
}