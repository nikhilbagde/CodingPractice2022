package LeetCode.Medium;

/**
 * Created by Nikhil on 4/4/2017 10:03 PM.
 */
public class P477TotalHammingDistance {
    public static void main(String[] args) {
        int[] a = {4, 14, 2};
        System.out.println(totalHammingDistance(a));
    }

    private static int totalHammingDistance(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int temp = nums[i] ^ nums[j];
                while (temp > 0) {
                    if ((temp & 1) == 1)
                        result++;
                    temp = temp >> 1;
                }
            }
        }
        return result;
    }
}
