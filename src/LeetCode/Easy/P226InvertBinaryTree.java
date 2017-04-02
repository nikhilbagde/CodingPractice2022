package LeetCode.Easy;

/**
 * Created by Nikhil on 4/1/2017 8:39 PM.
 */
public class P226InvertBinaryTree {

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) return null;
            TreeNode l = root.left;
            TreeNode r = root.right;
            root.left = r;
            root.right = l;
            invertTree(root.left);
            invertTree(root.right);
            return root;
        }
    }
}
