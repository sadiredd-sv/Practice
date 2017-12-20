/*

http://www.geeksforgeeks.org/write-a-c-program-that-given-a-set-a-of-n-numbers-and-another-number-x-determines-whether-or-not-there-exist-two-elements-in-s-whose-sum-is-exactly-x/

https://www.programcreek.com/2012/12/leetcode-solution-of-two-sum-in-java/

*/

import java.util.*;

class TwoNumberSum {

	/* O(nlogn) + O(n) using sorting */
	public static int[] numberSumUsingSorting(int arr[], int sum) {

		if(arr==null || arr.length<2)
			return new int[]{0,0};

		Arrays.sort(arr);

		int l=0,r=arr.length-1;

		while(l<r) {
			int tmpSum = arr[l]+arr[r];
			if(tmpSum == sum)
				return new int[]{l,r};
			else if(tmpSum > sum)
				r--;
			else
				l++;
		}

		return new int[]{0,0};
	}

	/* O(n) using HashMap */
	public static int[] numberSumUsingHashMap(int arr[], int sum) {

		if(arr==null || arr.length<2)
			return new int[]{0,0};

		Map<Integer,Integer> map = new HashMap<>();

		for(int i=0; i<arr.length; i++) {
			if(map.containsKey(arr[i]))
				return new int[]{map.get(arr[i]),i};
			else
				map.put(sum-arr[i],i);
		}

		return new int[]{0,0};
	}


	/* Find all pairs with given sum */
	public static void allPairsWithGivenSum(int arr[], int sum, ArrayList<ArrayList<Integer>> result) {

		if(arr==null || arr.length<2)
			return;

		Map<Integer,Integer> map = new HashMap<>();

		for(int i=0; i<arr.length; i++) {
			if(map.containsKey(arr[i])) {
				ArrayList<Integer> al = new ArrayList<>();
				al.add( map.get(arr[i]) );
				al.add(i);
				result.add(al);
			}
			else
				map.put(sum-arr[i],i);
		}

	}


	public static void main(String args[]) {

		int arr[]={2, 7, 11, 15};
		System.out.println( Arrays.toString(numberSumUsingHashMap(arr, 17)) );
		System.out.println( Arrays.toString(numberSumUsingSorting(arr,17)) );


		int arr2[]={2, 7, 11, 16};
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		allPairsWithGivenSum(arr2,18,result);
		System.out.println(Arrays.toString(result.toArray()));
	}
}
