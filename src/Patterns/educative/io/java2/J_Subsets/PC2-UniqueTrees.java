package Patterns.educative.io.java2.J_Subsets;

import java.util.*;

class TreeNode {
    int val;
    TreeNode2 left;
    TreeNode2 right;

    TreeNode(int x) {
        val = x;
    }
};

class UniqueTrees {
    public static List<TreeNode2> findUniqueTrees(int n) {
        List<TreeNode2> result = new ArrayList<>();
        // TODO: Write your code here
        return generate(1,n);
    }

    private static List<TreeNode2> generate(int start, int end) {
        List<TreeNode2> result = new ArrayList<>();
        if (start > end) {
            result.add(null);
            return result;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode2> left = new ArrayList<>(generate(start, i-1));
            List<TreeNode2> right = new ArrayList<>(generate(i+1, end));
            for (TreeNode2 l: left) {
                for (TreeNode2 r: right) {
                    TreeNode2 temp = new TreeNode2(i);
                    temp.left = l;
                    temp.right = r;
                    result.add(temp);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<TreeNode2> result = UniqueTrees.findUniqueTrees(2);
        System.out.print("Total trees: " + result.size());
    }
}
