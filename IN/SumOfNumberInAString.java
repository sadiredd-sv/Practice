/*

https://discuss.leetcode.com/topic/55479/find-sum-of-number-in-the-string

*/

class SumOfNumberInAString {

	// 1. Method 1
	static int sumOfNumbers(char arr[]) {
		
		String temp="";
		int sum=0;

		for(char c : arr) {
			if(isDigit(c)) 
				temp=temp+Character.toString(c);
			else {
				if(!temp.isEmpty())
					sum+=Integer.parseInt(temp);
				temp="";
			}
		}
		// to handle the trailing integers
		if(!temp.isEmpty())
			sum+=Integer.parseInt(temp);

		return sum;
	}

	static boolean isDigit(char c) {
		int diff = (int)(c-'0');

		if(diff>=0 && diff<=9)
			return true;
		return false;
	}





	// 2. Method 2
	static int sumofNumbersStringReplace(String str) {
		
		int sum=0;
		String arr[] = str.replaceAll("[a-zA-Z]"," ").split(" ");
		
		for(String s : arr) {
			if(!s.isEmpty())
				sum+=atoi(s);
		}
		return sum;
	} 

	static int atoi(String s) {
		
		int sum=0;
		for(char c : s.toCharArray())
			sum=sum*10+(c-'0');
		return sum;
	}

	public static void main(String args[]) {

		String str = "12abc20yz68";
		System.out.println(sumofNumbersStringReplace(str));
		System.out.println(sumOfNumbers(str.toCharArray()));
	}

}