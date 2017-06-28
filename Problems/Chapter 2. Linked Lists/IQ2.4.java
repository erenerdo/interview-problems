import java.io.IOException;
import java.util.Random;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        // Chapter 2
        // IQ 2.4 Partition

        /*
        Question:

        Write code to partition a linked list around a value x, such that all nodes less than x come
        before all nodes greater than or equal to x. lf x is contained within the list, the values of x only need
        to be after the elements less than x (see below). The partition element x can appear anywhere in the
        "right partition"; it does not need to appear between the left and right partitions.

        EXAMPLE
        Input: 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [partition = 5)
        Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
        Hints: #3, #24

        Solution:

        Pseudocode:
        Have two different stacks. Iterate through the array once and push all the values less than x
        onto Stack A and the values greater than or equal to x onto stack B. Then start back from the head
        and pop the values out of Stack A first, then once thats empty, pop the values out of stack B.

         */


//        Node head = new Node(3);
//
//        head.appendToTail(5);
//        head.appendToTail(8);
//        head.appendToTail(5);
//        head.appendToTail(10);
//        head.appendToTail(2);
//        head.appendToTail(1);

        Random rand = new Random();

        Node head = new Node(rand.nextInt(10));

        for (int i = 0; i < 20; i++){

            head.appendToTail(rand.nextInt(10));
        }

        System.out.println("Original Linked List:");
        printLinkedList(head);
        System.out.println();

        int x = rand.nextInt(3) + 5;

        System.out.println("\nPartition around value " + x);

        partition(head, x);

        System.out.println("\nPartitioned Linked List:");
        printLinkedList(head);



    }

    public static boolean partition(Node head, int x){

        if (head == null || head.next == null)
            return false;


        Stack<Integer> stackA = new Stack<>();
        Stack<Integer> stackB = new Stack<>();

        Node ptr1 = head;
        Node ptr2 = head;


        while (ptr1 != null){

            if (ptr1.data < x) {
                stackA.push(ptr1.data);
            }
            else{
                stackB.push(ptr1.data);
            }
            ptr1 = ptr1.next;

        }

        while (!stackA.isEmpty()){
            ptr2.data = stackA.pop();
            ptr2 = ptr2.next;
        }

        while (!stackB.isEmpty()){
            ptr2.data = stackB.pop();
            ptr2 = ptr2.next;
        }

        return true;
    }

    public static void printLinkedList(Node head){

        if (head == null)
            return;

        Node ptr = head;

        while (ptr.next != null){

            System.out.print(ptr.data + " -> ");
            ptr = ptr.next;

        }

        System.out.print(ptr.data);


    }

    static class Node {
        Node next = null;
        int data;

        public Node( int d) {
            data = d;
            }

        public void appendToTail(int d) {
            Node end = new Node(d);
            Node n = this;
            while (n.next != null) {
                n = n.next;
                 }
             n. next = end;
        }


 }

}