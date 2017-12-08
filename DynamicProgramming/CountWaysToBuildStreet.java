/*

http://www.geeksforgeeks.org/count-ways-build-street-given-constraints/

*/
class CountWaysToBuildStreet {

	/* Dynamic programming way */
	static int dpWay(int n){
		int dp[] = new int[n];
		dp[0]=3; dp[1]=7;

		for (int i=2; i< n; i++)
			dp[i] = 2*dp[i-1] + dp[i-2];

		return dp[n-1];
	}

	static int countways(int n) {
		if(n==1)
			return 3;
		if(n==2)
			return 7;

		return (2*countways(n-1)+ countways(n-2));
	}

	public static void main(String args[]){
		System.out.println(dpWay(11));
	}
}