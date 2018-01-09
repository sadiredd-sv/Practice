/*

Divide and Conquer
https://www.geeksforgeeks.org/divide-and-conquer-maximum-sum-subarray/

Algorithm:
{-2, -5, 6, -2, -3, 1, 5, -6}
Output = 7 with {6, -2, -3, 1, 5}

Algorithm:

arr1 = {-2 -5 6 -2}
arr2 = {-3 1 5 -6}

1. Split arr into 2 halves
2. Find the max sum subarray in left and find the max subarray in right
3. Combine the left max and right max.
4. Return the max of (left, right, combined):
Max(leftsubarray, rightsubarray, combined left and right)


Code Algo:

f(arr, l, r) {
	
	Math.max( f(arr,l,m), f(arr,m+1,r), sumcrossingmid(arr,l,mid,r) )
}

sumcrossingmid(arr,l,mid,r) {
	- Left_sum = Add elements from mid towards left side. Get the max of it
	- Right_sum = Add elements from mid+1 towards right side. Get the max of it
	- Return (left_sum+Right_sum)
}

*/

class MaxSubarraySum {

	/* Divide and Conquer method */
	int maxSumCrossingMid(int arr[], int left, int mid, int right ){

		// Mid to left
		int sum=0;
		int left_sum= Integer.MIN_VALUE;

		for(int i=mid; i >=left; i--) {
			sum+=arr[i];
			left_sum= Math.max(sum, left_sum);
		}

		// Mid+1 to right
		sum=0;
		int right_sum= Integer.MIN_VALUE;

		for(int i=mid+1; i<=right; i++) {
			sum+=arr[i];
			right_sum= Math.max(sum, right_sum);
		}

		return (left_sum + right_sum);
	}

	int maxSubarraySumDivideConquer(int arr[], int left, int right) {

		if(left==right)
			return arr[left];

		int mid = (left + right)/2;
		return Math.max( Math.max(maxSubarraySumDivideConquer(arr, left, mid), maxSubarraySumDivideConquer(arr, mid+1, right)) , maxSumCrossingMid(arr, left, mid, right) );
	}


	/* 

	Kadane Algo:
	
	https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/

	Simple idea of the Kadane's algorithm is to look for all positive contiguous segments of the array (max_ending_here is used for this). 
	And keep track of maximum sum contiguous segment among all positive segments (max_so_far is used for this). 
	Each time we get a positive sum compare it with max_so_far and update max_so_far if it is greater than max_so_far

	{-2, -5, 6, -2, -3, 1, 5, -6}
	Output = 7 with {6, -2, -3, 1, 5}

	for(i=0 to n-1) {
		max_ending_here=Math.max(arr[i],max_ending_here+arr[i]);
		max_so_far = Math.max(max_so_far,max_so_far);
	}

	*/
	int kadaneMaxSubarraySum(int arr[]) {

		int max_ending_here=arr[0];
		int max_so_far=arr[0];
		for(int i=1; i < arr.length; i++) {
			max_ending_here=Math.max(arr[i], max_ending_here+arr[i]);
			max_so_far = Math.max(max_so_far,max_ending_here);
		}

		return max_so_far;
	}

	public static void main(String args[]) {

		//int arr[] = {-2, -5, 6, -2, -3, 1, 5, -6};
		int arr[] = {2, 3, 4, 5, 7};
		MaxSubarraySum ob = new MaxSubarraySum();
		System.out.println( ob.maxSubarraySumDivideConquer(arr, 0, arr.length-1) );
		System.out.println( ob.kadaneMaxSubarraySum(arr) );

	}
}
