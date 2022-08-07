package LeetCode.CompanyBased.Facebook;

/**
 * @author Nikhil Bagde
 * @package LeetCode.CompanyBased.Facebook
 * @created 04/23/2021
 * @date 4/23/2021- 1:18 AM
 * @project HackerRank2017
 **/
public class P_112_PathSum {

    //idea first we can check if current node is null then return null
    // then plan is check for leaf node, check root.left == null && root.r = null && curentSum = targerSum return true
    // otherwise recurse for left and right subtree adding or condition as we need to either go in left or right

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) return false;
        //return helperSubtractor (root, targetSum);
        return helperAdder(root, targetSum, 0);
    }

    public boolean helperAdder(TreeNode root, int s, int currentSum){
        if(root==null) {
            return false;
        }
        if(root.left==null && root.right ==null && root.val + currentSum == s) {
            return true;
        }
        return helperAdder(root.left, s, currentSum + root.val) ||
                helperAdder(root.right, s, currentSum + root.val);

    }

    public boolean helperSubtractor(TreeNode root, int s){
        if(root==null) {
            return false;
        }
        if(root.left==null && root.right ==null && root.val  == s) {
            return true;
        }
        return helperSubtractor(root.left,  s - root.val) ||
                helperSubtractor(root.right,  s - root.val);

    }
    private static  class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
