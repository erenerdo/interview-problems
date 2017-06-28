import java.io.IOException;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws IOException {
        // Chapter 2
        // IQ 2.5 Sum List

        /*
        Question:

        You have two numbers represented by a linked list, where each node contains a single
        digit. The digits are stored in reverse order, such that the 1 's digit is at the head of the list. Write a
        function that adds the two numbers and returns the sum as a linked list.

        EXAMPLE
        Input: (7 -> 1 -> 6) + (5 -> 9 -> 2)
        That is, 617 + 295.

        Output: 2 -> 1 -> 9.
        That is, 912.

        Solution:   Iterate through linked list 1 and get it's numerical value.
                    Iterate through linked list 2 and get it's numerical value.
                    Create new linked list and assign values to it using modulus operator to get units digits.
                    Return head of new linked list.



        Pseudocode:

         */


//        Node head1 = new Node(7);
//        head1.appendToTail(1);
//        head1.appendToTail(6);
//
//        Node head2 = new Node(5);
//        head2.appendToTail(9);
//        head2.appendToTail(2);


        // Random Linked List Generator

        Random rand = new Random();

        Node head1 = new Node(rand.nextInt(10));
        for (int i = 0; i < 5; i++){

            head1.appendToTail(rand.nextInt(10));
        }

        Node head2 = new Node(rand.nextInt(10));
        for (int i = 0; i < 5; i++){

            head2.appendToTail(rand.nextInt(10));
        }


        System.out.println("Linked List 1:");
        printLinkedList(head1);
        System.out.println();

        System.out.println("Linked List 2:");
        printLinkedList(head2);
        System.out.println();

        Node sum = sumList(head1, head2);
        System.out.println("Summed Link List:");
        printLinkedList(sum);



    }

    public static Node sumList(Node head1, Node head2){

        // Null Pointers
        if (head1 == null)
            return head2;
        else if (head2 == null)
            return head1;

        // Used to store numerical values
        int h1 = 0;
        int h2 = 0;

        Node ptr1 = head1;
        Node ptr2 = head2;

        int multiplier = 1;

        while (ptr1 != null){

            h1 +=  ptr1.data * multiplier;
            ptr1 = ptr1.next;
            multiplier *= 10;

        }

        // Reset multiplier
        multiplier = 1;

        // Do same for second linked list
        while (ptr2 != null){

            h2 +=  ptr2.data * multiplier;
            ptr2 = ptr2.next;
            multiplier *= 10;

        }

        // 912
        int sum = h1 + h2;

        // Create new linked list
        Node newHead = new Node(sum % 10);

        while (sum >= 10){
           sum /= 10;
           newHead.appendToTail(sum % 10);
        }

        return newHead;
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