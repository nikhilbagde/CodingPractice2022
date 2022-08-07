package LeetCode.Medium;

/**
 * Created by Nikhil on 4/3/2017 2:08 PM.
 * <p>
 * Input:
 * [4,3,2,7,8,2,3,1]
 * Output:
 * [2,3]
 */
public class P442FindAllDuplicatesinanArray {
    public static void main(String[] args) {
        int[] a = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDuplicates(a));
    }

    private static java.util.List<Integer> findDuplicates(int[] nums) {
        java.util.List<Integer> list = new java.util.ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {     //check if it was already negative. so instead of making it again positive, add it to list as final answer.
                list.add(Math.abs(index + 1));
            }
            nums[index] = -nums[index];
        }
        return list;

        /*
        for(int i=0; i<nums.length;i++){
            if(nums[i]>0)
                list.add(i+1);
        }
        System.out.println("nums" + java.util.Arrays.toString(nums));
        java.util.Set<Integer> result = new java.util.HashSet<>();
        for(int i=0; i<nums.length;i++){
            if(list.contains((nums[i])))
                result.add(nums[i]);
        }
        System.out.println("list"+list);
        System.out.println("result" +result);
        return new java.util.ArrayList<>(result);*/
    }
}
