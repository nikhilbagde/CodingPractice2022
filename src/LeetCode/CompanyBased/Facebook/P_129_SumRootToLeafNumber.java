package LeetCode.CompanyBased.Facebook;

/**
 * @author Nikhil Bagde
 * @package LeetCode.CompanyBased.Facebook
 * @created 04/23/2021
 * @date 4/23/2021- 1:46 AM
 * @project HackerRank2017
 **/
public class P_129_SumRootToLeafNumber {
    // check if root is null then simply return zero
    // check if current is left, then first append current root val at end of string, take IntegerParse of final string, which is the root to leaf sum. return that sum
    // as we need to add all root to leaf sum, we can call rec for root.left passing ""+ root.val )
      // + recursive call to right subtree to get full sum.
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        int result = helper (root, "");
        return result;
    }
    public int helper(TreeNode root, String num){
        if(root == null) return 0;

        if(root.left == null & root.right ==null){
            return  Integer.parseInt(num + root.val) ;  //REMEMBER: add num + root.val and not Inte.par(num) + root.val
        }
        //REMEMBER: called recu + recu (adding ) b/c at each end once we got sum, we need to add sum for all paths till leaf.
        return helper(root.left, num + root.val) + helper(root.right, num + root.val);
    }
    private static  class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
