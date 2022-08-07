package CompanyCompetetions.Amazon.Interview1;

import OTT.P7_GeeksForGeeks.DataStructure.Trees.TreeNode;

/**
 * Created by Nikhil on 4/6/2017 8:28 PM.
 */
public class MirrorTree {
    private static boolean isFoldable(TreeNode root) {
        return isFoldableRec(root.left, root.right);
    }

    private static boolean isFoldableRec(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;          //means both nodes are not present on both sides.
        if (left == null || right == null) return false;     //one is null and other is not.
        return isFoldableRec(left.left, right.right)
                && isFoldableRec(left.right, right.left);
    }
}
