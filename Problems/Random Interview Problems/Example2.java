import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException{
        // write your code here

        int [] A = {13, 27, 35, 40, 49, 55, 59};
        int [] B = {17, 35, 39, 40, 55, 58, 60};

        ArrayList<Integer> arrayList = matches(A,B);

        for (int i : arrayList){

            System.out.println(i);
        }

    }

    public static ArrayList matches (int [] A, int [] B){

        ArrayList<Integer> aL = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < A.length && j < B.length){

            if (A[i] == B[j]){
                aL.add(A[i]);
                i++;
                j++;
            }
            else if ( A[i] < B[j])
                i++;
            else
                j++;

        }

        return aL;



    }

}