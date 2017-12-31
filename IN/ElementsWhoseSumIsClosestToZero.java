/*

https://www.geeksforgeeks.org/two-elements-whose-sum-is-closest-to-zero/

1) Sort all the elements of the input array.
2) Use two index variables l and r to traverse from left and right ends respectively. Initialize l as 0 and r as n-1.
3) sum = a[l] + a[r]
4) If sum is -ve, then l++
5) If sum is +ve, then r–
6) Keep track of abs min sum.
7) Repeat steps 3, 4, 5 and 6 while l < r Implementation

Time Complexity: O(nlogn) for sorting + O(n) for finding the min pair. Total = O(nlogn)

*/

import java.util.*;

class ElementsWhoseSumIsClosestToZero {

	public static int sumClosestToZero(int arr[]) {

		Arrays.sort(arr);
		int l=0;
		int r=arr.length-1;
		int min = arr[l]+arr[r];
		List<Integer> output = new ArrayList<>();
		output.add(arr[l]);
		output.add(arr[r]);
		l++; r--;

		while(l<r) {

			int diff = arr[l]+arr[r];
			if(Math.abs(diff) < Math.abs(min)) {
				min= diff;
				output.clear();
				output.add(arr[l]);
				output.add(arr[r]);
			}
			if( diff < 0 )
				l++;
			else if(diff > 0)
				r--;
		}

		System.out.println(Arrays.toString(output.toArray()));
		return min;
	}

	public static void main(String args[]) {

		int arr[] = {1, 60, -10, 70, -80, 85};
		System.out.println(sumClosestToZero(arr));
	}
}