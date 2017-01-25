package GeeksForGeeks.CodingProblems.Trees.Set4;

import GeeksForGeeks.CodingProblems.Trees.BinaryTree;
import GeeksForGeeks.CodingProblems.Trees.Set1.ConstructBST;
import GeeksForGeeks.CodingProblems.Trees.TreeNode;

import java.util.*;

/**
 * Created by Nikhil on 1/25/2017 2:44 PM.
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
        TempNode tempNode = new TempNode(0);
        maxSumToLeafRec(root, path, 0, tempNode);               // at any level number of nodes = 2^level = 3rd level = 2^3= 8 nodes as leaf. and 8-1 above it as internal nodes
        System.out.println("Sum = " + tempNode.maxSum);// so total = 2^3 = (2^3 -1) = 8+7=15
    }


    private static void maxSumToLeafRec(TreeNode root, int[] path, int level, TempNode maxSumNode){
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
    static class TempNode{
        int maxSum = 0;

        public TempNode(int maxSum) {
            this.maxSum = maxSum;
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
        BinaryTree tree = ConstructBST.constructBSTLeftInclined();
        maxSumToLeaf(tree.getRoot());
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
