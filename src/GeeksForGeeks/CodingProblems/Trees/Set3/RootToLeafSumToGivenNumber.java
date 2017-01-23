package GeeksForGeeks.CodingProblems.Trees.Set3;

import GeeksForGeeks.CodingProblems.Trees.BinaryTree;
import GeeksForGeeks.CodingProblems.Trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Nikhil on 1/20/2017 2:17 PM.
 */
public class RootToLeafSumToGivenNumber {


    /*
    Similar Problems:
    1. Get level of Nodes
    2. Print Level Order Traversal
    3. Has path sum equal to given sum.
    4. Root to leaf sum with given number - DFS would be more efficient.
    5. Vertical order traversal.
    6. Minimum path or depth from Root
     */

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
    //DFS would be efficient.
    private static boolean hasPathSumDFS(TreeNode root, int sum){
        if(root==null) return false;
        if(root.value == sum && root.left ==null && root.right == null) return true;
        return hasPathSumDFS(root.left, sum - root.value)
                || hasPathSumDFS(root.right, sum - root.value);
    }
    //I think using queue meaning going level wise is not efficient.
    private static boolean hasPathSumBFS(TreeNode root, int sum){
        if(root==null) return false;
        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<Integer> values = new LinkedList<>();     //new queue not for level but to keep track of values

        nodes.offer(root);
        values.offer(root.value);

        while(!nodes.isEmpty()){
            TreeNode node = nodes.poll();
            int sumValue = values.poll();

            //now check if we reached end of queue meaning check for leaf node  + == sum of values
            if(node.left==null && node.right==null && sum == sumValue){
                return true;
            }

            if(node.left!=null){
                nodes.offer(node.left);
                values.offer(sumValue + node.left.value);
            }

            if(node.right!=null){
                nodes.offer(node.right);
                values.offer(sumValue + node.right.value);
            }

        }
        return false;
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
