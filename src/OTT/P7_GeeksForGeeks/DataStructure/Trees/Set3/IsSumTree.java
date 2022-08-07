package OTT.P7_GeeksForGeeks.DataStructure.Trees.Set3;

import OTT.P7_GeeksForGeeks.DataStructure.Trees.BinaryTree;
import OTT.P7_GeeksForGeeks.DataStructure.Trees.TreeNode;

/**
 * Created by Nikhil on 1/22/2017 5:35 PM.
 */
public class IsSumTree {
    private static boolean isSumTree(TreeNode root){        //If ELSE is must
        if(root==null || root.left==null && root.right==null) return true;            //wrong// check for if it reaches leaf node or root null and return true and not flase;
        else {
            int lv = root.left != null ? root.left.value : 0;
            int rv = root.right != null ? root.right.value : 0;

            return (root.value == lv + rv)
                    && isSumTree(root.left)
                    && isSumTree(root.right);
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

        System.out.println(isSumTree(tree.getRoot()) ? "Yes" : "No" );
    }
}

/*
                10
               /  \
              8    2
             3 5    2
 */
