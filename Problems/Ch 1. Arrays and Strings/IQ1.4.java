import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        // Chapter 1: Arrays and Strings
        // IQ 1.4 "Palindrome Permutation"
        /*

        Given a string, write a function to check if it is a permutation of a palindrome.
        A palindrome is a word or phrase that is the same forwards and backwords.
        A permutation is a rearrangement of letters

        */


        String a = "Tact coa"; // True
        String b = "Pizza"; // False
        String c = "Race Car"; // True

        System.out.println(a + " -> " + isPalin(a));
        System.out.println(b + " -> " + isPalin(b));
        System.out.println(c + " -> " + isPalin(c));

    }

    public static boolean isPalin(String s){

        int [] ch = new int[128];

        for (char c : s.toCharArray())
            ch[ (int) Character.toLowerCase(c)]++;

        // Ignore spaces
        ch[32] = 0;

        int count = 0;

        for (int i : ch)
            if (i % 2 == 1)
                count++;

        return count < 2;
    }
}