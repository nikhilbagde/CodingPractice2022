package LeetCode.Tags.P1_Arrays;

import java.util.Arrays;

/**
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 * <p>
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class LC_16_3SumClosest {
    public static void main(String[] args) {

        //test case 1
        //int[] nums = {-1, 2, 1, -4};
        //int target = 1;

        //test case 2
        //int[] nums = {-1,2,1,-4};
        //int target = 1;
        //expected = 2

        //test case 3
        int[] nums = {0, 1, 2};
        int target = 3;
        //expected = 3

        closestSum3(nums, target);
        closestSum3_1(nums, target);

    }

    private static void closestSum3(int[] nums, int target) {
        Arrays.sort(nums);

        int minDiff = Integer.MAX_VALUE;
        int closestSum = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                int diff = Math.abs(target - sum);

                if (diff == 0) {
                    System.out.println(diff);
                    break;
                }

                if (diff < minDiff) {
                    minDiff = diff;
                    closestSum = diff;
                }

                if (sum < target) {
                    int leftValue = nums[left];
                    while (left < right && leftValue == nums[left])
                        left++;
                } else {
                    int rightValue = nums[right];
                    while (left < right && rightValue == nums[right])
                        right--;
                }

            }

        }
        System.out.println(closestSum);
    }

    /**
     * Accepted Solution : Nikhil Bagde
     *
     * @param nums
     * @param target
     */
    private static void closestSum3_1(int[] nums, int target) {
        Arrays.sort(nums);

        int minDiff = Integer.MAX_VALUE;
        int resultSum = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            //if(i>0&& nums[i]== nums[i-1]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                int diff = Math.abs(target - sum);

                if (diff == 0) {
                    System.out.println(sum);        //bug print sum and not diff. We need closes number. Not by how much closes.
                    break;
                }

                if (diff < minDiff) {
                    minDiff = diff;
                    resultSum = sum;
                }

                if (sum < target) {
                    left++;
                } else {
                    right--;
                }

            }
        }
        //System.out.println(minDiff);
        System.out.println(resultSum);
    }
}
