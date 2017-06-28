import java.io.IOException;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws IOException {
        // Chapter 2
        // IQ 2.1 Remove Dups Part 2
        /*

        Question: Write code to remove duplicates from an unsorted linked list.


        FOLLOW UP
        How would you solve this problem if a temporary buffer is not allowed?


        Example:

        Given:
        1 -> 2 -> 3 -> 2 -> 1 -> 4 -> 5 -> 2

        Output:
        1 -> 2 -> 3 -> 4 -> 5

        */

        Node head = new Node(1);




        Random rand = new Random();

        for (int i = 0; i < 20; i++){

            head.appendToTail(rand.nextInt(6));
        }


        printLinkedList(head);
        removeDups(head);
        System.out.println();
        printLinkedList(head);




    }

    public static Node removeDups(Node head){

        if (head == null)
            return head;

        Node ptr1 = head;

        while (ptr1 != null && ptr1.next != null) {

            Node ptr2 = ptr1;

            while (ptr2 != null && ptr2.next != null){

                if (ptr2.next.data == ptr1.data) {
                    ptr2.next = ptr2.next.next;
                }else{
                    ptr2 = ptr2.next;
                }

            }

            ptr1 = ptr1.next;

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