import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        // Chapter 1: Arrays and Strings
        // IQ 1.5 "Palindrome Permutation"
        /*

        There are three types of edits that can be performed on strings: insert a character,
        remove a character, or replace a character. Given two strings, write a function to check if they are
        one edit (or zero edits) away.

        EXAMPLE
        pale, pIe -> true
        pales. pale -> true
        pale. bale -> true
        pale. bake -> false

         */


        String a = "pale";
        String b = "ple";
        String c = "pales";


        String e = "bale";
        String f = "bake";
        String h = "bakl";

        System.out.println(a + ", " + b + " -> " + oneAway(a,b));
        System.out.println(c + ", " + a + " -> " + oneAway(c,a));
        System.out.println(a + ", " + e + " -> " + oneAway(a,e));
        System.out.println(a + ", " + f + " -> " + oneAway(a,f));
        System.out.println(h + ", " + a + " -> " + oneAway(h,a));



    }

    public static boolean oneAway(String A, String B) {

        // Edge Case
        if (A.equals(null) || B.equals(null))
            return false;

        // A and B not 1 length apart
        else if (Math.abs(A.length()-B.length()) > 1)
            return false;

        if (A.length() == B.length())
            return equalLength(A, B);

        else if (A.length() > B.length())
            return oneApart(A,B);

        else
            return oneApart(B,A);



    }

    public static boolean equalLength(String A, String B){

        int count = 0;

        for (int i = 0; i < A.length(); i++){

            if (A.charAt(i) != B.charAt(i))
                count++;

            if (count > 1)
                return false;
        }

        return true;

    }

    public static boolean oneApart(String A, String B){

        // Note, A will be the word with the longer length.

        // Used to iterate A
        int i = 0;

        // Used to iterate B
        int j = 0;

        int count = 0;


        while (i < A.length() && j < B.length() ){

            if (A.charAt(i) != B.charAt(j)){
                i++;
                count++;
            }
            else{
                i++;
                j++;
            }
            if (count > 1)
                return false;

        }

        // While loop finished scanning, success
        return true;

    }


}