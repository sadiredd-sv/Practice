/*

https://www.geeksforgeeks.org/count-possible-decodings-given-digit-sequence/

https://www.geeksforgeeks.org/find-all-possible-interpretations/

*/

class CountDecoding {

	/* Recursive */
	static int countDecoding(String digits, int n, String str) {

		if(n==0 || n==1) {
			System.out.println(str);
  			return 1;
		}
  		
  		int count=0;
  		
  		int c1 = (int)(digits.charAt(n-1)-'0');
  		int c2 = (int)(digits.charAt(n-2) -'0');

  		if(c1>0)
	  		count = countDecoding(digits, n-1, str+((char)(c1+64)) );

  		if( c2==1 || (c2==2 && c1<=6) ) 
  			count += countDecoding(digits, n-2, str+((char)(c2*10+c1+64)) );
  	
  		return count;

	}

	/* DP */
	
	public static void main(String args[]) {

		String digits="1234";
		String str="";
		System.out.println(countDecoding( digits, digits.length(), str) );
	}
}