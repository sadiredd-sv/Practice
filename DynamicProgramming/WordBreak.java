/*

http://www.geeksforgeeks.org/dynamic-programming-set-32-word-break-problem/

Consider the following dictionary 
{ i, like, sam, sung, samsung, mobile, ice, 
  cream, icecream, man, go, mango}

Input:  ilike
Output: Yes 
The string can be segmented as "i like".

Input:  ilikesamsung
Output: Yes
The string can be segmented as "i like samsung" 
or "i like sam sung".

*/

import java.util.*;

class WordBreak {

	public static boolean presentInDict(String str) {

		HashSet<String> dict = new HashSet<String>(Arrays.asList("mobile","samsung","sam","sung",
                            "man","mango","icecream","and",
                             "go","i","like","ice","cream"));
		return dict.contains(str);
	}

	public static String wordbreak(String str, int start, int end, boolean flag) {

		if(flag) {

			if(presentInDict(str.substring(start,end))) 
				return str.substring(start,end);
			else			
				return null;
		}


		for(int i=start;i<end;i++) {
			String left = wordbreak(str, start, end-i, true);
			String right = wordbreak(str, end-i, end, true);
			if(left!=null && right!=null) {
				System.out.println(left+" "+right);
				return left+right;
			}
			// if(left!=null) {
			// 	System.out.println(left);
			// 	return left;
			// }
			// if(right!=null) {
			// 	System.out.println(right);
			// 	return right;
			// }
		}

		return null;
	}

	public static void main(String args[]) {

		String str="samsung";
		wordbreak(str,0,str.length(),false);
	}
}