package LeetCode.Easy;

/**
 * Created by Nikhil on 4/9/2017 11:59 PM.
 */
public class P167TwoSumIIInputarrayissorted {
    public static void main(String[] args) {
        int[] a = {2, 7, 11, 15};
        int target = 9, target1 = 18;
        int[] result = twoSum(a, target);
        System.out.println(java.util.Arrays.toString(result));
    }

    private static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int i = 0, j = numbers.length - 1;

        while (i < j) {
            if (numbers[i] + numbers[j] > target) j--;
            else if (numbers[i] + numbers[j] < target) i++;
            else {
                result[0] = i + 1;
                result[1] = j + 1;
                return result;
            }
        }
        return result;
    }
}
