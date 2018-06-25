import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static ArrayList<ArrayList<Integer>> allCombinations(List<Integer> list, int n) {

        if(n==0) {
            //return list.get(n);
            ArrayList<Integer> base = new ArrayList<Integer>(Arrays.asList(list.get(n)));
            ArrayList<ArrayList<Integer>> output = new ArrayList<>();
            output.add(base);
            return output;
        }

        ArrayList<ArrayList<Integer>> prev = allCombinations(list, n-1);


        ArrayList<ArrayList<Integer>> output = new ArrayList<>();

        //one
        ArrayList<ArrayList<Integer>> prevCopy = new ArrayList<>();
        for(ArrayList<Integer> lists : prev)
            prevCopy.add(new ArrayList<Integer>(lists));

        for(ArrayList<Integer> prevCopyLists : prevCopy)
            output.add(prevCopyLists);

        // add new element to prev lists
        for(ArrayList<Integer> prevLists : prev)
            prevLists.add(list.get(n));
        for(ArrayList<Integer> lists : prev)
            output.add(lists);

        ArrayList<Integer> singleElement = new ArrayList<Integer>(Arrays.asList(list.get(n)));
        output.add(singleElement); //

        return output;
    }

    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */

        List<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,3));

        ArrayList<ArrayList<Integer>> output = allCombinations(list, list.size()-1);

        for(ArrayList<Integer> lists : output) {
            System.out.println(lists);
        }

    }
}