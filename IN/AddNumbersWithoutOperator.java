/*

https://www.geeksforgeeks.org/add-two-numbers-without-using-arithmetic-operators/

*/

class AddNumbersWithoutOperator {
	
	public static int add(int x, int y) {

		if(y==0)
			return x;
		return add( x^y, (x&y) << 1 );
	}

	public static void main(String args[]) {
		System.out.println(add(32,32));
	}
}