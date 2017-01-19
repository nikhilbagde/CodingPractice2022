package GeeksForGeeks.CodingProblems.Trees.Set2;

import GeeksForGeeks.CodingProblems.Trees.BinaryTree;
import GeeksForGeeks.CodingProblems.Trees.TreeNode;

import java.util.Arrays;

/**
 * Created by Nikhil on 1/17/2017 9:38 PM.
 */
public class PrintPathToLeaf {
    private static void printPathToLeaf(TreeNode node) {
        int[] path = new int[10];
        int length = 0;
        printPathToLeafRec(node, path, length);
    }

    private static void printPathToLeafRec(TreeNode node, int[] path, int length) {
        if (node == null) return;

        path[length++] = node.value;
        if (node.left == null && node.right == null) {
            printPath(path);
        } else {
            printPathToLeafRec(node.left, path, length);
            printPathToLeafRec(node.right, path, length);
        }
    }

    private static void printPath(int[] path) {
        System.out.println(Arrays.toString(path));
    }

    public static void main(String[] args) {
        BinaryTree tree = GeeksForGeeks.CodingProblems.Trees.Set1.ConstructBST.constructBST();
        printPathToLeaf(tree.getRoot());


    }

}

