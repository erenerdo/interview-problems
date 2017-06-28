import java.io.IOException;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws IOException {
        // Chapter 2
        // IQ 2.3 Delete Middle Node

        /*
        Question:

        Implement an algorithm to delete a node in the middle (i.e., any node but
        the first and last node, not necessarily the exact middle) of a singly linked list, given only access to
        that node.


        EXAMPLE
        Input:
        the node c from the linked list a -> b -> c -> d -> e -> f

        Result:
        nothing is returned, but the new linked list looks like a -> b -> d -> e -> f

        Hints: #72


        Pseudocode:
        Iterate through the array and copy element from next element. Then delete the last node.


         */

        // Generate random linked list


        Random rand = new Random();

        Node head = new Node(rand.nextInt(10));

        for (int i = 0; i < 6; i++){

            head.appendToTail(rand.nextInt(10));
        }

        Node ptr = head;
        int count = 3;

        while(count > 0){
            ptr = ptr.next;
            count--;
        }

        int k = ptr.data;

        printLinkedList(head);
        System.out.println();
        System.out.println("Deleteing Node with value " + k);
        deleteMiddle(ptr);
        printLinkedList(head);







    }

    public static boolean deleteMiddle(Node ptr){

        if (ptr.next == null || ptr == null)
            return false;

        // Shift data over
        ptr.data = ptr.next.data;

        // Delete next node
        ptr.next = ptr.next.next;

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