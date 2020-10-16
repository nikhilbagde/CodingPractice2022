package LeetCode.Patterns.BFS;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
 int val;
 TreeNode left;
 TreeNode right;
 TreeNode() {}
 TreeNode(int val) { this.val = val; }
 TreeNode(int val, TreeNode left, TreeNode right) {
  this.val = val;
  this.left = left;
  this.right = right;
 }
}

public class LC_107_Binary_Tree_Level_Order_Traversal_II {
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
    if(root==null)
      return new ArrayList<>();

    List<List<Integer>> result = new ArrayList<>();
   Queue<TreeNode> queue = new LinkedList<>();

   queue.add(root);

   while(queue.size()!=0){
       List<Integer> levelList = new ArrayList<>();
       int nodeCount = queue.size();

       while(nodeCount>0){
           TreeNode  currentNode = queue.poll();
           levelList.add(currentNode.val);

           if(currentNode.left!=null){
               queue.offer(currentNode.left);
           }
           if(currentNode.right!=null){
               queue.offer(currentNode.right);
           }
           nodeCount--;
       }

       //result.add(levelList);
       result.add(0, levelList);
   }
   return result;
  }

  public static TreeNode prepareATree(TreeNode root){
        root.val=3;
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left=  new TreeNode(15);
        root.right.right = new TreeNode(7);
    return root;
  }

    public static void main(String[] args) {
        TreeNode root = prepareATree(new TreeNode());
        List<List<Integer>> result = levelOrderBottom(root);
        System.out.println(result);
    }
}
