package DataStructure.Trees.Methods;

import DataStructure.Trees.TreeNode;

/**
 * Created by Nikhil on 1/11/2017 12:29 AM.
 */
public class SizeOfATree {
    private static int sizeOfATree(TreeNode root){
        if(root == null){
            return 0;
        }
        return (sizeOfATree(root.left) + 1 + sizeOfATree(root.right));
    }
}
