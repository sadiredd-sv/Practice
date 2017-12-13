
/*

http://www.geeksforgeeks.org/length-of-the-longest-valid-substring/

Input : ((()
Output : 2
Explanation : ()

Input: )()())
Output : 4
Explanation: ()() 

Input:  ()(()))))
Output: 6
Explanation:  ()(())


*/

import java.util.*;

class LongestParantheses {

	public static int longestParan(String str) {
		Stack<Character> stack = new Stack<Character>();

		for(Character c : str.toCharArray()){
			if(c.equals('('))
				stack.push(c);
			else if(c.equals(')')) {
				if(!stack.empty() && !stack.peek().equals(')'))
					stack.pop();
				else
					stack.push(c);
			}
		}
		return (str.length() - stack.size());
	}

	public static void main(String args[]) {
		String str = "((()()";
        System.out.println(longestParan(str));
      
        str = "()(()))))";
        System.out.println(longestParan(str));


        str = ")()())";
        System.out.println(longestParan(str));
      
        str = "((()";
        System.out.println(longestParan(str));
	}
}

