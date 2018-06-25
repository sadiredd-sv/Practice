import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void minDistance(HashMap<String,Queue<Integer>> map) {
        Queue<Integer> q = new ArrayList<Integer>();

        for( Queue<Integer> queue : map.values() ) {
            q.add(queue.poll());
            Arrays.sort(q);

        }
    }

    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */

        Map<String, Queue<Integer>> map = new HashMap<>();
        Queue<Integer> l1 = new ArrayList<Integer>(Arrays.asList(6,14));
        Queue<Integer> l2 = new ArrayList<Integer>(Arrays.asList(2,11));
        Queue<Integer> l3 = new ArrayList<Integer>(Arrays.asList(3,7,12));
        map.put("big",l1);
        map.put("small",l2);
        map.put("dog",l3);
    }
}