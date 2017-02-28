package GeeksForGeeks.DataStructure.Trees.Set3;

import GeeksForGeeks.DataStructure.Trees.BinaryTree;
import GeeksForGeeks.DataStructure.Trees.Set1.ConstructBST;
import GeeksForGeeks.DataStructure.Trees.TreeNode;

/**
 * Created by Nikhil on 1/22/2017 5:05 PM.
 */
public class PrintAncestorOfGivenNode {
    //Non working code! Get back later
    private static TreeNode printAncestorOfNode(TreeNode root, TreeNode node){
        if(root==null) return null;
        if(root.left!=null) return printAncestorOfNodeUtil(root, root.left, node);
        if(root.right!=null) return printAncestorOfNodeUtil(root, root.right, node);
        return null;
    }
    private static TreeNode printAncestorOfNodeUtil(TreeNode parent, TreeNode root, TreeNode node){
        if(root.value == node.value) return parent;
        if(root.left==null && root.right ==null) return null;
        if(root.left!=null) return printAncestorOfNodeUtil(root, root.left, node);
        return printAncestorOfNodeUtil(root, root.right, node);
    }

    public static void main(String[] args) {
        BinaryTree tree = ConstructBST.constructBinarySearchTree();
        TreeNode result = printAncestorOfNode(tree.getRoot(), new TreeNode(7));     //Expected : 3->6, 7->8
        System.out.println("result.value = " + result.value);
    }
}
