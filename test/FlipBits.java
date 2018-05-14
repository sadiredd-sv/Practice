class FlipBits {

    /**
     Given n = 31 (11111), m = 14 (01110), return 2.
     */
    public static void convertOneToAnotherFlipBits(int x, int y) {
        int r = x^y; // 10001
        int count=0;
        while(r!=0) {
            r&=(r-1);
            count++;
        }
        System.out.println(count);
    }

    public static void flipBits(long N){

        N = ~N;
        long result=0, mask=1;

        for(int i=0; i < 32; i++) {
            result |= (N & mask);
            mask <<=1;
        }

        System.out.println(result);
    }

    public static void main(String args[]) {
        //flipBits(2147483647);
        convertOneToAnotherFlipBits(31,14);
    }
}