package DataStructure.Trees.Methods;

import  DataStructure.Trees.Methods.CreateATree;
/**
 * Created by Nikhil on 1/14/2017 4:56 PM.
 */
/*
We start from root, if its less than both nodes then we shift focus on right of root. Else left
Keep doing this, until its inbetween or equal to one of those. In that case just return root.
That one is lowest ancestor
 */
public class LowestCommonAncester {
    private static Node lowestCommonAnchester(Node root, Node minNode, Node maxNode){
        if(root.data < Math.min(minNode.data, maxNode.data)){
            return lowestCommonAnchester(root.right, minNode, maxNode);
        }else if(root.data > Math.max(minNode.data, maxNode.data)){
            return lowestCommonAnchester(root.left, minNode, maxNode);
        }
        return root;
    }
    private static Node lowestCommonAnchester2(Node root, Node minNode, Node maxNode){
        if(root.data < minNode.data && root.data < maxNode.data){
            return lowestCommonAnchester2(root.right, minNode, maxNode);
        }else if(root.data >minNode.data &&  root.data >maxNode.data){
            return lowestCommonAnchester2(root.left, minNode, maxNode);
        }
        return root;
    }
    private static Node lowestCommonAnchester3(Node root, int min, int max){
        if(root.data < Math.min(min, max)){
            return lowestCommonAnchester3(root.right, min, max);
        }else if(root.data > Math.max(min, max)){
            return lowestCommonAnchester3(root.left, min, max);
        }
        return root;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(10);
        tree.insert(-10);
        tree.insert(30);
        tree.insert(8);
        tree.insert(25);
        tree.insert(60);
        tree.insert(6);
        tree.insert(9);
        tree.insert(28);
        tree.insert(78);

        Node minNode = tree.root.getRight().getLeft().getRight();
        Node maxNode = tree.root.getRight().getRight().getRight();
        Node root = tree.root;

        int min = 28;
        int max = 78;

        Node result = lowestCommonAnchester(root , minNode ,maxNode);
        Node result1 = lowestCommonAnchester2(root , minNode ,maxNode);
        Node result2 = lowestCommonAnchester3(root , min, max);
        System.out.println(result.data);
        System.out.println(result1.data);
        System.out.println(result2.data);
    }
}
