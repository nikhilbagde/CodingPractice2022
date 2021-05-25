package Patterns.educative.io.java2.H_TreeDepthFirstSearch;

class TreeNode4 {
    int val;
    TreeNode1 left;
    TreeNode1 right;

    TreeNode4(int x) {
        val = x;
    }
};

class TreeDiameter {
    static int max;
    public static int findDiameter(TreeNode1 root) {
        // TODO: Write your code here
        max = 0;
        dfs(root, 0);
        return max;
    }

    private static int dfs(TreeNode1 root, int len) {
        if (root == null) return len;
        int left = dfs(root.left, len);
        int right = dfs(root.right, len);
        if (left + right + 1 > max) max = left+right+1;
        return 1+Math.max(left, right);
    }

    public static void main(String[] args) {
        TreeNode1 root = new TreeNode1(1);
        root.left = new TreeNode1(2);
        root.right = new TreeNode1(3);
        root.left.left = new TreeNode1(4);
        root.right.left = new TreeNode1(5);
        root.right.right = new TreeNode1(6);
        System.out.println("Tree Diameter: " + TreeDiameter.findDiameter(root));
        root.left.left = null;
        root.right.left.left = new TreeNode1(7);
        root.right.left.right = new TreeNode1(8);
        root.right.right.left = new TreeNode1(9);
        root.right.left.right.left = new TreeNode1(10);
        root.right.right.left.left = new TreeNode1(11);
        System.out.println("Tree Diameter: " + TreeDiameter.findDiameter(root));
    }
}
