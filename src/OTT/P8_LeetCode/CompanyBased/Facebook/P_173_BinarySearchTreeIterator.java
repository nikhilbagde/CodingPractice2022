package LeetCode.CompanyBased.Facebook;

import java.util.Stack;

public class P_173_BinarySearchTreeIterator {
    public static Stack<TreeNode> stack;
    public static void main(String[] args) {

    }

    public P_173_BinarySearchTreeIterator(TreeNode root){
        stack = new Stack<>();
        while(root!=null){
            stack.push(root);
            root = root.left;
        }
    }

    public boolean hasNext(){
        return !stack.isEmpty();
    }

    public int next(){
        TreeNode currentNode = stack.pop();

        TreeNode temp = currentNode;
        if(temp.right!=null){
            temp = temp.right;

            while(temp!=null){
                stack.push(temp);
                temp = temp.left;
            }
        }

        return currentNode.val;
    }

    private static  class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
