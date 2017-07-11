import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        /*
        Question:   Binary to String: Given a real number between 0 and 1 (e.g., 0.72) that is passed in as a double, print
                    the binary representation. If the number cannot be represented accurately in binary with at most 32
                    characters, print "ERROR:'

        */

        double dec = 0.78;

        // 0.11000111101011100001

        System.out.println(dec + " in binary is " + decimalToBinary(dec));
    }

    public static String decimalToBinary(double dec){

        if(dec > 1 || dec < 0)
            return "Error, out of bounds";

        String binary = "";

        while (binary.length() <= 32){

            dec *= 2.0;

            if (dec == 1.0){
                binary = binary + "1";
                return "." + binary;
            }
            else if( dec > 1.0){
                binary = binary + "1";
                dec -= 1;
            }
            else{
                binary = binary + "0";
            }

        }

        return "." + binary;

    }



}