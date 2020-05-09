package LeetCode.Tags.P1_Arrays;

/**
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * Example 1:
 * <p>
 * Given nums = [1,1,2],
 * <p>
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 * <p>
 * It doesn't matter what you leave beyond the returned length.
 * Example 2:
 * <p>
 * Given nums = [0,0,1,1,1,2,2,3,3,4],
 * <p>
 * Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.
 * <p>
 * It doesn't matter what values are set beyond the returned length.
 */
public class LC_26_RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        //int [] nums = {0,0,1,1,1,2,2,3,3,4};
        //int [] nums = {1,2};
        //int [] nums = {1};
        //int [] nums = {};
        int[] nums = {1, 1, 1};


        removeDuplicated_1(nums);
        removeDuplicated_2(nums);
    }

    private static void removeDuplicated_1(int[] nums) {
        if (nums.length == 0) {
            System.out.println(0);
        } else {
            int length = 1;
            for (int i = 0, j = i + 1; i < nums.length - 1 && j < nums.length - 1; ) {

                while (nums[i] == nums[j]) {
                    j++;
                }
                if (nums[i] != nums[j]) {
                    length++;
                    nums[++i] = nums[j];
                }
            }
            System.out.println(length);
        }
    }

    private static void removeDuplicated_2(int[] nums) {
        if (nums.length == 0) {
            System.out.println(0);
        } else {
            int length = 0;
            for (int i = 0, j = i + 1; j < nums.length; j++) {

                if (nums[i] != nums[j]) {
                    length++;
                    nums[++i] = nums[j];
                }
            }
            System.out.println(length + 1);
        }
    }

}
