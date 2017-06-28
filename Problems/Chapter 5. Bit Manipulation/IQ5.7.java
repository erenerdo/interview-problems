import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        // Chapter 5: Bit Manipulation
        // IQ 5.7: Pairwise Swap

        /*

        Question: Write a program to swap odd and even bits in an integer with as few instructions as
        possible (e.g., bit 13 and bit 1 are swapped, bit 2 and bit 3 are swapped, and so on).

         */

        int num = 17;

        System.out.println("num: " + num + ", binary: " + Integer.toBinaryString(num));
        System.out.println("swapped: " + pairWiseSwap(num) + ", binary: " + Integer.toBinaryString(pairWiseSwap(num)));


        

    }

    public static int pairWiseSwap(int num){

        return ( ( (num & 0xaaaaaaaa) >> 1 ) | ( (num & 0x55555555) << 1) );

    }




}