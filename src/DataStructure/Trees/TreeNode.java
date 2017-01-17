package DataStructure.Trees;

/**
 * Created by Nikhil on 9/14/2016.
 */
public class TreeNode {
    public int data;
    public TreeNode left, right, parent;

    TreeNode(int data){
        this.data = data;
        left = right = parent = null;
    }


}
