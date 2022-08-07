package OTT.P7_GeeksForGeeks.DataStructure.Trees.Set1;

import OTT.P7_GeeksForGeeks.DataStructure.Trees.TreeNode;

/**
 * Created by Nikhil on 1/18/2017 11:52 AM.
 */
public class LeafNodeCount {
    private static int countLeaf(TreeNode root){
        if(root==null) return 0;
        if(root.left==null && root.right==null) return 1;
        else
            return countLeaf(root.left) + countLeaf(root.right);
    }

}
