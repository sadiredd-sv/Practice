/*

https://www.geeksforgeeks.org/heap-sort/

Input data: 4, 10, 3, 5, 1

Steps
1. Assume that the given array is in the form of a Heap:
		4
	10		3
5		1


2. Build Max heap: 
- Root should be greater than left or right child.
- While building map heap, if there is a swap, then apply the same build_max_heap() on the changed node.

3. Swap 0th element with n-1th element, because 0th element is the largest element in the array as we are building the Max heap
- After swapping, build the max heap with 0th element as the root (3.1)

*/

import java.util.*;

class HeapSort {

	public void sort(int arr[]) {

		// step 1
		for(int i=arr.length/2-1;i>=0;i--)
			// step 2
			heapify(arr, arr.length, i); // heapify() with i as the root of the subtree

		// step 3 -- n-1th element is the largest now.
		for(int i=arr.length-1; i>=0; i-- ) {
			int temp = arr[i];
			arr[i]= arr[0];
			arr[0]= temp;
			// step 3.1
			heapify(arr, i, 0);
		}

	}

	public void heapify(int arr[], int n, int i) {

		int largest=i;
		int left = 2*i+1;
		int right = 2*i+2;

		if(left<n && arr[left]>arr[largest])
			largest=left;

		if(right<n && arr[right]>arr[largest])
			largest=right;

		if(largest!=i){
			int temp = arr[i];
			arr[i]=arr[largest];
			arr[largest]=temp;

			heapify(arr,n,largest);
		}
	}

	public static void main(String args[]) {

		int arr[] = {12, 11, 13, 5, 6, 7};
		HeapSort h = new HeapSort();
		h.sort(arr);
		System.out.println(Arrays.toString(arr));

	}
}