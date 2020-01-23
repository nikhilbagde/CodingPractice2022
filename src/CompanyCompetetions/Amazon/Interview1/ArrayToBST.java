package CompanyCompetetions.Amazon.Interview1;


import java.util.Arrays;

/**
 * Created by Nikhil on 4/6/2017 7:54 PM.
 */
public class ArrayToBST {
    public static void main(String[] args) {
        int a[] =  { 33,6,3,7,34,57,99,100,9,1,14,27,45,54,67,71,89,90};
        System.out.println(Arrays.toString(a));
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        TreeNode root =  sortedArrayToBST(a);
    }
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
