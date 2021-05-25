package Patterns.educative.io.java2.H_TreeDepthFirstSearch;

class TreeNode1 {
    int val;
    TreeNode1 left;
    TreeNode1 right;

    TreeNode1(int x) {
        val = x;
    }
};

class CountAllPathSum {
    public static int countPaths(TreeNode1 root, int S) {
        return dfs(root, S, 0, false);
    }

    private static int dfs(TreeNode1 root, int S, int count, boolean next) {
        if (root == null) return count;
        if (root.val == S) count++;
        if (root.left == null && root.right == null) return count;
        if (next) {
            count = dfs(root.left, S-root.val, count, true);
            count = dfs(root.right, S-root.val, count, true);
        } else {
            count = dfs(root.left, S, count, false);
            count = dfs(root.right, S, count, false);
            count = dfs(root.left, S-root.val, count, true);
            count = dfs(root.right, S-root.val, count, true);
        }
        return count;
    }

    public static void main(String[] args) {
        TreeNode1 root = new TreeNode1(12);
        root.left = new TreeNode1(7);
        root.right = new TreeNode1(1);
        root.left.left = new TreeNode1(4);
        root.right.left = new TreeNode1(10);
        root.right.right = new TreeNode1(5);
        System.out.println("Tree has path: " + CountAllPathSum.countPaths(root, 11));
    }
}
