import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        // Chapter 1: Arrays and Strings
        // IQ 1.7 Rotate Matrix

        /*

        Question: Given an image represented by an NxN matrix, where each pixel in the image is 4
        bytes, write a method to rotate the image by 90 degrees. (an you do this in place?
        Hints: #51, #100

        Hint 51: Try thinking about it layer by layer. Can you rotate a specific layer?

        Hint 100: Rotating a specific layer would just mean swapping the values in four arrays. If you were
        asked to swap the values in two arrays, could you do this? Can you then extend it to four
        arrays?

        Example:

                1   2  3  4             13   9  5  1
                5   6  7  8    --->     14  10  6  2
                9  10 11 12             15  11  7  3
               13  14 15 16             16  12  8  4


               0,0  0,1  0,2  0,3           3,0  2,0  1,0  0,0
               1,0  1,1  1,2  1,3   --->    3,1  2,1  1,1  0,1
               2,0  2,1  2,2  2,3           3,2  2,2  1,2  0,2
               3,0  3,1  3,2  3,3           3,3  2,3  1,3  0,3


               1  2             3  1
               3  4     --->    4  2

               0,0  0,1   --->   1,0  0,0
               1,0  1,1          1,1  0,1

        Pseudocode:

        A better way to do this is to implement the swap index by index. In this case, we do the following:
        for i = 0 to n
        temp = top[i]j
        top[i] = left[i]
        left[i] = bottom[i]
        bottom[i] = right[i]
        right[i] = temp

         */


    }


}