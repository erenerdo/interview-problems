import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        // Chapter 1: Arrays and Strings
        // IQ 1.3 "URLify
        /* Write a method to replace all the spaces in a string with
        '%20'. You may assume that the string has sufficient space at the end
         to hold the additional characters, and that you are given the true
         length of the string.


        */
        
        String s = "Mr John Smith    ";

        System.out.println(URLify(s));


    }

    public static String URLify(String s){


        int j = 0;
        char [] URL = new char[s.length()];

        for (int i = 0; j < s.length(); i++) {

            if (s.charAt(i) == ' ') {
                URL[j] = '%';
                URL[++j] = '2';
                URL[++j] = '0';
                j++;
            } else
                URL[j++] = s.charAt(i);

        }

        String U = new String(URL);
        return U;
    }

}