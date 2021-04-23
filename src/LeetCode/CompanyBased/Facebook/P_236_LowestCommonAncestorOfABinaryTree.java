package LeetCode.CompanyBased.Facebook;

public class P_236_LowestCommonAncestorOfABinaryTree {

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


        TreeNode result = lowestCommonAncestor( root, new TreeNode(7), new TreeNode(8));
    }

    /**
     * The very simple idea is to see where the two values are compared with root:
     *
     * Both values are on the left, then LCA is on the left
     * Both values are on the right, then LCA is on the right
     * One on the left and one on the right means that LCA is the current root node.
     */

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(root==null) return null;
        if(root.val == p.val || root.val == q.val) return root;                 //how does TreeNode object equality works? should be .val ==

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

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

