import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        // Chapter 1: Arrays and Strings
        // IQ 1.2 ; "Check Permutation"
        // Given two strings, write a method to decide if one is a permuation of the other


        String a = "Bat";
        String b = "Tab";

        String c = "Pizza";
        String d = "Pie";

        System.out.println("(" + a + ", " + b +  ") -> " + isPerm(a,b));

        System.out.println("(" + c + ", " + d + ") -> " + isPerm(c,d));


    }


    public static boolean isPerm(String a, String b){

        if( a.length() != b.length())
            return false;

        // Array to store ASCII values
        int [] freq = new int[128];

        for (char c : a.toCharArray()){
            freq[(int) Character.toLowerCase(c)]++;
        }

        for (char c : b.toCharArray()){

            freq[(int) Character.toLowerCase(c)]--;

            if ( freq[(int) Character.toLowerCase(c)] < 0)
                return false;
        }

        return true;
    }

}