/*

https://www.geeksforgeeks.org/wildcard-pattern-matching/

Text = "baaabab",
Pattern = “*****ba*****ab", output : true
Pattern = "baaa?ab", output : true
Pattern = "ba*a?", output : true
Pattern = "a*ab", output : false 

Algorithm:
1. If pattern = '*':
	1.1. Ignore that character and move to next character in pattern (or)
	1.2. Ignore the character in text and move to next char in text

2. If pattern = '?'
	Ignore that character in pattern and text, and move to next character.

3. If character(text) = character(pattern)
	same as 2 above

4. If character(text) != character(pattern)
	return false;


Initialization:
lookup[i][j] -- i characters in text(length), j characters in pattern(length)

1. If pattern is null: lookup[i][0]= false.
2. If pattern and text both are null : lookup[0][0]= true.
3. if text is null:
	lookup[0][j]=lookup[0][j-1] if pattern[j-1]='*'

*/

class WildcardPatternMatching {

	static boolean strmatch(String str, String pattern, int n, int m) {

		boolean lookup[][] = new boolean[n+1][m+1];

		/* Initialization */

		// case 1
		for(int i=0; i<=n; i++)
			lookup[i][0]=false;

		// case 2
		lookup[0][0]=true;

		// case 3
		for(int j=1; j<=m; j++) {
			if(pattern.charAt(j-1)=='*')
				lookup[0][j]=lookup[0][j-1];
		}

		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {

				// case 1
				if( pattern.charAt(j-1) == '*')
					lookup[i][j] = lookup[i-1][j] || lookup[i][j-1];

				//case 2 and 3
				else if( (str.charAt(i-1) == pattern.charAt(j-1)) || (pattern.charAt(j-1)=='?') )
					lookup[i][j] = lookup[i-1][j-1];

				// case 4
				else if( str.charAt(i-1) != pattern.charAt(j-1) )
					lookup[i][j]=false;
			}
		}

		return lookup[n][m];

	}

	public static void main(String args[]) {

		String str = "baaabab";
        String pattern = "*****ba*****ab";
        // String pattern = "ba*****ab";
        // String pattern = "ba*ab";
        // String pattern = "a*ab";
        // String pattern = "a*****ab";
        // String pattern = "*a*****ab";
        // String pattern = "ba*ab****";
        // String pattern = "****";
        // String pattern = "*";
        // String pattern = "aa?ab";
        // String pattern = "b*b";
        // String pattern = "a*a";
        // String pattern = "baaabab";
        // String pattern = "?baaabab";
        // String pattern = "*baaaba*";
      
        if (strmatch(str, pattern, str.length(),
                             pattern.length()))
            System.out.println("Yes");
        else
            System.out.println("No");

	}
}