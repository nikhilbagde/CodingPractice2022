package LeetCode.Easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by Nikhil on 3/30/2017 3:26 AM.
 */
public class P496NextGreaterElementI {
    public static void main(String[] args) {
        int[] a = {4, 1, 2};
        int[] b = {1, 3, 4, 2};

        int[] c = {2, 4};
        int[] d = {1, 2, 3, 4};

        //wrong
        //nextGreaterElementUsingPQ(a, b);
        //stack right
        nextGreaterElementUsingStack(a, b);
        nextGreaterElementUsingStack(c, d);
    }

    private static int[] nextGreaterElementUsingPQ(int[] findNums, int[] nums) {
        //BUG: for maxheap signs should be reversed.
        java.util.PriorityQueue<Integer> maxHeap = new java.util.PriorityQueue<>(((o1, o2) -> o1 > o2 ? -1 : (o1 < o2 ? 1 : 0)));

        //keep track of next  max for every element from nums in this array.
        int[] tillMax = new int[nums.length];
        Map<Integer, Integer> elementToNextMaxMap = new HashMap<>();

        elementToNextMaxMap.put(nums[nums.length - 1], -1);   //last elements next MAX is always nothing = -1
        //for last element next max is nothing, hence -1.
        tillMax[tillMax.length - 1] = -1;
        // TO start, add last element to maxHeap as its only element there.
        maxHeap.add(nums[nums.length - 1]);           //BUG maxHeap.add(nums.length - 1);  Changed to maxHeap.add(nums[nums.length - 1]);


        //we start from second last element. in Reverse direction
        for (int i = nums.length - 2; i >= 0; --i) {
            //check if maxHeap's max element at top is greater than current element
            if (maxHeap.peek() > nums[i]) {
                //so this is our next max for current elment store at same location in tillMax array
                tillMax[i] = maxHeap.peek();
                elementToNextMaxMap.put(nums[i], maxHeap.peek());
            } else if (maxHeap.peek() < nums[i]) {
                tillMax[i] = -1;
                elementToNextMaxMap.put(nums[i], -1);
            }
            //no need to handle equal condition as all elements would be unique.
            maxHeap.add(nums[i]);
        }
        System.out.println(Arrays.toString(tillMax));
        System.out.println(elementToNextMaxMap);

        //{1=4, 2=-1, 3=4, 4=-1} not working as for 1 it should be 3. But its returning max from PQ.
        // PQ is a bad idea.

        return null;
    }

    private static int[] nextGreaterElementUsingStack(int[] findNums, int[] nums) {
        Stack<Integer> stack = new Stack<>();
        //Added later to handle line 88 when num[0] is null as num has size zero
        if (findNums.length == 0 || nums.length == 0) {
            return new int[0];
        }
        //push first element to stack
        stack.push(nums[0]);

        Map<Integer, Integer> nextMaxMap = new HashMap<>();
        //start from second element
        for (int i = 1; i < nums.length; ++i) {
            while (!stack.isEmpty() && stack.peek() < nums[i]) {
                nextMaxMap.put(stack.pop(), nums[i]);
            }
            stack.push(nums[i]);
        }
        while (!stack.empty()) {
            nextMaxMap.put(stack.pop(), -1);
        }
        System.out.println(nextMaxMap);

        int[] result = new int[findNums.length];
        for (int i = 0; i < findNums.length; ++i) {
            result[i] = nextMaxMap.get(findNums[i]) != null ? nextMaxMap.get(findNums[i]) : -1;
        }
        System.out.println(Arrays.toString(result));
        return result;
    }

    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        int[] result = new int[findNums.length];
        //Arrays.sort(findNums);
        //Arrays.sort(nums);


        for (int i = 0; i < findNums.length; ++i) {
            for (int j = 0; j < nums.length; ++j) {
                if (findNums[i] == nums[j] && j + 1 < nums.length) {
                    result[i] = nums[j];
                }
            }
        }

        return result;
    }
}

/*
Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
Output: [-1,3,-1]
Explanation:
    For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
    For number 1 in the first array, the next greater number for it in the second array is 3.
    For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
*/