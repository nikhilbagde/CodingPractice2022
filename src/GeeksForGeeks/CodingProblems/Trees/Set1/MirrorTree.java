package GeeksForGeeks.CodingProblems.Trees.Set1;

import GeeksForGeeks.CodingProblems.Trees.BinaryTree;
import GeeksForGeeks.CodingProblems.Trees.TreeNode;

/**
 * Created by Nikhil on 1/17/2017 9:35 PM.
 */
public class MirrorTree {
    private static TreeNode mirrorTree(TreeNode node){
        if(node==null) return null;

        TreeNode left = mirrorTree(node.left);
        TreeNode right = mirrorTree(node.right);

        node.left = right;
        node.right = left;

        return node;
    }
}
