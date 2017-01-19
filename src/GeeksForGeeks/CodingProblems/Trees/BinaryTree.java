package GeeksForGeeks.CodingProblems.Trees;

import java.util.PriorityQueue;

/**
 * Created by Nikhil on 1/17/2017 9:23 PM.
 */
public class BinaryTree {

    private TreeNode root;
    public BinaryTree(){
        root = null;
    }
    public BinaryTree(int n){
        root.value = n;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public void insert(int valueIn){
        if(root ==  null){
            root = new TreeNode(valueIn);
        }else {
            insertNode(root, valueIn);
        }
    }
    private TreeNode insertNode(TreeNode root, int valueIn){
        if(valueIn < root.value){
            if(root.left ==  null){
                root.left = new TreeNode(valueIn);
            }else{
                insertNode(root.left, valueIn);
            }
        }else if(valueIn > root.value){
            if(root.right == null){
                root.right = new TreeNode(valueIn);
            }else{
                insertNode(root.right, valueIn);
            }
        }else{
            System.out.println("Duplicate Value Discarded.");
        }
        return root;
    }
    public void preOrder(){
        preOrder(root);
    }
    private void preOrder(TreeNode root){
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
    public void inOrder(){
        inOrder(root);
    }
    private void inOrder(TreeNode root){
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
    public void postOrder(){
        postOrder(root);
    }
    private void postOrder(TreeNode root){
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
    private int getSize(TreeNode root){
        if(root==null){
            return 0;
        }
        return 1 + getSize(root.left) + getSize(root.right);
    }
    public int getHeight(){
        return getHeight(root);
    }
    private int getHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right== null){
            return 1;
        }
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
    public void printLevelWise(int level){
        printLevelWise(root, level);
    }
    private void printLevelWise(TreeNode root, int level){
        if(root == null){
            return;
        }
        int currentLevel = 0;

        java.util.Queue<TreeNode> nodesQ = new java.util.LinkedList<>();
        java.util.Queue<Integer> levelQ = new java.util.LinkedList<>();
        //java.util.PriorityQueue<Integer> maxHeap = new PriorityQueue<>(((o1, o2) -> o1 > o2? -1 : (o1< o2? 1: 0)));
        //java.util.PriorityQueue<Integer> maxHeap = new PriorityQueue<>(((o1, o2) -> o1.value > o2.value ? -1 : (o1.value < o2.value ? 1: 0)));

        nodesQ.offer(root);
        levelQ.offer(currentLevel+1);

        while(!nodesQ.isEmpty()){
            TreeNode node = nodesQ.poll();

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
    public void getMaxKAtLevelL(int level, int numberCount){
        getMaxKAtLevelL(root, level, numberCount);
    }
    private void getMaxKAtLevelL(TreeNode root, int level, int numberCount){
        if(root == null){
            return;
        }
        int currentLevel = 0;

        java.util.Queue<TreeNode> nodesQ = new java.util.LinkedList<>();
        java.util.Queue<Integer> levelQ = new java.util.LinkedList<>();
        java.util.PriorityQueue<Integer> maxHeap = new PriorityQueue<>(((o1, o2) -> o1 > o2? -1 : (o1< o2? 1: 0)));

        nodesQ.offer(root);
        levelQ.offer(currentLevel+1);

        while(!nodesQ.isEmpty()){
            TreeNode node = nodesQ.poll();

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
