/*

https://www.geeksforgeeks.org/count-distinct-elements-in-every-window-of-size-k/


Efficient solution for distinct elements in a window of size 'k'


*/

import java.util.*;

class DistinctElementsInAnArray {

	public static int distinctElements(int arr[]) {

		Set<Integer> set = new HashSet<>();
		for(int i : arr) {
			if(!set.contains(i))
				set.add(i);
		}
		return set.size();
	}

	public static void distinctElementsInkWindow(int arr[], int k) {

		Set<Integer> set = new HashSet<>();
		int i=0;
		int j=i;

		while( i+k-1 < arr.length ) {
			if(!set.contains(arr[j]))
				set.add(arr[j]);

			if(j==k+i-1) {
				System.out.println(set.size());
				set.clear();
				i++;
				j=i;
			}
			else
				j++;
		}
	}

	/* Distinct elements in 'k' window in better way */
	public static void distinctElementsInkWindowBetterSolution(int arr[], int k) {

		Map<Integer,Integer> map = new HashMap<>();
		int count=0;

		int i;
		// 1. Add all elements in FIRST window to Hashmap with "element:count" and print the count of unique elements.
		for(i=0; i<k; i++) {
			if(map.containsKey(arr[i])) {
				int c = map.get(arr[i]);
				map.put(arr[i], c+1 );
			}
			else {
				count++;
				map.put(arr[i],1);
			}
		}
		System.out.println(count);


		while(i<arr.length) {

			// 2) Remove the first element from previous window [i-k]:
			//		if the count of element is 1, remove it from HashMap and decrement the overall count of unique elements.
			if( map.get(arr[i-k])==1 ) {
				map.remove(arr[i-k]);
				count--;
			}
			// 		else, update the HashMap
			else
				map.put( arr[i-k], map.get(arr[i-k])-1 );
				

			// 3) Add the last element [i] to the current window:
			//		if the element not present, put it in HashMap and increment the overall count of unique elements.
			if(!map.containsKey(arr[i])) {
				map.put(arr[i],1);
				count++;
			}
			//		else, just update the HashMap entry
			else {
				int c = map.get(arr[i]);
				map.put( arr[i], c+1 );
			}

			// 3) Print the count for the new window
			System.out.println(count);
			i++;
		}
	}

	public static void main(String args[]) {

		int arr[] = {10, 21, 22, 10, 31, 10, 21, 22, 301};
		int arr2[] = {1, 2, 1, 3, 4, 2, 3, 1, 3, 3, 1};
		//System.out.println(distinctElements(arr));
		//distinctElementsInkWindow(arr2,4);
		distinctElementsInkWindowBetterSolution(arr2,4);

	}
}