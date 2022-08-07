package LeetCode.Easy;

/**
 * Created by Nikhil on 4/9/2017 9:11 PM.
 */
public class P283MoveZeroes {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        int[] nums1 = {1, 0, 1};
        int[] nums2 = {1, 0};
        int[] nums3 = {4, 2, 4, 0, 0, 3, 0, 5, 1, 0};
        moveZeroes(nums3);
    }

    private static void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int insertPos = 0;
        for (int num : nums) {
            if (num != 0) nums[insertPos++] = num;
        }

        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
        System.out.println(java.util.Arrays.toString(nums));
    }

}
