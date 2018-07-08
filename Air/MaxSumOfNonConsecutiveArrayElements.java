class MaxSumOfNonConsecutiveArrayElements {

    /*
    * https://www.glassdoor.com/Interview/Airbnb-Software-Engineer-Interview-Questions-EI_IE391850.0,6_KO7,24_IP5.htm
    * */

    public static int maxSumRecursion(int arr[], int n) {

        if(n<0)
            return 0;

        if(n==0)
            return arr[n];

        return Math.max(arr[n]+maxSumRecursion(arr,n-2), maxSumRecursion(arr,n-1) );
    }

    // DP
    public static int maxSumDP(int arr[]) {

        if(arr==null)
            return 0;

        if(arr.length==1)
            return arr[0];

        int result[] = new int[arr.length+1];
        result[0]=0;
        result[1]= arr[0];

        for(int i=2; i < result.length; i++)
            result[i] = Math.max(arr[i-1]+result[i-2], result[i-1]);

        return result[arr.length];
    }

    public static void main(String args[]) {
        int arr[] = {4,10,3,1,5};
        //int arr[] = {5,1,1,5};
        //int arr[] = {3,6,4};
        System.out.println(maxSumRecursion(arr,arr.length-1));
        System.out.println(maxSumDP(arr));
    }
}