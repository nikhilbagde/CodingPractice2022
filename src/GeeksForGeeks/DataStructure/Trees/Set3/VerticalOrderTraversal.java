package GeeksForGeeks.DataStructure.Trees.Set3;

import GeeksForGeeks.DataStructure.Trees.BinaryTree;
import GeeksForGeeks.DataStructure.Trees.Set1.ConstructBST;
import GeeksForGeeks.DataStructure.Trees.TreeNode;

import java.util.*;

/**
 * Created by Nikhil on 1/19/2017 9:37 PM.
 */
public class VerticalOrderTraversal {

    /*
    Similar Problems:
    1. Get level of Nodes
    2. Print Level Order Traversal
    3. Has path sum equal to given sum.
    4. Root to leaf sum with given number - DFS would be more efficient.
    5. Vertical order traversal.
    6. Minimum path or depth from Root
     */

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
        BinaryTree tree = ConstructBST.constructBinarySearchTree();
        verticalOrder(tree.getRoot());
    }
}
