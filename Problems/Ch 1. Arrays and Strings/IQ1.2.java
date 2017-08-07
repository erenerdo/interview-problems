import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        // Chapter 1: Arrays and Strings
        // IQ 1.2 ; "Check Permutation"
        // Given two strings, write a method to decide if one is a permuation of the other


        String a = "Bat";
        String b = "Tab";

        String c = "Pizza";
        String d = "azipz";

        String e = null;
        String f = "apple";

        String g = "banana";
        String h = "apple";


        System.out.println("(" + a + ", " + b +  ") -> " + isPerm(a,b));

        System.out.println("(" + c + ", " + d + ") -> " + isPerm(d,c));

        System.out.println("(" + e + ", " + f +  ") -> " + isPerm(e,f));

        System.out.println("(" + g + ", " + h + ") -> " + isPerm(g,h));


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

    // Other way to do it with a hash table
    public static boolean isPerm2(String a, String b) {

        // Cant have null values passed in
        if(a == null || b == null)
            return false;

        // Must be of same length to be a permutation
        if(a.length() != b.length())
            return false;


        HashMap<Character, Integer> hashMap = new HashMap<>();

        // Add increment all the values from string a
        for (char c : a.toCharArray()){
            c = Character.toLowerCase(c);

            if (hashMap.containsKey(c)) {
                hashMap.put(c, hashMap.get(c) + 1);
            }
            else{
                hashMap.put(c, 1);
            }

        }


        // Decrement all values from string b
        for (char c : b.toCharArray()){

            c = Character.toLowerCase(c);
            // Check if value has been seen before, if not then return false if so then decrement
            if (hashMap.containsKey(c) && hashMap.get(c) > 0){
                hashMap.put(c, hashMap.get(c)-1);
            }
            else{
                return false;
            }
        }

        return true;

    }

}