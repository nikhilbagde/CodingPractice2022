package GeeksForGeeks.DataStructure.Trees.Set2;

import GeeksForGeeks.DataStructure.Trees.BinaryTree;
import GeeksForGeeks.DataStructure.Trees.TreeNode;

import java.util.Arrays;

/**
 * Created by Nikhil on 1/17/2017 9:38 PM.
 */
public class PrintPathToLeaf {
    private static void printPathToLeaf(TreeNode node) {
        int[] path = new int[10];
        int length = 0;
        printPathToLeafRec(node, path, length);
    }

    /**
     *
     * @param node
     * @param path
     * @param length
     * @Algorithm
     * 1. add node to an array
     * 2. if its leaf node then print an array.
     * 3. if its not a leaf node, call recursevly its left and right
     * 4. Once done with left mode and then right most before leaving method set array[length-1] = 0 / list.remove(list.length-1) to clear array before going up.
     */
    private static void printPathToLeafRec(TreeNode node, int[] path, int length) {
        if (node == null) return;

        path[length++] = node.value;
        if (node.left == null && node.right == null) {
            printPath(path);
            path[length-1]=0;                               //to remove that value once its printed
        } else {
            printPathToLeafRec(node.left, path, length);
            printPathToLeafRec(node.right, path, length);
            path[length-1]=0;                               //same with each level while going down the stack put length-1 element position to zero or null
                                                            // length -1 b/c we increment once we add element.
        }
    }

    private static void printPath(int[] path) {
        System.out.println(Arrays.toString(path));
    }

    public static void main(String[] args) {
        BinaryTree tree = GeeksForGeeks.DataStructure.Trees.Set1.ConstructBST.constructBinarySearchTree();
        tree.getRoot().left.left.left.right = new TreeNode(3);
        tree.getRoot().left.left.left.right.left = new TreeNode(1);

        printPathToLeaf(tree.getRoot());


    }

}

/*
/*                                         height = 5;
//                  6                        0
//              /     \
//          3           10                 1
//        / \         /   \
//      2    4      8    12              2
//   /  \  / \    /  \    / \
// 1        5  7   9  11  13         3
//   \
//    3                                     4
//  /
// 1                                        5
*/

