import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

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