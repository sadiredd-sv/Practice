/*

http://www.geeksforgeeks.org/dynamic-programming-set-5-edit-distance/

f(str1,str2,m,n) {
	if(m==0)
		return n;
	if(n==0)
		return m;
	if(str1[m]==str2[n])
		f(str1,str2,m-1,n-1);
	else
		return 1 + Math.min( f(str1,str2,m-1,n) , f(str1,str2,m,n-1) , f(str1,str2,m-1,n-1) );
}

*/

class EditDistance {
	
	static int min(int x, int y, int z) {
		return Math.min(Math.min(x,y), z);
	}


	/* Recursive solution */
	static int editdist(String str1, String str2, int m, int n) {

		if(m==0)
			return n;

		if(n==0)
			return m;

		if( str1.charAt(m-1) == str2.charAt(n-1) )
			return editdist(str1,str2,m-1,n-1);

		return 1 + min( editdist(str1,str2,m-1,n-1), editdist(str1,str2,m-1,n), editdist(str1,str2,m,n-1) );
	}	
	

	/* DP */
	static int editdistDP(String str1, String str2, int m, int n) {

		int dp[][] = new int[m+1][n+1];
		
		for(int i=0;i<=m;i++)
			dp[i][0]=i;

		for(int j=0;j<=n;j++)
			dp[0][j]=j;

		for(int i=1;i<=m;i++) {
			for(int j=1;j<=n;j++) {
				if( str1.charAt(i-1)==str2.charAt(j-1) )
					dp[i][j] = dp[i-1][j-1];
				else
					dp[i][j] = 1 + min( dp[i-1][j-1], dp[i-1][j], dp[i][j-1] );
			}
		}

		return dp[m][n];
	}

	public static void main(String args[]) {

		String str1 = "sunday";
        String str2 = "saturday";
  
        System.out.println( editdistDP( str1 , str2 , str1.length(), str2.length()) );
	}
}