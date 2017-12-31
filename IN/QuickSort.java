/*

Quicksort algorithm:

1. Partition:
	- Pick a pivot (Say rightmost element)
	- Put all values less than the pivot, on the left side.
	- Put all values greater than pivot, on the right side.
	- As final step, swap the pivot with the first element in the "greater than pivot" right subarray
2. Sort left half of pivot
3. Sort right half of pivot

*/

import java.util.*;

class QuickSort {
	
	int partition(int arr[], int left, int right) {

		int pivot = right;
		int i=left;
		right--;

		while(left<=right) {

			if( arr[left] > arr[pivot] ) {
				swap(arr,left,right);
				right--;
			}
			else
				left++;
		}

		swap(arr,left,pivot);
		return left;
	}

	void swap(int arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	void sort(int arr[], int left, int right) {

		if(left<right) {
			int pivot = partition(arr,left,right);
			sort(arr,left,pivot-1);
			sort(arr,pivot+1,right);
		}
	}

	public static void main(String args[]) {

		QuickSort q = new QuickSort();
		int arr[] = {10, 6, 42, 9, 1, 5, 2, 4, 12};
		q.sort(arr,0,arr.length-1);

		System.out.println(Arrays.toString(arr));
	}
}