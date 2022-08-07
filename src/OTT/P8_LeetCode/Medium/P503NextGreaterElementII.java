package LeetCode.Medium;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by Nikhil on 4/4/2017 2:52 PM.
 */
public class P503NextGreaterElementII {
    public static void main(String[] args) {
        int[] a = {1, 2, 1};
        nextGreaterElements(a);
    }
    //array is circular.

    //didn't solve : I AM SUPER LAZY
    private static int[] nextGreaterElements(int[] nums) {
        java.util.Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new LinkedHashMap<>();
        stack.push(nums[0]);
        for (int i = 1; i < nums.length; i++) {      //for every element
            for (int j = 0; j < nums.length - 1; j++) {   //repeat (length of array-1)times.
                while (!stack.isEmpty() && stack.peek() < nums[i]) {
                    map.put(stack.pop(), nums[i]);
                }
                stack.push(nums[i]);
            }
        }
        while (!stack.empty()) {
            map.put(stack.pop(), -1);
        }
        System.out.println(map);

        int[] result = new int[nums.length];
        for (int i = 0; i < result.length; ++i) {
            result[i] = map.get(nums[i]) != null ? map.get(nums[i]) : -1;
        }
        System.out.println(Arrays.toString(result));
        return result;
    }
}

/*Given a circular array (the next element of the last element is the first element of the array), print the Next Greater Number for every element. The Next Greater Number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, output -1 for this number.

Example 1:
Input: [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2;
The number 2 can't find next greater number;
The second 1's next greater number needs to search circularly, which is also 2.
Note: The length of given array won't exceed 10000. */