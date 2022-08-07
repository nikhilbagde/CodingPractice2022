package LeetCode.Easy;

/**
 * Created by Nikhil on 4/9/2017 10:57 PM.
 */
public class P530MinimumAbsoluteDifferenceinBST {
    static int min = Integer.MAX_VALUE;
    static TreeNode prev = null;

    private static int getMinimumDifference(TreeNode root) {
        if (root == null) return min;
        getMinimumDifference(root.left);
        if (prev != null)
            min = Math.min(min, root.val - prev.val);
        prev = root;

        getMinimumDifference(root.right);
        return min;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

/*
Input:

   1
    \
     3
    /
   2

Output:
1

Explanation:
The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
 */