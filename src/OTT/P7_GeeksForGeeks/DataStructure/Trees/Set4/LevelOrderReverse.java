package OTT.P7_GeeksForGeeks.DataStructure.Trees.Set4;

import OTT.P7_GeeksForGeeks.DataStructure.Trees.BinaryTree;
import OTT.P7_GeeksForGeeks.DataStructure.Trees.Set1.ConstructBST;
import OTT.P7_GeeksForGeeks.DataStructure.Trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Nikhil on 1/26/2017 12:30 AM.
 */
public class LevelOrderReverse {
    private static void levelOrderReverse(TreeNode root){
        Queue<TreeNode> nodes = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        nodes.add(root);

        while(!nodes.isEmpty()){
            TreeNode current = nodes.peek();                //USE PEEK add to stack then only pop
            stack.push(current);
            nodes.poll();

            if(current.right!=null){                        //RIGHT before LEFT
                nodes.add(current.right);
            }
            if(current.left!=null){                        //RIGHT before LEFT
                nodes.add(current.left);
            }
        }
        while(!stack.isEmpty()){
            System.out.print(stack.peek().value + " ");
            stack.pop();
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = ConstructBST.constructBinaryTree();
        levelOrderReverse(tree.getRoot());
    }
}
