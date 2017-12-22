/*

http://www.geeksforgeeks.org/closest-pair-of-points/

https://www.youtube.com/watch?v=0W_m46Q4qMc

*/
import java.util.*;

/* Comparable */
class Point implements Comparable<Point>{

	int x;
	int y;

	Point(int x, int y) {
		this.x=x;
		this.y=y;
	}

	int getX() {
		return this.x;
	}

	@Override
	public int compareTo(Point p) {
		return this.x-p.x;
	}

	@Override
	public String toString() {
		return "("+Integer.toString(x) + "," +Integer.toString(y)+")";
	}
}

/* Comparator to sort by X */
class SortByX implements Comparator<Point> {
	public int compare(Point a, Point b) {
		return a.x-b.x;
	}
}

/* Comparator to sort by Y */
class SortByY implements Comparator<Point> {
	public int compare(Point a, Point b) {
		return a.y-b.y;
	}
}

class ClosestPair {

	double distance(Point a, Point b) {
		return Math.sqrt( ( (b.x-a.x)*(b.x-a.x) + (b.y-a.y)*(b.y-a.y) ) );
	}

	double BruteForceClosestPair(Point p[]) {

		double min =Integer.MAX_VALUE;
		for(int i=0; i < p.length-1; i++) {
			for(int j=i+1; j< p.length; j++ ) {
				min = Math.min(min,distance(p[i],p[j]));
			}
		}

		return min;
	}

	double getMinFromStrip(List<Point> strip, double d) {

		double min = d;
		Collections.sort(strip,new SortByY());

		for(int i=0; i <strip.size();i++) {
			for(int j=i+1; j < strip.size() && (strip.get(j).y-strip.get(i).y) < d ; j++) {
				min = Math.min(distance(strip.get(i), strip.get(j)),min);
			}
		}
		return min;
	}

	double DivideAndConquer(Point p[], int l, int r) {

		if((r-l+1)<=3)
			return BruteForceClosestPair(p);

		int mid = (l+r)/2;

		double dl=DivideAndConquer(p,l,mid);
		double dr=DivideAndConquer(p,mid+1,r);
		double d = Math.min(dl,dr);

		/* get all points in the mid strip */
		List<Point> strip = new ArrayList<Point>();
		for(Point pt : p) {
			if( Math.abs(pt.x - p[mid].x) < d )
				strip.add(pt);
		}

		/* Find the minimum from the mid strip and compare with the existing minimum */
		return Math.min(d,getMinFromStrip(strip,d));
	}

	public static void main(String args[]) {

		int arr[][] = {{4,25},{7,2}, {6,33}, {12, 30}, {40, 50}, {5, 1}, {12, 10}, {3, 4}};
		Point p[] = new Point[arr.length];

		for(int i=0; i < p.length; i++)
			p[i] = new Point(arr[i][0],arr[i][1]);

		/* Comparable test */
		//Arrays.sort(p);
		//System.out.println(Arrays.toString(p));

		/* Comparator test */
		//Collections.sort(Arrays.asList(p),new SortByX());

		Arrays.sort(p, Comparator.comparing(Point::getX));
		System.out.println(Arrays.toString(p));

		ClosestPair cp = new ClosestPair();
		System.out.println(cp.DivideAndConquer(p,0,p.length-1));
	}
}