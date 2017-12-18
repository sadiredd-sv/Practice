/*

http://www.geeksforgeeks.org/check-if-two-given-strings-are-isomorphic-to-each-other/
https://www.programcreek.com/2014/05/leetcode-isomorphic-strings-java/

Given two strings s and t, determine if they are isomorphic. Two strings are isomorphic if the characters in s can be replaced to get t.
For example,"egg" and "add" are isomorphic, "foo" and "bar" are not.

Algorithm:
1. Create a hashmap
2. loop through str1 and str2:
	if(ch in str1 isn't present in hashmap)
		if(hashmap.containsValue(str2.ch))
			return false;
		put str1.ch as key and str2.ch as value
	else
		if(hashmap.get(str1.ch)!=str2.ch )
			return false;

edge cases:
if(str1==null)
	return false;
if(str1.length()!=str2.length())
	return false;
*/

import java.util.*;

class IsomorphicStrings {

	public static boolean checkIsomorphicStrings(String str1, String str2) {

		if(str1==null || str2==null)
			return false;

		if(str1.length() != str2.length())
			return false;

		Map<Character,Character> map = new HashMap<Character,Character>();

		for(int i=0; i < str1.length(); i++){
			char c1 = str1.charAt(i);
			char c2 = str2.charAt(i);

			if(map.containsKey(c1)) {
				if(map.get(c1)!=c2)
					return false;
			}
			else {
				if(map.containsValue(c2))
					return false;
				map.put(c1,c2);
			}

		}

		return true;
	}
	public static void main(String args[]) {

		System.out.println(checkIsomorphicStrings("aab", "xyz"));
		System.out.println(checkIsomorphicStrings("aab", "xxy"));
		System.out.println(checkIsomorphicStrings("bar", "foo"));
		System.out.println(checkIsomorphicStrings("egg", "add"));
	}
}