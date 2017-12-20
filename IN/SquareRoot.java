
/*

http://www.geeksforgeeks.org/square-root-of-an-integer/

*/

class SquareRoot {

	/* O(n) approach */
	public static int squareroot(int n) {

		if(n==0 || n==1)
			return n;

		for(int i=1;i<n/2;i++) {

			if(i*i == n)
				return i;
			else if(i*i > n)
				return i-1;
		}

		return -1;
	}

	/* Binary search approach */
	public static int binarysearchsquareroot(int n) {

		if(n==0 || n==1)
			return n;

		int start = 1, end=n, answer=0;

		while(start<end) {
			int mid = (end+start)/2;
			if(mid*mid == n)
				answer=mid;

			if(mid*mid < n) {
				start=mid+1;
				answer=mid;
			}
			else
				end=mid-1;
		}
		return answer;
	}

	public static void main(String args[]) {

		System.out.println(squareroot(37891));
		System.out.println(binarysearchsquareroot(37891));
	}
}