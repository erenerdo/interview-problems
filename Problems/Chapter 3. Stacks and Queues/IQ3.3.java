import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        // Chapter 3
        // IQ 3.3 Stack of Plates

        /*

        Question:

        Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
        Therefore, in real life, we would likely start a new stack when the previous stack exceeds some
        threshold. Implement a data structure SetOfStacks that mimics this. SetOfStacks should be
        composed of several stacks and should create a new stack once the previous one exceeds capacity.
        SetOfStacks. push () and SetOfStacks. pop () should behave identically to a single stack
                (that is, pop ( ) should return the same values as it would if there were just a single stack).

        FOLLOW UP
        Implement a function popAt (int index) which performs a pop operation on a specific sub-stack.


        Solution:



         */

        StackOfPlates sp = new StackOfPlates(5);

        sp.push(1);
        sp.push(2);
        sp.push(3);
        sp.push(4);
        sp.push(5);
        sp.push(6);
        sp.push(7);
        sp.push(8);
        sp.push(9);
        sp.push(10);
        sp.push(11);
        sp.push(12);
        sp.push(13);
        sp.push(14);
        sp.push(15);
        sp.push(16);

        System.out.println("The top of our " + (sp.currentIndex + 1) + " plates are: ");
        System.out.println(sp.SOP.get(0).peek());
        System.out.println(sp.SOP.get(1).peek());
        System.out.println(sp.SOP.get(2).peek());
        System.out.println(sp.SOP.get(3).peek());

        System.out.println();

        sp.pop(); // 16 popped
        System.out.println(sp.SOP.get(2).peek());
        sp.pop(); // 15 popped
        sp.pop(); // 14 popped
        sp.pop(); // 13 popped
        sp.pop(); // 12 popped
        System.out.println(sp.SOP.get(2).peek());
        sp.pop(); // 11 popped
        sp.pop(); // 10 popped
        sp.pop(); // 9 popped
        sp.pop(); // 8 popped
        System.out.println(sp.SOP.get(1).peek());
        sp.pop(); // 7 popped
        sp.pop(); // 6 popped
        sp.pop(); // 5 popped
        sp.pop(); // 4 popped
        System.out.println(sp.SOP.get(0).peek());







    }

    public static class StackOfPlates{

        ArrayList< Stack<Integer> > SOP = new ArrayList<>();

        int count; // Number of plates
        int currentIndex; // Number of stacks

        final int threshold; // Number of plates where we start a new stack


        // Constructor
        public StackOfPlates(int val) {

            Stack<Integer> s = new Stack<>();
            SOP.add(s);
            currentIndex = 0;
            count = 0;
            this.threshold = val;
        }


        public void push (int val){

            // Need to create a new stack of platers
            if (count % threshold == 0 && count != 0){

                Stack<Integer> s = new Stack<>();
                SOP.add(s);
                currentIndex++;

            }
            SOP.get(currentIndex).push(val);
            count++;
        }

        public int pop (){

            count--;
            if (count % threshold == 0){

                // get the value to pop
                int ele = SOP.get(currentIndex).pop();

                // Delete that stack
                SOP.remove(currentIndex);

                // Remove stack from count
                currentIndex--;

                return ele;
            } else {

                int ele = SOP.get(currentIndex).pop();
                return ele;


            }

        }

        public int getStacks (){
            return currentIndex;
        }

        public void popAt(int index){

            SOP.get(index).pop();
        }



    }




}