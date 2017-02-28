package GeeksForGeeks.DataStructure.Trees.Set1;

import GeeksForGeeks.DataStructure.Trees.BinaryTree;
import GeeksForGeeks.DataStructure.Trees.TreeNode;

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
        BinaryTree tree = ConstructBST.constructBinarySearchTree();
        int size = sizeOfTree(tree.getRoot());
        System.out.println(size);
        
        int size2 = sizeOfTree2(tree.getRoot());
        System.out.println(size2);
    }



    private static int sizeOfTree2(TreeNode node){
        if(node == null) return 0;
        int leftSubTreeSize  = sizeOfTree2(node.left);
        int rightSubTreeSize  = sizeOfTree2(node.right);
        int totalSize = 1 + leftSubTreeSize + rightSubTreeSize;
        return totalSize;
    }

}
