package OTT.P7_GeeksForGeeks.DataStructure.Trees.Set3;

import OTT.P7_GeeksForGeeks.DataStructure.Trees.BinaryTree;
import OTT.P7_GeeksForGeeks.DataStructure.Trees.TreeNode;

/**
 * Created by Nikhil on 1/22/2017 4:36 PM.
 */
public class KDistanceFromRoot {
    //Time : O(n)
    // if I do return type, return root.value when k==0 it will go back to function stack left/right node which has called.
    //hence just print the value.
    private static void printKDistanceFromRoot(TreeNode root,  int k){      //changed return type from int to void
        if(root==null) return;
        if(k==0){
            System.out.println("root.value = "+root.value);
            return;     //get out of function
        }else {
        if( root.left!=null)
            printKDistanceFromRoot(root.left, k - 1);        //no need to write if root.left!=null b/c even if its null, it will return -1 in next recursion.
        if( root.right!=null)       //but save 1 recursion by adding this condition.
            printKDistanceFromRoot(root.right, k - 1);
        }
        //return -1;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
         
        /* Constructed binary tree is
                1
              /   \
             2     3
            /  \   /
           4    5 8 
        */
        tree.setRoot(new TreeNode(1));
        tree.getRoot().left = new TreeNode(2);
        tree.getRoot().right = new TreeNode(3);
        tree.getRoot().left.left = new TreeNode(4);
        tree.getRoot().left.right = new TreeNode(5);
        tree.getRoot().right.left = new TreeNode(8);
        
        printKDistanceFromRoot(tree.getRoot(), 2);
        //System.out.println("value = " + value);
    }

}
