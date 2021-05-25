package Patterns.educative.io.java2.G_TreeBreadthFirstSearch;

import java.util.*;

class TreeNode7 {
    int val;
    TreeNode1 left;
    TreeNode1 right;

    TreeNode7(int x) {
        val = x;
    }
};

class ReverseLevelOrderTraversal {
    public static List<List<Integer>> traverse(TreeNode1 root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        // TODO: Write your code here
        if (root == null) return result;
        Queue<TreeNode1> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() > 0) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while (size > 0) {
                TreeNode1 node = queue.poll();
                list.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                size--;
            }
            result.add(0, list);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode1 root = new TreeNode1(12);
        root.left = new TreeNode1(7);
        root.right = new TreeNode1(1);
        root.left.left = new TreeNode1(9);
        root.right.left = new TreeNode1(10);
        root.right.right = new TreeNode1(5);
        List<List<Integer>> result = ReverseLevelOrderTraversal.traverse(root);
        System.out.println("Reverse level order traversal: " + result);
    }
}
