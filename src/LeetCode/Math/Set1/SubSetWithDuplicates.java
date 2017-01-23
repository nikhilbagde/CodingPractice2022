package LeetCode.Math.Set1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Nikhil on 1/21/2017 4:27 PM.
 */
public class SubSetWithDuplicates {

    private static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());                          //for blank set
        Arrays.sort(nums);

        for (int i=0;i<nums.length;i++) {
            int curSize = result.size();
            for (int j=0;j<curSize;j++) {
                List<Integer> currList = new ArrayList<>(result.get(j));            //add list iterating over list.
                currList.add(nums[i]);
                if(!result.contains(currList))
                    result.add(currList);
            }
        }
        for (List<Integer> list: result) {
            System.out.println(list);
        }
        return result;
    }

    public static void main(String[] args) {
        subsetsWithDup(new int[] {3,2,1,1});
    }
}
