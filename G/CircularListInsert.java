class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next=null;
    }
}

class CircularListInsert {
    Node head;

    CircularListInsert() {
        head=null;
    }

    void sortedInsert(int d){

        Node temp = head;
        Node n = new Node(d);
        Node prev =null;

        if(temp==null) { // no element in the list
            head = n;
            return;
        }else {
            while(temp!=null && temp.data< d) {
                prev=temp;
                temp=temp.next;
            }

            if(prev==null) {
                n.next = head;
                head=n;
            } else {
                n.next=prev.next;
                prev.next=n;
            }
        }

    }

    void printList(){

        Node temp = head;

        while(temp!=null) {
            System.out.println(temp.data);
            temp=temp.next;
        }
    }

    public static void main(String args[]) {
        CircularListInsert list = new CircularListInsert();
        int arr[] = new int[]{12, 56, 2, 11, 1, 90};

        for(int i : arr) {
            list.sortedInsert(i);
        }

        list.printList();
    }
}