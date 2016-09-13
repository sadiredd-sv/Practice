import java.io.*;
import java.util.*;

class presence {
	
	public static boolean calc(String str1, String str2) {
	
		if (str1.length()>str2.length())
			return false;

		HashMap<Character,Integer> hm = new HashMap<Character,Integer>();
		for(int i=0;i<str2.length();i++){
			System.out.println(str2.charAt(i));
			if(hm.containsKey(str2.charAt(i)))
				hm.put(str2.charAt(i), hm.get(str2.charAt(i))+1);
			else
				hm.put(str2.charAt(i),1);
		}

		for(int i=0;i<str1.length();i++){
			if(!hm.containsKey(str1.charAt(i)))
				return false;
			if( hm.get(str1.charAt(i))<= 0 ) {
				return false;
			}
			else {
				int val = hm.get(str1.charAt(i));
				hm.put(str1.charAt(i), val-1);
			}
		}
		return true;
	}
	
	public static void main(String args[]){
		System.out.println(calc("xyzzz","abcxzigcyaazzzzz"));
	}
}
