import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        // Chapter 5: Bit Manipulation
        // IQ 5.6: Conversion

        /*

        Question: Write a function to determine the number of bits you would
        need to flip to convert integer A to integer B.

        Example:

            input: 29 (11101), 15 (01111)

            output: 2

        Solution:


         */

        int A = 9;
        int B = 15;

        System.out.println("A: " + A + ", " + Integer.toBinaryString(A));
        System.out.println("B: " + B + ", " + Integer.toBinaryString(B));

        System.out.println("Number of bits we'd need to flip to convert A to B is " + conversion(A, B));
    }


    public static int conversion(int A, int B){

        int count = 0;
        int C = A ^ B; // A XOR B to get differences

        for (int i = 0 ; i < 32; i++){

            // Will run 32 times since integers are 32-bits

            if ( (C & 1) == 1){

                // A bit difference occurred
                count++;

                // Right shift bits in C
                C = C >> 1;
            }
            else {
                // Bits are the same

                // Just right shift bits in C
                C = C >> 1;
            }
        }

        return count;
    }



}