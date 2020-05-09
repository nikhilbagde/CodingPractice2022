package LeetCode.Tags.P1_Arrays;

import java.util.Arrays;

/**
 * Given nums = [3,2,2,3], val = 3,
 * <p>
 * Your function should return length = 2,
 * with the first two elements of nums being 2.
 * <p>
 * It doesn't matter what you leave beyond the returned length.
 */
public class LC_27_RemoveElement {
    public static void main(String[] args) {
        //Given
        /*int [] nums = {3,2,2,3};
        int val = 3;*/

        //case 1:
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;

        //case 2:
        /*
        int[] nums = {1};
        int val = 1;
        //expected = 0
        */

        //case 3:
        //int[] nums = {3,3};
        //int val = 3;
        //expected = 0


        //removeElement_1(nums, val);
        //int result = removeElement_2(nums, val);
        //int result = removeElement_3(nums, val);
        int result = removeElement_4(nums, val);
        System.out.println("result = " + result);


    }

    private static int removeElement_4(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    private static int removeElement_3(int[] nums, int val) {
        if (nums.length == 1 && nums[0] == val) {
            return 0;
        } else if (nums.length == 1) {
            return 1;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            if (nums[left] == val && left < right)
                left++;

            if (nums[right] == val && left < right)
                right--;

            int value = nums[left];
            nums[left] = nums[right];
            nums[right] = value;

        }
        return (right - left) + 1;
    }

    private static int removeElement_2(int[] nums, int val) {
        if (nums.length == 1 && nums[0] == val) {
            return 0;
        } else if (nums.length == 1) {
            return 1;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            while (left < right && nums[right] == val) {
                right--;
            }
            if (nums[left] == val) {
                //if(left<right){
                int value = nums[left];
                nums[left] = nums[right];
                nums[right] = value;
                //}
                left++;
                right--;
            } else {
                left++;
            }
        }
        return left + 1;
    }

    private static void removeElement_1(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            if (nums[left] == val) {
                if (nums[left] != nums[right]) {
                    int value = nums[left];
                    nums[left] = nums[right];
                    nums[right] = value;
                    left++;
                    right--;

                } else {
                    right--;

                }
            } else {
                left++;
            }
            System.out.println(Arrays.toString(nums));
        }
    }
}
