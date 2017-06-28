import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws IOException {
        // Chapter 2
        // IQ 2.1 Remove Dups

        /*
            Input
            ------
            array 1 = [4, 5, 0, 2]

            array 2 = [5, 2, -1, -2]

            Output
            ------
            [5, 2] or [2, 5]
        */

        int [] array1 = {4, 5, 0, 2};

        int [] array2 = {5, 2, -1, -2};

        ArrayList<Integer>  al = commonElements(array1, array2);

        for (int i : al){

            System.out.print(i + " ");
        }


    }

    public static ArrayList<Integer> commonElements(int [] array1, int [] array2){

        HashSet<Integer> h = new HashSet<>();

        ArrayList<Integer> al = new ArrayList<>();

        for (int i : array1){
            h.add(i);
        }

        for (int i: array2){
            if (h.contains(i))
                al.add(i);
        }

        return al;


    }

}