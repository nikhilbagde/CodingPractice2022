package LeetCode.Patterns.SlidingWindow;

/**
 * @author Nikhil Bagde
 * @date 5/7/2021- 9:41 PM
 **/
public class P_209_Minimum_Size_Subarray_Sum {
    public static void main(String[] args) {
        /* Input: target = 7, nums = [2,3,1,2,4,3]
       Output: 2
       Explanation: The subarray [4,3] has the minimal length under the problem constraint.

       Example 2:
       Input: target = 4, nums = [1,4,4]
       Output: 1

       Example 3:
       Input: target = 11, nums = [1,1,1,1,1,1,1,1]
       Output: 0
       */
        int minLenght = minSubArrayLen(7, new int[] {2,3,1,2,4,3});
        System.out.println("minLenght = " + minLenght);
    }

    /**
     * Given an array of positive integers nums and a positive integer target,
     * return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr]
     * of which the sum is greater than or equal to target.
     * If there is no such subarray, return 0 instead.
     * @param target
     * @param nums
     * @return
     */
    public static int minSubArrayLen(int target, int[] nums) {
        int sum = 0, start = 0, minLength = Integer.MAX_VALUE;
        for (int end = 0; end < nums.length; end++) {
            sum += nums[end];
            while (sum >= target) {
                minLength = Math.min(minLength, end - start + 1);
                sum -= nums[start++];
            }
        }
        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }
}
