// 1->2->3->4->null

//saree design
class Node {
	int value; 
	Node next;

	Node(int val){
		this.value = val;
		next=null;
	}

	void print () {
		Node temp = this; //temp = 1

		while(temp != null){
			System.out.println(temp.value);
			temp = temp.next; 
		}
	}

}


class linkedlist {
	public static void main(String args[]) {
		Node n1 = new Node(1); // 1->null  ----- saree stiching
		Node n2 = new Node(2); // 1->2->null
		n1.next = n2;
		n1.next.next = new Node(3); //1->2->3->null
		n1.next.next.next = new Node(4); //1->2->3->4->null

		n1.print();

		Node insertnew = new Node (100);
		// Insert this Node 100, after the node 3: 
		// 1->2->3->100->4->null
		n1.insert(insertnew);
	}
}
