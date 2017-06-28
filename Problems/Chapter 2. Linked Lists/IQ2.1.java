import java.io.IOException;
import java.util.HashSet;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws IOException {
        // Chapter 2
        // IQ 2.1 Remove Dups
        /*

        Question: Write code to remove duplicates from an unsorted linked list.

        Example:

        Given:
        1 -> 2 -> 3 -> 2 -> 1 -> 4 -> 5 -> 2

        Output:
        1 -> 2 -> 3 -> 4 -> 5

	Solution: 

        Pseudocode:

        Iterate through linked list. Check if item is in a Hash table. If not add to hash table.
        If so then arrange to delete it.


         */

        Node head = new Node(1);

        Random rand = new Random();

        for (int i = 0; i < 20; i++){

            head.appendToTail(rand.nextInt(10));
        }


        printLinkedList(head);
        removeDups(head);
        System.out.println();
        printLinkedList(head);




    }

    public static Node removeDups(Node head){

        // Null Pointer Edge (empty linked list)
        if (head == null)
            return head;

        Node ptr = head;

        HashSet<Integer> h = new HashSet<>();

        // Initialize hash table with first
        h.add(ptr.data);

        while (ptr.next != null && ptr != null){

            // Check if next node is in Hash Table
            if (!h.contains(ptr.next.data)){
                // Value not seen before since it is not in the Hash Table
                ptr = ptr.next;
                h.add(ptr.data);
            }
            else {
                // Value seen before and therefore a duplicate
                ptr.next = (ptr.next).next;

            }

        }

        return head;


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
