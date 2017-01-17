package DataStructure.Trees;

import java.util.*;
import java.util.Queue;

/**
 * Created by Nikhil on 9/14/2016.
 */
public class BinaryTree {
    private TreeNode root;

    BinaryTree(){
        root = null;
    }
    BinaryTree(int data){
        root = new TreeNode(data);
    }

    public TreeNode getRoot() {
        return root;
    }

    public  void insert(int data){
        if(root == null){
            root = new TreeNode(data);
        }else {
            root = insertRec(root, data);
        }
    }

    private TreeNode insertRec(TreeNode root, int data){
        if(data < root.data){
            if(root.left == null){
                root.left = new TreeNode(data);
            }else{
                root.left = insertRec(root.left, data);
            }
        }else if( data > root.data){
            if(root.right == null){
                root.right = new TreeNode(data);
            }else{
                root.right = insertRec(root.right, data);
            }
        }else{
            //Do nothing when data == root.data.
            System.out.println("Can not add duplicated values into the tree!");
        }
        return root;
    }

    // https://www.hackerrank.com/challenges/tree-top-view
    void goLeft(TreeNode node){
        if(node.left != null){
            goLeft(node.left);
        }
        System.out.print(node.data + " ");
    }
    void goRight(TreeNode node){
        System.out.print(node.data + " ");
        if(node.right != null){
            goRight(node.right);
        }
    }
    void top_view(TreeNode root){
        if(root.left != null){
            goLeft(root.left);
        }
        System.out.print(root.data + " ");

        if(root.right != null){
            goRight(root.right);
        }
    }

    //https://www.hackerrank.com/challenges/tree-preorder-traversal
    void preOrder(TreeNode root) {
        System.out.print(root.data + " ");
        if(root.left!=null){
            preOrder(root.left);
        }
        if(root.right!=null){
            preOrder(root.right);
        }
    }

    //https://www.hackerrank.com/challenges/tree-postorder-traversal/submissions/code/27943957
    void postOrder(TreeNode root) {
        if(root!=null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }
    }

   //https://www.hackerrank.com/challenges/tree-inorder-traversal
    void inOrder(TreeNode root) {
        if(root!=null){
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }

    }

    //https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree
    int height(TreeNode root){
        if(root == null){
            return -1;  //-1 since when there is no root, height is nothing
                        // when root is there, means height is zero.
        }else{
            //int leftH = height(root.left);
            //int rightH = height(root.right);
            //System.out.print(leftH + "\n" + rightH);
            return 1 + Math.max(height(root.left), height(root.right));
        }

    }

    //https://www.hackerrank.com/challenges/tree-level-order-traversal

    public void levelOrder(TreeNode root)
    {
        /* printLevelorder(tree)
        1) Create an empty queue q
        2) temp_node = root //start from root
        3) Loop while temp_node is not NULL, loop while queue is not empty.

        a) print temp_node->data.
        b) Enqueue temp_node’s children (first left then right children) to q
        c) Dequeue a node from q and assign it’s value to temp_node
    */
        // We can use array implementation of queue too, here I have used linked list.
        // Its easy b/c I don't have to specify length as in case of array

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while(!queue.isEmpty()){
            // Poll() is used for remove element from queue.
            // Read your java collection framework notes for detail.
            TreeNode tempNode = queue.poll();
            System.out.print(tempNode.data + " ");

            if(tempNode.left != null){
                queue.add(tempNode.left);
            }
            if(tempNode.right != null){
                queue.add(tempNode.right);
            }
        }

    }

    public void inOrderUsingStack(TreeNode root){
        if(root == null){
            return;
        }
        //Step 1 : Create a stack
        Stack<TreeNode> stack = new Stack<>();

        //Step 2: Create a temp node which points to root
        //          and keep adding to stack till you reach leftmost node
        TreeNode node = root;
        while(node!= null){
            stack.add(node);
            node = node.left;
        }

        //Step 3: now, Start popping from stack
        //          and print out node value
        //          and then check if this left most node has right node,
        //          if yes, then again add those right nodes to stack.
        //          Like step 2 till leftmost node again.
        while(stack.size() > 0){
            node = stack.pop();
            System.out.println(node.data + " ");

            //3.a reach to right node of left most node
            if(node.right!=null){
                node = node.right;
            }
            //3.b Now considering this node as root again,
            //      go to its left most node
            while(node!=null){
                stack.add(node);
                node = node.left;
            }
        }
    }

    // Size of tree
    public int size(TreeNode root){
        if(root == null){
            return 0;
        }else{
            return ( 1 + size(root.left) + size(root.right));
        }
    }

