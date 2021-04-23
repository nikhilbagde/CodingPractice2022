package LeetCode.CompanyBased.Facebook;

public class P_124_BinaryTreeMaximumPathSum {

    public static void main(String[] args) {
        int maximumaPathSum = maximumSumPath(new TreeNode (2));
    }
    public static int maximumSumPath(TreeNode root){
        int max = Integer.MIN_VALUE;
        if(root==null) return 0;
        max = helper(root, max);
        return max;
    }

    public static int helper(TreeNode root, int max){
        if(root==null) return 0;

        int leftChildVal = helper(root.left, max);
        int rightChildVal = helper(root.right, max);

        int localMax = Math.max(
                    Math.max(root.val, root.val + root.left.val),
                    Math.max(root.val + root.right.val, root.val + root.left.val + root.right.val)
        );
        max = Math.max(localMax, max);

        return Math.max(root.val, Math.max(root.val + root.left.val, root.right.val));
    }

    private static  class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}


