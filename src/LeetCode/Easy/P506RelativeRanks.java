package LeetCode.Easy;

import java.util.Arrays;

/**
 * Created by Nikhil on 4/9/2017 11:18 PM.
 */
public class P506RelativeRanks {
    public static void main(String[] args) {
        int[] a = {5, 4, 3, 2, 1};
        findRelativeRanks(a);
    }

    private static String[] findRelativeRanks(int[] nums) {
        //int[] to Integer[]
        //primitive array to object array.
        //int[] array to Integer[] array
        //Integer[] numss=  Arrays.stream(nums).boxed().toArray(Integer[]::new);
        //Sort primitive array.
        //Arrays.sort(numss, java.util.Collections.reverseOrder());
        //System.out.println(Arrays.deepToString(numss));

        //sorting array keeping original index.
        //sort array and keep original index.
        Integer[] index = new Integer[nums.length];

        for (int i = 0; i < nums.length; i++) {
            index[i] = i;
        }
        //Array in reverse order.
        Arrays.sort(index, (o1, o2) -> nums[o1] > nums[o2] ? -1 : (nums[o1] < nums[o2] ? 1 : 0));
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.deepToString(index));

        String[] result = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                result[index[i]] = "Gold Medal";
            } else if (i == 1) {
                result[index[i]] = "Silver Medal";
            } else if (i == 2) {
                result[index[i]] = "Bronze Medal";
            } else {
                result[index[i]] = (i + 1) + "";
            }
        }
        return result;
    }
}
/*
Input: [5, 4, 3, 2, 1]
Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
Explanation: The first three athletes got the top three highest scores, so they got "Gold Medal", "Silver Medal" and "Bronze Medal".
For the left two athletes, you just need to output their relative ranks according to their scores.
 */