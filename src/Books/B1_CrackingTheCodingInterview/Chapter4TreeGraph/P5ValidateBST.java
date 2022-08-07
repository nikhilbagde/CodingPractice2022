package Books.B1_CrackingTheCodingInterview.Chapter4TreeGraph;

import DataStructure.Trees.TreeNode;

/**
 * Created by Nikhil on 2/15/2017 12:50 AM.
 * Validate BST: Implement a function to check if a binary tree is a binary search tree.
 * Hints:
 * #35,    - If you traversed the tree using an in-order traversal and the elements were truly in
 * the right order, does this indicate that the tree is actually in order? What happens for
 * duplicate elements? If duplicate elements are allowed, they must be on a specific side
 * (usually the left).
 * #57,    - To be a binary search tree, it's not sufficient that the left. value <= current.
 * value < right. value for each node. Every node on the left must be less than the
 * current node, which must be less than all the nodes on the right.
 * #86,    - If every node on the left must be less than or equal to the current node, then this is really
 * the same thing as saying that the biggest node on the left must be less than or equal to
 * the current node.
 * #113,    - Rather than validating the current node's value against left Tree. max and
 * rightTree. min, can we flip around the logic? Validate the left tree's nodes to ensure
 * that they are smaller than current value.
 * #128    - Think about the checkBST function as a recursive function that ensures each node is
 * within an allowable (min, max) range. At first, this range is infinite. When we traverse
 * to the left, the min is negative infinity and the max is root. value . Can you implement
 * this recursive function and properly adjust these ranges as you traverse the tree?
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
