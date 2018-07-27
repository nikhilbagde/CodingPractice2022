package CompanyCompetetions.Amazon.Interview2.Top12Problems;

import GeeksForGeeks.DataStructure.Trees.BinaryTree;
import GeeksForGeeks.DataStructure.Trees.Set1.ConstructBST;
import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * Created by nbagde on 7/23/2018.
 */
public class P3_BinaryTreeTraversal {

    //Inner static class
    public static class TreeNode{
        public int value;
        public TreeNode left, right;
        TreeNode(int value){
            this.value = value;
            left = right  = null;
        }
    }

    //Member Variables.
    TreeNode root;

    //Constructor
    public P3_BinaryTreeTraversal(){
        root = null;
    }
    P3_BinaryTreeTraversal(int value){
        root = new TreeNode(value);
    }

    public TreeNode getRoot(){
        return root;
    }
    /*
    If root is null create first node as root
    if root already there, insert recursively.
     */
    public void insert(int value){
        if(root==null){
            root = new TreeNode(value);
        }else {
            root = insertRec(root, value);
        }
    }
    private TreeNode insertRec(TreeNode root, int value){
        //Insert to left
        if(value < root.value){
            root.left = (root.left ==null) ? new TreeNode(value) : insertRec(root.left, value);
        }else if(value>root.value){
            root.right = (root.right==null) ? new TreeNode(value) : insertRec(root.right, value);
        }else{
            System.out.println("Duplicate can not be inserted!");
        }
        return root;
    }

    //TRAVERSAL
    //TOP VIEW
    //                       5
    //           /                       \
    //          2                       7
    //      /        \              /       \
    //    1          3           6         8
    // OUTPUT: 1 2 5 7 8

    public void topView(TreeNode root){
        //First go to the left and left most node then when reach to null then start printing.
        if(root.left!=null){
            goLeft(root.left);
        }
        //Then print root
        System.out.print(root.value + " ");
        //Then keep printing Right first then move to right most node.
        if(root.right!=null){
            goRight(root.right);
        }
    }
    private void goLeft(TreeNode  node){
        if(node.left!=null)
            goLeft(node.left);
        //when Node.left == null meaning left most
        System.out.print(node.value + " ");
    }
    private void goRight(TreeNode node){
        //first print then go deep
        System.out.print(node.value + " ");
        if(node.right!=null)
            goRight(node.right);
    }

