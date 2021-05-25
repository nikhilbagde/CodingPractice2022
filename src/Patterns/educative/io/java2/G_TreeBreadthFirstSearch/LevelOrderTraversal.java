package Patterns.educative.io.java2.G_TreeBreadthFirstSearch;

import java.util.*;

class TreeNode3 {
    int val;
    TreeNode1 left;
    TreeNode1 right;

    TreeNode3(int x) {
        val = x;
    }
};

class LevelOrderTraversal {
    public static List<List<Integer>> traverse(TreeNode1 root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        // TODO: Write your code here
        if (root == null) return result;
        Queue<TreeNode1> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() > 0) {
            int num = queue.size();
            List<Integer> traversal = new ArrayList<>();
            while (num > 0) {
                TreeNode1 currRoot = queue.poll();
                traversal.add(currRoot.val);
                if (currRoot.left != null) queue.add(currRoot.left);
                if (currRoot.right != null) queue.add(currRoot.right);
                num--;
            }
            result.add(traversal);
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
        List<List<Integer>> result = LevelOrderTraversal.traverse(root);
        System.out.println("Level order traversal: " + result);
    }
}
