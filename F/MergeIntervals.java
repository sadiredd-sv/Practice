/*

https://www.programcreek.com/2012/12/leetcode-merge-intervals/

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].

*/

import java.util.*;

class Interval {
	int start, end;
	Interval(int start, int end) {
		this.start=start;
		this.end=end;
	}

	public String toString() {
		return "[ "+start+" , "+end+" ]";
	}
}

class SortByStart implements Comparator<Interval> {
	public int compare(Interval a, Interval b) {
		if(a.start!=b.start)
			return a.start-b.start;
		else
			return a.end-b.end;
	}
}

class MergeIntervals {

	void merge(ArrayList<Interval> list) {

		Collections.sort(list,new SortByStart());

		for(int i=0; i<list.size()-1; ) {
			if(list.get(i).end > list.get(i+1).start) {
				Interval merged = new Interval( list.get(i).start, Math.max(list.get(i).end, list.get(i+1).end) );
				list.remove(0);
				list.remove(0);
				list.add(0,merged);
			}
			else
				i++;
		}
	}

	public static void main(String args[]) {

		MergeIntervals ob = new MergeIntervals();
		ArrayList<Interval> list = new ArrayList<Interval>(Arrays.asList(new Interval(2,6), new Interval(8,10), new Interval(15,18), new Interval(1,8)));
		ob.merge(list);
		System.out.println(list);
	}
}