package LeetCode.CompanyBased.Facebook;

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

        pathSum(root, 22);
    }

    public static int pathSum(TreeNode root, int sum){
        target = sum;
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

    private static  class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
