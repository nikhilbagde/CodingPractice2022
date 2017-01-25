package GeeksForGeeks.CodingProblems.Trees.Set1;


import GeeksForGeeks.CodingProblems.Trees.TreeNode;

/**
 * Created by Nikhil on 1/17/2017 9:13 PM.
 */
public class IdentialTree {
    private static boolean isIdenticalTrees(TreeNode node1, TreeNode node2){
        if(node1 == null && node2 ==null) return true;                                      //what if both are null
        if(node1 != null && node2 == null || node1 == null && node2 != null ) return false; //what if either is only null
        return node1.value == node2.value                                                   //otherwise check data and left and right
                && isIdenticalTrees(node1.left, node2.left)                                         //subtree.
                && isIdenticalTrees(node1.right, node2.right);

        //return false;
    }

    public static void main(String[] args) {
        GeeksForGeeks.CodingProblems.Trees.BinaryTree tree1 = ConstructBST.constructBST();
        GeeksForGeeks.CodingProblems.Trees.BinaryTree tree2 = ConstructBST.constructBST();
        boolean result = isIdenticalTrees(tree1.getRoot(), tree2.getRoot());
        System.out.println(result);
    }
}
