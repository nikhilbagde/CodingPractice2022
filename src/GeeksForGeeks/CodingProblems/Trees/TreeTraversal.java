package GeeksForGeeks.CodingProblems.Trees;

import java.util.PriorityQueue;

/**
 * Created by Nikhi on 12/10/2016 7:54 PM.
 */
public class TreeTraversal {
    public static void main(String[] args) {
        BinarayTree tree = new BinarayTree();
        tree.insert(5);                        //    5
        tree.insert(1);                       //  /     \
        tree.insert(10);                    //  1         10
        tree.insert(2);                    //  / \        / \
        tree.insert(8);                   //      2      8
        tree.insert(4);                  //        \    /
        tree.insert(6);                 //          4  6

        System.out.println("PreOrder");
        tree.preOrder();
        System.out.println("InOrder");
        tree.inOrder();
        System.out.println("PostOrder");
        tree.postOrder();

        System.out.println("Size of Tree: " + tree.getSize());
        System.out.println("Height of Tree: " + tree.getHeight());

        //LevelWise Traversal
        BinarayTree tree1 = new BinarayTree();
        tree1.insert(6);                        //      6
        tree1.insert(3);                       //    /     \
        tree1.insert(10);                    //   3           10
        tree1.insert(2);                    //  / \         /   \
        tree1.insert(4);                   //  2    4      8    12
        tree1.insert(8);                  //  /      \    / \   /  \
        tree1.insert(12);                 // 1        5  7   9 11  13
        tree1.insert(1);
        tree1.insert(5);
        tree1.insert(7);
        tree1.insert(9);
        tree1.insert(11);
        tree1.insert(13);

        System.out.println("Tree 2 : InOrder : ");
        tree1.inOrder();
        for (int i = 0; i < tree1.getHeight(); i++) {
            tree1.printLevelWise(i+1);
        }
        System.out.println("Find Max K element from level L");
        tree1.getMaxKAtLevelL(4, 3 );

    }
}
class Node{
    int value;
    Node left;
    Node right;

    Node(int valueIn){
        value = valueIn;
        left = right = null;
    }

}
class BinarayTree{
    private Node root;
    BinarayTree(){
        root = null;
    }
    void insert(int valueIn){
        if(root ==  null){
            root = new Node(valueIn);
        }else {
            insertNode(root, valueIn);
        }
    }
    private Node insertNode(Node root, int valueIn){
        if(valueIn < root.value){
            if(root.left ==  null){
                root.left = new Node(valueIn);
            }else{
                insertNode(root.left, valueIn);
            }
        }else if(valueIn > root.value){
            if(root.right == null){
                root.right = new Node(valueIn);
            }else{
                insertNode(root.right, valueIn);
            }
        }else{
            System.out.println("Duplicate Value Discarded.");
        }
        return root;
    }
    void preOrder(){
        preOrder(root);
    }
    private void preOrder(Node root){
        if(root == null){
            return;
        }else{
            //when its root, add < root.value >
            if(this.root.value == root.value){
                System.out.println("<"+root.value+">");
            }else{
                System.out.println(root.value);
            }
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    void inOrder(){
        inOrder(root);
    }
    private void inOrder(Node root){
        if(root == null){
            return;
        }else{
            inOrder(root.left);
            //when its root, add < root.value >
            if(this.root.value == root.value){
                System.out.println("<"+root.value+">");
            }else{
                System.out.println(root.value);
            }

            inOrder(root.right);
        }
    }
    void postOrder(){
        postOrder(root);
    }
    private void postOrder(Node root){
        if(root == null){
            return;
        }else{
            postOrder(root.left);
            postOrder(root.right);
            //when its root, add < root.value >
            if(this.root.value == root.value){
                System.out.println("<"+root.value+">");
            }else{
                System.out.println(root.value);
            }

        }
    }
    public int getSize(){
        return getSize(root);
    }
    private int getSize(Node root){
        if(root==null){
            return 0;
        }
        return 1 + getSize(root.left) + getSize(root.right);
    }
    int getHeight(){
        return getHeight(root);
    }
    private int getHeight(Node root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right== null){
            return 1;
        }
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
    void printLevelWise(int level){
        printLevelWise(root, level);
    }
    private void printLevelWise(Node root, int level){
        if(root == null){
            return;
        }
        int currentLevel = 0;

        java.util.Queue<Node> nodesQ = new java.util.LinkedList<>();
        java.util.Queue<Integer> levelQ = new java.util.LinkedList<>();
        //java.util.PriorityQueue<Integer> maxHeap = new PriorityQueue<>(((o1, o2) -> o1 > o2? -1 : (o1< o2? 1: 0)));
        //java.util.PriorityQueue<Integer> maxHeap = new PriorityQueue<>(((o1, o2) -> o1.value > o2.value ? -1 : (o1.value < o2.value ? 1: 0)));

        nodesQ.offer(root);
        levelQ.offer(currentLevel+1);

        while(!nodesQ.isEmpty()){
            Node node = nodesQ.poll();

            if(currentLevel == level){
                //maxHeap.offer(node.value);
                System.out.println(node.value);
            }
            if(node.left!= null || node.right!= null){
                if(node.left!=null){
                    nodesQ.offer(node.left);
                }
                if(node.right!=null){
                    nodesQ.offer(node.right);
                }
                currentLevel++;
            }
        }

    }
    void getMaxKAtLevelL(int level, int numberCount){
        getMaxKAtLevelL(root, level, numberCount);
    }
    private void getMaxKAtLevelL(Node root, int level, int numberCount){
        if(root == null){
            return;
        }
        int currentLevel = 0;

        java.util.Queue<Node> nodesQ = new java.util.LinkedList<>();
        java.util.Queue<Integer> levelQ = new java.util.LinkedList<>();
        java.util.PriorityQueue<Integer> maxHeap = new PriorityQueue<>(((o1, o2) -> o1 > o2? -1 : (o1< o2? 1: 0)));

        nodesQ.offer(root);
        levelQ.offer(currentLevel+1);

        while(!nodesQ.isEmpty()){
            Node node = nodesQ.poll();

            if(currentLevel == level){
                //if(node.value > maxHeap.peek())
                    maxHeap.offer(node.value);
            }
            if(node.left!= null || node.right!= null){
                if(node.left!=null){
                    nodesQ.offer(node.left);
                }
                if(node.right!=null){
                    nodesQ.offer(node.right);
                }
                currentLevel++;
            }
        }

    }
    private void printHeap(java.util.PriorityQueue<Integer> pq){
        int size = pq.size();
        for (int i = 0; i < size; i++) {
            System.out.println(pq.poll());
        }
    }
}

