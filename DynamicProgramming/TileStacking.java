/*
http://www.geeksforgeeks.org/tile-stacking-problem/
*/

class TileStacking {

	public static int possibleWays(int n, int m, int k) {
		
		if(m==0 && n>0)
			return 0;
		if(n==0)
			return 1;

		if(k==0)
			return possibleWays(n-1,m-1,k);
		return possibleWays(n-1,m,k--) + possibleWays(n,m-1,k);
	}

	public static void main(String args[]) {
		int n = 3, m = 3, k = 1;
		System.out.println(possibleWays(n,m,k));
	}
}