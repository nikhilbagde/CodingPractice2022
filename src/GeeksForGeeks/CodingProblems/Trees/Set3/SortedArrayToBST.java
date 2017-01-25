package GeeksForGeeks.CodingProblems.Trees.Set3;

import GeeksForGeeks.CodingProblems.Trees.TreeNode;

/**
 * Created by Nikhil on 1/19/2017 10:35 PM.
 */
public class SortedArrayToBST {
    private static TreeNode sortedArrayToBST(int[] array){
        if(array.length == 0) return null;
        return sortedArrayToBSTRec(array, 0, array.length-1);
    }
    private static TreeNode sortedArrayToBSTRec(int[] array, int start, int end){
        if(start>end) return null;
        int mid = (start+end)/2;                                                //Step 1: Take mid value of array
        TreeNode root = new TreeNode(array[mid]);                                      //Step 2 : Set mid value as Root. 1st element
        root.left = sortedArrayToBSTRec(array, start, mid - 1);             //Step 3 : Then set left and right child as mid values
        root.right = sortedArrayToBSTRec(array, mid+1, end);                            //of respective left and right sub array.
        return root;                                                            //Step 4 : this function should return that root,
    }                                                                                          //which will set back to root.left and root.right.
}
