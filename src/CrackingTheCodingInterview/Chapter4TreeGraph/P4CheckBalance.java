package CrackingTheCodingInterview.Chapter4TreeGraph;

import GeeksForGeeks.DataStructure.Trees.TreeNode;

/**
 * Created by Nikhil on 2/15/2017 12:45 AM.
 * Check Balanced: Implement a function to check if a binary tree is balanced.
 * For the purposes of  this question, a balanced tree is defined to be a tree
 * such that the heights of the two subtrees of any  node never differ by more than one.
 * Hints:
 * #21,  - Think about condiiton of balance tree, can you check it for single node, and then for every node?
 * #33, - Brute force, if you are computing height for every level it would be inefficient.
 * #49, - What if we modify node class to store height of its subTree
 * #105, - YOu dont need to have field in Node class, instead can you try recursevly to calcualte height of subtree and
 * also if its balanced and try returning two values?
 * #124 - Instead you can only have checkHeighBalance fundtion to computer both and have integer value as result.
 */
public class P4CheckBalance {

    public static int getHeight(TreeNode root) {
        if (root == null) return -1;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    //O (N log N)
    public static boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int heightDiff = getHeight(root.left) - getHeight(root.right);
        if (Math.abs(heightDiff) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    //O(N)  O(H) Space h=height
    public static int checkHeight(TreeNode root) {
        if (root == null) return -1;

        int leftHeight = checkHeight(root.left);
        if (leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        int rightHeight = checkHeight(root.right);
        if (rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        int heightDiff = leftHeight - rightHeight;
        if (Math.abs(heightDiff) > 1)
            return Integer.MIN_VALUE;
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public boolean isBalancedEfficient(TreeNode root) {
        return checkHeight(root) != Integer.MIN_VALUE;
    }


}
