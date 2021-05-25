package Patterns.educative.io.java2.H_TreeDepthFirstSearch;

class TreeNode5 {
    int val;
    TreeNode1 left;
    TreeNode1 right;

    TreeNode5(int x) {
        val = x;
    }
};

class MaximumPathSum {
    static int max = Integer.MIN_VALUE;
    public static int findMaximumPathSum(TreeNode1 root) {
        // TODO: Write your code here
        if (root == null) return 0;
        max = Integer.MIN_VALUE;
        dfs(root);
        return max;
    }

    private static int dfs(TreeNode1 root) {
        if (root == null) return 0;
        int left = Math.max(dfs(root.left), 0);
        int right = Math.max(dfs(root.right), 0);
        max = Math.max(left+right+root.val, max);
        return Math.max(left, right) + root.val;
    }

    public static void main(String[] args) {
        TreeNode1 root = new TreeNode1(1);
        root.left = new TreeNode1(2);
        root.right = new TreeNode1(3);
        System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));

        root.left.left = new TreeNode1(1);
        root.left.right = new TreeNode1(3);
        root.right.left = new TreeNode1(5);
        root.right.right = new TreeNode1(6);
        root.right.left.left = new TreeNode1(7);
        root.right.left.right = new TreeNode1(8);
        root.right.right.left = new TreeNode1(9);
        System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));

        root = new TreeNode1(-1);
        root.left = new TreeNode1(-3);
        System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));
    }
}
