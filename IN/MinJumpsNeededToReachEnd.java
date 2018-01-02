/*

https://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/


Algorithm (DP) :

dp[i] -- minjumps needed to reach i
dp[0]=0;

for(int i=1; i<n; i++) {
	for(int j=0; j<i && dp[j]+arr[j]>=i; j++) {
		min = Math.min(dp[j]+1, min);
	}
	dp[i] = min;
}





Algorithm ( O(n) ) - Linear solution :

https://www.geeksforgeeks.org/minimum-number-jumps-reach-endset-2on-solution/

jump=0, i=0, maxreach=arr[0]
while(true) {
	while(i<maxreach) {
		if(i+arr[i] > max) {
			max = i +arr[i];
			if(max>=n-1)
				return jump;
			step=i;
		}
	}
	
	jump++;
	i=step;
	maxreach=i+arr[i];
	i++;
}

*/

import java.util.*;

class MinJumpsNeededToReachEnd {
	
	/* Recursive : Exponential solution */
	public static int minJumps(int arr[], int l, int r, int count) {

		if(l==r)
			return count;

		int min =Integer.MAX_VALUE;
		for(int i=1; l+i<=r && i<=arr[l];i++)
			min = Math.min(minJumps(arr, l+i, r,count+1), min);

		return min;
	}


	/* DP solution : O(n^2) */
	public static int dpMinJumps(int arr[]) {

		int n = arr.length;
		// Edge case:
		if(n==0 || arr[0]==0)
			return Integer.MAX_VALUE;

		int dp[] = new int[n];
		dp[0] = 0;

		for(int i=1; i<n; i++) {
			int min = Integer.MAX_VALUE;
			for(int j=0; j<i ; j++) {
				if( (j+arr[j])>=i && dp[j]!=Integer.MAX_VALUE )
					min = Math.min(dp[j]+1, min);
			}
			dp[i] = min;
		}
		return dp[n-1];
	}

	/* Linear solution */
	public static int linearSolution(int arr[]) {
			
			int jump=0, i=0, step=0, maxreach=arr[0];

			while(i < arr.length) {
				int max = Integer.MIN_VALUE;
				while(i<=maxreach) {
					if(i+arr[i] > max) {
						max = i +arr[i];
						step=i;
						if(max >= arr.length-1)
							return ++jump;
					}
					i++;
				}

			jump++;
			i=step+1;
			maxreach=i+arr[i];
			i++;
		}

		return -1;
	}


	public static void main(String args[]) {

		int arr[] = {1, 3, 2, 3,1, 1, 2, 3, 1, 1, 2, 3,1,1,2,1,10};
		//int arr[] ={1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		//int arr[] ={1, 3, 2, 1,4,8};
		System.out.println(minJumps(arr,0,arr.length-1,0));
		System.out.println(dpMinJumps(arr));
		System.out.println(linearSolution(arr));
	}
}