package Patterns.educative.io.java2.G_TreeBreadthFirstSearch;

import java.util.*;

class TreeNode1 {
    int val;
    TreeNode1 left;
    TreeNode1 right;

    TreeNode1(int x) {
        val = x;
    }
};

class LevelAverage {
    public static List<Double> findLevelAverages(TreeNode1 root) {
        List<Double> result = new ArrayList<>();
        // TODO: Write your code here
        if (root == null) return result;
        Queue<TreeNode1> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() > 0) {
            int size = queue.size();
            double sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode1 node = queue.poll();
                sum += node.val;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            result.add((double)sum/size);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode1 root = new TreeNode1(12);
        root.left = new TreeNode1(7);
        root.right = new TreeNode1(1);
        root.left.left = new TreeNode1(9);
        root.left.right = new TreeNode1(2);
        root.right.left = new TreeNode1(10);
        root.right.right = new TreeNode1(5);
        List<Double> result = LevelAverage.findLevelAverages(root);
        System.out.print("Level averages are: " + result);
    }
}
