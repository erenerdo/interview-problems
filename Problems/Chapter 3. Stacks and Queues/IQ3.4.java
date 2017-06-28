import java.io.IOException;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        // Chapter 3
        // IQ 3.4 Queue via Stacks
        /*

        Question:

        Implement a MyQueue class which implements a queue using two stacks


        Solution:



         */
        

        myQueue<Integer> mq = new myQueue<>();

        System.out.println("Enqueueing " + 1 + " to queue ");
        mq.add(1);
        System.out.println("Enqueueing " + 2 + " to queue ");
        mq.add(2);
        System.out.println("Enqueueing " + 3 + " to queue ");
        mq.add(3);
        System.out.println("Enqueueing " + 4 + " to queue ");
        mq.add(4);

        System.out.println();
        System.out.println("Peek queue: " + mq.peek());
        System.out.println("Is the queue empty? " + mq.isEmpty());
        System.out.println();

        System.out.println("Dequeue: " + mq.remove());
        System.out.println("Dequeue: " + mq.remove());
        System.out.println("Dequeue: " + mq.remove());
        System.out.println("Dequeue: " + mq.remove());
        System.out.println("Is the queue empty? " + mq.isEmpty());



    }

    public static class myQueue<T>{

        Stack<T> stackA = new Stack<>();
        Stack<T> stackB = new Stack<>();


        public void add(T val){

            if (!stackB.isEmpty()){

                while (!stackB.isEmpty()){
                    stackA.push(stackB.pop());
                }
            }

            stackA.push(val);
        }

        public T remove(){


            if (stackB.isEmpty()) {

                while (!stackA.isEmpty()) {
                    stackB.push(stackA.pop());
                }

            }

            T val = stackB.pop();
            return val;

        }

        public T peek(){

            if (stackB.isEmpty()) {
                while (!stackA.isEmpty()) {
                    stackB.push(stackA.pop());
                }
            }

            T val = stackB.peek();
            return val;


        }

        public boolean isEmpty(){
            return stackA.isEmpty() && stackB.isEmpty();
        }




    }



}