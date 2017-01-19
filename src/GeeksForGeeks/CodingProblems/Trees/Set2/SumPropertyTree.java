package GeeksForGeeks.CodingProblems.Trees.Set2;

import GeeksForGeeks.CodingProblems.Trees.BinaryTree;
import GeeksForGeeks.CodingProblems.Trees.TreeNode;

/**
 * Created by Nikhil on 1/19/2017 4:41 PM.
 */
// tree where children sum is equal to root
public class SumPropertyTree {
    private static boolean isSumPropertyTree(TreeNode root){
        if(root==null || root.left==null && root.right==null) return true;
        else{
            int lv = root.left!=null ? root.left.value : 0;
            int rv = root.right!=null ? root.right.value : 0;
            return lv+rv == root.value && isSumPropertyTree(root.left) && isSumPropertyTree(root.right);
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.setRoot(new TreeNode(10));
        tree.getRoot().left = new TreeNode(8);
        tree.getRoot().right = new TreeNode(2);
        tree.getRoot().left.left = new TreeNode(3);
        tree.getRoot().left.right = new TreeNode(5);
        tree.getRoot().right.right = new TreeNode(2);
        
        boolean result = isSumPropertyTree(tree.getRoot());
        System.out.println("Is Sum property true ? = " + (result ? "Yes" :  "NO"));
    }
}
