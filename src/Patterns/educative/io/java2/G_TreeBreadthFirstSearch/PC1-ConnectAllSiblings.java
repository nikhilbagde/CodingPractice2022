package Patterns.educative.io.java2.G_TreeBreadthFirstSearch;

import java.util.*;

class TreeNode5 {
    int val;
    TreeNode5 left;
    TreeNode5 right;
    TreeNode5 next;

    TreeNode5(int x) {
        val = x;
        left = right = next = null;
    }
}

class ConnectAllSiblings {
    public static void connect(TreeNode5 root) {
        // TODO: Write your code here
        if (root == null) return;
        Queue<TreeNode5> queue = new LinkedList<>();
        queue.add(root);
        TreeNode5 curr = null;
        while (queue.size() > 0) {
            int size = queue.size();
            while (size > 0) {
                TreeNode5 node = queue.poll();
                if (curr != null) curr.next = node;
                curr = node;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                size--;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode5 root = new TreeNode5(12);
        root.left = new TreeNode5(7);
        root.right = new TreeNode5(1);
        root.left.left = new TreeNode5(9);
        root.right.left = new TreeNode5(10);
        root.right.right = new TreeNode5(5);
        ConnectAllSiblings.connect(root);

        // level order traversal using 'next' pointer
        TreeNode5 current = root;
        System.out.println("Traversal using 'next' pointer: ");
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}