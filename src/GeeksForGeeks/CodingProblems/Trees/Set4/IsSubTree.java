package GeeksForGeeks.CodingProblems.Trees.Set4;

import GeeksForGeeks.CodingProblems.Trees.BinaryTree;
import GeeksForGeeks.CodingProblems.Trees.Set1.ConstructBST;
import GeeksForGeeks.CodingProblems.Trees.TreeNode;

/**
 * Created by Nikhil on 1/25/2017 2:32 AM.
 */
public class IsSubTree {
    private static boolean isSubTree(TreeNode root1, TreeNode root2){
        if(root1==null) return false;                   //first tree is null so no subtree possible
        if(root2==null) return true;                    //root1 is not null but root2 is, meaning null is subset of tree1. Yes

        //search for root2 position in tree1
        if(root1.value == root2.value && isIdentical(root1, root2)) {
               return true;
        }
        return isSubTree(root1.left, root2) || isSubTree(root1.right, root2);
    }
    private static boolean isIdentical(TreeNode root1, TreeNode root2){
        if(root1==null && root2==null) return true;
        if(root1==null || root2==null) return false;
        return root1.value == root2.value
                && isIdentical(root1.left, root2.left)
                && isIdentical(root1.right, root2.right);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // TREE 1
        /* Construct the following tree
              26
             /   \
            10     3
           /    \     \
          4      6      3
           \
            30  */

        tree.setRoot(new TreeNode(26));
        tree.getRoot().right = new TreeNode(3);
        tree.getRoot().right.right = new TreeNode(3);
        tree.getRoot().left = new TreeNode(10);
        tree.getRoot().left.left = new TreeNode(4);
        tree.getRoot().left.left.right = new TreeNode(30);
        tree.getRoot().left.right = new TreeNode(6);

        BinaryTree tree1 = new BinaryTree();

        // TREE 2
        /* Construct the following tree
           10
         /    \
         4      6
          \
          30  */

        tree1.setRoot(new TreeNode(10));
        tree1.getRoot().right = new TreeNode(6);
        tree1.getRoot().left = new TreeNode(4);
        tree1.getRoot().left.right = new TreeNode(30);
        
        boolean result = isSubTree(tree.getRoot(), tree1.getRoot());
        System.out.println("result = " + result);
    }
}
