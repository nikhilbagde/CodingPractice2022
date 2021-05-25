package Patterns.educative.io.java2.H_TreeDepthFirstSearch;

class TreeNode6 {
    int val;
    TreeNode1 left;
    TreeNode1 right;

    TreeNode6(int x) {
        val = x;
    }
};

class SumOfPathNumbers {
    static int sum;
    public static int findSumOfPathNumbers(TreeNode1 root) {
        // TODO: Write your code here
        if (root == null) return 0;
        sum = 0;
        dfs(root, 0);
        return sum;
    }

    private static void dfs(TreeNode1 root, int num) {
        if (root == null) return;
        num = num*10 + root.val;
        if (root.left == null && root.right == null) {
            sum += num;
            return;
        }
        dfs(root.left, num);
        dfs(root.right, num);
    }

    public static void main(String[] args) {
        TreeNode1 root = new TreeNode1(1);
        root.left = new TreeNode1(0);
        root.right = new TreeNode1(1);
        root.left.left = new TreeNode1(1);
        root.right.left = new TreeNode1(6);
        root.right.right = new TreeNode1(5);
        System.out.println("Total Sum of Path Numbers: " + SumOfPathNumbers.findSumOfPathNumbers(root));
    }
}
