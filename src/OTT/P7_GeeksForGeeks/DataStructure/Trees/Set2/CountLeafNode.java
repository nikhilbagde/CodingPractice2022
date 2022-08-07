package OTT.P7_GeeksForGeeks.DataStructure.Trees.Set2;

import OTT.P7_GeeksForGeeks.DataStructure.Trees.TreeNode;

/**
 * Created by Nikhil on 1/17/2017 10:02 PM.
 */
public class CountLeafNode {
    private static int countLeafNodes(TreeNode node){
        if(node==null) return 0;
        if(node.left==null && node.right==null) return 1;
        return countLeafNodes(node.left) + countLeafNodes(node.right);  //adding!
    }
}
