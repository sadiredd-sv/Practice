/*

http://www.geeksforgeeks.org/dynamic-programming-subset-sum-problem/


Given a set of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum.

Examples: set[] = {3, 34, 4, 12, 5, 2}, sum = 9
Output:  True  //There is a subset (4, 5) with sum 9.


*/

class SubsetSum {
	/* Recursion */
	static boolean isSubsetSum(int set[], int n, int sum) {
		
		if (sum!=0 && n==0)
			return false;
		if (sum == 0)
			return true;

		return isSubsetSum(set,n-1,sum) || isSubsetSum(set,n-1,sum-set[n-1]) ;
	}

	/* DP */
	static boolean DPIsSubsetSum(int set[], int n, int sum) {
		boolean dp[][] = new boolean[n+1][sum+1];
		
		 // If sum is not 0 and set is empty, then answer is false
		for(int j=1;j<=sum;j++)
			dp[0][j]=false;

		// If sum is 0, then return true
		for(int i=0;i<=n;i++)
			dp[i][0]=true;

		for(int i=1;i<=n;i++) {
			for(int j=1;j<=sum;j++) {
				if(j > set[i-1])
					dp[i][j] = dp[i-1][j] || dp[i-1][j-set[i-1]];
			}
		}
		
		return dp[n][sum];
	}

	public static void main(String args[]) {
		int set[] = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        System.out.println( DPIsSubsetSum(set, set.length, sum) );
	}
}