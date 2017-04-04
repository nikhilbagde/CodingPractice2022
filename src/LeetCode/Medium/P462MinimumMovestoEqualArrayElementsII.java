package LeetCode.Medium;

/**
 * Created by Nikhil on 4/3/2017 8:40 PM.
 */
public class P462MinimumMovestoEqualArrayElementsII {
    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int[] b = {12, 11, 10, 9, 8, 7, 0};
        System.out.println(minMoves2(b));
    }

    private static int minMoves2(int[] nums) {

        //Step1: Sort : using sorting middle element would be actual mid of max and min somewhere near.
        java.util.Arrays.sort(nums);
        System.out.println(java.util.Arrays.toString(nums));

        //Step2: Meeting point while(i<j) and i++ and j--
        int i = 0;
        int j = nums.length - 1;
        int count = 0;

        while (i < j) {
            System.out.println(nums[j] - nums[i]);
            count = count + (nums[j] - nums[i]);          // nums[j]-nums[i] this much we need for balancing add to min and substract from max.
            i++;
            j--;
        }
        return count;
    }
}
/*
Input:
[1,2,3]

Output:
2

Explanation:
Only two moves are needed (remember each move increments or decrements one element):

[1,2,3]  =>  [2,2,3]  =>  [2,2,2]
 */
