package LeetCode.CompanyBased.Facebook;

/**
 * @author Nikhil Bagde
 * @package LeetCode.CompanyBased.Facebook
 * @created 04/22/2021
 * @date 4/22/2021- 11:38 PM
 * @project HackerRank2017
 **/
public class P_235_LowestCommonAncestorOfABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        if(root.val > Math.max(p.val, q.val)) return lowestCommonAncestor(root.left,p,q);
        if(root.val < Math.min(p.val, q.val)) return lowestCommonAncestor(root.right,p,q);
        return root;
    }
    private  static  class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
