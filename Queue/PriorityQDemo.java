import java.util.*;

class PriorityQDemo {
	public static void main(String args[]) {

		int arr[] = {4, 1, 14, 8, 16, 2};
		int k = 3;
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(k);

		for(int n : arr) {
			q.offer(n);

			if(q.size() > 3)
				q.poll();
		}

		System.out.println(q.peek());
	}
}