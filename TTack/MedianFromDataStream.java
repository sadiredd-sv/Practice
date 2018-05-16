/*
*   max heap             min heap
*       10                      11
*    8       9          12            13
*  6   7            14      15
*
* */


import java.util.*;

class MedianFromDataStream {

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFromDataStream() {
        maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        minHeap = new PriorityQueue<Integer>();
    }

    public void addNumber(int i) {

        maxHeap.offer(i);
        minHeap.offer(maxHeap.poll());

        if(maxHeap.size()<minHeap.size())
            maxHeap.offer(minHeap.poll());
    }

    public double findMedian() {

        if(minHeap.size()==maxHeap.size())
            return (double)( minHeap.peek() + maxHeap.peek() )/2;
        else
            return maxHeap.peek();
    }

    public static void main(String args[]) {

        MedianFromDataStream ob = new MedianFromDataStream();

        for(int i=6; i<=15; i++) {
            ob.addNumber(i);
        }

        System.out.println(ob.findMedian());
    }
}