package GeeksForGeeks.CodingProblems.Trees.Set1;

import GeeksForGeeks.CodingProblems.Trees.TreeNode;

/**
 * Created by Nikhil on 1/17/2017 9:17 PM.
 */
public class DeleteTree {
    private static void deleteTree(TreeNode node){
        if(node == null) return;
        deleteTree(node.left);
        deleteTree(node.right);

        System.out.println("deleted Node " + node.value);
        node = null;
    }
}
