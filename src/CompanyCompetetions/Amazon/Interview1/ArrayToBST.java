package CompanyCompetetions.Amazon.Interview1;

/**
 * Created by Nikhil on 4/6/2017 7:54 PM.
 */
public class ArrayToBST {
    private static TreeNode sortedArrayToBST(int[] a) {
        if (a.length == 0) return null;
        return sortedArrayToBSTRec(a, 0, a.length);
    }

    private static TreeNode sortedArrayToBSTRec(int[] a, int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(mid);
        root.left = sortedArrayToBSTRec(a, start, mid - 1);
        root.right = sortedArrayToBSTRec(a, mid + 1, end);
        return root;
    }

    static class TreeNode {
        int value;
        TreeNode left, right;

        public TreeNode(int value) {
            this.value = value;
            left = right = null;
        }
    }
}
