package DataStructure.Trees.Methods;

import DataStructure.Trees.TreeNode;

/**
 * Created by Nikhil on 1/12/2017 1:39 AM.
 */
public class MaxDepth {
    private static int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
    private static int maxDepth2(TreeNode node){
        if(node == null){
            return 0;
        }else{
            int leftDepth = maxDepth2(node.left);
            int rightDepth = maxDepth2(node.right);

            if(leftDepth > rightDepth){
                return leftDepth +1;
            }else
                return rightDepth +1;
        }

    }
}
