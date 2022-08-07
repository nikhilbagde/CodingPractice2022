package LeetCode.Patterns.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class LC_111_Minimum_Depth_of_Binary_Tree {
    public static int minDepth(TreeNode root) {
        if(root==null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while(queue.size()!=0){
            int nodeCount  = queue.size();
            level++;
            while(nodeCount>0) {
                TreeNode currentNode = queue.poll();

                if (currentNode!=null && currentNode.left == null && currentNode.right == null) {
                    return level;
                }

                if (currentNode!=null && currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode!=null && currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
                nodeCount--;
            }
        }
        return level;
    }

    public static TreeNode prepareATree(TreeNode root){
        root.val=3;
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left=  new TreeNode(15);
        root.right.right = new TreeNode(7);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = prepareATree(new TreeNode());
        int minDepth = minDepth(root);
        System.out.println("minDepth = " + minDepth);
    }
}
