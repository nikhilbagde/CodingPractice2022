package GeeksForGeeks.CodingProblems.Trees.Set1;

import GeeksForGeeks.CodingProblems.Trees.BinaryTree;
import GeeksForGeeks.CodingProblems.Trees.TreeNode;

/**
 * Created by Nikhil on 1/17/2017 4:39 PM.
 */
public class SizeOfTree {
    private static int sizeOfTree(TreeNode node){
        if(node == null) return 0;
        //if(node.left == null && node.right ==null ) return 1;
        return 1 + sizeOfTree(node.left) + sizeOfTree(node.right);
    }

    public static void main(String[] args) {
        BinaryTree tree = ConstructBST.constructBST();
        int size = sizeOfTree(tree.getRoot());
        System.out.println(size);
    }
}
