import java.io.IOException;
import java.util.EmptyStackException;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        // Chapter 3
        // IQ 3.2 Stack Min

        /*

        Question:

        How would you design a stack which, in addition to push and pop, has a function min which returns the
        minimum element? Push, pop and min should all operate in O(1) time.

        Solution:

        This new stack class is going to consist of two different standard stacks, called StackVals and StackMins.

        One stack will be used to keep track of the elements add and the other will be used to keep track
        of the minium values.

        When pushing a new value onto the stack the push operation will check if this new value is less than the
        top element of StackMins (previous minimum in StackVals). If so it will push it onto StackMins as well as
        onto StackVals.

        When popping a value we will check to see if the top value of StackVals is also the top value of StacksMins.
        This would tell us that the value we are popping is the minimum of StackVals. If it is then we pop from StackVals
        and from StackMin. The old min value is now at the top of StackMins


         */


        MinStack minStack = new MinStack();

        minStack.push(5);
        System.out.println("Added " + minStack.peek() + ". Min value is " + minStack.getMin());
        minStack.push(3);
        System.out.println("Added " + minStack.peek() + ". Min value is " + minStack.getMin());
        minStack.push(4);
        System.out.println("Added " + minStack.peek() + ". Min value is " + minStack.getMin());
        minStack.push(2);
        System.out.println("Added " + minStack.peek() + ". Min value is " + minStack.getMin());
        minStack.push(6);
        System.out.println("Added " + minStack.peek() + ". Min value is " + minStack.getMin());
        minStack.push(1);
        System.out.println("Added " + minStack.peek() + ". Min value is " + minStack.getMin());

        System.out.println("Min value is " + minStack.getMin());

        System.out.println("Popped " + minStack.pop() + ". Min is " + minStack.getMin());
        System.out.println("Popped " + minStack.pop() + ". Min is " + minStack.getMin());
        System.out.println("Popped " + minStack.pop() + ". Min is " + minStack.getMin());
        System.out.println("Popped " + minStack.pop() + ". Min is " + minStack.getMin());
        System.out.println("Popped " + minStack.pop() + ". Min is " + minStack.getMin());
        System.out.println("Popped " + minStack.pop() + ". Stack is empty");




    }

    public static class MinStack{


        private Stack<Integer> stackVals = new Stack<Integer>();
        private Stack<Integer> stackMins = new Stack<Integer>();


        public int getMin(){

            if (stackMins.isEmpty())
                throw new EmptyStackException();

            return stackMins.peek();
        }

        public int pop(){

            if (stackVals.peek() == stackMins.peek()){
                stackMins.pop();
                return stackVals.pop();
            }
            else
                return stackVals.pop();

        }

        public void push(int val){

            if (stackMins.isEmpty()){
                stackMins.push(val);
                stackVals.push(val);
            }
            else {

                stackVals.push(val);

                if (val < stackMins.peek())
                    stackMins.push(val);
            }
        }

        public int peek(){
            return stackVals.peek();
        }


    }




}