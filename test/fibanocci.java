/*

series:  0 1 1 2 3 5
indices: 0 1 2 3 4 5

f(1) = 1
f(0)= 0
f(2) = f(1) + f(0)
f(3) = (f2) + f(1)

if n<2:
fib(n) = n;
else
fib(n) = fib(n-1) + fib(n-2)



---------------------

DIVYA

reversed:
Reverse(DIVYA):
= A + Reverse (DIVY)
                = Y + Reverse (DIV)
              					= V + Reverse (DI)
                     					       = I + Reverse(D)




1. Remove duplicates in a String
http://www.geeksforgeeks.org/remove-all-duplicates-from-the-input-string/
              				
2. HashMap example: count occurrences of each integer in given array of integers.
http://www.geeksforgeeks.org/hashmap-treemap-java/


*/


class fibanocci {


	public static int fib(int n){

		if (n<2)
			return n;
		else
			return ( fib(n-1) + fib(n-2) );

	}


	public static String reverse (String s) {

			if(s.length()<2)
				return s;

		return s.charAt(s.length()-1) + reverse(s.substring(0,s.length() - 1));

	}



	public static void main(String args[]) {
		
		//for (int i=0; i<10;i++){
		//	System.out.println(fib(i));
		//}


		System.out.println(reverse("DIVYA"));
	}
}



