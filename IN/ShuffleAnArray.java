/*

http://www.geeksforgeeks.org/shuffle-a-given-array/

Fisher–Yates shuffle Algorithm

*/

import java.util.*;

class ShuffleAnArray {
		
	public static void shuffle(int arr[]) {
		Random r = new Random();
		for(int i=arr.length-1; i >0; i--) {
			int j=r.nextInt(i);
			/* swap i and j */
			int temp=arr[i];
			arr[i]=arr[j];
			arr[j]=temp;
		}
	}

	public static void main(String args[]) {

		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
		shuffle(arr);
		System.out.println(Arrays.toString(arr));
	}	
}