package OTT.P7_GeeksForGeeks.DataStructure.Trees.Set4;

import OTT.P7_GeeksForGeeks.DataStructure.Trees.BinaryTree;
import OTT.P7_GeeksForGeeks.DataStructure.Trees.Set1.ConstructBST;
import OTT.P7_GeeksForGeeks.DataStructure.Trees.TreeNode;

import java.util.*;

/**
 * Created by Nikhil on 1/25/2017 2:44 PM.
 * Using BFS is not efficient. Henced changed it to dfs using recursion.
 * Used exactly same approach of getting path to leaf node.
 */
public class MaxSumRootToLead {
    // would not be efficient
    private static void maxSumRootToLeaf(TreeNode root){
        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<Integer> levels = new LinkedList<>();

        Map<Integer, List<Integer>> map = new HashMap<>();

        nodes.offer(root);
        levels.offer(0);

    }
    private static int getHeight(TreeNode root){
        if(root==null) return 0;
        if(root.left==null && root.right==null) return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
    private static void maxSumToLeaf(TreeNode root){
        int height = getHeight(root);
        int[] path = new int[(int) Math.pow(2,height) + (int) Math.pow(2, height)];       //height will help me to understand total max possible size of a tree
        SumNode sumNode = new SumNode(0);
        maxSumToLeafRec(root, path, 0, sumNode);               // at any level number of nodes = 2^level = 3rd level = 2^3= 8 nodes as leaf. and 8-1 above it as internal nodes
        System.out.println("Sum = " + sumNode.maxSum);// so total = 2^3 = (2^3 -1) = 8+7=15
    }


    private static void maxSumToLeafRec(TreeNode root, int[] path, int level, SumNode maxSumNode){
        if(root==null) return;
        path[level++]= root.value;
        if(root.left==null && root.right==null){
            //int maxSum = 0;
            int newMaxSum = getMaximum(path);
            maxSumNode.maxSum = newMaxSum > maxSumNode.maxSum ? newMaxSum : maxSumNode.maxSum;
            path[level-1]=0;
        }else {
            maxSumToLeafRec(root.left, path, level, maxSumNode);
            maxSumToLeafRec(root.right, path, level, maxSumNode);
            path[level-1]=0;
        }
    }

    private static int getMaximum(int[] path){
        int sum = 0;
        for (int i = 0; i < path.length; i++) {
            sum += path[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        BinaryTree tree = ConstructBST.constructBinaryTree();
        maxSumToLeaf(tree.getRoot());       //expected 6 + 10 + 12 + 13 = 41 Perfect!
    }

    static class SumNode {
        int maxSum = 0;

        public SumNode(int maxSum) {
            this.maxSum = maxSum;
        }
    }

}
  /*
            /*                              height = 5;
            //         6                        0
            //      /     \
            //    3           10                1
            //   / \         /   \
            //  2    4      8    12             2
            // /      \    / \   /  \
            // 1        5  7   9 11  13         3
            //  \
            //   3                              4
            //  /
            // 1                                5
            */
