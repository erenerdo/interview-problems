import java.io.IOException;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws IOException {
        // Chapter 2
        // IQ 2.7 Intersection

        /*
        Question:

        Given two (singly) linked lists, determine if the two lists intersect. Return the intersecting
        node. Note that the intersection is defined based on reference, not value. That is, if the kth
        node of the first linked list is the exact same node (by reference) as the jth node of the second
        linked list, then they are intersecting.



        Solution:


        Pseudocode:

        Iterate through the entire first linked list and put each Node in a HashSet.
        Then iterate through the second linked list. If it is in the HashSet then there is
        an intersection, return the node where intersection happens.

        If the second linked list finished traversing then it is not in the HashSet and therefore
        there is no intersection. Return null. 


         */


        Node head1 = new Node(1);
        head1.appendToTail(2);
        head1.appendToTail(3);

        Node ptr = head1;
        ptr = ptr.next;
        ptr = ptr.next;

        head1.appendToTail(4);
        head1.appendToTail(5);

        Node head2 = new Node (7);
        head2.appendToTail(6);

        Node ptr2 = head2;
        while (ptr2.next!= null){
            ptr2 = ptr2.next;
        }
        ptr2.next = ptr;

        printLinkedList(head1);
        System.out.println();
        printLinkedList(head2);
        System.out.println();
        Node intersect2 = isIntersect(head1, head2);

        if (intersect2 != null)
            System.out.println("Yes there is an intersection at " + isIntersect(head1, head2).data);
        else
            System.out.println("No intersection");

        System.out.println();

        Node head3 = new Node(9);
        head3.appendToTail(10);
        head3.appendToTail(11);

        printLinkedList(head1);
        System.out.println();
        printLinkedList(head3);
        System.out.println();


        Node intersect = isIntersect(head1, head3);

        if (intersect != null)
            System.out.println("Yes there is an intersection at " + isIntersect(head1, head3).data);
        else
            System.out.println("No intersection");



    }

    public static Node isIntersect(Node head1, Node head2){

        HashSet<Node> h = new HashSet<>();

        Node ptr1 = head1;

        while (ptr1 != null){
            h.add(ptr1);
            ptr1 = ptr1.next;
        }

        Node ptr2 = head2;

        while (ptr2 != null){
            if (h.contains(ptr2))
                return ptr2;
            else
                ptr2 = ptr2.next;
        }

        return null;
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

        public Node(int d) {
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