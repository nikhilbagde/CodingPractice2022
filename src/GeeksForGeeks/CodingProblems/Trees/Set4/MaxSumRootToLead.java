package GeeksForGeeks.CodingProblems.Trees.Set4;

import GeeksForGeeks.CodingProblems.Trees.TreeNode;

import java.util.*;

/**
 * Created by Nikhil on 1/25/2017 2:44 PM.
 */
public class MaxSumRootToLead {
    // would not be efficient
    private static void maxSumRootToLead(TreeNode root){
        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<Integer> levels = new LinkedList<>();

        Map<Integer, List<Integer>> map = new HashMap<>();

        nodes.offer(root);
        levels.offer(0);

    }
}
