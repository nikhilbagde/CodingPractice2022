package GeeksForGeeks.CodingProblems.Trees.Set2;

import GeeksForGeeks.CodingProblems.Trees.TreeNode;

/**
 * Created by Nikhil on 1/17/2017 9:46 PM.
 */
public class LowestCommonAncester {
    private static TreeNode LCA(TreeNode node, int a, int b){
        if(node==null) return null;
        if(node.value < a && node.value < b) LCA(node.right, a, b);
        if(node.value > a && node.value > b) LCA(node.left, a, b);
        return node;
    }
}
