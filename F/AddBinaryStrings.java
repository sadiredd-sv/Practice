/*

https://www.programcreek.com/2014/05/leetcode-add-binary-java/


*/

class AddBinaryStrings {

	static String addBinary(String a, String b) {

		if(a==null || a.length()==0)
			return b;

		if(b==null || b.length()==0)
			return a;

		int lena = a.length()-1;
		int lenb = b.length()-1;
		int carry=0;
		StringBuilder sb = new StringBuilder();

		while(lena>=0 || lenb>=0) {

			int sum= carry;
			if(lena>=0) {
				sum= sum+ ( a.charAt(lena)=='0' ? 0 : 1 );
				lena--;
			}
			if(lenb>=0) {
				sum= sum+ ( b.charAt(lenb)=='0' ? 0 : 1 );	
				lenb--;			
			}

			/* One way to assign carry and sum */
			// carry=0;
			// if(sum==3 || sum==1)
			// 	sb.insert(0,"1");
			// else if(sum==2 || sum==0)
			// 	sb.insert(0,"0");
			// if(sum==3 || sum==2)
			// 	carry=1;

			/* Second way to assign carry and sum */
			sb.insert(0, sum%2);
			carry=sum/2;
		}

		if(carry==1)
			sb.insert(0,"1");

		return sb.toString();
	}

	public static void main(String args[]) {
		System.out.println(addBinary("111","11"));
	}
}