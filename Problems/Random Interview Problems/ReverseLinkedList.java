import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        // Reverse Linked List

        /*
        Question:

        Reverse a linked list in O(N) time using O(1) memory


        Example:

        Given:
        1 -> 2 -> 3 -> 4 -> 5 -> 6

        Output:
        6 -> 5 -> 4 -> 3 -> 2 -> 1

         */

        // Generate linked list


        Node head = new Node(1);
        head.appendToTail(2);
        head.appendToTail(3);
        head.appendToTail(4);
        head.appendToTail(5);
        head.appendToTail(6);


        printLinkedList(head);

        // Reverse Linked List
        head = reverseLinkedList(head);

        printLinkedList(head);

        


    }

    public static Node reverseLinkedList(Node head){

        if (head == null || head.next == null)
            return head;

        Node ptr_A = head.next;
        Node ptr_B = ptr_A.next;

        head.next = null;
        ptr_A.next = head;

        head = ptr_A;
        ptr_A = ptr_B;

        while (ptr_A != null){
            ptr_B = ptr_B.next;
            ptr_A.next = head;
            head = ptr_A;
            ptr_A = ptr_B;
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

        System.out.println(ptr.data);



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