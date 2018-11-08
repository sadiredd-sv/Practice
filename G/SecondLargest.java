class SecondLargest {

    public static int secondLargest(int arr[]) {

        if(arr.length==1 || arr.length==0)
            return -1;

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for(int i : arr) {
            if(i > largest) {
                secondLargest = largest;
                largest = i;
            }
            else if(i > secondLargest && i <largest)
                secondLargest = i;
        }
        return secondLargest!=Integer.MIN_VALUE? secondLargest : -1;
    }

    public static void main(String args[]) {
        int arr[] = {12, 35, 1, 10, 34, 1};
        System.out.println(secondLargest(arr));
    }
}