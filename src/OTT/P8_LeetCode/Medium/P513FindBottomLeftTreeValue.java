package LeetCode.Medium;

import OTT.P7_GeeksForGeeks.DataStructure.Trees.BinaryTree;
import OTT.P7_GeeksForGeeks.DataStructure.Trees.Set1.ConstructBST;

/**
 * Created by Nikhil on 4/2/2017 7:13 PM.
 */
public class P513FindBottomLeftTreeValue {
    public static void main(String[] args) {
        BinaryTree tree = ConstructBST.constructBinaryTree();
        System.out.println(findBottomLeftValue(tree.getRoot()));
    }

    private static int findBottomLeftValue(OTT.P7_GeeksForGeeks.DataStructure.Trees.TreeNode root) {
        int h = getHeight(root);        //5
        java.util.Queue<OTT.P7_GeeksForGeeks.DataStructure.Trees.TreeNode> q = new java.util.LinkedList<>();
        java.util.Queue<Integer> l = new java.util.LinkedList<>();
        q.offer(root);
        l.offer(0);

        while (!q.isEmpty()) {
            OTT.P7_GeeksForGeeks.DataStructure.Trees.TreeNode c = q.poll();
            int cl = l.poll();

            if (cl == h) {
                return c.value;
            }
            if (c.left != null) {
                q.offer(c.left);
                l.offer(cl + 1);
            }
            if (c.right != null) {
                q.offer(c.right);
                l.offer(cl + 1);
            }
        }
        return -1;
    }

    private static int getHeight(OTT.P7_GeeksForGeeks.DataStructure.Trees.TreeNode node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 0;
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
