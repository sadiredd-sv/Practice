/*

http://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/

https://www.programcreek.com/2013/02/leetcode-permutations-java/

[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].

*/

import java.util.*;

class Permutations {

	public static void permutations(int arr[], int start, ArrayList<ArrayList<Integer>> result) {

		if(start==arr.length-1) {
			result.add(convertArrToArrayList(arr));
		}

		for(int i=start;i<arr.length;i++){
			/* if condition to handle duplicates */
			if( i==start || (i!=start && arr[i]!=arr[start]) ) {	
				swap(arr,i,start);
				permutations(arr,start+1,result);
				swap(arr,i,start);
			}
		}
	}

	public static ArrayList<Integer> convertArrToArrayList(int arr[]) {

		ArrayList<Integer> arrList = new ArrayList<>();
		for(int i : arr)
			arrList.add(i);
		return arrList;
	}

	public static void swap(int arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String args[]) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		permutations(new int[]{1,2,3},0,result);
		System.out.println(Arrays.toString(result.toArray()));

		result.clear();
		permutations(new int[]{1,1,2},0,result);
		System.out.println(Arrays.toString(result.toArray()));
	}
}