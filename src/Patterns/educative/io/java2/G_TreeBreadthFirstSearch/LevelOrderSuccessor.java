package Patterns.educative.io.java2.G_TreeBreadthFirstSearch;

import java.util.*;

class TreeNode2 {
    int val;
    TreeNode1 left;
    TreeNode1 right;

    TreeNode2(int x) {
        val = x;
    }
};

class LevelOrderSuccessor {
    public static TreeNode1 findSuccessor(TreeNode1 root, int key) {
        // TODO: Write your code here
        if (root == null) return null;
        Queue<TreeNode1> queue = new LinkedList<>();
        boolean reach = false;
        queue.add(root);
        while (queue.size() > 0) {
            int size = queue.size();
            while (size > 0) {
                TreeNode1 node = queue.poll();
                if (reach) return node;
                if (node.val == key) reach = true;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                size--;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode1 root = new TreeNode1(12);
        root.left = new TreeNode1(7);
        root.right = new TreeNode1(1);
        root.left.left = new TreeNode1(9);
        root.right.left = new TreeNode1(10);
        root.right.right = new TreeNode1(5);
        TreeNode1 result = LevelOrderSuccessor.findSuccessor(root, 12);
        if (result != null)
            System.out.println(result.val + " ");
        result = LevelOrderSuccessor.findSuccessor(root, 9);
        if (result != null)
            System.out.println(result.val + " ");
    }
}
