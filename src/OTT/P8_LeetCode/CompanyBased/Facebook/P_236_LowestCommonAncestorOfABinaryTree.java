package LeetCode.CompanyBased.Facebook;

import java.util.ArrayList;
import java.util.List;

public class P_236_LowestCommonAncestorOfABinaryTree {

    static List<TreeNode> pList;
    static List<TreeNode> qList;
    public static void main(String[] args) {
       /*    _______3______
                /              \
        ___5__          ___1__
       /      \        /      \
  6      _2      0        8
                /  \
             7   4
    */
        TreeNode root = new TreeNode(3);
        root.left  = new TreeNode(5);
        root.left.left = new TreeNode(6, null,null);
        root.left.right = new TreeNode(2, null,null);

        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0, new TreeNode(7,null, null), new TreeNode(4, null, null));
        root.right.right = new TreeNode(8, null, null);


        TreeNode result = lowestCommonAncestor_1( root, new TreeNode(7), new TreeNode(8));
    }

    /**
     * The very simple idea is to see where the two values are compared with root:
     *
     * Both values are on the left, then LCA is on the left
     * Both values are on the right, then LCA is on the right
     * One on the left and one on the right means that LCA is the current root node.
     *
     * We may recognize that we should only need to search the entire tree once to find p and q. We should then
     * be able to "bubble up" the findings to earlier nodes in the stack. The basic logic is the same as the earlier
     * solution.
     * We recurse through the entire tree with a function called commonAncestor(TreeNode root,
     * TreeNode p, Tree Node q). This function returns values as follows:
     * Returns p, if root's subtree includes p (and not q).
     * Returns q, if root's subtree includes q (and not p).
     * Returns null, if neither p nor q are in root's subtree.
     * Else, returns the common ancestor of p and q.
     */

    public static TreeNode lowestCommonAncestor_1(TreeNode root, TreeNode p, TreeNode q){
        if(root==null) return null;
        if(root.val == p.val || root.val == q.val) return root;                 //how does TreeNode object equality works? should be .val ==

        //above step can be combined as
        /*
        if(root ==null || root.val == p.val || root.val == q.val) return root;
         */
        TreeNode left = lowestCommonAncestor_1(root.left, p, q);
        TreeNode right = lowestCommonAncestor_1(root.right, p, q);

        if(left == null && right == null){
            return null;
        } else if( left!=null && right!=null){
            return root;
        } else if( left==null && right!=null){
            return right;
        } else { //left !=null && right==null
            return left;
        }
    }

    public static TreeNode lowestCommonAncestor_2(TreeNode root, TreeNode p, TreeNode q){
        backtrack(root, p, q, new ArrayList<>());

        for (int i = 0; i < Math.min(pList.size(), qList.size()) ; i++) {
            if(pList.get(i).val == qList.get(i).val) return pList.get(i);
        }
        return null;
    }
    public static void backtrack(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> list){
        if(root==null) return;

        list.add(root);

        if(root.val == p.val) pList = list;
        if(root.val == q.val) qList = list;

        backtrack(root.left, p, q, list);
        backtrack(root.right, p,q , list);
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

