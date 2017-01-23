package GeeksForGeeks.CodingProblems.Trees.Set4;

import GeeksForGeeks.CodingProblems.Trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Nikhil on 1/22/2017 6:38 PM.
 Similar Problems:
 1. Get level of Nodes
 2. Print Level Order Traversal
 3. Has path sum equal to given sum.
 4. Root to leaf sum with given number - DFS would be more efficient.
 5. Vertical order traversal.
 6. Minimum path or depth from Root
 */
public class MinimumPathOrDepth {
    /*
    thought process. Use Level wise traversal. As we just need to reach first leaf node.
    maintain second queue with nodes -> of count: it is nothing but length from root.
    Once we reach leaf node return count at that point only.
     */

    private static int getMinimumPathOrDepth(TreeNode root){
        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<Integer> count = new LinkedList<>();

        nodes.offer(root);
        count.offer(1);

        while(!nodes.isEmpty()){
            TreeNode node = nodes.poll();
            int minCount = count.remove();          //b/c poll on empty gives -1.

            if(node.left==null && node.right==null) return minCount;        //asap we find first leaf node, return

            if(node.left!=null){
                nodes.offer(node.left);
                count.offer(minCount+1);
            }

            if(node.right!=null){
                nodes.offer(node.right);
                count.offer(minCount+1);
            }
        }
        return 0;
    }
}
