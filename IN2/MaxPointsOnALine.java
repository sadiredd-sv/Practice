/*

https://www.geeksforgeeks.org/count-maximum-points-on-same-line/
https://www.programcreek.com/2014/04/leetcode-max-points-on-a-line-java/

max points in a line:
1. Pick all pairs of points, calculate the slope and put in HashMap.
2. From the Hashmap, get the number with highest value(value in key-value pair) = x
    Math.sqrt(2*x+1)

time: O(n^2)
space: O(n)


*/

import java.util.*;

class Point {
	int x;
	int y;

	Point(int x, int y) {
		this.x =x;
		this.y=y;
	}
}

class MaxPointsOnALine {

	static void findMaxPoints(Point points[]) {

		Map<Double, Integer> map = new HashMap<Double,Integer>();

		for(int i=0; i<points.length-1; i++) {
			for(int j=i+1; j<points.length; j++) {

				double slope = Integer.MAX_VALUE;
				// handle infinite slope (x2-x1 = 0)
				if( points[j].x != points[i].x )
					slope = (points[j].y-points[i].y)/(points[j].x-points[i].x);

				if( map.containsKey(slope) ){
					int val = map.get(slope);
					map.put(slope, val+1);
				}
				else
					map.put(slope, 1);
			}
		}

		// highest value in the map
		int max = Integer.MIN_VALUE;
		for(Map.Entry<Double,Integer> entry: map.entrySet()) {
			max = Math.max(max,entry.getValue());
			System.out.println(entry.getKey()+" , "+ entry.getValue());
		}

		System.out.println(Math.ceil( Math.sqrt(2*max+1)) );
	}

	public static void main(String args[]) {
		Point points[] = new Point[6];

		points[0] = new Point(-1,1);
		points[1] = new Point(0,0);
		points[2] = new Point(1,1);
		points[3] = new Point(2,2);
		points[4] = new Point(3,3);
		points[5] = new Point(3,4);

		// for(int i=0;i<points.length;i++)
		// 	points[i] = new Point(i,i);

		findMaxPoints(points);
	}
}