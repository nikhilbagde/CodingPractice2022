package OTT.P7_GeeksForGeeks.DataStructure.Trees.Set3;

import OTT.P7_GeeksForGeeks.DataStructure.Trees.BinaryTree;
import OTT.P7_GeeksForGeeks.DataStructure.Trees.Set1.ConstructBST;
import OTT.P7_GeeksForGeeks.DataStructure.Trees.TreeNode;

import java.util.Stack;

/**
 * Created by Nikhil on 1/19/2017 5:17 PM.
 */
public class InorderWithoutRecursion {
    //Also known as DFS approach: Using Stack | recursion.
    private static void InorderUsingStack(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();                              //Step 1 : Create  a Stack

        pushAllLeftToStack(root, stack);                             //Step 2: add root and all its left node to stack till it reaches null

        while(!stack.isEmpty()){                                            //Step 3: Pop node, (Print) check if it has right node
            TreeNode tempNode = stack.pop();
            System.out.println("node.value = " + tempNode.value);

            if(tempNode.right!=null) {                                      //Step 4: if it has right node, move to right node
                tempNode = tempNode.right;
                pushAllLeftToStack(tempNode, stack);                        //Step 5: = Step 2 : All all its left nodes to stack.
            }
        }
    }
    private static Stack<TreeNode> pushAllLeftToStack(TreeNode node, Stack<TreeNode> stack){
        while(node!=null){                                                  //Step a: while we don't reach left end
            stack.push(node);                                               //Step b : first add current node, and keep adding to stack
            node = node.left;                                               //Step c: keeping navigating to left. (farthest)
        }
        return stack;
    }

    public static void main(String[] args) {
        //Test 1
        BinaryTree tree = ConstructBST.constructBinarySearchTree();
        InorderUsingStack(tree.getRoot());

        //Test 2
        BinaryTree tree1 = new BinaryTree();
        tree1.setRoot(new TreeNode(1));
        tree1.getRoot().left = new TreeNode(2);
        tree1.getRoot().right = new TreeNode(3);
        tree1.getRoot().left.left = new TreeNode(4);
        tree1.getRoot().left.right = new TreeNode(5);

        InorderUsingStack(tree1.getRoot()); //Expected 4 2 5 1 3
    }
}
