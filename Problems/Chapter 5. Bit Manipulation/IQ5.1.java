import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {


    /*
    Question:   

    IQ5.1 Instertion:

        You are given two 32-bit numbers, Nand M, and two bit positions, i and
        j. Write a method to insert Minto N such that M starts at bit j and ends at bit i. You
        can assume that the bits j through i have enough space to fit all of M. That is, if
        M = 10011, you can assume that there are at least 5 bits between j and i. You would not, for
        example, have j = 3 and i = 2, because M could not fully fit between bit 3 and bit 2.

        EXAMPLE
        Input: N 10011, i = 2, j = 6
        Output: N 10001001100

    */

    int N = 1024;
    int M = 19;
    int i = 2;
    int j = 6;

        System.out.println(insertBits(M, N, i, j));

    }

    public static int insertBits(int M , int N, int i, int j){

        // Create Mask to clear bits from i to j

        int mask = -1; // 1s

        for (int k = i; k <= j; k++){
            mask = mask << 1;
        }



        for (int k = 0; k < i; k++){
            mask = mask << 1;
            mask += 1;
        }


        // Mask is made, bits from i to j cleared

        N = N & mask;


        // Move M over the correct number of bits
        for (int k = 0; k < i; k++){
            M = M << 1;
        }

        N = N | M;

        return N;


    }



}