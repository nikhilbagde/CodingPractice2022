package GeeksForGeeks.CodingProblems.Trees.Set2;

import GeeksForGeeks.CodingProblems.Trees.BinaryTree;
import GeeksForGeeks.CodingProblems.Trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Nikhil on 1/19/2017 4:50 PM.
 */
public class LevelOrderTraversal {

    //Method 1 : Using Queue
    private static void levelOrder(TreeNode root, int level){
        Queue<TreeNode> nodeQueue = new LinkedList<>();                     //Step 1: Create a queue to store nodes.
        Queue<Integer> levelQ = new LinkedList<>();                         //        & another queue to keep track of nodes<->level position

        int currentLevel = 0;
        nodeQueue.add(root);                                                //Step 2: Add root to queue and zero level to another queue.
        levelQ.add(currentLevel);

        while(!nodeQueue.isEmpty()){                                        //Step 3: remove root, and its level. Till queue is empty.
            TreeNode currentNode = nodeQueue.poll();
            currentLevel = levelQ.poll();

            if(currentLevel == level){                                              //process current Node and level
                System.out.println("level = "+ currentLevel + " Nodes value = " + currentNode.value);
            }

           // if(currentNode.left!=null || currentNode.right!=null) {
                //currentLevel++;                                             //Step 4: Add its (left | right)-> NodesQ
                if (currentNode.left != null) {                             //          and corresponding (levels)->LevelQ
                    nodeQueue.add(currentNode.left);
                    levelQ.add(currentLevel+1);
                }
                if (currentNode.right != null) {
                    nodeQueue.add(currentNode.right);
                    levelQ.add(currentLevel+1);
                }
                //levelQ.add(++currentLevel);
           // }
        }
    }

    //Method 2 : Recursive
    private static int getHeightOfTree(TreeNode root){
        if(root==null) return 0;
        else return 1 + Math.max(getHeightOfTree(root.left), getHeightOfTree(root.right));
    }
    private static void levelWise(TreeNode root){
        int h = getHeightOfTree(root);
        for (int i = 1; i <= h; i++) {
            printLevelRec(root, i);
        }
    }
    private static void printLevelRec(TreeNode root, int level){
        if(root==null) return;
        if(level==1) System.out.println("root.value = " + root.value);
        else if(level>1) {
            printLevelRec(root.left, level-1);
            printLevelRec(root.right, level-1);
        }
    }

    public static void main(String[] args) {
        BinaryTree tree_level = new BinaryTree();
        tree_level.setRoot(new TreeNode(1));
        tree_level.getRoot().left = new TreeNode(2);
        tree_level.getRoot().right = new TreeNode(3);
        tree_level.getRoot().left.left = new TreeNode(4);
        tree_level.getRoot().left.right = new TreeNode(5);

        //Method 1
        levelOrder(tree_level.getRoot(), 2);
        
        int height = getHeightOfTree(tree_level.getRoot());
        System.out.println("height = " + height);

        //Method 2
        printLevelRec(tree_level.getRoot(), 3);

        //
        levelWise(tree_level.getRoot());
    }
}
