package LeetCode.Medium;



import java.util.Collections;
import java.util.List;

/**
 * Created by Nikhil on 4/3/2017 12:21 PM.
 */
public class P515FindLargestValueinEachTreeRow {
    public static void main(String[] args) {
        TreeNode root = prepareATree(new TreeNode(3));
        List<Integer> list = largestValues(root);
        System.out.println("list = " + list);
    }

    public static java.util.List<Integer> largestValues(TreeNode root) {
        java.util.Queue<TreeNode> nodes = new java.util.LinkedList<>();
        java.util.Queue<Integer> level = new java.util.LinkedList<>();
        java.util.ArrayList<Integer> list = new java.util.ArrayList<>();

        java.util.Map<Integer, java.util.ArrayList<Integer>> map = new java.util.HashMap<>();


        nodes.offer(root);
        level.offer(1);

        while (!nodes.isEmpty()) {
            TreeNode currentNode = nodes.poll();
            int currentLevel = level.poll();

            java.util.ArrayList<Integer> listTemp = map.get(currentLevel) == null ? new java.util.ArrayList<>() : map.get(currentLevel);
            listTemp.add(currentNode.val);
            map.put(currentLevel, listTemp);

            if (currentNode.left != null) {
                nodes.offer(currentNode.left);
                level.offer(currentLevel + 1);
            }
            if (currentNode.right != null) {
                nodes.offer(currentNode.right);
                level.offer(currentLevel + 1);
            }
        }

        for (java.util.Map.Entry<Integer, java.util.ArrayList<Integer>> entry : map.entrySet()) {
            java.util.ArrayList<Integer> cList = entry.getValue();
            java.util.Collections.sort(cList, Collections.reverseOrder());
            System.out.println(entry.getKey() + " " + (cList.get(0) == null ? "-1" : cList.get(0)));
        }
        return list;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode prepareATree(TreeNode root){

        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left=  new TreeNode(15);
        root.right.right = new TreeNode(7);
        return root;
    }
}
