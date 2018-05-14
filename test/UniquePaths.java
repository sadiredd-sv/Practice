class UniquePaths {

    public static int uniquePaths(int i, int j, int m, int n){

        if(i==m-1 && j==n-1)
            return 1;

//        if(i+1 < m && j+1 <n )
//            return uniquePaths(i+1, j, m,n) + uniquePaths(i, j+1, m,n);
//        else if (i+1 < m)
//            return uniquePaths(i+1, j, m,n);
//        else if (j+1 < n)
//            return uniquePaths(i, j+1, m,n);


        int down =0, right=0;
        if (i+1 < m)
            down = uniquePaths(i+1, j, m,n);
        if (j+1 < n)
            right= uniquePaths(i, j+1, m,n);

        return down+right;
    }


    public static int uniquePathsDP(int m, int n) {

        if(m==0 || n==0)
            return 0;
        if(m==1 || n==1)
            return 1;

        int dp[][] = new int[m][n];
        for(int i=0; i<m; i++)
            dp[i][0]=1;
        for(int j=0; j<m; j++)
            dp[0][j]=1;

        for(int i=1; i < m; i++) {
            for(int j=1; j< n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    public static void printAllUniquePaths(int arr[][], int i, int j, int m, int n, String str){

        if(i==m-1 && j==n-1) {
            System.out.println(str+arr[i][j]);
            return;
        }

        if (i+1 < m)
            printAllUniquePaths(arr, i+1, j, m,n, str+arr[i][j]);
        if (j+1 < n)
            printAllUniquePaths(arr, i, j+1, m,n, str+arr[i][j]);
    }


    public static int uniquePathsObstacles(int arr[][]) {
        int m = arr.length;
        int n = arr[0].length;

        int [][]dp = new int[m][n];
        dp[0][0]= 1;

        for(int i=1; i<m; i++) {
            if(arr[i][0]==1)
                dp[i][0]=0;
            else
                dp[i][0]= dp[i-1][0];
        }

        for(int j=1; j<n; j++) {
            if(arr[0][j]==1)
                dp[0][j]=0;
            else
                dp[0][j]= dp[0][j-1];
        }

        for(int i=1; i < m; i++) {
            for(int j=1; j< n; j++) {
                if(arr[i][j]==1)
                    dp[i][j]=0;
                else
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }

    public static void main(String args[]) {

//        System.out.println(uniquePathsDP(2,3));
//
//        int arr[][] = { {0,0,0}, {0,1,0}, {0,0,0} };
//        System.out.println(uniquePathsObstacles(arr));


//        int arr[][] = { {1,2,3}, {4,5,6} };
//        int arr[][] = { {1,2}, {3,4} };
        int arr[][] = { {1,2,3}, {4,5,6}, {7,8,9} };
        printAllUniquePaths(arr,0,0,arr.length,arr[0].length,"");
    }
}