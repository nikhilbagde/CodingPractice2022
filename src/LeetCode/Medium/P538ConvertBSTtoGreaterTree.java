package LeetCode.Medium;

/**
 * Created by Nikhil on 4/3/2017 3:45 PM.
 */
public class P538ConvertBSTtoGreaterTree {
    static int sum = 0;

    public static void main(String[] args) {

    }

    private static TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        convertBST(root.right);
        root.val += sum;
        sum = root.val;
        convertBST(root.left);
        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
