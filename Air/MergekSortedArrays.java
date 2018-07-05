import java.util.*;

class ArrayContainer implements Comparable<ArrayContainer> {
    int arr[];
    int index;
    ArrayContainer(int arr[], int index) {
        this.arr = arr;
        this.index = index;
    }

    @Override
    public int compareTo(ArrayContainer ob) {
        return this.arr[this.index]-ob.arr[ob.index];
    }
}

class MergekSortedArrays {

    public static List<Integer> merge(int arr[][]) {

        PriorityQueue<ArrayContainer> pq = new PriorityQueue<ArrayContainer>();
        int total = 0;

        for(int i=0; i < arr.length; i++) {
            ArrayContainer ac = new ArrayContainer(arr[i],0);
            pq.add(ac);
            total+=arr[i].length;
        }

        List<Integer> output = new ArrayList<>();

        while(!pq.isEmpty()) {
            ArrayContainer ac = pq.poll();
            output.add(ac.arr[ac.index]);

            if(ac.index < ac.arr.length-1)
                pq.add(new ArrayContainer(ac.arr,ac.index+1));
        }

        return output;
    }

    public static void main(String args[]) {
        int[] arr1 = { 1, 3, 5, 7 };
        int[] arr2 = { 2, 4, 6, 8 };
        int[] arr3 = { 0, 9, 10, 11 };

        List<Integer> output= merge(new int[][]{arr1,arr2,arr3});
        System.out.println(output);
    }
}