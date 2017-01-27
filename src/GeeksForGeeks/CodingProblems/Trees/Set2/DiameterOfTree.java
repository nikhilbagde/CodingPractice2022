package GeeksForGeeks.CodingProblems.Trees.Set2;

import GeeksForGeeks.CodingProblems.Trees.BinaryTree;
import GeeksForGeeks.CodingProblems.Trees.Set1.ConstructBST;
import GeeksForGeeks.CodingProblems.Trees.TreeNode;

/**
 * Created by Nikhil on 1/18/2017 10:04 PM.
 */
public class DiameterOfTree {
    private static int getDiameter(TreeNode root){
        if(root==null) return 0;

        int leftTreeHeight = getHeight(root.left);
        int rightTreeHeight = getHeight(root.right);

        int leftDiameter = getDiameter(root.left);
        int rightDiameter = getDiameter(root.right);

        return Math.max(
                (1 + leftTreeHeight + rightTreeHeight),
                Math.max(leftDiameter, rightDiameter));
    }
    private static int getHeight(TreeNode root){
        if(root==null) return 0;
        if(root.left==null && root.right==null) return 1;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    public static void main(String[] args) {
        BinaryTree tree = ConstructBST.constructBinarySearchTree();
        int diameter = getDiameter(tree.getRoot());
        System.out.println("diameter = " + diameter);
    }
}
