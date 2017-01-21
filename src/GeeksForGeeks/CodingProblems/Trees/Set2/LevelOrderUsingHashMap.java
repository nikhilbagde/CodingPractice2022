package GeeksForGeeks.CodingProblems.Trees.Set2;

import GeeksForGeeks.CodingProblems.Trees.BinaryTree;
import GeeksForGeeks.CodingProblems.Trees.Set1.ConstructBST;
import GeeksForGeeks.CodingProblems.Trees.TreeNode;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by Nikhil on 1/19/2017 9:40 PM.
 */
public class LevelOrderUsingHashMap {
    private static HashMap<Integer, List<TreeNode>> levelWiseTraversal(TreeNode root){
        Queue<TreeNode> nodesQ = new LinkedList<>();
        Queue<Integer> levelQ = new LinkedList<>();
        HashMap<Integer, List<TreeNode>> levelNodeMap = new HashMap<>();

        int min = 0;
        int max = 0;

        nodesQ.offer(root);
        levelQ.offer(0);

        while(!nodesQ.isEmpty()){
            TreeNode node = nodesQ.poll();
            int level = levelQ.poll();

            min = Math.min(min, level);
            max = Math.max(max, level);

            if(levelNodeMap.containsKey(level)){
                levelNodeMap.get(level).add(node);              //Add to that level -> list of nodes
            }else{
                List<TreeNode> nodeList = new ArrayList<>();
                nodeList.add(node);
                levelNodeMap.put(level, nodeList);
            }

            level++;
            if(node.left!=null){
                nodesQ.offer(node.left);
                levelQ.offer(level);
            }
            if(node.right!=null){
                nodesQ.offer(node.right);
                levelQ.offer(level);
            }
        }
        for (int level = min; level <= max; level++) {
            System.out.print("Level = "+ level + " -> ");
            if(levelNodeMap.containsKey(level)){
                List<TreeNode> list = levelNodeMap.get(level);
                for (TreeNode node :list) {
                    System.out.print(/*" Value = " +*/ node.value + " ");
                }
            }
            System.out.println();
        }
        return levelNodeMap;
    }

    public static void main(String[] args) {
        BinaryTree tree = ConstructBST.constructBST();
        levelWiseTraversal(tree.getRoot());
    }

}
