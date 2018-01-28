/*

https://www.geeksforgeeks.org/check-given-string-valid-number-integer-floating-point/

Input : str = "11.5"
Output : true

Input : str = "abc"
Output : false

Input : str = "2e10"
Output : true

Input : 10e5.4
Output : false


Algorithm:
1.Ignore the leading and trailing white spaces.
2.Ignore the ‘+’, ‘-‘ and’.’ at the start.
3.Ensure that the characters in the string belong to {+, -, ., e, [0-9]}
4.Ensure that no ‘.’ comes after ‘e’.
5.A dot character ‘.’ should be followed by a digit.
6.The character ‘e’ should be followed either by ‘+’, ‘-‘, or a digit.


*/

class ValidNumber {

	boolean isDigit(char c){
		int diff = (int)(c-'0');
		return (diff>=0 && diff<=9);
	}

	boolean specialCharacters(char c) {
		return (c=='e' || c=='.' || c=='+' | c=='-');
	}

	boolean isValidNumeric(String input) {

		int countdot =0;
		for(char c : input.toCharArray()) {

			if(!specialCharacters(c) || !isDigit(c))
				return false;

			if(c=='.') {
				if(countdot==1)
					return false;
				countdot++;
			}
		}
	}

	public static void main() {
		String input = "0.1e10";
        ValidNumber gfg = new ValidNumber();
        System.out.println(gfg.isValidNumeric(input));
	}
}