package LeetCode.Medium;


import java.util.Arrays;

/**
 * Created by Nikhil on 4/3/2017 10:45 PM.
 */
public class P260SingleNumberIII {
    public static void main(String[] args) {
        int[] a = {1, 2, 1, 3, 2, 5};   //expect 3,5 all repeat twice
        int[] b = {0, 1, 1, 2};         //expect 0,2 all repeat twice
        int[] c = {0, 0, 1, 2};         //expect 1,2 all repeat twice
        int[] d = {2, 1, 2, 3, 4, 1};         //expect 3,4 all repeat twice
        singleNumber(b);
    }

    //BUG: What if array contains 0. Then P x =0 and y =0 wont work, changed it to -1.
    private static int[] singleNumber(int[] nums) {
        java.util.Arrays.sort(nums);
        Pair pair = new Pair();
        for (int i = 0; i < nums.length; i++) {

            if (pair.x == -1 || pair.y == -1) {
                if (pair.x == -1) {
                    pair.x = nums[i];
                } else {
                    pair.y = nums[i];
                }

                if (pair.x == pair.y) {
                    pair.x = -1;
                    pair.y = -1;
                }
            } else if (pair.x == nums[i] || pair.y == nums[i]) {
                if (pair.x == nums[i]) pair.x = -1;
                else pair.y = -1;
            }
        }
        int[] result = {pair.x, pair.y};
        System.out.println(Arrays.toString(result));
        return result;
    }

    static class Pair {
        int x = -1;
        int y = -1;
    }

}

/*
Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

For example:

Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

Note:
The order of the result is not important. So in the above example, [5, 3] is also correct.
Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
Credits:
 */