/*

https://www.programcreek.com/2013/03/leetcode-lru-cache-java/

*/

import java.util.*;

class Node {

	int value,key;
	Node prev, next;
	Node(int key, int value) {
		this.key=key;
		this.value=value;
		this.prev=this.next=null;
	}
}

class Lru {

	Map<Integer,Node> map = new HashMap<>();
	Node front,rear;
	int capacity;

	Lru(int capacity) {
		front=rear=null;
		this.capacity=capacity;
	}

	/* Put elements in cache , or set the value of existing key-value pairs in cache */
	void set(int key, int value) { 

		Node n=null;
		// set the value of existing key-value pairs in cache
		if(map.containsKey(key)) {
			n = map.get(key);
			removeFromCurrentPositionInQueue(n);
			setFront(n);
			n.value = value;
		}
		else {
			// Add new element to cache
			if(map.size() >= capacity) {
				map.remove(rear.key);
				removeFromCurrentPositionInQueue(rear); // LRU - Eviction
			}
			n = new Node(key,value);
			setFront(n);
		}
		map.put(key,n);
	}

	/* Access the cache */
	int get(int key) {

		if(map.containsKey(key)) {
			Node used = map.get(key);
			removeFromCurrentPositionInQueue(used);
			setFront(used); //Cache hit. So, move it to the front of the queue.
			return used.value;
		}

		return -1;
	}

	void setFront(Node n) {

		n.next=front;

		if(front!=null)	
			front.prev=n;
		
		front=n;

		if(rear==null) 
			rear=n;
	}

	void removeFromCurrentPositionInQueue(Node n) {

		if(n.prev==null)
			front=n.next;

		if(n.next==null)
			rear=n.prev;

		if(n.prev!=null)
			n.prev.next=n.next;

		if(n.next!=null)
			n.next.prev=n.prev;
	}

	void printCache() {

		Node temp = front;

		while(temp!=null) {
			System.out.println(temp.value);
			temp=temp.next;
		}
	}

	public static void main(String args[]) {

		Lru ob = new Lru(3);
		ob.set(1,1);
		ob.set(2,2);
		ob.set(3,3);
		ob.printCache();

		ob.get(1);
		System.out.println(" Cache after accessing element 1: ");
		ob.printCache();

		ob.set(4,4);
		System.out.println(" Cache after adding 4: ");
		ob.printCache();

		ob.set(3,3);
		System.out.println(" Cache after accessing element 3: ");
		ob.printCache();
	}
}