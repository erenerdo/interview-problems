import java.io.IOException;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException{
        // Chapter 1: Arrays and Strings
        // IQ 1.1 ; "Is Unique"
        // Implement an algorithm to determine if a string has all unique characters.

        String a = "apple";

        String b = "peach";

        System.out.println("Check if " + a + " has all unique characters is " + isUnique(a));

        System.out.println("Check if " + b + " has all unique characters is " + isUnique(b));

    }


    public static boolean isUnique(String s){

        HashSet<Character> hashSet = new HashSet<>();

        for (char c : s.toCharArray()){

            if(hashSet.contains(c)){
                return false;
            }
            hashSet.add(c);
        }

        return true;

    }

}
