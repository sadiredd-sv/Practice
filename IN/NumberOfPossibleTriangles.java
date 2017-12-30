/*

https://www.geeksforgeeks.org/find-number-of-triangles-possible/

*/

import java.util.*;

class NumberOfPossibleTriangles {

	/* Search for all elements greater than x */
	int binarySearch(int arr[], int x, int l, int r) {
		
		if(l<=r) {
			int mid = (l+r)/2;
			if(arr[mid] > x)
				return (r-mid+1) + binarySearch(arr,x,l,mid-1);
			else
				return binarySearch(arr,x,mid+1,r);
		}
		return 0;
	}

	int countTriangles(int arr[]) {

		int count=0;

		for(int i=0; i<= arr.length-3; i++) {
			for(int k=i+2; k<= arr.length-1; k++) {
				int diff = arr[k]-arr[i];
				count+=binarySearch(arr, diff,i+1,k-1);
			}
		}

		return count;
	}

	public static void main(String args[]) {

		int arr[] = {10, 21, 22, 100, 101, 200, 300, 301};
		NumberOfPossibleTriangles triangles = new NumberOfPossibleTriangles();
		System.out.println( triangles.countTriangles(arr) );
	}
}