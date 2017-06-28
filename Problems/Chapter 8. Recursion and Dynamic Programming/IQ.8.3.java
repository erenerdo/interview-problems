import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        /*

        [ 0,  1,  2, 3, 4, 5, 6]


        [-3, -2, -1, 2, 3, 5, 7]

        */


        int [] array = {-3, -2, -1, 2, 4, 5, 7};

        System.out.println("Magic Index: " + magicIndex(array));

    }

    public static int magicIndex(int [] array){

        int value = magicIndex(array, 0, array.length-1);

        return value;
    }

    public static int magicIndex(int [] array, int lo, int hi){

        // Failure Case
        if (lo > hi)
            return -1;

        int mid = lo + (hi-lo)/2;

        if (array[mid] == mid){
            return mid;
        }
        else if(array[mid] < mid){
            return magicIndex(array, mid + 1, hi);
        }
        else{
            return magicIndex(array, lo, mid - 1);
        }


    }

}