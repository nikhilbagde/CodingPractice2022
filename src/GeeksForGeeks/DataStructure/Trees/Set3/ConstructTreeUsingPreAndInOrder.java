package GeeksForGeeks.DataStructure.Trees.Set3;

import GeeksForGeeks.DataStructure.Trees.TreeNode;

/**
 * Created by Nikhil on 1/20/2017 2:59 PM.
 */
public class ConstructTreeUsingPreAndInOrder {
    static int index = 0;
    //Given two arrays with characters in preOrder and InOrder
    private static TreeNode constructTreeUsingPreAndIn(int[] inOrder, int[] preOrder, int start, int end){
        if(start > end) return null;
        TreeNode root = new TreeNode(preOrder[index++]);            //take first element from pre and create node out of it.
        if(start== end) return root;                                // if both index are same means its a same node without any children.
        int indexOfNodeInINORDER = search(inOrder, start, end, root.value);

        root.left = constructTreeUsingPreAndIn(inOrder, preOrder, start, indexOfNodeInINORDER - 1); //set root.left and do same for left node by recursion
        root.right = constructTreeUsingPreAndIn(inOrder, preOrder, indexOfNodeInINORDER+1, end); //set root.right and do same for right node by recursion
        return root;
    }

    private static int search(int[] inOrder, int start, int end, int value){
        int i;
        for (i = start; i <=end ; i++) {
            if(inOrder[i] == value) return i;
        }
        return i;
    }

    public static void main(String[] args) {
        int in[] = new int[]{4, 2, 5, 1, 6, 3};
        int pre[] = new int[]{1, 2, 4, 5, 3, 6};

        TreeNode node =constructTreeUsingPreAndIn(in, pre, 0, in.length-1);
        inOrder(node);
    }

    private static void inOrder(TreeNode root){
        if(root==null) return;
        inOrder(root.left);
        System.out.println("root.value = " + root.value);
        inOrder(root.right);
    }
}
