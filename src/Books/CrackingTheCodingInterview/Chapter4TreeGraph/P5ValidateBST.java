package Books.CrackingTheCodingInterview.Chapter4TreeGraph;

import DataStructure.Trees.TreeNode;

/**
 * Created by Nikhil on 2/15/2017 12:50 AM.
 * Validate BST: Implement a function to check if a binary tree is a binary search tree.
 * Hints:
 * #35,    - if tried inorder, what if tree has duplicates?
 * #57,    - checking left.value <= current.value < right.value, this should be true for everyNode.
 * #86,    -
 * #113,
 * #128    - write recursive function.
 */
public class P5ValidateBST {
    public static boolean isBinarySearchTree(TreeNode root) {
        return isBinarySearchTree(root, null, null);
    }

    private static boolean isBinarySearchTree(TreeNode root, Integer min, Integer max) {
        if (root == null) return true;
        if ((min != null && root.data <= min) || (max != null && root.data > max)) return false; //check current root.

        return !(!isBinarySearchTree(root.left, min, root.data) || !isBinarySearchTree(root.right, root.data, max));
    }
}
