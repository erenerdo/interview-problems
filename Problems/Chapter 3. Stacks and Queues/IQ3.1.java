import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        // Chapter 3
        // IQ 3.1 Three In One

        /*

        Question: 

        Describe how you could use a single array to implement three stacks

        Solution:

        An array can be implemented like a fixed size stack with only minor modifications

        Each stack would be size array.length/3, for this explanation lets assume array.length = 30.

        There would be three pointers that would be used to
        to keep track of each stack. One pointer starts as array[0], the other starts at array[9], and the
        last one starts at array[19]. Based off what stack you want to add to you have to call a specific
        pointer. As elements are added to the stack the pointer modifies the current element and then
        moves up + 1 to the next index. When a stack is full it'll have a pointer at a multiple of 10.

        To create more space we could just double the array then reassign the values in the new sized array
        again with array.length/3 and fill in each stack with the pointers.


         */





    }




}