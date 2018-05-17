/*

Given an integer n, find the closest integer (not including itself), which is a palindrome.

The 'closest' is defined as absolute difference minimized between two integers.

Example 1:
Input: "123"
Output: "121"

Note:
The input n is a positive integer represented by string, whose length will not exceed 18.
If there is a tie, return the smaller one as answer.


Algorithm(efficient):

Three cases:
1. Replicate left half onto the right half - diff1
2. If middle number is 9, make it zero and all the 9s on the left are converted to 0
3. If the middle number is 0, subtract 1 there


* */

class ClosestPalindrome {

    public static boolean isPalindrome(int i) {
        int revInp = i;
        int rev =0;

        while(revInp>0) {
            rev= rev*10 + revInp%10;
            revInp=revInp/10;
        }

        return rev==i;
    }

    public static int naiveMethod(String input) {
        int inp = Integer.parseInt(input);

        for(int i=1;;i++) {

            if(isPalindrome(inp-i))
                return inp-i;
            if(isPalindrome(inp+i))
                return inp+i;
        }
    }

    public static String ifMiddleIsNine(String input, int mid) {

        StringBuilder sb = new StringBuilder(input);
        //int mid = input.length()%2==0? input.length()/2-1 : input.length()/2;

        while(mid>=0 && input.charAt(mid)=='9') {
            sb.setCharAt(mid,'0');
            mid--;
        }

        if(mid>=0)
            sb.setCharAt(mid, (char)(input.charAt(mid)+1) );
        else
            sb.insert(0,1);

        String res = copyLeftToRight(sb.toString());
        return res;
    }


    public static String ifMiddleIsZero(String input, int mid) {

        StringBuilder sb = new StringBuilder(input);
        //int mid = input.length()%2==0? input.length()/2-1 : input.length()/2;

        while(mid>=0 && input.charAt(mid)=='0') {
            sb.setCharAt(mid,'9');
            mid--;
        }

        if(mid>=1)
            sb.setCharAt(mid, (char)(input.charAt(mid)-1) );
        else
            sb.deleteCharAt(0);

        String res = copyLeftToRight(sb.toString());
        return res;
    }


    public static String copyLeftToRight(String input) {

        StringBuilder sb = new StringBuilder(input);
        int len = input.length();
        int i=len/2-1;
        int j= len%2==0?len/2 : len/2+1;

        while(i>=0 && j<len) {
            sb.setCharAt(j,input.charAt(i));
            i--;j++;
        }

        System.out.println(sb.toString());
        return sb.toString();
    }

    public static String closestPalindrome(String input) {

        int diff1 = Integer.MAX_VALUE, diff2 = Integer.MAX_VALUE, diff3 = Integer.MAX_VALUE;

        String a = copyLeftToRight(input);
        diff1 = Math.abs(Integer.parseInt(a)-Integer.parseInt(input));
        int mid = input.length()%2==0? input.length()/2-1 : input.length()/2;

        String b=null,c=null;
        if(input.charAt(mid)=='9') {
            b=ifMiddleIsNine(input, mid);
            diff2 = Math.abs(Integer.parseInt(b) - Integer.parseInt(input));
        }

        if(input.charAt(mid)=='0') {
            c=ifMiddleIsZero(input,mid);
            diff3 = Math.abs(Integer.parseInt(c)-Integer.parseInt(input));
        }

        if(diff1 <= diff2 && diff1 <= diff3)
            return a;
        if(diff2 <= diff1 && diff2 <= diff3)
            return b;
        else
            return c;

    }

    public static void main(String args[]) {
        //System.out.println(naiveMethod("123"));

        //String input = "12945";
        //String input = "99945";
        String input = "11045";
        System.out.println("Closest Palindrome is: "+closestPalindrome(input));
    }
}