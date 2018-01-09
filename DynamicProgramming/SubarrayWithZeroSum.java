/*

http://www.geeksforgeeks.org/find-the-largest-subarray-with-0-sum/

{15, -2, 2, -8, 1, 7, 10, 23}



Algorithm:

If the current sum has been seen before, then there is a zero sum array

Sum=0
1. Do sum+arr[i]
2. If this sum is present in the hashmap(zero sum is found), calculate i-hm.get(sum)
3. If this value is greater than max, assign max = i-hm.get(sum)
4. If this sum isn't present(step 2 above), put the current element in the hashmap

*/

import java.util.*;

class SubarrayWithZeroSum {

	/* O(n^2) complexity */
	int maxSubarrayNonLinear(int arr[]) {

		int max=0;
		for(int i=0; i< arr.length; i++){
			int sum=0;
			for(int j=i; j< arr.length; j++) {
				sum+=arr[j];
				if(sum==0)
					max = Math.max(j-i+1, max);
			}
		}
		return max;
	}

	/* Linear time */
	int maxSubarrayLinearSolution(int arr[]) {

		int sum=0;
		int max=0;
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i=0; i< arr.length; i++) {
			sum+=arr[i];
			if(map.get(sum)!=null)
				max=Math.max(i-map.get(sum),max);
			else
				map.put(arr[i],i);
		}
		return max;
	}

	public static void main(String args[]) {
		SubarrayWithZeroSum ob = new SubarrayWithZeroSum();
		int arr[] = {15, -2, 2, -8, 1, 7, 10, 23};
		//int arr[] = {1, 2, 3};
		//int arr[] = {1, 0, 3};
		System.out.println( ob.maxSubarrayLinearSolution(arr) );
		System.out.println( ob.maxSubarrayNonLinear(arr) );
	}
}