    //check if two trees are identical
    public boolean isIdentical(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null){
            return true;
        }
        if(root1 !=null && root2!= null){
            return (root1.data == root2.data
                        && isIdentical(root1.left, root2.left)
                        && isIdentical(root1.right, root2.right));
        }
        return false;
    }

    //http://www.geeksforgeeks.org/given-a-binary-tree-print-out-all-of-its-root-to-leaf-paths-one-per-line/
    //Print path length from root to all leaf nodes
    public void printPath(TreeNode root){
        int counter = 0;
        int path[] = new int[100];
        printPathRec(root, path, counter);
    }

    public void printPathRec(TreeNode root, int path[], int counter){
        if(root == null){
            return;
        }else{
            //Now keep tracking data while going from root to left most node
            path[counter] = root.data;
            counter++;
            //check if we reached leaf node vai recursion
            if(root.left == null && root.right == null){
                //Print this path. Calling overloaded function.
                printPath(path, counter);
            }else{
                //Try both substrees
                printPathRec(root.left, path, counter);
                printPathRec(root.right, path, counter);
            }
        }
    }

    public void printPath(int path[], int counter){
        for (int i = 0; i < counter; i++) {
            System.out.print(path[i] + " ");
        }
        System.out.println();
    }

    public int leafCount(){
        return getLeafCount(root);
    }

    public int getLeafCount(TreeNode node){
        if(node == null){
            return 0;
        }
        //we found leaf node return 1
        if(node.left == null && node.right == null){
            return 1;
        }else{
            return getLeafCount(node.left) + getLeafCount(node.right);
        }
    }
    public int maxDepth(TreeNode A) {
        return depth(A, 0);
    }

    public int depth(TreeNode node, int level) {

        if (node == null)
            return level;

        int left = depth(node.left, level + 1);
        int right = depth(node.right, level + 1);

        return Math.max(left, right);

    }
    public void FindLargestFromLevel(TreeNode root, int givenLevel) throws IllegalArgumentException{
        Queue<TreeNode> queue = new LinkedList<>();
        //ArrayList<SLLNode> nodeList = new ArrayList<>();
        queue.add(root);
        int elementCounter = 0;
        int levelCounter = 0;

        while(!queue.isEmpty()){
            List<TreeNode> list = new ArrayList<>();
            list.addAll(queue);

            if(levelCounter == givenLevel){
                //return list;
            }
            TreeNode temp = queue.poll();
            //nodeList.add(temp);

            //printLevelLargest(nodeList);

            //nodeList = null;
            if(temp.left!=null || temp.right!=null) {
                levelCounter++;
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);

                }
            }

        }
        //return ;
    }
    public void printLevelLargest(TreeNode root, int level, int maxCount){
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> levelNodes = new LinkedList<>();

        PriorityQueue<TreeNode> minHeap = new PriorityQueue<>((o1, o2) ->
                o1.data > o2.data ? 1 : (o1.data < o2.data ? -1 : 0)
        );
        //Pathetic logic
        minHeap.add(root);
        minHeap.add(root.left == null ? new TreeNode(-1): root.left);
        minHeap.add(root.right == null ? new TreeNode(-2) : root.right ) ;

        queue.add(root);
        levelNodes.add(1);


        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            int currentLevel = levelNodes.poll();

            if(currentLevel == level){
                //System.out.println(temp.data);
                //if(sizeofMinHeap++ != 2){
                 //   minHeap.add(temp);
                //}
                if(temp.data > minHeap.peek().data){
                    minHeap.poll();
                    minHeap.add(temp);
                }
            }
            if(temp.left!=null || temp.right!=null){
                if(temp.left!=null){
                    queue.add(temp.left);
                    levelNodes.add(currentLevel + 1);
                }
                if(temp.right!=null){
                    queue.add(temp.right);
                    levelNodes.add(currentLevel + 1);
                }
            }
        }
        printHeap(minHeap, maxCount);
    }

    public static void printTree(TreeNode node){
        //a n = - 2^(-n) . (-16+2^n)

    }
    static void printHeap(PriorityQueue<TreeNode> heap){
        System.out.println("\nPrinting Heap:");
        while(!heap.isEmpty()){
            System.out.print(heap.poll().data+ " ");
        }
    }
    static void printHeap(PriorityQueue<TreeNode> heap, int maxCount){
        System.out.println("\nPrinting Heap:");
        while(!heap.isEmpty() && maxCount-- >0){
            System.out.print(heap.poll().data+ " ");
        }
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                "root=" + root +
                '}';
    }
}
