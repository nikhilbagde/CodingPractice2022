package GeeksForGeeks.CodingProblems.Trees.Set3;

import GeeksForGeeks.CodingProblems.Trees.BinaryTree;
import GeeksForGeeks.CodingProblems.Trees.TreeNode;

/**
 * Created by Nikhil on 1/20/2017 2:17 PM.
 */
public class RootToLeafSumToGivenNumber {

    //wrong
    private static boolean rootToLeafSumEquals(TreeNode root, int sum){
        if(root==null) return sum==0;
        else {//correction return true -> return sum==0                         //correction added extra else part
            if (root.left == null && root.right == null && root.value == sum) return true;
            if (root.left != null && (root.value + root.left.value) < sum)
                return rootToLeafSumEquals(root.left, sum - (root.value));
            if (root.right != null && (root.value + root.right.value) < sum)
                return rootToLeafSumEquals(root.right, sum - (root.value));
            else
                return false;
        }
    }
    //right
    private static boolean rootToLeafSumEquals2(TreeNode root, int sum){
        if(root==null) return sum==0;
        else {//correction return true -> return sum==0                         //correction added extra else part
            boolean flag = false;

            int subSum = sum - root.value;

            if( sum == root.value && root.left==null && root.right==null) return true;
            if(root.left!=null) flag = flag || rootToLeafSumEquals2(root.left, sum - root.value);
            if(root.right!=null) flag = flag || rootToLeafSumEquals2(root.right, sum - root.value);

            return flag;
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.setRoot(new TreeNode(10));
        tree.getRoot().left = new TreeNode(8);
        tree.getRoot().right = new TreeNode(2);
        tree.getRoot().left.left = new TreeNode(5);
        tree.getRoot().left.right = new TreeNode(3);
        tree.getRoot().right.left = new TreeNode(2);

        boolean result = rootToLeafSumEquals2(tree.getRoot(),21);
        System.out.println("result = " + (result ? "Yes" : "NO"));
    }
}
