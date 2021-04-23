package LeetCode.CompanyBased.Facebook;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nikhil Bagde
 * @package LeetCode.CompanyBased.Facebook
 * @created 04/23/2021
 * @date 4/23/2021- 2:37 AM
 * @project HackerRank2017
 **/
public class P_113_PathSymII {
    public static void main(String[] args) {

    }

    /**
     * understand : if you create a list to add nodes at each stage, if till left bath is not found
     * it is important to not to include that node. Otherwise it just like simply adding all notes to list.
     *  to crack this, add new reference of list while moving from one stack to next, in that case
     *  once stack is completed new reference is automatically gone from previous stage.
     *
     *  Finally also, while adding final result to result list, do same as of adding it as a new reference list.
     *  but if we are adding new reference to list for every stack, adding new reference to final result is not neccessary.
     */
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        if(root==null) return result;

        helper(root, targetSum, result, new ArrayList<>());
        return result;
    }

    public void helper(TreeNode root, int targetSum, List<List<Integer>> result, List<Integer> currentList){         //make currentList of type Integer and not TreeNode
        if(root==null) return ;


        currentList.add(root.val);          //add root.val and not root

        if(root.left == null && root.right ==null && root.val == targetSum){
            result.add(new ArrayList<>(currentList));        //add return boolean, dont return directly   + REMEMBER add as a NEW LIST
            //return result;
        }

        //else if(root.left == null && root.right ==null && root.val != targetSum){
        // currentList.remove(currentList.size()-1);
        // }


        helper(root.left, targetSum - root.val,
                result, new ArrayList<>(currentList)); // REMEMBER add as a NEW LIST
        helper(root.right, targetSum - root.val,
                result, new ArrayList<>(currentList)); //+ REMEMBER add as a NEW LIST
        //return result;
    }
    private static  class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
