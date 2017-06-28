import java.io.IOException;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException{
        // Given an array of distinct integer values, 
        // count the number of pairs of integers that have difference k. 
        // Example : [1, 7, 5, 9, 2, 12, 3], k = 2
        // Pairs: (1,3), (3,5), (5,7), (7,9)

        int [] a = {1, 7, 5, 9, 2, 12, 3};

        int k = 2;

        HashMap<Integer,Integer> h = new HashMap<>();

        for (int i : a){
            h.put(i,i);
        }

        for (int i : a){

            if(h.get(i+k) != null) // (i, i+k) is pair
                System.out.println("(" + i + ", " + (i+k) + ")");

        }


    }


}