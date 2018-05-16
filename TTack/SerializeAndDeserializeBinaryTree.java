/*

            1
     2              3
  4     5        6     7


* */

import java.util.*;

class Node {
    int data;
    Node left, right;


    Node(int data) {
        this.data = data;
    }
}


class SerializeAndDeserializeBinaryTree {


    public static String serialize(Node root) {
        if(root==null)
            return null;

        Stack<Node> stack = new Stack<Node>();
        StringBuilder sb = new StringBuilder();
        stack.push(root);

        while(!stack.isEmpty()) {
            Node popped = stack.pop();
            System.out.println(popped.data);
            sb.append(popped.data+",");

            if(popped.right!=null)
                stack.push(popped.right);
            else
                sb.append("#,");

            if(popped.left!=null)
                stack.push(popped.left);
            else
                sb.append("#,");
        }
        System.out.println(" Serialized: "+sb.toString());

        return sb.toString();
    }

    public static Node deserialize(String sb) {
        String data[] = sb.split(",");
        int[] i={0};
        return helper(data,i);
    }

    public static Node helper(String data[],int[] i) {

        if(data[i[0]].equals("#"))
            return null;
        Node n = new Node(Integer.parseInt(data[i[0]]));
        i[0]=i[0]+1;
        n.left = helper(data,i);
        i[0]=i[0]+1;
        n.right = helper(data,i);
        return n;
    }

    public static void preorderTraversal(Node root) {

        if(root==null)
            return;
        System.out.println(root.data);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    public static void main(String args[]) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        //preorderTraversal(root);
        String serialized = serialize(root);
        Node n = deserialize(serialized);
        System.out.println("After deserialization : Preorder traversal");
        preorderTraversal(n);
    }
}