import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        // Zero Swap Question

        /*

        Question:


        Given an array nums, write a function to move all 0's to the end of it
        while maintaining the relative order of the non-zero elements.

        For example, given nums = [0, 10, 0, -1, 120], after calling your function,
        nums should be [10, -1, 120, 0, 0].

        Note:
        You must do this in-place without making a copy of the array.
        Minimize the total number of operations.


        Solution:

        Steps:

        Example 1:

        [0, 10, 0, -1, 120]

        [10, 0, 0, -1, 120]

        [10, -1, 0, 0, 120]

        [10, -1, 120, 0, 0]


        Example 2:

        [1, 4, 0, 6, 0, 7]

        [1, 4, 6, 0, 0, 7]

        [1, 4, 6, 7, 0, 0]


        int [] nums = {1, 2, 0, 4, 3, 0, 5, 0};

        */

        int [] nums = {1, 2, 0, 4, 3, 0, 5, 0};

        zeroSwap(nums);

        for (int i : nums)
            System.out.print(i + " ");



    }

    public static void zeroSwap(int [] nums){

        if (nums.length < 2)
            return;

        // Find first zero
        int zeroIndex = -1;

        for (int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                zeroIndex = i;
                break;
            }
        }

        if (zeroIndex == -1)
            return;

        for (int i = zeroIndex + 1; i < nums.length; i++){

            if (nums[i] != 0){
                swap(nums,i, zeroIndex);
                zeroIndex++;
            }
        }

    }

    // Helper function called swap

    public static void swap(int [] nums, int i, int j){

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

    }






}