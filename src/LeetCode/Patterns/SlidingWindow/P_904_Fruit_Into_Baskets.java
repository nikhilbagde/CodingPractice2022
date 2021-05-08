package LeetCode.Patterns.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Nikhil Bagde
 * @date 5/8/2021- 1:45 AM
 **/
public class P_904_Fruit_Into_Baskets {
    /**
     * In a row of trees, the i-th tree produces fruit with type tree[i].
     *
     * You start at any tree of your choice, then repeatedly perform the following steps:
     *
     * Add one piece of fruit from this tree to your baskets.  If you cannot, stop.
     * Move to the next tree to the right of the current tree.  If there is no tree to the right, stop.
     * Note that you do not have any choice after the initial choice of starting tree:
     *  you must perform step 1, then step 2, then back to step 1, then step 2, and so on until you stop.
     *
     * You have two baskets, and each basket can carry any quantity of fruit,
     * but you want each basket to only carry one type of fruit each.
     *
     * What is the total amount of fruit you can collect with this procedure?
     */

    public static void main(String[] args) {
        //int totalFurits = totalFruit(new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4});
        int totalFurits = totalFruit2(new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4}); //O(N) space O(2)  <<------------
        int totalFurits2 = totalFruit3(new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4}); //O(N) space O(2) - Fastest
        System.out.println("totalFurits = " + totalFurits);
    }

    public static int totalFruit(int[] nums) {
        //Input: [3,3,3,1,2,1,1,2,3,3,4]
        int start = 0;
        int totalFruits = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int end = 0; end < nums.length; end++) {
            map.put(nums[end], map.getOrDefault(nums[end], 0 )+ 1);

            //below logic will delete duplicates of start index and move it to next index accordingly.
            while(map.size()>2) {
                map.put(nums[start], map.get(nums[start]) -1);  //decrement the count till it becomes zero
                map.remove(nums[start], 0); //remove key with value zero.
                start++;
            }
            totalFruits = Math.max(totalFruits, end - start+1); //here we just need to check the count of fruits which is diff of the index.
        }
        return totalFruits;
    }

    public static int totalFruit2(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        int res = 0;
        int start = 0;
        for (int end = 0; end < nums.length; ++end) {
            count.put(nums[end], count.getOrDefault(nums[end], 0) + 1);

            while (count.size() > 2) { // while size is more, we can keep decrementing count of start element till it gets to zero,
                count.put(nums[start], count.get(nums[start]) - 1);
                if (count.get(nums[start]) == 0) count.remove(nums[start]); // Once count=0, remove the element
                start++;
            }
            res = Math.max(res, end - start + 1);
        }
        return res;
    }

    public static int totalFruit3(int[] tree) {
        int res = 0, left = 0, right = -1;
        int n = tree.length;
        for(int i=1;i<n;i++){
            if(tree[i]!=tree[i-1]){
                if(right>=0 && tree[right]!=tree[i]){
                    res = Math.max(res,i-left);
                    left = right+1;
                }
                right = i-1;
            }
        }
        return Math.max(n-left,res);
    }

    /**
     * Example 1:
     *
     * Input: [1,2,1]
     * Output: 3
     * Explanation: We can collect [1,2,1].
     * Example 2:
     *
     * Input: [0,1,2,2]
     * Output: 3
     * Explanation: We can collect [1,2,2].
     * If we started at the first tree, we would only collect [0, 1].
     * Example 3:
     *
     * Input: [1,2,3,2,2]
     * Output: 4
     * Explanation: We can collect [2,3,2,2].
     * If we started at the first tree, we would only collect [1, 2].
     * Example 4:
     *
     * Input: [3,3,3,1,2,1,1,2,3,3,4]
     * Output: 5
     * Explanation: We can collect [1,2,1,1,2].
     * If we started at the first tree or the eighth tree, we would only collect 4 fruits.
     */
}

