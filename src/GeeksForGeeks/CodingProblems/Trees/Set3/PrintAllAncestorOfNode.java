package GeeksForGeeks.CodingProblems.Trees.Set3;

import GeeksForGeeks.CodingProblems.Trees.BinaryTree;
import GeeksForGeeks.CodingProblems.Trees.Set1.ConstructBST;
import GeeksForGeeks.CodingProblems.Trees.TreeNode;

/**
 * Created by Nikhil on 1/22/2017 5:22 PM.
 */
public class PrintAllAncestorOfNode {
    private static boolean printAncestors(TreeNode root, int value){            //boolean b/c we will never give root's value. No ancester for root.
        if(root==null || root.left==null && root.right==null) return true;
        if(root.value == value) return true;
        if(printAncestors(root.left, value) || printAncestors(root.right, value)) {
            System.out.println("root.value = " + root.value);
            return true;                                                        //after printing its first parent, we need to go up the ladder hence return true.
        }                                                                       //its calling function would catch true and again print root at above level. Cool!
        return false;           //nothing happened return false.
    }

    public static void main(String[] args) {
        BinaryTree tree = ConstructBST.constructBST();
        if(!printAncestors(tree.getRoot(), 5)){
            System.out.println("Did not found!");
        }
    }
}
/*
//         6
//      /     \
//    3           10
//   / \         /   \
//  2    4      8    12
// /      \    / \   /  \
// 1        5  7   9 11  13
 */

