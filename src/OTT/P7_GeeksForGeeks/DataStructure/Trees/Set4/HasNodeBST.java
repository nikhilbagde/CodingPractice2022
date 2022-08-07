package OTT.P7_GeeksForGeeks.DataStructure.Trees.Set4;

import OTT.P7_GeeksForGeeks.DataStructure.Trees.BinaryTree;
import OTT.P7_GeeksForGeeks.DataStructure.Trees.Set1.ConstructBST;
import OTT.P7_GeeksForGeeks.DataStructure.Trees.TreeNode;

/**
 * Created by Nikhil on 1/26/2017 7:14 PM.
 */
public class HasNodeBST {
    private static boolean hasNodeBST(TreeNode root, int value){
        if(root==null) return false;
        if(root.value == value) return true;
        if(root.left== null && root.right== null) return false;     //even searching for given value in 2nd if its not found and we reach leaf. then its not there buddy.

        if(value < root.value) return hasNodeBST(root.left, value);
        return hasNodeBST(root.right, value);
    }

    public static void main(String[] args) {
        BinaryTree tree = ConstructBST.constructBinarySearchTree();
        boolean result = hasNodeBST(tree.getRoot(), 99);
        System.out.println("result = " + (result ? "Present": "Not Present"));
    }
}
