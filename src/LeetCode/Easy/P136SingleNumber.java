package LeetCode.Easy;

/**
 * Created by Nikhil on 3/31/2017 12:10 AM.
 */
public class P136SingleNumber {
    public static void main(String[] args) {
        int[] a = {1, 1, 2, 2, 3, 3, 7, 4, 4, 5, 5, 6, 7, 0, 0};
        System.out.println(singleNumber(a));
    }

    private static int singleNumber(int[] nums) {
        for (int i = 1; i < nums.length; ++i) {
            /*System.out.println(Integer.toBinaryString(nums[i-1]));
            System.out.println(Integer.toBinaryString(nums[i]));
            System.out.println(Integer.toBinaryString(nums[i] ^ nums[i-1]));*/
            nums[i] = nums[i] ^ nums[i - 1];
        }
        return nums[nums.length - 1];
    }
}
