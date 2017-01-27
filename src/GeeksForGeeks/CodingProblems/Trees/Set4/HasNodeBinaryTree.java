package GeeksForGeeks.CodingProblems.Trees.Set4;

import GeeksForGeeks.CodingProblems.Trees.BinaryTree;
import GeeksForGeeks.CodingProblems.Trees.Set1.ConstructBST;
import GeeksForGeeks.CodingProblems.Trees.TreeNode;

/**
 * Created by Nikhil on 1/26/2017 7:05 PM.
 */
public class HasNodeBinaryTree {
    private static boolean hasNode(TreeNode root, int value){
        if(root==null) return false;
        if(root.value == value) return true;
        return hasNode(root.left, value) || hasNode(root.right, value);
    }

    public static void main(String[] args) {
        BinaryTree tree = ConstructBST.constructBinaryTree();
        boolean result = hasNode(tree.getRoot(), 99);
        System.out.println("result = " + (result ? "Present" : "Not Present"));
    }
}

 /*
/*                              height = 5;
//         6                        0
//      /     \
//    3           10                1
//   / \         /   \
//  2    4      8    12             2
// /      \    / \   /  \
// 1        5  7   9 11  13         3
//  \
//   3                              4
//  /
// 1                                5
*/