// sorted interval sets
// interval: [1,4] -> {1,2,3,4}, [2,5]->{2..5}
// sorted interval set: [0,0], [2,5], [7,10]
// [0,0], [1,2] X -> [0,2]
// [0,3], [1,6] X -> [0,6]
// [2,5], [0,0] X -> [0,0], [2,5]
// implement 1 of AND/OR operation on 2 sorted interval sets
// example:
// 1st sorted interval set: [0,0], [2,5], [7,10] -> {0, 2, 3, 4, 5, 7, 8, 9, 10}
// 2nd sorted interval set: [1,1], [5,8], [12,15] -> {1, 5, 6, 7, 8, 12, 13, 14, 15}
// and -> {5, 7, 8}
// and RESULT: [5,5],[7,8]
// or: [0,10],[12,15]

// [5, 7] [8, 8] -> {5, 6, 7, 8} -> [5, 8]

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


class Interval {
    int x, y;
    Interval(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class AndMerge {

    public static List<Interval> mergeAnd(List<Interval> list1, List<Interval> list2) {

        int l1 = list1.size();
        int l2 = list2.size();
        List<Interval> output = new ArrayList<Interval>();

        int i=0,j=0;

        while(i < l1 && j < l2) {
            /* during the interview, I compared "x in list2 with y in list1". But I immediately corrected it to "y in list2 with y in list1”
                All the other code is same.
             */
            if( (list1.get(i).y >= list2.get(j).x) && (list2.get(j).y > list1.get(i).y) ) {
                Interval iv = new Interval(list2.get(j).x,list1.get(i).y);
                output.add(iv);
                i++;
            }
            else if( (list2.get(j).y >= list1.get(i).x) && (list1.get(i).x > list2.get(j).x) ) {
                Interval iv = new Interval(list1.get(i).x,list2.get(j).y);
                output.add(iv);
                j++;
            }
            else {
                i++;
                j++;
            }

        }

        return output;

    }

    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */

        Interval v1 = new Interval(0,0);
        Interval v2 = new Interval(2,5);
        Interval v3 = new Interval(7,10);
        List<Interval> list1 = new ArrayList<>(Arrays.asList(v1,v2,v3));


        Interval v4 = new Interval(1,1);
        Interval v5 = new Interval(5,8);
        Interval v6 = new Interval(12,15);
        List<Interval> list2 = new ArrayList<>(Arrays.asList(v4,v5,v6));

        List<Interval> output = mergeAnd(list1,list2);

        for(Interval iv: output) {
            System.out.println(iv.x+","+iv.y);
        }

    }
}