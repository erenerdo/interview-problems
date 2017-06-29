import java.io.IOException;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        // Chapter 2
        // IQ 2.6 Palindrome

        /*
        Question:

        Palindrome: Implement a function to check if a linked list is a palindrome.

        Solution:


        Pseudocode:
                    - Iterate through the linked list and count the elements
                    - Create a stack, and iterate through the linked list again to the midpoint
                    while pushing characters onto the stack
                    - When midpoint reached, start popping characters off the stack
                    and comparing values in the remaining linked list
                    - If any case fails, return false
                    - If completed, the all cases passed. Return true.

                    NOTE: All lower case letter assumed however it would be easy to modify for both lower
                    and upper case.

                    Simply just convert to lowercase before analyzing




         */

        Node head1 = new Node('r');
        head1.appendToTail('a');
        head1.appendToTail('c');
        head1.appendToTail('e');
        head1.appendToTail('c');
        head1.appendToTail('a');
        head1.appendToTail('r');

        printLinkedList(head1);
        System.out.println();
        System.out.println(isPal(head1) + "\n");

        Node head2 = new Node('p');
        head2.appendToTail('o');
        head2.appendToTail('o');
        head2.appendToTail('p');

        printLinkedList(head2);
        System.out.println();
        System.out.println(isPal(head2) + "\n");

        Node head3 = new Node('b');
        head3.appendToTail('a');
        head3.appendToTail('n');
        head3.appendToTail('a');
        head3.appendToTail('n');
        head3.appendToTail('a');

        printLinkedList(head3);
        System.out.println();
        System.out.println(isPal(head3) + "\n");

    }

    public static boolean isPal(Node head){

        if (head == null || head.next == null)
            return false;

        Node ptr = head;
        Node ptr2 = head;

        int count = 0;

        while (ptr != null){
            ptr = ptr.next;
            count++;
        }

        // Not long enough to be a palindrome
        if (count < 2)
            return false;

        // Get mid point
        int mid = count/2;

        Stack<Character> stack = new Stack<>();

        // Push first half values onto stack
        for ( int i = 0; i < mid; i++){
            stack.push(ptr2.data);
            ptr2 = ptr2.next;
        }

        // if odd length, skip middle element
        if (count % 2 == 1)
            ptr2 = ptr2.next;

        // Check values with stack values, should in in same order
        while (!stack.isEmpty()){
            if (stack.pop() != ptr2.data)
                return false;
            else
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

    // Node Class
    static class Node {
        Node next = null;
        char data;

        public Node( char d) {
            data = d;
            }

        public void appendToTail(char d) {
            Node end = new Node(d);
            Node n = this;
            while (n.next != null) {
                n = n.next;
                 }
             n. next = end;
        }


 }

}