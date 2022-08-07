package LeetCode.Patterns.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class LC_637_Average_of_Levels_in_Binary_Tree {
    
    public static List<Double> averageOfLevels(TreeNode root) {
        if(root==null)
            return new ArrayList<>();

        List<Double> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while(queue.size()!=0){
            int size = queue.size();
            double sum = 0.0;
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                sum += currentNode.val;

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            result.add(sum/ size);
        }
        return result;
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
        List<Double> result = averageOfLevels(root);
        System.out.println("result = " + result);

        List<Double> resultDFS = averageOfLevelsDFS(root);
        System.out.println("resultDFS = " + resultDFS);
    }
    
    //DFS approach
    public static List < Double > averageOfLevelsDFS(TreeNode root) {
        List < Integer > count = new ArrayList < > ();
        List < Double > sum = new ArrayList < > ();
        average(root, 0, sum, count);
        for (int i = 0; i < sum.size(); i++)
            sum.set(i, sum.get(i) / count.get(i));
        return sum;
    }

    /**
     *          3
     *        /   \
     *      9     20
     *            /   \
     *         15     7
     */
    public static void average(TreeNode t, int i, List < Double > sum, List < Integer > count) {
        if (t == null)
            return;
        if (i < sum.size()) {
            sum.set(i, sum.get(i) + t.val);
            count.set(i, count.get(i) + 1);
        } else {
            sum.add(1.0 * t.val);
            count.add(1);
        }
        average(t.left, i + 1, sum, count);
        average(t.right, i + 1, sum, count);
    }
}
