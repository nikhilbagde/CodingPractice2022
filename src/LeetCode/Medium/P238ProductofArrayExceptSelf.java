package LeetCode.Medium;

/**
 * Created by Nikhil on 4/4/2017 1:12 AM.
 */
public class P238ProductofArrayExceptSelf {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        //For example, given [1,2,3,4], return [24,12,8,6].
        productExceptSelf(a);
    }
    //Notice we are multipying. Hence take notice of multiplying by zero.

    //Not accpeted.
    private static int[] productExceptSelf(int[] nums) {
        int product = 1;
        for (int i = 0; i < nums.length; i++) {
            product *= nums[i];
        }
        int[] result = new int[nums.length];
        if (product == 0) {
            return result;
        }
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[i] == 0 ? 1 : product / nums[i];  //BUG: solved divide by zero error.
        }
        System.out.println(java.util.Arrays.toString(result));
        return result;
    }
}
