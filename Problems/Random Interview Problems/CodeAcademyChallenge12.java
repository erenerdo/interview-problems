/*
Name: Eren Erdogan
Email: ererdogan20@gmail.com
GitHub: github.com/erenerdo
*/


import java.util.ArrayList;
import java.util.HashMap;


public class Main {

    public static void main(String[] args) {

        /*
        CodeAcademy Code Challenge #12: July 5, 2017

        You've spent decades setting high scores on Donkey Kong but now, a challenger approaches.
        Write a function, scoreSettler, that will definitively show who is the King of Kong.
        scoreSettler will take a list of unsorted scores plus the highest possible score and return a sorted list of
        all of the scores, in descending order from high score to low score.


        Function Name: scoreSettler
        Input: list of integers representing scores and a single integer for the highest possible score
        Output: A sorted list of integers in descending order
        Example: scoreSettler([ 1, 2, 3, 999999], 1000000) => [999999, 3, 2, 1]
        In your submission, please use as a test of your function the maximum value of 1218000,
        with a list of scores [874300, 879200, 1172100, 1141800, 933900, 1177200, 1190200, 1110100, 1158400, 985600, 1047200, 1049100, 1138600, 1170500, 1064500, 1190000, 1050200, 1090400, 1062800, 1061700, 1218000, 1068000, 1127700, 1144800, 1195100]

        Solution:


        PseudoCode:

        1. put all values in a HashMap, key: number, value: frequency. If number already in HashMap increase frequency

        2. Iterate from the max value (the highest score possible) through the lowest value which we will keep track of;

        3. Add value to ArrayList keeping sure to track the there could be multiple occurrences of the
        same score

        4. Make an array from the arrayList. Used arrayList initially since it is dynamic and easier to implement
        but could also be done with a single array and then just return that

        Note: This algorithm technically is O(N) time and space complexity. However there are cases where
        a sorting algorithm like quicksort would be faster. For example if the scores are really spread out like
        1, 2, 3, Integer.MAX_VALUE then this algorithm would still technically be O(N) but much slower than a quicksort
        like algorithm. Also note it is not necessary to keep track of the min value in the array but it will increase the
        efficiency of the algorithm

         */


        int [] array = {874300, 879200, 1172100, 1141800, 933900, 1177200,
                        1190200, 1110100, 1158400, 985600, 1047200, 1049100,
                        1138600, 1170500, 1064500, 1190000, 1050200, 1090400,
                        1062800, 1061700, 1218000, 1068000, 1127700, 1144800, 1195100};

        int maxValue = 1218000;




        array = scoreSettler(array, maxValue);

        System.out.println("Sorted Scores in Descending Order:");

        for (int i : array){
            System.out.println(i);
        }
    }

    public static int [] scoreSettler(int [] array, int maxValue){

        // Step 1:
        HashMap<Integer, Integer> hMap = new HashMap<>();

        int minValue = Integer.MAX_VALUE;

        for (int i: array){

            // Get min value which will be used later in this method
            if (i < minValue)
                minValue = i;


            // If it is already in the hash map
            if(hMap.containsKey(i)){
                // Increment the value for the corresponding key
                hMap.put(i, hMap.get(i)+ 1);
            }else{
                // It is not in the hashmap
                hMap.put(i, 1);
            }
        }

        ArrayList<Integer> arrayList = new ArrayList<>();

        // Step 2:
        for (int i = maxValue; i >= minValue; i--){

            // Step 3
            if (hMap.containsKey(i)){
                for (int j = 0; j < hMap.get(i); j++){
                    arrayList.add(i);
                }
            }

        }

        // Step 4:

        int[] sortedArray = new int [array.length];

        for (int i = 0; i < arrayList.size(); i++){
            sortedArray[i] = arrayList.get(i);
        }

        return sortedArray;

    }



}



