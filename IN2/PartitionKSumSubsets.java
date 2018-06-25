
import java.util.*;

class PartitionKSumSubsets {

	static boolean f(int arr[],int n, Set<Integer> set,int k, Map<Integer,Integer> map) {
	
		if(n==0)
			return k==1 ? true: false;

		System.out.println(set);

		
		int sum=0;
		Iterator<Integer> iter = set.iterator();
		while(iter.hasNext())
			sum+=iter.next();
		
		
		if(map.containsKey(sum)) {
			int x = map.get(sum);
			map.put(sum, x+1);
		}
	
		for( Map.Entry<Integer,Integer> entry : map.entrySet() ) {
			if(entry.getValue() == k)
				return true;
		}	

		boolean caseone = f(arr, n-1, set, k,map);
		set.add(arr[n]);
		boolean casetwo = f( arr, n-1, set, k, map );
		return (caseone || casetwo);
	}

	public static void main(String args[]) {

		Map<Integer,Integer> map = new HashMap<>();
		int arr[] = {2, 1, 4, 5, 6};
		System.out.println( f(arr, arr.length-1, new HashSet<Integer>(),3,map) );
	}
}