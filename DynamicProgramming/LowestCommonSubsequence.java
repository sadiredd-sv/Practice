import java.io.*;


class LowestCommonSubsequence {

	/* Recursive approach :
   Let the input sequences be X[0..m-1] and Y[0..n-1] of lengths m and n respectively. And let L(X[0..m-1], Y[0..n-1]) be the length of LCS of the two sequences X and Y. Following is the recursive definition of L(X[0..m-1], Y[0..n-1]).

   If last characters of both sequences match (or X[m-1] == Y[n-1]) then
   L(X[0..m-1], Y[0..n-1]) = 1 + L(X[0..m-2], Y[0..n-2])

   If last characters of both sequences do not match (or X[m-1] != Y[n-1]) then
   L(X[0..m-1], Y[0..n-1]) = MAX ( L(X[0..m-2], Y[0..n-1]), L(X[0..m-1], Y[0..n-2])
	*/
	public static int LCS(String str1, String str2){

		if( str1.length()==0 || str2.length()==0 )
			return 0;
		if( str1.charAt(str1.length()-1) == str2.charAt(str2.length()-1) )
			return 1 + LCS( str1.substring(0, str1.length()-1), str2.substring(0, str2.length()-1) );
		else
			return Math.max( LCS( str1.substring(0, str1.length()-1), str2.substring(0, str2.length()) ), LCS( str1.substring(0, str1.length()), str2.substring(0, str2.length()-1) ) );
	}

	public static void main(String args[]) {
		String str1="AGGTAB", str2="GXTXAYB";
		System.out.println(LCS(str1,str2));
	}
	/*
	TODO: DP implementation
	*/
}