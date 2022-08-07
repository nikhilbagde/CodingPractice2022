package LeetCode.CompanyBased.Facebook;

public class P_404_SumOfLeftLeaves_Easy {
    public int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeftLeavesRec(root, false);
    }
    public int sumOfLeftLeavesRec(TreeNode root, boolean isLeft){
        if(root==null)
            return 0;
        if(isLeft && root.left == null && root.right == null)
            return root.val;
        return sumOfLeftLeavesRec(root.left, true) + sumOfLeftLeavesRec(root.right, false);
    }

    private static  class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
