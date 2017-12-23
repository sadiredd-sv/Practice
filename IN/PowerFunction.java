/*

https://www.geeksforgeeks.org/write-a-c-program-to-calculate-powxn/

O(logn)


*/
class PowerFunction {

	double power(int x, int n) {

		if(n==0)
			return 1;

		double temp = power(x,n/2);

		if(n%2==0)
			return temp*temp;
		else {
			if(n<0)
				return (temp*temp)/x;
			else
				return x*temp*temp;
		}
	}

	public static void main(String args[]) {
		PowerFunction p = new PowerFunction();
		System.out.println(p.power(3,-4));
	}
}