/*
http://www.geeksforgeeks.org/maximum-sum-subsequence-least-k-distant-elements/

Input : arr[] = {4, 5, 8, 7, 5, 4, 3, 4, 6, 5}
           k = 2
Output: 19
Explanation: The highest value is obtained 
if you pick indices 1, 4, 7, 10 giving 
4 + 7 + 3 + 5 = 19




Input: arr[] = {50, 70, 40, 50, 90, 70, 60, 
                              40, 70, 50}
           k = 2
Output: 230
Explanation: There are 10 elements and k = 2. 
If you select 2, 5, and 9 you get a total 
value of 230, which is the maximum possible.


*/

class MaxSumSubsequenceWithKdistanceElements {
	
	
	static int k = 11;
	
	/* Recursion */
	public static int maxSumWithkdistance(int arr[], int n, int sum) {
		
		if(n<0)
			return sum;
		return Math.max( maxSumWithkdistance(arr,n-k-1,sum+arr[n]) , maxSumWithkdistance(arr,n-1, sum) );
	}

	/* DP method */

	public static int dpMaxSumWithkdistance(int arr[]) {

		int dp[] = new int[arr.length];

		for(int i=0 ; i< dp.length ; i++)
			dp[i] = arr[i];

		for(int i=1; i< dp.length ; i++) { 
			if(i-1 >=0 && i-k-1 >=0 )
				dp[i] = Math.max(dp[i-k-1]+arr[i], dp[i-1]);
			else
				dp[i] = Math.max(dp[i-1], arr[i]);
		} 
		return dp[dp.length-1];
	}

	public static void main(String args[]) {
		int arr[] = {50, 70, 40, 50, 90, 70, 60, 
                              40, 70, 50};
		System.out.println(maxSumWithkdistance(arr,arr.length-1,0));
		System.out.println(dpMaxSumWithkdistance(arr));
	}
}