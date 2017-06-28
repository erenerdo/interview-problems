import java.io.IOException;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws IOException {
        // Chapter 2
        // IQ 2.2 Return Kth to Last:

        /*
        Question:

        Implement an algorithm to find the kth to last element of a singly linked list.


        Question: Write code to remove duplicates from an unsorted linked list.

        Example:

        Given:
        1 -> 2 -> 3 -> 2 -> 1 -> 4 -> 5 -> 2
        k = 3

        Output:
        1


        Pseudocode:


         */

        // Generate random linked list


        Random rand = new Random();

        Node head = new Node(rand.nextInt(10));

        for (int i = 0; i < 7; i++){

            head.appendToTail(rand.nextInt(10));
        }


        printLinkedList(head);
        System.out.println();

        int k = 2;

        System.out.println("kth to last element, where k is " + k + ", is " + getKth(head, k));






    }

    public static int getKth(Node head, int k){

        if (head == null)
            return -1;


        Node ptrA = head;
        Node ptrB = head;

        for (int i = 0; i < k; i ++){
            ptrB = ptrB.next;

        }

        while (ptrB.next != null){

            ptrA = ptrA.next;
            ptrB = ptrB.next;

        }

        return ptrA.data;

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