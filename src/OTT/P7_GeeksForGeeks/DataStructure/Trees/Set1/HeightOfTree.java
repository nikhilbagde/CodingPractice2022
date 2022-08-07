package OTT.P7_GeeksForGeeks.DataStructure.Trees.Set1;

import OTT.P7_GeeksForGeeks.DataStructure.Trees.BinaryTree;
import OTT.P7_GeeksForGeeks.DataStructure.Trees.TreeNode;

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
        BinaryTree tree = ConstructBST.constructBinarySearchTree();
        tree.getRoot().left.left.left.right = new TreeNode(3);
        tree.getRoot().left.left.left.right.left = new TreeNode(1);

        int height = heightOfTree(tree.getRoot());
        System.out.println(height);

        int height2 = heightOfTree2(tree.getRoot());
        System.out.println(height2);

    }

    private static int heightOfTree2(TreeNode node){

        if(node == null) return 0;
        if(node.left == null && node.right==null) return 0;

        int leftHeight = heightOfTree(node.left);
        int rightHeight = heightOfTree(node.right);
        int currentHeight  = 1;

        return currentHeight + Math.max(leftHeight, rightHeight);
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