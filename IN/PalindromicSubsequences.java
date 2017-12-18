/*

http://www.geeksforgeeks.org/count-palindromic-subsequence-given-string/

*/


class PalindromicSubsequences {

	public static int countPalindomicSubsequences(String s, String pal, int n) {

		if(n<0)
			if(isPalindrome(pal,0,pal.length()-1))
				return 1;
			else 
				return 0;

		return countPalindomicSubsequences(s, pal+s.charAt(n), n-1) + countPalindomicSubsequences(s, pal, n-1);
	}
	
	public static boolean isPalindrome(String s, int l, int r) {

		if(s==null)
			return false;

		if(l>=r)
			return true;

		if(s.charAt(l) == s.charAt(r))
			return isPalindrome(s,l+1,r-1);
		else
			return false;
	}

	public static void main(String args[]) {
		String s = "malayalam";
		// System.out.println(isPalindrome(s, 0, s.length()-1));
		System.out.println(countPalindomicSubsequences(s,"",s.length()-1));

	}

}