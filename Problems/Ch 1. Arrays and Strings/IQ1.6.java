import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        // Chapter 1: Arrays and Strings
        // IQ 1.6 String Compression

        /*

        Question:

        Implement a method to perform basic string compression using the counts
        of repeated characters. For example, the string aabcccccaaa would become a2b1c5a3. If the
        "compressed" string would not become smaller than the original string, your method should return
        the original string. You can assume the string has only uppercase and lowercase letters (a - z).


        Pseudocode:

        Initialize a empty string to store these updates. Have a pointer start at the beginning of the string.
        It will be used to mark a change in letters and to count the number of occurrences. Each new character and
        frequency wil be added to the new empty string until the pointer reaches the end. Then the
        new string we created will be returned.

         */

        String a = "aabcccccaaa";

        String b = "ddddcccbba";

        String c = "";

        String d = null;

        String e = "abcdefg";

        System.out.println(a + " -> " + compress(a));

        System.out.println(b + " -> " + compress(b));

        System.out.println(c + " -> " + compress(c));

        System.out.println(d + " -> " + compress(d));

        System.out.println(e + " -> " + compress(e));


    }

    public static String compress(String s){

        if (s == null)
            return "";

        // Edge Cases
        //if (s.length() == 0)
            //return s;

        int ptr = 0;

        String compressed = "";

        while (ptr < s.length()){

            // Initialize c to letter
            char c = s.charAt(ptr);

            // Initialize counter
            int count = 0;

            // Add new character to compressed string
            compressed += s.substring(ptr, ptr+1);

            while (c == s.charAt(ptr)){
                count++;
                ptr++;

                if (ptr >= s.length())
                    break;
            }

            // Add count to compressed string
            compressed += Integer.toString(count);

            if (compressed.length() > s.length())
                return s;

        } // end main while

        return compressed;

    }

}