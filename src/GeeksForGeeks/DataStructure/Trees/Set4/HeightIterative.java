package GeeksForGeeks.DataStructure.Trees.Set4;

import GeeksForGeeks.DataStructure.Trees.Set1.ConstructBST;
import GeeksForGeeks.DataStructure.Trees.TreeNode;

import java.util.Stack;

/**
 * Created by Nikhil on 1/25/2017 10:10 PM.
 */
public class HeightIterative {
    public static void main(String[] args) {
        GeeksForGeeks.DataStructure.Trees.BinaryTree tree = ConstructBST.constructBinaryTree();
        int height = getHeight(tree.getRoot());
        System.out.println("height = " + height);
    }
    private static int getHeight(TreeNode root){
        Stack<TreeNode> nodes = new Stack<>();
        TreeNode node = root;
        int heightCounter = 0, maxHeight = -1;
        while(node!=null){
            nodes.push(node);
            node = node.left;
            heightCounter++;
        }

        while(!nodes.isEmpty()){
            TreeNode currNode = nodes.pop();
            heightCounter--;
            if(currNode.right!=null){
                currNode = currNode.right;
                while(currNode!=null){
                    nodes.push(currNode);
                    currNode = currNode.left;
                    heightCounter++;
                    maxHeight = Math.max(maxHeight, heightCounter);
                }
            }

        }
        return maxHeight;
    }
}
