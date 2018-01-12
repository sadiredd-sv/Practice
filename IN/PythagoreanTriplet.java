/*

https://www.geeksforgeeks.org/find-pythagorean-triplet-in-an-unsorted-array/

a triplet (a, b, c) that satisfies a2 + b2 = c2.



Input: arr[] = {3, 1, 4, 6, 5}
Output: True
There is a Pythagorean triplet (3, 4, 5).

Input: arr[] = {10, 4, 6, 12, 5}
Output: False
There is no Pythagorean triplet.

*/

import java.util.*;

class PythagoreanTriplet {

	// O(n^3)
	static boolean isTriplet(int arr[], int n) {

		for(int i=0;i<n;i++) {
			for(int j=i+1;j<n;j++) {
				for(int k=j+1;k<n;k++) {
					int x=arr[i]*arr[i], y=arr[j]*arr[j], z=arr[k]*arr[k];
					if(x+y==z || x+z==y || y+z==x)
						return true;
				}
			}
		}

		return false;
	}

	/*

	O(n^2):
	
	1. sort({3, 1, 4, 6, 5}) = {1,3,4,5,6}
	2. Calculate the squares of the numbers and put them back in the array
	3. Fix the last (n-1)th element. Find the pair of numbers in the arr from 0 to (n-2)th element, whose sum is equal to arr[n-1]
	4. Repeat step 3, by fixing (n-2)th element and find the pair in the arr from 1 to (n-3)th element
	5. Repeat 4 until we find the pythagoras set or until the last element is at 2nd index.

	for(i=n-1; i>=2; i--) {
		if(findPairWithGivenSum(arr,arr[i],0,i-1))
			return true;
	}

	boolean findPairWithGivenSum(int arr[], int target, int l, int r) {
		
		if(arr[l]+arr[r] == target)
			return true;
		
		if(arr[l]+arr[r] < target)
			l++;
		else
			r--;
	}
	
	*/
	static boolean isTripletBetterSolution(int arr[], int n) {

		Arrays.sort(arr);

		for(int i=0;i<n;i++)
			arr[i] = arr[i]*arr[i];

		for(int i=n-1; i>=2; i--) {
			if(findPairWithGivenSum(arr,arr[i],0,i-1))
			return true;
		}

		return false;
	}

	static boolean findPairWithGivenSum(int arr[], int target, int l, int r) {
		
		while(l<r) {

			if(arr[l]+arr[r] == target)
				return true;
		
			if(arr[l]+arr[r] < target)
				l++;
			else
				r--;
		}
		return false;
	}

	public static void main(String args[]) {

		int ar[] = {3, 1, 4, 6, 5};
        //int ar[] = {10, 4, 6, 12, 5};
        int ar_size = ar.length;
        if(isTripletBetterSolution(ar,ar_size)==true)
           System.out.println("Yes");
        else
           System.out.println("No");  
	}
}