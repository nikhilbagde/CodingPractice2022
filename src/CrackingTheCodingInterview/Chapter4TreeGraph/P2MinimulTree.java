package CrackingTheCodingInterview.Chapter4TreeGraph;

import GeeksForGeeks.DataStructure.Trees.TreeNode;

/**
 * Created by Nikhil on 2/15/2017 12:35 AM.
 * Given a sorted (increasing order) array with unique integer elements, write an algorithm
 * to create a binary search tree with minimal height.
 * Hints:
 * #19 - Min binary Tree has same number of nodes on left and right of root.
 * #73 - Try recursion, can you find subProblem
 * #116 - Writing base case is actually entire function
 */
public class P2MinimulTree {
    public TreeNode minimumTree(int[] array) {
        return minimumTree(array, 0, array.length - 1);
    }

    private TreeNode minimumTree(int[] array, int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(array[mid]);
        root.left = minimumTree(array, start, mid - 1);
        root.right = minimumTree(array, mid + 1, end);
        return root;
    }
}
