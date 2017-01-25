package GeeksForGeeks.CodingProblems.Trees.Set1;

import GeeksForGeeks.CodingProblems.Trees.BinaryTree;
import GeeksForGeeks.CodingProblems.Trees.TreeNode;

/**
 * Created by Nikhil on 1/17/2017 8:53 PM.
 */
public class HeightOfTree {
    private static int heightOfTree(TreeNode node){
        if(node == null) return 0;
        if(node.left == null && node.right==null) return 0;
        return 1 + Math.max(heightOfTree(node.left), heightOfTree(node.right));
    }

    public static void main(String[] args) {
        BinaryTree tree = ConstructBST.constructBST();
        tree.getRoot().left.left.left.right = new TreeNode(3);
        tree.getRoot().left.left.left.right.left = new TreeNode(1);

        int height = heightOfTree(tree.getRoot());
        System.out.println(height);

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