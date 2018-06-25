/*

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

For example, given s = "AAAAACCCCCAAAAACCCCCCA AAAAGGGTTT", return: ["AAAAACCCCC", "CCCCCAAAAA"].


https://www.programcreek.com/2014/03/leetcode-repeated-dna-sequences-java/

1. Find all substrings of length 10 and keep putting them in HashMap.
2. Loop through the hashmap and find the string with count > 1 


*/

import java.util.*;

class DNASequence {

	static void getDNASeq(String str) {

		Set<String> set = new HashSet<String>();
		Set<String> result = new HashSet<String>();

		for(int i=0; i+9<str.length(); i++) {
			String s = str.substring(i,i+10);
			if(set.contains(s))
				result.add(s);
			else
				set.add(s);
		}

		System.out.println(new ArrayList(result));
	}

	public static void main(String args[]) {

		getDNASeq("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
	}
}