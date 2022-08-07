package LeetCode.Easy;

/**
 * Created by Nikhil on 3/31/2017 12:05 AM.
 */
public class P485MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] a = {1, 1, 0, 1, 1, 1};
        System.out.println(findMaxConsecutiveOnes(a));
    }
    //Pattern: Something continuous | to find slices | Grouping.

    private static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 1) {
                count++;                            //Something to count
            } else if (nums[i] == 0) {
                count = 0;
                max = Math.max(count, max);
            }
        }
        //since for last 3 111 case.
        max = Math.max(max, count);
        return max;
    }
}
