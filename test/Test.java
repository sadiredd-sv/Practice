class Test {
    static long flipBits(long N) {
        long result=0;
        long mask =1;

        long input = ~N;

        for(int i=0; i< 32;i++) {
            result |= input&mask;
            mask<<=1;
        }

        return result;
    }



    // Print all possible paths from left top to right bottom
    static void printAllPaths(int mat[][], int i, int j, String path) {

        if(i==mat.length-1) {
            for(int col=j; col<mat[0].length; col++)
                path=path+" "+mat[i][col];
            System.out.println(path);
            return;
        }

        if(j==mat[0].length-1) {
            for(int row=i; row<mat.length; row++)
                path=path+" "+mat[row][j];
            System.out.println(path);
            return;
        }

        path=path+" "+mat[i][j];
        printAllPaths(mat,i+1,j,path);
        printAllPaths(mat,i,j+1,path);

    }

    /* Min cost path in Matrix:
       f(m,n) = mat[m][n] + Math.min( f(m-1,n), f(m,n-1), f(m-1,n-1) )
    *
    *
    * Below is recursive approach
    * */

    public static int minPath(int mat[][], int m, int n) {

        if(m<0 || n<0)
            return Integer.MAX_VALUE;
        if(m==0 && n==0)
            return mat[m][n];

        return Math.min( Math.min(minPath(mat,m-1,n), minPath(mat,m,n-1)), minPath(mat,m-1,n-1) ) + mat[m][n];
    }

    /* Min cost path in Matrix:
        Below is DP approach
    *
    * */

    public static int minPathDP(int mat[][]) {

        int solution[][] = new int[mat.length][mat[0].length];
        solution[0][0] = mat[0][0];

        for(int i=1; i <mat.length; i++)
            solution[i][0]= solution[i-1][0] + mat[i][0];

        for(int j=1; j <mat[0].length; j++)
            solution[0][j]= solution[0][j-1] + mat[0][j];

        for(int i=1; i < mat.length; i++) {
            for(int j=1; j< mat[0].length; j++) {
                solution[i][j] = Math.min( Math.min(solution[i-1][j], solution[i][j-1]), solution[i-1][j-1] ) + mat[i][j];
            }
        }

        return solution[mat.length-1][mat[0].length-1];
    }

    /*

    Count all unique paths: Recursion
    *
    * */
    public static int uniquePaths(int mat[][], int i, int j) {

        if(i==mat.length-1 && j==mat[0].length-1)
            return 1;

        int down=0, right=0;
        if(i+1 < mat.length && mat[i+1][j]!=1)
            down=uniquePaths(mat,i+1,j);
        if(j+1 < mat[0].length && mat[i][j+1]!=1)
            right=uniquePaths(mat,i,j+1);

        return right+down;

    }
    /*
    * Count all unique paths: DP
    * */
    public static int uniquePathsDP(int mat[][]) {

        if(mat.length==0 || mat[0].length==0)
            return 0;

        if(mat.length==1 || mat[0].length==1)
            return 1;


        int dp[][] = new int[mat.length][mat[0].length];

        for(int i=0; i < mat.length; i++)
            dp[i][0]=1;

        for(int j=0; j < mat[0].length; j++)
            dp[0][j]=1;

        for(int i=1;i<mat.length;i++) {
            for(int j=1;j<mat[0].length;j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[mat.length-1][mat[0].length-1];
    }

    /*
    * Count all unique paths with obstacles : DP
    * */
    public static int uniquePathsDPObstacles(int mat[][]) {

        if(mat==null || mat.length==0)
            return 0;

        if(mat[0][0]==1 || mat[mat.length-1][mat[0].length-1]==1)
            return 0;


        int dp[][] = new int[mat.length][mat[0].length];
        dp[0][0] =1;

        for(int i=1; i < mat.length; i++) {
            if (mat[i][0] == 1)
                dp[i][0]=0;
            else
                dp[i][0] = dp[i-1][0];
        }

        for(int j=1; j < mat[0].length; j++) {
            if (mat[0][j] == 1)
                dp[0][j]=0;
            else
                dp[0][j] = dp[0][j-1];
        }


        for(int i=1;i<mat.length;i++) {
            for(int j=1;j<mat[0].length;j++) {
                if(mat[i][j]!=1)
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                else
                    dp[i][j]=0;
            }
        }

        return dp[mat.length-1][mat[0].length-1];
    }


    public static void main(String args[]) {
//        System.out.println(flipBits(0));
//
//        int mat[][] = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };
//        printAllPaths(mat,0,0,"");


//        int mat[][]= { {1, 2, 3}, {4, 8, 2}, {1, 5, 3} };
//        System.out.println(minPath(mat,2,2));
//        System.out.println(minPathDP(mat));

//        int mat[][]= { {0, 0, 0}, {0, 0, 0}, {0, 0, 0} };
//        System.out.println(uniquePaths(mat,0,0));
//        System.out.println(uniquePathsDP(mat));

        int mat[][]= { {0, 0, 0}, {0, 1, 0}, {0, 0, 0} };
        System.out.println(uniquePathsDPObstacles(mat));
    }
}