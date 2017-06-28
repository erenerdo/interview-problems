import java.io.IOException;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        // Chapter 3
        // IQ 3.5 Sort Stacks
        /*

        Question:

        Write a program to sort a stack such that the smallest items are on the top. You can use
        an additional temporary stack, but you may not copy the elements into any other data structure
        (such as an array). The stack supports the following operations: push, pop, peek, and isEmpty.

        Solution:



         */

        Stack<Integer> stackA = new Stack<>();
        stackA.push(3);
        stackA.push(1);
        stackA.push(5);
        stackA.push(2);
        stackA.push(6);
        stackA.push(4);

        System.out.println("Original Stack");
        printStack(stackA);

        System.out.println();

        stackA = sortStack(stackA);

        System.out.println("Sorted Stack");
        printStack(stackA);
    }

    public static Stack<Integer> sortStack(Stack<Integer> A){

        Stack<Integer> B = new Stack<>();

        while (true){

            B.push(A.pop());

            while(A.peek() > B.peek()){
                B.push(A.pop());

                if(A.isEmpty())
                    return B;
            }
            int hold = A.pop();

            while (B.peek() > hold){
                A.push(B.pop());
                if (B.isEmpty())
                    break;
            }

            A.push(hold);

            while(!B.isEmpty()){
                A.push(B.pop());
            }


        }

    }

    public static void printStack(Stack<Integer> s){

        Stack<Integer> temp = new Stack<>();

        while (!s.isEmpty()){

            System.out.print(s. peek() + " ");
            temp.push(s.pop());
        }

        while (!temp.isEmpty()){
            s.push(temp.pop());
        }

        System.out.println();
    }




}