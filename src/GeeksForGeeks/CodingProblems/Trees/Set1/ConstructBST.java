package GeeksForGeeks.CodingProblems.Trees.Set1;

import GeeksForGeeks.CodingProblems.Trees.BinaryTree;
import GeeksForGeeks.CodingProblems.Trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nikhil on 1/18/2017 7:47 AM.
 */
public class ConstructBST {
    public static BinaryTree constructBST(){
        BinaryTree tree = new BinaryTree();
        tree.insert(6);
        tree.getRoot().left = new TreeNode(3);
        tree.getRoot().left.left = new TreeNode(2);
        tree.getRoot().left.left.left = new TreeNode(1);
        tree.getRoot().left.right = new TreeNode(4);
        tree.getRoot().left.right.right = new TreeNode(5);

        tree.getRoot().right = new TreeNode(10);
        tree.getRoot().right.left = new TreeNode(8);
        tree.getRoot().right.left.left = new TreeNode(7);
        tree.getRoot().right.left.right = new TreeNode(9);
        tree.getRoot().right.right = new TreeNode(12);
        tree.getRoot().right.right.left = new TreeNode(11);
        tree.getRoot().right.right.right = new TreeNode(13);
        return tree;

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
