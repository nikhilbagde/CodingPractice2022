package CompanyCompetetions.Amazon.Interview1;

import java.util.Stack;

/**
 * Created by Nikhil on 4/6/2017 4:34 PM.
 */
public class TreeHeightUsingStack {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        getHeightUsingStack(root);
    }

    private static int getHeightUsingStack(TreeNode root) {
        if (root == null) return 0;
        int height = 0;
        Stack<TreeNode> stack = new Stack<>();

        TreeNode node = root;
        stack.push(node);
        while (node.left != null) {
            stack.push(node);
            node = node.left;
            height++;
        }

        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            if (temp.right != null) {
                temp = temp.right;
            }
            while (temp.left != null) {
                stack.push(temp);
                height++;
            }
        }
        return height;
    }

    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int v) {
            value = v;
            left = right = null;
        }
    }
}
