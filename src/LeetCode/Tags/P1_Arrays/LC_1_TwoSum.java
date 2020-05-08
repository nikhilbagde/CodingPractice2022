package LeetCode.Tags.P1_Arrays;

import java.util.*;

/**
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class LC_1_TwoSum {
    public static void main(String[] args) {

        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = twoSum(nums, target);
        System.out.println(Arrays.toString(result));

        int[] nums2 = {2, 7, 5, 4};
        System.out.println(twoSumAllList(nums2, 9));

        int[] nums3 = {2, 7, 5, 4, 10, -1};
        System.out.println(twoSumAllList(nums3, 9));

        int[] nums4 = {-4, -5, 5, 4, 10, -19};
        System.out.println(twoSumAllList(nums4, -9));


    }

    private static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();


        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];

            if (map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            } else {
                map.put(nums[i], i);
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    private static List<List<Integer>> twoSumAllList(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> list = new ArrayList<>();


        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];

            if (map.containsKey(diff)) {
                list.add(Arrays.asList(map.get(diff), i));
            } else {
                map.put(nums[i], i);
            }
        }
        return list;
    }
}
