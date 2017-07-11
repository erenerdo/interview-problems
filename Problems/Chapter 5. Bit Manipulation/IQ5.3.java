public class Main {

    public static void main(String[] args) {
        // write your code here\
        /*

        Question: 

        Flip Bit to Win: You have an integer and you can flip exactly one bit from a 0 to a 1. Write code to
        find the length of the longest sequence of 1s you could create.

        EXAMPLE
        Input: 1775 (or: 11011101111)
        Output: 8

        */

        System.out.println(flipBit("11111011111"));


    }


    public static int flipBit (String binary){

        int zeroCount = 0;
        int zeroIndex = 0;
        int currentCount = 0;
        int maxCount = 0;

        for (int i = 0; i < binary.length(); i++){

            if (binary.charAt(i) == '1'){
                currentCount++;
            }
            else{
                zeroCount++;

                if (zeroCount > 1){
                    i = zeroIndex;
                    zeroCount = 0;
                    currentCount = 0;
                    continue;
                }
                zeroIndex = i;
                currentCount++;
            }

            if(currentCount > maxCount)
                maxCount = currentCount;
        }

        return maxCount;
    }

}



