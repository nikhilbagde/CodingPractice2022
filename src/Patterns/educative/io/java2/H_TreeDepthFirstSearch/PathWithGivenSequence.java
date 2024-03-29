package Patterns.educative.io.java2.H_TreeDepthFirstSearch;

class TreeNode3 {
    int val;
    TreeNode1 left;
    TreeNode1 right;

    TreeNode3(int x) {
        val = x;
    }
};

class PathWithGivenSequence {
    public static boolean findPath(TreeNode1 root, int[] sequence) {
        if (root == null) return sequence.length == 0;
        return dfs(root, sequence, 0);
    }

    private static boolean dfs(TreeNode1 root, int[] sequence, int index) {
        if (root == null) return false;
        //check if index is out of bound  or if current val is not equal of index of sequence value. Return false.
        if (index >= sequence.length || root.val != sequence[index]) return false;
        // not check for leaf node condition, and also check for index condition if its sequence.length-1 then only return true. or false.
        if (root.left == null && root.right == null) {
            if (index == sequence.length-1) return true;
            return false;
        }
        //as we need to access any one the path either from left or right, we are going to use OR condition.
        return dfs(root.left, sequence, index+1) || dfs(root.right, sequence, index+1);
    }

    public static void main(String[] args) {
        TreeNode1 root = new TreeNode1(1);
        root.left = new TreeNode1(0);
        root.right = new TreeNode1(1);
        root.left.left = new TreeNode1(1);
        root.right.left = new TreeNode1(6);
        root.right.right = new TreeNode1(5);

        System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 0, 7 }));
        System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 1, 6 }));
    }
}
