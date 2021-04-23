package LeetCode.CompanyBased.Facebook;

public class P_124_BinaryTreeMaximumPathSum {

    public static void main(String[] args) {
        int maximumaPathSum = maxPathSum(new TreeNode (2));
    }
    static int max = Integer.MIN_VALUE;
    public static int maxPathSum(TreeNode root) {
        if(root==null) return 0;

        helper(root);

        return max;
    }
    public static int helper(TreeNode root){
        if(root==null) return 0;

        int l = helper(root.left);
        int r = helper(root.right);

        int localMax = Math.max (Math.max(root.val, root.val + l),  //not l.val but just l as its int
                Math.max(root.val + r, root.val + l + r));

        max = Math.max(localMax, max);

        return Math.max(root.val, Math.max(root.val+l, root.val + r));
    }
    private static  class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}


