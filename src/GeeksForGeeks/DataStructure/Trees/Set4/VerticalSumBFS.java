package GeeksForGeeks.DataStructure.Trees.Set4;

import GeeksForGeeks.DataStructure.Trees.BinaryTree;
import GeeksForGeeks.DataStructure.Trees.Set1.ConstructBST;
import GeeksForGeeks.DataStructure.Trees.TreeNode;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/**
 * Created by Nikhil on 1/25/2017 2:11 PM.
 */
public class VerticalSumBFS {
    private static void verticalSumBFS(TreeNode root){
        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<Integer> level = new LinkedList<>();

        Map<Integer, Integer> map = new TreeMap<>();       //changing Value= TreeNode to interger
                                                            // b/c is I have to keep it TreeNodes I will have to maintain ArrayliSt
        nodes.offer(root);
        level.offer(0);

        while(!nodes.isEmpty()){
            TreeNode currentNode = nodes.poll();
            int currentLevel = level.poll();

            map.put(currentLevel, map.containsKey(currentLevel)? map.get(currentLevel) + currentNode.value : currentNode.value);

            if(currentNode.left!=null){
                nodes.offer(currentNode.left);
                level.offer(currentLevel-1);
            }
            if(currentNode.right!=null){
                nodes.offer(currentNode.right);
                level.offer(currentLevel+1);
            }
        }
        printMap(map);
    }
    private static void printMap(Map<Integer, Integer> map){
        System.out.println("map.entrySet() = " + map.entrySet());   //Expected : map.entrySet() = [-3=2, -2=5, -1=10, 0=18, 1=35, 2=12, 3=13]
    }

    public static void main(String[] args) {
        BinaryTree tree = ConstructBST.constructBinaryTree();
        verticalSumBFS(tree.getRoot());
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
