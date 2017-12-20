/*

http://www.geeksforgeeks.org/find-k-closest-elements-given-value/

Input: K = 4, X = 35
       arr[] = {12, 16, 22, 30, 35, 39, 42, 
               45, 48, 50, 53, 55, 56}
Output: 30 39 42 45


O(Logn + k)

*/

import java.util.*;

class KclosestElementsToAvalue {
	
	public static void kClosestElements(int arr[], int mid, int k, int target) {

		List<Integer> result = new ArrayList<Integer>();

		int l = mid, r=mid+1;

		if(arr[mid]==target)
			l--;
		
		while(k>0 && l>=0 && r<arr.length) {

			if(( target-arr[l]) < (arr[r]-target )) {
				result.add(arr[l]);
				l--;
			} else {
				result.add(arr[r]);
				r++;
			}
			k--;
		}

		while(k>0 && r<arr.length) {
			result.add(arr[r]);
			r++;
			k--;
		}

		while(k>0 && l>=0) {
			result.add(arr[l]);
			l--;
			k--;
		}

		System.out.println(Arrays.toString(result.toArray()));
	}

	public static int binarySearch(int arr[], int l, int r, int target) {

		if(target<arr[l])
			return l;
		if(target>=arr[r])
			return r;
		//if(l<r) {
		int mid = (l+r)/2;

		if(arr[mid]==target)
			return mid;
		else if(arr[mid]>target)
			return binarySearch(arr,l,mid-1,target);
		else
			return binarySearch(arr,mid+1,r,target);
		// }
		// return l;
	}

	public static void main(String args[]) {

		int arr[] = {12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56};
        int x = 32;
		int mid = binarySearch(arr,0,arr.length-1,x);
		kClosestElements(arr,mid,4,x);
	}	
}