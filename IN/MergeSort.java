import java.util.*;

class MergeSort {
	
	/*  Number of inversions in the array:
		http://www.geeksforgeeks.org/counting-inversions/
	 */
		
	int count=0;

	void merge(int arr[], int l, int mid, int r) {

		int lcount = mid-l+1;
		int rcount = r-mid;

		/* Since we are chaning the original array arr[], we need to copy the current values in arr[] to temp arrays */
		int L[] = new int[lcount];
		int R[] = new int[rcount];

		for(int i=0; i<lcount; i++)
			L[i]=arr[l+i];

		for(int j=0; j<rcount; j++)
			R[j]=arr[mid+1+j];

		/* Actual merging of the above 2 sorted arrays happen here */
		int i=0,j=0;
		int k=l;
		while(i<lcount && j<rcount) {
			if(L[i]<=R[j]) {
				arr[k]=L[i];
				i++;
			}
			else {
				count=count+(mid-i);
				arr[k]=R[j];
				j++;
			}
			k++;
		}

		/* Copy the remaining elements in L[] array to the main arr[] */
		while(i<lcount) {
			count++;
			arr[k]=L[i];
			i++;
			k++;
		}
		/* Copy the remaining elements in R[] array to the main arr[] */
		while(j<rcount) {
			arr[k]=R[j];
			j++;
			k++;
		}

	} 
	
	void sort(int arr[], int l, int r) {

		/* Keep splitting the array until there's only 1 element in the subarray */
		if(l<r) {
			int mid = (l+r)/2;
			sort(arr, l, mid);
			sort(arr, mid+1, r);

			merge(arr, l, mid, r);
		}
	}	

	public static void main(String args[]) {
		MergeSort m = new MergeSort();
		int arr[] = {12, 11, 13, 5, 6, 7};
		//int arr[] = {30, 20, 6, 4, 5, 50};
		m.sort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
		System.out.println("Count: "+m.count);
	}
}