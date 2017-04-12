package LeetCode;

/**
 * Created by Nikhil on 4/10/2017 3:05 PM.
 */
public class P453MinimumMovestoEqualArrayElements {
    public static void main(String[] args) {

    }

    private static int minMoves(int[] nums) {
        if (nums.length == 0) return 0;
        int min = nums[0];
        for (int n : nums) min = Math.min(min, nums[n]);
        int result = 0;
        for (int n : nums) result += n - min;
        return result;
    }
}
/*
Given a non-empty integer array of size n,
find the minimum number of moves required to make all array elements equal,
where a move is incrementing n - 1 elements by 1.

Example:
Input:
[1,2,3]

Output:
3

Explanation:
Only three moves are needed (remember each move increments two elements):
[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 */