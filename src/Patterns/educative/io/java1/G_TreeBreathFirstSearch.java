package Patterns.educative.io.java1;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class TreeNode1 {
    int val;
    TreeNode1 left;
    TreeNode1 right;
    TreeNode1 next;

    TreeNode1(int x) {
        val = x;
    }
}
public class G_TreeBreathFirstSearch {
    public static List<List<Integer>> levelOrderTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int num = queue.size();
            List<Integer> traversal = new ArrayList<>();
            while (num > 0) {       //or for loop
                TreeNode currRoot = queue.poll();
                traversal.add(currRoot.val);
                if (currRoot.left != null) queue.add(currRoot.left);
                if (currRoot.right != null) queue.add(currRoot.right);
                num--;
            }
            result.add(traversal);
        }
        return result;
    }

    public static List<List<Integer>> reversalLevelOrderTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int num = queue.size();
            List<Integer> traversal = new ArrayList<>();
            while (num > 0) {       //or for loop
                TreeNode currRoot = queue.poll();
                traversal.add(currRoot.val);
                if (currRoot.left != null) queue.add(currRoot.left);
                if (currRoot.right != null) queue.add(currRoot.right);
                num--;
            }
            result.add(0, traversal);
        }
        return result;
    }

    public static List<List<Integer>> zigZagLevelOrderTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean leftToRight = true;
        while (!queue.isEmpty()) {
            int num = queue.size();
            List<Integer> traversal = new ArrayList<>();
            while (num > 0) {       //or for loop
                TreeNode currRoot = queue.poll();
                if(leftToRight)
                    traversal.add(currRoot.val);
                else
                    traversal.add(0, currRoot.val);

                if (currRoot.left != null) queue.add(currRoot.left);
                if (currRoot.right != null) queue.add(currRoot.right);
                num--;
            }
            leftToRight = !leftToRight;
            result.add(traversal);
        }
        return result;
    }

    public static List<Double> levelOrderAverage(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            result.add((double)sum/size);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<List<Integer>> result = G_TreeBreathFirstSearch.levelOrderTraversal(root);
        System.out.println("Level order traversal: " + result);
    }

    public static int minDepthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int level = 0;

        while(!q.isEmpty()){
            level++;
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode current = q.poll();
                if(current!=null && current.left==null && current.right==null){
                    return level;
                }
                if ( current!=null && current.left!=null){
                    q.offer(current.left);
                }
                if( current!=null && current.right!=null){
                    q.offer(current.right);
                }
            }
        }
        return -1;
    }

    public static TreeNode levelOrderSuccessor(TreeNode root, int key) {

        if(root==null) return root;
        if( root.val == key){
            return root;
        } else if( root.left!=null && root.val == key){
            return root.left;
        } else if( root.right!=null && root.val == key){
            return root.right;
        }

        Queue<TreeNode> q= new LinkedList<>();
        q.offer(root);

        //set this variable when key is found, so that in next for loop iteration
        // on same level it will return next node.

        //even though key node is last node in the level
        //since this found variable is outside, moving to next level with next for loop
        // should return the next node.
        boolean found = false;

        while(!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size ; i++) {
                TreeNode node = q.poll();
                if(found) return node;
                assert node != null;
                if(node.val == key) found = true;

                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
            }
        }
        return null;
    }
    public static TreeNode1 connectLevelOrderSiblings(TreeNode1 root) {
        if(root==null) return null;

        Queue<TreeNode1> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();
            TreeNode1 prev = null;
            for (int i = 0; i < size; i++) {
                TreeNode1  node = q.poll();
                if(prev!=null) prev.next = node;
                prev = node;
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
            }
        }
        return root;
    }

    public static TreeNode1 connectAllSiblings(TreeNode1 root) {
        if(root==null) return root;

        Queue<TreeNode1>q = new LinkedList<>();
        q.offer(root);
        TreeNode1 prev = null;

        while(!q.isEmpty()){
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode1 current = q.poll();
                if(prev!=null) prev.next = current;
                prev= current;

                if(current.left!=null) q.offer(current.left);
                if(current.right!=null) q.offer(current.right);
            }
        }
        return root;
    }

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root==null) return Collections.emptyList();

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();
            TreeNode current = null;

            for (int i = 0; i < size ; i++) {
                current = q.poll();

                if(current.left!=null) q.offer(current.left);
                if(current.right!=null) q.offer(current.right);
            }
            result.add(current.val);
        }
        return result;
    }
}
