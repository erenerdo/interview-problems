import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        /*

        IQ 16.17: Contiguous Sequence

        Quest: You are given an array of integerst5

        */


        int [] array = {2, -8, 3, -2, 4, -10};

        System.out.println(contiguousSum(array));
    }

    public static int contiguousSum(int [] array){
        int ptr = 0;

        int currentMax = Integer.MIN_VALUE;
        int globalMax = Integer.MIN_VALUE;

        for (int i : array){

            if (i > currentMax && currentMax < 0)
                currentMax = i;
            else {
                currentMax = i + currentMax;
            }

            if(currentMax > globalMax)
                globalMax = currentMax;
        }

        return globalMax;
    }


}