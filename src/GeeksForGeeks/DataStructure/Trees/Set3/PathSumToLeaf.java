package GeeksForGeeks.DataStructure.Trees.Set3;

import GeeksForGeeks.DataStructure.Trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Nikhil on 1/22/2017 4:14 PM.
 */
    /*
    Similar Problems:
    1. Get level of Nodes
    2. Print Level Order Traversal
    3. Has path sum equal to given sum.
    4. Root to leaf sum with given number - DFS would be more efficient.
    5. Vertical order traversal.
    6. Minimum path or depth from Root
     */

public class PathSumToLeaf {
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

}
