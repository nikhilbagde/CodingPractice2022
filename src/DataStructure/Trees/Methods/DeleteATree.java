package DataStructure.Trees.Methods;

import DataStructure.Trees.TreeNode;

/**
 * Created by Nikhil on 1/12/2017 1:47 AM.
 */
public class DeleteATree {
    private static void deleteTree(TreeNode node){
        if(node == null){
            return;
        }
        deleteTree(node.left);
        deleteTree(node.right);

        System.out.println("Deleted SLLNode is" + node.data);
        node = null;
    }
}
