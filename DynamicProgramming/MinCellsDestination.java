/*
	DP:
	http://www.geeksforgeeks.org/minimum-cells-required-reach-destination-jumps-equal-cell-values/

	Input : mat[][] = { {2, 3, 2, 1, 4},
                    {3, 2, 5, 8, 2},
                    {1, 1, 2, 2, 1}  }
Output : 4
The movement and cells covered are as follows:
(0, 0)->(0, 2)
          |
        (2, 2)->(2, 4)

Input : mat[][] = { {2, 4, 2},
                {5, 3, 8},
            {1, 1, 1} }
Output : 3


*/
class MinCellsDestination {

	static int mincells(int mat[][], int x, int y) {

		int dp[][] = new int[x][y];

		for (int l = 0; l < x; l++)
            for (int m = 0; m < y; m++)
                dp[l][m] = Integer.MAX_VALUE;

		dp[x-1][y-1]=1;
		
		for(int l=x-1;l>=0;l--) {
			int m;
			if(l==x-1)
				m=y-2;
			else
				m=y-1;

			for(;m>=0;m--) {
				if( (l+mat[l][m] < x ) && ( m+ mat[l][m] < y) )
					dp[l][m]= 1 + Math.min(dp[l+mat[l][m]][m], dp[l][m+mat[l][m]]);
				else if (l+mat[l][m] < x)
					dp[l][m]= 1 + dp[l+mat[l][m]][m];
				else if ( m+ mat[l][m] < y )
					dp[l][m]= 1 + dp[l][m+mat[l][m]];
			}
		}
		if(dp[0][0]!=Integer.MAX_VALUE)
			return dp[0][0];

		return -1;
	}

	public static void main(String args[]) {

		int mat[][] = { 
					{2, 3, 2, 1, 4},
                    {3, 2, 5, 8, 2},
                    {1, 1, 2, 2, 1}  
                	};

        // int mat[][] = { {2, 4, 2},
        //         {5, 3, 8},
        //     {1, 1, 1} };

		System.out.println(mincells(mat,mat.length,mat[0].length));
	}
}