import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
    
        // Chapter 16: Moderate
        // IQ 16.6 Smallest Difference
        /*

        Question:

        Given two arrays of integers, compute the pair of values (one value in each
        array) with the smallest (non-negative) difference. Return the difference.


        EXAMPLE
        Input: {1, 3, 15, 11, 2}, {23, 127, 235, 19, 8}
        Output: 3. That is, the pair (11 , 8).


        Solution:



         */

        int [] A = {1, 3, 5, 11, 2};
        int [] B = {23, 127, 235, 19, 8};


        System.out.println("Minimum difference of arrays A and B is " + minDifference(A, B) );

        //minDifference(A, B);


    }

    public static int minDifference(int [] A, int [] B){

        // Make a copy of array A and B so that sorting doesnt change those arrays
        int [] C = new int [A.length];


        for (int i = 0; i < A.length; i++){
            C[i] = A[i];
        }

        int [] D = new int [B.length];

        for (int i = 0; i < B.length; i++){
            D[i] = B[i];
        }

        Arrays.sort(C);
        Arrays.sort(D);


        // Used to keep track of the minimum difference
        int minD = Integer.MAX_VALUE;

        // Index for array C
        int iC = 0;

        // Index for array D
        int iD = 0;

        while (iC < C.length && iD < D.length){

            if( Math.abs(C[iC] - D[iD]) < minD) {
                minD = Math.abs(C[iC] - D[iD]);
            }
            if (C[iC] <= D[iD])
                iC++;
            else
                iD++;
        }

        return minD;

    }

    public static void printArray(int [] A){

        for (int i : A){
            System.out.print(i + " ");
        }
        System.out.println();
    }







}