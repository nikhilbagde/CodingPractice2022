package Books.B1_CrackingTheCodingInterview.Chapter4TreeGraph;

import OTT.P7_GeeksForGeeks.DataStructure.Trees.Set1.ConstructBST;
import OTT.P7_GeeksForGeeks.DataStructure.Trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Nikhil on 2/15/2017 12:40 AM.
 * List of Depths: Given a binary tree, design an algorithm which creates a linked list of all the nodes
 * at each depth (e.g., if you have a tree with depth D, you'll have D linked lists).
 * Hints:
 * #107, - Try modifying graph search algorithms to track depth of root
 * #123, - Array or hashMap from level number > Node at that level might be helpful
 * #135 - Write both DFS and BFS algorithm for this.
 */
public class P3ListsOfDepths {
    public static ArrayList<Queue<TreeNode>> createListsByLevel(TreeNode root) {
        ArrayList<Queue<TreeNode>> list = new ArrayList<>();
        createListsByLevel(root, list, 0);
        return list;
    }

    //pre order traversal  DFS
    private static void createListsByLevel(TreeNode root, ArrayList<Queue<TreeNode>> lists, int level) {
        if (root == null) return;
        Queue<TreeNode> list = null;
        if (lists.size() == level) {         // 0 == 0
            list = new LinkedList<>();
            lists.add(list);
        } else {
            list = lists.get(level);
        }
        list.add(root);
        createListsByLevel(root.left, lists, level + 1);
        createListsByLevel(root.right, lists, level + 1);
    }

    //BFS
    private static ArrayList<Queue<TreeNode>> listbylevel(TreeNode root) {
        ArrayList<Queue<TreeNode>> resultList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            resultList.add(queue);
            Queue<TreeNode> parentLevel = queue;    //use current queue as auxiliary queue
            queue = new LinkedList<>();             //make it a new queue to flush our parent level nodes

            for (TreeNode node : parentLevel) {     //notice for loop, we need to add all nodes of the level
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return resultList;
    }

    public static void printResultList(ArrayList<Queue<TreeNode>> lists) {
        for (Queue<TreeNode> list : lists) {
            for (TreeNode root : list) {
                System.out.print(root.value + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        OTT.P7_GeeksForGeeks.DataStructure.Trees.BinaryTree tree = ConstructBST.constructBinaryTree();
        ArrayList<Queue<TreeNode>> lists = createListsByLevel(tree.getRoot());
        System.out.println("DFS");
        printResultList(lists);

        System.out.println("BFS");
        printResultList(listbylevel(tree.getRoot()));

    }


}


