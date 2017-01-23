package GeeksForGeeks.CodingProblems.Trees.Set3;

import GeeksForGeeks.CodingProblems.Trees.TreeNode;

/**
 * Created by Nikhil on 1/21/2017 7:48 PM.
 */
public class IsFoldable {
    /*      It is checking, mirrorBinary was to converting to mirror | Same concept though.
    Thought Process:      root
                        /       \
                        L       R
                     /  \     /  \
                    LL   LR  RL  RR

          for Left sub tree and Right sub Tree,
          check each node, LL with RL  && LR with RR

          We are not checking for the Node.data but Node itself whether its null or not.
     */

    private static boolean isFoldable(TreeNode root){
        return isFoldableRec(root.left, root.right);
    }

    private static boolean isFoldableRec(TreeNode left, TreeNode right){
        if(left==null && right==null) return true;          //means both nodes are not present on both sides.
        if(left==null && right!=null || left!=null&&right==null ) return false;     //one is null and other is not.
        return isFoldableRec(left.left, right.right)
                && isFoldableRec(left.right, right.left);
    }

}
