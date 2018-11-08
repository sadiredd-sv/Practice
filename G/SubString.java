/*
* https://www.programcreek.com/2012/12/leetcode-implement-strstr-java/
* */

class SubString {

    public static int strstr(String haystack, String needle) {

        if(needle==null || haystack==null || needle.length()==0 )
            return -1;

        for(int i=0; i<haystack.length(); i++) {

            int m =i;
            for(int j=0; j<needle.length(); j++) {
                if(haystack.charAt(m)==needle.charAt(j)) {
                    if(j==needle.length()-1)
                        return i;
                    m++;
                } else
                    break;
            }
        }

        return -1;

    }

    public static void main(String args[]) {
        System.out.println(strstr("decdefghi", "def"));
    }
}