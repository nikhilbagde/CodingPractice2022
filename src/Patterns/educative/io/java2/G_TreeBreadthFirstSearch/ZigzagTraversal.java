package Patterns.educative.io.java2.G_TreeBreadthFirstSearch;

import java.util.*;

class TreeNode8 {
    int val;
    TreeNode1 left;
    TreeNode1 right;

    TreeNode8(int x) {
        val = x;
    }
};

class ZigzagTraversal {
    public static List<List<Integer>> traverse(TreeNode1 root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        // TODO: Write your code here
        if (root == null) return result;
        boolean order = true;
        Queue<TreeNode1> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() > 0) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            while (size > 0) {
                TreeNode1 node = queue.poll();
                size--;
                if (order) list.add(node.val);
                else list.add(0, node.val);

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            if (order) order = false;
            else order = true;
            result.add(list);
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
        root.right.left.left = new TreeNode1(20);
        root.right.left.right = new TreeNode1(17);
        List<List<Integer>> result = ZigzagTraversal.traverse(root);
        System.out.println("Zigzag traversal: " + result);
    }
}
