package Patterns.educative.io.java2.H_TreeDepthFirstSearch;

class TreeNode7 {
    int val;
    TreeNode1 left;
    TreeNode1 right;

    TreeNode7(int x) {
        val = x;
    }
};

class TreePathSum {
    static boolean exist = false;
    public static boolean hasPath(TreeNode1 root, int sum) {
        // TODO: Write your code here
        exist = false;
        dfs(root, sum, 0);
        return exist;
    }

    private static void dfs(TreeNode1 root, int sum, int currSum) {
        if (root == null) return;
        currSum += root.val;
        if (root.left == null && root.right == null) {
            if (currSum == sum) exist = true;
            return;
        }
        if (root.left != null) dfs(root.left, sum, currSum);
        if (root.right != null) dfs(root.right, sum, currSum);
    }

    public static void main(String[] args) {
        TreeNode1 root = new TreeNode1(12);
        root.left = new TreeNode1(7);
        root.right = new TreeNode1(1);
        root.left.left = new TreeNode1(9);
        root.right.left = new TreeNode1(10);
        root.right.right = new TreeNode1(5);
        System.out.println("Tree has path: " + TreePathSum.hasPath(root, 23));
        System.out.println("Tree has path: " + TreePathSum.hasPath(root, 16));
    }
}
