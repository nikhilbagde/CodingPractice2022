package LeetCode.Medium;

import java.util.Stack;

/**
 * Created by Nikhil on 4/5/2017 8:00 PM.
 */
public class KSmallestElementInTree {
    //K smallest element in Tree
    public int kthSmallest(P508MostFrequentSubtreeSum.TreeNode root, int k) {
        Stack<P508MostFrequentSubtreeSum.TreeNode> st = new Stack<>();

        while (root != null) {
            st.push(root);
            root = root.left;
        }

        while (k != 0) {
            P508MostFrequentSubtreeSum.TreeNode n = st.pop();
            k--;
            if (k == 0) return n.val;
            P508MostFrequentSubtreeSum.TreeNode right = n.right;
            while (right != null) {
                st.push(right);
                right = right.left;
            }
        }

        return -1; // never hit if k is valid
    }

}