    //Post Order Traversal
    //                       5
    //           /                       \
    //          2                       7
    //      /        \              /       \
    //    1          3           6         8
    // OUTPUT: 1 3 2 6 8 7 5
    private void postOrder(TreeNode node){
        if(node!=null){
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.value + " ");
        }
    }
    //Pre Order Traversal
    //                       5
    //           /                       \
    //          2                       7
    //      /        \              /       \
    //    1          3           6         8
    // OUTPUT: 1 2 3 5 6 7 8
    private void preOrder(TreeNode node){
        if(node!=null){
            System.out.print(node.value + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    //In Order Traversal
    //                       5
    //           /                       \
    //          2                       7
    //      /        \              /       \
    //    1          3           6         8
    // OUTPUT: 1 2 3 5 6 7 8
    private void inOrder(TreeNode node){
        if(node!=null){
            inOrder(node.left);
            System.out.print(node.value + " ");
            inOrder(node.right);
        }
    }
    //In Order Traversal
    //                       5                                      Depth 0                     1
    //           /                       \
    //          2                       7                          Depth 1                     2
    //      /        \              /       \
    //    1          3           6         8                     Depth 2                     3
    //Height of tree  height = 3.
    private int height(TreeNode node){
        if(node==null){
            return -1;
        }else{
            return 1+ Math.max(height(node.left), height(node.right));
        }
    }

    //In Order Traversal
    //                       5
    //           /                       \
    //          2                       7
    //      /        \              /       \
    //    1          3           6         8
    // Level Order : 5
    //                       2 7
    //                      1 3 6 8
    private void levelOrder(TreeNode node){
        Queue<TreeNode> queue= new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            System.out.println(currentNode.value);

            if (currentNode.left != null) {
                queue.offer(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.offer(currentNode.right);
            }
        }
    }

    // Levelwise Traversal with given level find max n numbers.
    //                       5
    //           /                       \
    //          2                       7
    //      /        \              /       \
    //    1          3           6         8
    // Level Order :  level 3 and max =3 / min=3
    //                      min = 1 3 6
    //                      max = 8 6 3

    private void levelWiseMaxNAtKlevel(TreeNode node, int maxN, int levelK){
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer>  level = new LinkedList<>();

        queue.offer(node);
        level.offer(1);

        PriorityQueue<TreeNode> minHeap = new PriorityQueue<>( (o1,o2) ->  o1.value >o2.value? 1 :( o1.value < o2.value? -1:0));
        PriorityQueue<TreeNode> maxHeap = new PriorityQueue<>( (o1,o2) ->  o1.value >o2.value? -1 :( o1.value < o2.value? 1:0));
        while(!queue.isEmpty()){
            TreeNode currentNode = queue.poll();
            int currentLevel = level.poll();

            if(currentLevel == levelK){
                minHeap.offer(currentNode);
                maxHeap.offer(currentNode);
            }

            if(currentNode.left!=null){
                queue.offer(currentNode.left);
                level.offer(currentLevel+1);
            }
            if(currentNode.right!=null){
                queue.offer(currentNode.right);
                level.offer(currentLevel+1);
            }
        }
        System.out.println("\nMinHeap: " );
        printHeap(minHeap, maxN);
        System.out.println("\nMaxHeap: " );
        printHeap(maxHeap, maxN);

    }


    static void printHeap(PriorityQueue<TreeNode> heap, int count){
        while(!heap.isEmpty() && count-- >0){
            System.out.print( " " + heap.poll().value + " ");
        }
    }

    /**
     *      Check for Children Sum Property in a Binary Tree
     *     Given a binary tree, write a function that returns true if the tree satisfies below property.
     *     For every node, data value must be equal to sum of data values in left and right children.
     *     Consider data value as 0 for NULL children. Below tree is an example
     */

    private boolean isSumProperty(TreeNode node){
        if(node==null || (node.left ==null && node.right==null)) {
            return false;
        }else {
            int leftValue = node.left != null ? node.left.value : 0;
            int rightValue = node.right != null ? node.right.value : 0;

            if(node.value == (leftValue+rightValue)
            && isSumProperty(node.left)
            && isSumProperty(node.right)){
                return true;
            }
            return false;
        }
    }

    /* Constructing below tree
               5
             /   \
            3     6
           / \     \
          1   4     8
         / \       / \
        0   2     7   9
   */

    private TreeNode binaryToDLL(TreeNode node){
        return null;
    }

    private TreeNode findLowestCommenAncestor(int a, int b, TreeNode node){
        TreeNode currentNode = node;
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        //stack = findPathtoNode(stack, node, a);
        printStack(stack);
        //stack2 = findPathtoNode(stack2, node, b);
        printStack(stack2);

        return currentNode;
    }

    private void printPathToNode(TreeNode node){
        List<Integer> list = new LinkedList<>();
        printPathToNodeRec(list, node);
    }
    private void printPathToNodeRec(List<Integer> list, TreeNode node){
        if(node==null)
            return;

            list.add(node.value);

            if(node.left == null && node.right == null){
                Object[] array = list.toArray();
                System.out.println(Arrays.toString(array));
                list.remove(list.size()-1);
            }else{
                printPathToNodeRec(list, node.left);
                printPathToNodeRec(list, node.right);
                list.remove(list.size()-1);
            }
    }

    private static void printStack(Stack<TreeNode> stack){
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            System.out.print(node.value + " ");
        }
    }

    static void display(String a){
        System.out.println();
        System.out.println(a);
    }

    public static void main(String[] args) {
        int [] a = {5,2,7,1,3,6,8};
        P3_BinaryTreeTraversal binaryTree = new P3_BinaryTreeTraversal();

        for (Integer  i: a ) {
            binaryTree.insert(i);
        }

        // TOP VIEW
        display("Top View");
        binaryTree.topView(binaryTree.getRoot());

        display("Post Order");
        binaryTree.postOrder(binaryTree.getRoot());

        display("Pre Order");
        binaryTree.preOrder(binaryTree.getRoot());

        display("In Order");
        binaryTree.inOrder(binaryTree.getRoot());

        display("Height");
        int height = binaryTree.height(binaryTree.getRoot());
        System.out.println(++height);

        display("Level Order Traversal");
        binaryTree.levelOrder(binaryTree.getRoot());

        display("Find Max n at level k");
        binaryTree.levelWiseMaxNAtKlevel(binaryTree.getRoot(), 3, 3);

        display("Children Sum Property");
        boolean result = binaryTree.isSumProperty(binaryTree.getRoot());
        System.out.println(result);

        display("Convert Binary Tree to DLL");
        binaryTree.binaryToDLL(binaryTree.getRoot());

        display("Find Lowest Common Ancester");
        binaryTree.findLowestCommenAncestor(1, 3, binaryTree.getRoot());

        display("PrintPathToNode");
        binaryTree.printPathToNode(binaryTree.getRoot());
    }
}
