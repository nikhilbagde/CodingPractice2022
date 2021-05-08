package LeetCode.LeetCodeWeeklyContest239;

public class Problem1 {
    public static void main(String[] args) {

    }

    public int getMinDistance(int[] nums, int target, int start) {
        //nums = [1,2,3,4,5], target = 5, start = 3
        int min = Integer.MIN_VALUE;
        int goBack = start;
        int goFront = start + 1;
        while (goBack >= 0) {
            if (nums[goBack] == target) {
                min = Math.min(min, Math.abs(start - goBack));
            }
            goBack--;
        }

        while (goFront < nums.length) {
            if (nums[goFront] == target) {
                min = Math.min(min, Math.abs(start - goFront));
            }
            goFront++;
        }
        return min;
    }
}
