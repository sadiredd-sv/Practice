class atoi {

    public static int atoiImpl(String str) {

        if(str==null || str.length()<1)
            return 0;

        str.trim();

        boolean negative = false;

        if(str.charAt(0)=='-' || str.charAt(0)=='+') {
            if(str.charAt(0)=='-')
                negative = true;
            str = str.substring(1);
        }

        int result=0;
        for(int i=0;i<str.length(); i++) {
            result= result*10 + (str.charAt(i)-'0');
        }

        if(result > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;

        if(result < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        return negative==true? result*(-1) : result;

    }

    public static void main(String args[]) {
        System.out.println(atoiImpl("17429"));
    }
}