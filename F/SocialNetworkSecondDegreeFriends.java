/*

https://discuss.leetcode.com/topic/54969/fb-08-2016-phone-interview-find-2nd-degree-connections

*/
import java.util.*;

class Person {
	String name;
	int id;
	Person(String name, int id) {
		this.name = name;
		this.id=id;
	}
}

// class SocialNetworkSecondDegreeFriends {

// }

class SocialNetworkSecondDegreeFriends {

	int count;
	LinkedList<Person> arr[];
	
	SocialNetworkSecondDegreeFriends(int count) {
		this.count=count;
		arr = new LinkedList[count];
		for(int i=0; i<count; i++)
			arr[i] = new LinkedList();
	}

	void addFriend(Person a, Person friend) {
		arr[a.id].add(friend);
	}

	void BFS(int s) {

		Queue<Integer> queue = new LinkedList<Integer>();
		Queue<Integer> countQ = new LinkedList<Integer>();
		boolean visited[] = new boolean[count];
		queue.add(s);
		countQ.add(0);
		visited[s]=true;

		while(!queue.isEmpty() && countQ.peek()<=1) {
			int x = queue.poll();
			int c = countQ.poll();
			System.out.println(x+ " at level:"+c);
			c++;
			for(Person friend : arr[x]) {
				if(!visited[friend.id]) {
					visited[friend.id]=true;
					queue.add(friend.id);
					countQ.add(c);
				}
			}
		}
		System.out.println(queue);
	}

	public static void main(String args[]) {
		SocialNetworkSecondDegreeFriends g = new SocialNetworkSecondDegreeFriends(4);
		g.addFriend(new Person("a",0), new Person("b",1));
		g.addFriend(new Person("a",0), new Person("b",2));
		g.addFriend(new Person("a",1), new Person("b",2));
		g.addFriend(new Person("a",2), new Person("b",0));
		g.addFriend(new Person("a",2), new Person("b",3));
		g.addFriend(new Person("a",3), new Person("b",3));
		g.BFS(2);
	}
}