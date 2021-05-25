package Patterns.educative.io.java2.G_TreeBreadthFirstSearch;

import java.util.*;

class TreeNode4 {
    int val;
    TreeNode1 left;
    TreeNode1 right;

    TreeNode4(int x) {
        val = x;
    }
};

class MinimumBinaryTreeDepth {
    public static int findDepth(TreeNode1 root) {
        // TODO: Write your code here
        if (root == null) return 0;
        Queue<TreeNode1> queue = new LinkedList<>();
        int depth = 0;
        queue.add(root);
        while (queue.size() > 0) {
            depth++;
            int size = queue.size();
            while (size > 0) {
                TreeNode1 node = queue.poll();
                if (node.left == null && node.right == null) return depth;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                size--;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        TreeNode1 root = new TreeNode1(12);
        root.left = new TreeNode1(7);
        root.right = new TreeNode1(1);
        root.right.left = new TreeNode1(10);
        root.right.right = new TreeNode1(5);
        System.out.println("Tree Minimum Depth: " + MinimumBinaryTreeDepth.findDepth(root));
        root.left.left = new TreeNode1(9);
        root.right.left.left = new TreeNode1(11);
        System.out.println("Tree Minimum Depth: " + MinimumBinaryTreeDepth.findDepth(root));
    }
}
