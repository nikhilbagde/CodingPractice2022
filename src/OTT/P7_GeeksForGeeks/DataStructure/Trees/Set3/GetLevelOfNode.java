package OTT.P7_GeeksForGeeks.DataStructure.Trees.Set3;

import OTT.P7_GeeksForGeeks.DataStructure.Trees.BinaryTree;
import OTT.P7_GeeksForGeeks.DataStructure.Trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Nikhil on 1/22/2017 4:56 PM.
 /*
 Similar Problems:
 1. Get level of Nodes
 2. Print Level Order Traversal
 3. Has path sum equal to given sum.
 4. Root to leaf sum with given number - DFS would be more efficient.
 5. Vertical order traversal.
 6. Minimum path or depth from Root
 */

public class GetLevelOfNode {
    private static int getLevelOfNode(BinaryTree tree ,TreeNode node){
        return getLevelOfNodeUtil(tree.getRoot(), node);
    }
    private static int getLevelOfNodeUtil(TreeNode root, TreeNode node){
        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<Integer> level = new LinkedList<>();

        nodes.offer(root);
        level.offer(1);

        while(!nodes.isEmpty()){
            TreeNode  node1 = nodes.poll();
            int currLevel = level.poll();

            if(node1.value == node.value) return currLevel;

            if(node1.left!=null){
                nodes.offer(node1.left);
                level.offer(currLevel+1);
            }
            if(node1.right!=null){
                nodes.offer(node1.right);
                level.offer(currLevel+1);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        /* Constructing tree given in the above figure */
        /*
                        3
                       / \
                      2   5
                     / \  
                    1   4
         */
        tree.setRoot(new TreeNode(3));
        tree.getRoot().left = new TreeNode(2);
        tree.getRoot().right = new TreeNode(5);
        tree.getRoot().left.left = new TreeNode(1);
        tree.getRoot().left.right = new TreeNode(4);

        int level = getLevelOfNode(tree, new TreeNode(1));
        System.out.println("level = " + level);
    }
}
