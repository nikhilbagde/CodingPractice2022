package Patterns.educative.io.java2.H_TreeDepthFirstSearch;

import java.util.*;

class TreeNode2 {
    int val;
    TreeNode1 left;
    TreeNode1 right;

    TreeNode2(int x) {
        val = x;
    }
};

class FindAllTreePaths {
    public static List<List<Integer>> findPaths(TreeNode1 root, int sum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        // TODO: Write your code here
        if (root == null) return allPaths;
        dfs(root, sum, new ArrayList<Integer>(), 0, allPaths);
        return allPaths;
    }

    private static void dfs(TreeNode1 root, int sum, List<Integer> list, int currSum, List<List<Integer>> res) {
        if (root == null) return;
        currSum += root.val;
        list.add(root.val);
        if (root.left == null && root.right == null) {
            if (currSum == sum) res.add(new ArrayList<>(list));         //its a new ArrayList
            return;
        }
        if (root.left != null) {
            dfs(root.left, sum, list, currSum, res);
            list.remove(list.size()-1);
        }
        if (root.right != null) {
            dfs(root.right, sum, list, currSum, res);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        TreeNode1 root = new TreeNode1(12);
        root.left = new TreeNode1(7);
        root.right = new TreeNode1(1);
        root.left.left = new TreeNode1(4);
        root.right.left = new TreeNode1(10);
        root.right.right = new TreeNode1(5);
        int sum = 23;
        List<List<Integer>> result = FindAllTreePaths.findPaths(root, sum);
        System.out.println("Tree paths with sum " + sum + ": " + result);
    }
}
