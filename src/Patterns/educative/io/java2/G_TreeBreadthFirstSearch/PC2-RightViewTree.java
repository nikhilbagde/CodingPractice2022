package Patterns.educative.io.java2.G_TreeBreadthFirstSearch;

import java.util.*;

class TreeNode6 {
    int val;
    TreeNode6 left;
    TreeNode6 right;

    TreeNode6(int x) {
        val = x;
    }
};

class RightViewTree {
    public static List<TreeNode6> traverse(TreeNode6 root) {
        List<TreeNode6> result = new ArrayList<>();
        // TODO: Write your code here
        if (root == null) return result;
        Queue<TreeNode6> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() > 0) {
            int size = queue.size();
            while (size > 0) {
                TreeNode6 node = queue.poll();
                if (size == 1) result.add(node);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                size--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode6 root = new TreeNode6(12);
        root.left = new TreeNode6(7);
        root.right = new TreeNode6(1);
        root.left.left = new TreeNode6(9);
        root.right.left = new TreeNode6(10);
        root.right.right = new TreeNode6(5);
        root.left.left.left = new TreeNode6(3);
        List<TreeNode6> result = RightViewTree.traverse(root);
        for (TreeNode6 node : result) {
            System.out.print(node.val + " ");
        }
    }
}

