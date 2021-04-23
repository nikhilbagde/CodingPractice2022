package LeetCode.CompanyBased.Facebook;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P_199_RightSideViewOfATree {
    public static void main(String[] args) {

    }
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        List<Integer> result = new ArrayList<>();

        while(!queue.isEmpty()){
            TreeNode currentNode =null;
                                                                                                                            //System.out.println("queue.size() = " + queue.size());
            int size = queue.size();                                                                        // take the size variable here, since queue size will change after polling
            for( int i=0; i< size; i++){
                currentNode = queue.poll();
                                                                                                                        // System.out.println("queue.poll = " + currentNode.val);

                                                                                                                        //    System.out.println("i = " + i);
                //if(i==size-1){
                                                                                                                         //                           System.out.println("i = " + i);
                //  result.add(currentNode.val);
                //}

                if(currentNode!=null && currentNode.left!=null){
                    queue.offer(currentNode.left);
                }
                if(currentNode!=null && currentNode.right!=null){
                    queue.offer(currentNode.right);
                }
            }

            if(currentNode!=null)
                result.add(currentNode.val);

        }
        return result;
    }

    private  static  class TreeNode {
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
}
