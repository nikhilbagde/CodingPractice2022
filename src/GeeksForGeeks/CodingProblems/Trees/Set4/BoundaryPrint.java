package GeeksForGeeks.CodingProblems.Trees.Set4;

import GeeksForGeeks.CodingProblems.Trees.BinaryTree;
import GeeksForGeeks.CodingProblems.Trees.Set1.ConstructBST;
import GeeksForGeeks.CodingProblems.Trees.TreeNode;

/**
 * Created by Nikhil on 1/25/2017 9:57 PM.
 */
public class BoundaryPrint {
/*
Thought process :
1. Print nodes from root to leftMost node
2. Then Print leaf nodes from left to right
3. Then print right nodes from bottom up fashion
(make sure nodes are not repeated)
 */
    private static void printBoundary(TreeNode root){
        if(root!=null) {
            System.out.println(root.value+" ");
            printLeftBoundary(root.left);
            printLeaves(root.left);
            printLeaves(root.right);
            printRightBoundary(root.right);
        }
    }
    private static void printLeftBoundary(TreeNode root){
        if(root!=null){                                     //Pre Order
            if(root.left!=null){
                System.out.print(root.value + " ");         //first print node value
                printLeftBoundary(root.left);               //then go to left in deep
            }else if(root.right!=null){                     //once to extreme left, check for its right
                System.out.println(root.value + " ");       // right will again check for left first then its right
                printLeftBoundary(root.right);              //then print
            }
            //no logic for lead node here. To avoid duplicates.
        }
    }
    private static void printLeaves(TreeNode root){
        if(root!=null){
            printLeaves(root.left);
            if(root.left==null && root.right==null) System.out.println(root.value+" ");
            printLeaves(root.right);
        }
    }
    private static void printRightBoundary(TreeNode root){
        if(root!=null){                                     //InOrder / PostOrder
            if(root.right!=null){
                printRightBoundary(root.right);             //first we have to go to end then print
                System.out.println(root.value +" ");
            }else if(root.left!=null){
                printRightBoundary(root.left);
                System.out.println(root.value +" ");
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = ConstructBST.constructBinaryTree();
        printBoundary(tree.getRoot());
    }

}

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