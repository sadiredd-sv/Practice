/*

Other forms:
1. Max submatrix with sum =0
http://www.geeksforgeeks.org/largest-rectangular-sub-matrix-whose-sum-0/

2. Max submatrix with equal number of 0s and 1s
http://www.geeksforgeeks.org/largest-area-rectangular-sub-matrix-equal-number-1s-0s/

*/

import java.io.*;
import java.util.*;

class MaxSumMatrix {

	/* Kadane algorithm on a 1D array */
	public static int Kadane(int arr[]){
		int maxendinghere=0, maxsofar=Integer.MIN_VALUE;

		for(int i : arr) {
			maxendinghere = Math.max(i,maxendinghere+i);
			maxsofar = Math.max(maxendinghere,maxsofar);
		}

		return maxsofar;
	}

	/* Max sum Submatrix */
	public static void maxSumMatrixCalc(int mat[][]) {

		int maxSum = Integer.MIN_VALUE;

		for(int left=0; left < mat[0].length ; left++){
			int temp[] = new int[mat.length];
			
			for( int right=left; right < mat[0].length ; right++) {

				for(int row=0; row < mat.length; row++)
					temp[row] += mat[row][right];

				maxSum = Math.max(Kadane(temp), maxSum);
			}
		}

		System.out.println("Max sum sub-matrix: "+maxSum);
	}

	public static void main(String args[]){

		int arr[] = {-2, -3, 4, -1, -2, 1, 5, -3};
		//System.out.println(Kadane(arr));

		int mat[][] = {
					  {1, 2, -1, -4, -20},
					  {-8, -3, 4, 2, 1},
					  {3, 8, 10, 1, 3},
					  {-4, -1, 1, 7, -6}
					};
		maxSumMatrixCalc(mat);
	}
}