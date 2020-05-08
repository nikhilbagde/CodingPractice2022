package LeetCode.Tags.P1_Arrays;


/**
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49
 */
public class LC_11_ContainerWithMostWater {
    public static void main(String[] args) {

        int[] input = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        int start = 0, end = input.length - 1, maxArea = Integer.MIN_VALUE;

        while (start < end) {
            maxArea = Math.max(maxArea, Math.min(input[start], input[end]) * (end - start));
            if (input[start] < input[end]) {
                start++;
            } else {
                end--;
            }
        }
        System.out.println(maxArea);
    }
}
