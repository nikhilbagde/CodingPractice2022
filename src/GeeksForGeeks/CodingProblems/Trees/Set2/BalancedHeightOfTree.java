package GeeksForGeeks.CodingProblems.Trees.Set2;

import GeeksForGeeks.CodingProblems.Trees.BinaryTree;
import GeeksForGeeks.CodingProblems.Trees.TreeNode;

/**
 * Created by Nikhil on 1/19/2017 4:31 PM.
 */
public class BalancedHeightOfTree {
    private static boolean isBalancedHeight(TreeNode root){
        if(root==null) return true;
        int lh = getHeight(root.left);
        int rh = getHeight(root.right);

        return Math.abs(lh-rh) <2 && isBalancedHeight(root.left) && isBalancedHeight(root.right);

    }
    private static int getHeight(TreeNode root){
        if(root==null) return 0;
        return 1 + Math.max( getHeight(root.left), getHeight(root.right));
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.setRoot(new TreeNode(1));
        tree.getRoot().left = new TreeNode(2);
        tree.getRoot().right = new TreeNode(3);
        tree.getRoot().left.left = new TreeNode(4);
        tree.getRoot().left.right = new TreeNode(5);
        tree.getRoot().left.left.left = new TreeNode(8);

        boolean result = isBalancedHeight(tree.getRoot());
        System.out.println(result);
    }
}
