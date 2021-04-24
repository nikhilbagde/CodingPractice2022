package LeetCode.CompanyBased.Facebook;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Nikhil Bagde
 * @package LeetCode.CompanyBased.Facebook
 * @created 04/24/2021
 * @date 4/24/2021- 11:38 AM
 * @project HackerRank2017
 **/
public class P_437_PathSum_III {
    static int count = 0;
    static int target  = 0;
    public static void main(String[] args) {
        //[5,4,8,11,null,13,4,7,2,null,null,5,1]
        //22
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);

        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
                /*
                           5                            22
                      ____________
                     |           |
                     4           8
                 _________   _________
                 |       |  |         |
                11     null 13        4
            ________               ________
            |       |             |       |
            7       2             5       1
        */

        //brute force
        count = pathSum(root, 22);
        System.out.println("count = " + count);

        //optimized
        count = pathSumHashMap(root, 22);
        System.out.println("count = " + count);
    }

    public static int pathSum(TreeNode root, int sum){
        target = sum; //just defining globle variable so that I dont need to pass it to the recursive method,
        outerDFS(root);
        return count;
    }

    private static void outerDFS(TreeNode root){
        if(root!=null){
            innerDFS(root, 0);
            outerDFS(root.left);
            outerDFS(root.right);
        }
    }

    private static void innerDFS(TreeNode root, int currentSum){
        if(root!=null){
            currentSum += root.val;
            if(currentSum == target){
                count++;
            }
            innerDFS(root.left, currentSum);
            innerDFS(root.right, currentSum);
        }
    }

    public static int pathSumHashMap(TreeNode root, int k){
        int count = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);

        count = helper(root, k, 0, map);
        return count;
    }

            /*
                           5                            22
                      ____________
                     |           |
                     4           8
                 _________   _________
                 |       |  |         |
                11     null 13        4
            ________               ________
            |       |             |       |
            7       2             5       1
        */
    public static int helper(TreeNode root, int k, int currentSum, Map<Integer,Integer> map){
        if(root==null) return 0;

        currentSum = currentSum + root.val;
        int count = map.getOrDefault(currentSum- k , 0);

        //add to the map before calling children
        map.put(currentSum, map.getOrDefault(currentSum,0)+1);

        count = count
                + helper(root.left, k, currentSum, map)
                + helper(root.right, k, currentSum, map);

        //remove before going to parents another child
        map.put(currentSum, map.get(currentSum)-1);         //no need to use get or Default as we already added it in previous steps. SO we know its there.

        return count;
    }


    private static  class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
