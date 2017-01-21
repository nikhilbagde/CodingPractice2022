package GeeksForGeeks.CodingProblems.Trees.Set3;

import GeeksForGeeks.CodingProblems.Trees.BinaryTree;
import GeeksForGeeks.CodingProblems.Trees.Set1.ConstructBST;
import GeeksForGeeks.CodingProblems.Trees.TreeNode;

import java.util.*;

/**
 * Created by Nikhil on 1/19/2017 9:37 PM.
 */
public class VerticalOrderTraversal {


    private static List<List<Integer>> verticalOrder(TreeNode root){
        if(root==null) return null;

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> level = new LinkedList<>();

        queue.add(root); level.add(0);

        int min=0, max=0;

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
           // System.out.println(node.value);
            int l = level.poll();

            min = Math.min(min, l);
            max = Math.max(max, l);

            if(map.containsKey(l)){
                map.get(l).add(node.value);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(node.value);
                map.put(l, list);
            }

            if(node.left!=null){
                queue.add(node.left);
                level.offer(l-1);                   // for left node add level-1
            }
            if(node.right!=null){
                queue.add(node.right);
                level.offer(l+1);                   // for right node add level+1
            }
        }


        List<List<Integer>> result = new ArrayList<>();
        for (int i = min; i <= max ; i++) {
            if(map.containsKey(i)){
                System.out.println("Level = " + i + "Value" + map.get(i) + " ");
                result.add(map.get(i));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        BinaryTree tree = ConstructBST.constructBST();
        verticalOrder(tree.getRoot());
    }
}
