package Patterns.educative.io.java1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class H_TreeDepthFirstSearch {
    static boolean exist = false;
    public static boolean pathSumRootToLeaf(TreeNode root, int sum) {
        exist = false;
        dfs(root, sum, 0);
        return exist;
    }
    private static void dfs(TreeNode root, int sum, int currSum) {
        if (root == null) return;
        currSum += root.val;
        if (root.left == null && root.right == null) {
            if (currSum == sum) exist = true;
            return;
        }
        if (root.left != null) dfs(root.left, sum, currSum);
        if (root.right != null) dfs(root.right, sum, currSum);
    }

    static List<List<Integer>> result = new ArrayList<>();
    public static List<List<Integer>> allPathSum1(TreeNode root, int targetSum) {
        if(root==null) return result;
        helper(root, targetSum, result, new ArrayList<>());
        return result;
    }

    public static void helper(TreeNode root, int targetSum, List<List<Integer>> result, List<Integer> currentList){         //make currentList of type Integer and not TreeNode
        if(root==null) return ;

        currentList.add(root.val);          //add root.val and not root

        if(root.left == null && root.right ==null && root.val == targetSum){
            //result.add(new ArrayList<>(currentList));        //add return boolean, dont return directly   + REMEMBER add as a NEW LIST
            result.add(currentList);        //add return boolean, dont return directly   + REMEMBER add as a NEW LIST
            //return result;
        }

        //else if(root.left == null && root.right ==null && root.val != targetSum){
        // currentList.remove(currentList.size()-1);
        // }

        helper(root.left, targetSum - root.val, result, new ArrayList<>(currentList)); // REMEMBER add as a NEW LIST
        helper(root.right, targetSum - root.val, result, new ArrayList<>(currentList)); //+ REMEMBER add as a NEW LIST
        //return result;
    }
    public static List<List<Integer>> allPathSum2(TreeNode1 root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        dfs(root, targetSum, new ArrayList<>(), 0, res);
        return res;
    }
    private static void dfs(TreeNode1 root, int sum, List<Integer> list, int currSum, List<List<Integer>> res) {
        if (root == null) return;
        currSum += root.val;
        list.add(root.val);
        if (root.left == null && root.right == null) {
            if (currSum == sum) res.add(new ArrayList<>(list));         //its a new ArrayList
            return;
        }
        if (root.left != null) {
            dfs(root.left, sum, list, currSum, res);
            list.remove(list.size()-1);
        }
        if (root.right != null) {
            dfs(root.right, sum, list, currSum, res);
            list.remove(list.size()-1);
        }
    }

    public static List<String> rootToLeafPaths(TreeNode root) {
        List<String> answer = new ArrayList<String>();
        if (root != null) dfs(root, "", answer);
        return answer;
    }
    private static void dfs(TreeNode root, String path, List<String> answer) {
        if (root.left == null && root.right == null) answer.add(path + root.val);
        if (root.left != null) dfs(root.left, path + root.val + "->", answer);
        if (root.right != null) dfs(root.right, path + root.val + "->", answer);
    }
    public static void main(String[] args) {
        TreeNode1 root = new TreeNode1(12);
        root.left = new TreeNode1(7);
        root.right = new TreeNode1(1);
        root.left.left = new TreeNode1(4);
        root.right.left = new TreeNode1(10);
        root.right.right = new TreeNode1(5);
        int sum = 23;
        List<List<Integer>> result = H_TreeDepthFirstSearch.allPathSum2(root, sum);
        System.out.println("Tree paths with sum " + sum + ": " + result);
    }

    public static  int rootToLeafSumOfPaths(TreeNode root) {
        return sumNodes(root, 0);
    }
    private static int sumNodes(TreeNode root, int currentSum) {
        if (root == null) return 0;
        currentSum = currentSum * 10 + root.val;
        if (root.left == null && root.right == null) return currentSum;
        int leftSum = sumNodes(root.left, currentSum);
        int rightSum = sumNodes(root.right, currentSum);
        return leftSum + rightSum;
    }

    public static boolean findPathWithGivenSequence(TreeNode1 root, int[] sequence) {
        if (root == null) return sequence.length == 0;
        return dfs(root, sequence, 0);
    }

    private static boolean dfs(TreeNode1 root, int[] sequence, int index) {
        if (root == null) return false;
        //check if index is out of bound  or if current val is not equal of index of sequence value. Return false.
        if (index >= sequence.length || root.val != sequence[index]) return false;
        // not check for leaf node condition, and also check for index condition if its sequence.length-1 then only return true. or false.
        if (root.left == null && root.right == null) {
            if (index == sequence.length-1) return true;
            return false;
        }
        //as we need to access any one the path either from left or right, we are going to use OR condition.
        return dfs(root.left, sequence, index+1) || dfs(root.right, sequence, index+1);
    }

    static int count;
    public static int pathSumFromAnyNode(TreeNode root, int targetSum) {
        //count  = bruteForce( root,  targetSum);
        count = pathSumHashMap( root,  targetSum);      // prefix sum
        return count;
    }
    public static int bruteForce(TreeNode root, int targetSum) {
        if(root==null) return 0;
        List<Integer> paths = new ArrayList<>();
        helper(root, targetSum, 0, paths);
        return count;
    }

    public static void helper(TreeNode root, int targetSum, int currentSum, List<Integer> paths){
        if(root==null) return;

        if(currentSum + root.val == targetSum){
            paths.add(root.val);
            count++;
            return;
        } else if( root.val + currentSum < targetSum ){
            currentSum += root.val;
            paths.add(root.val);
        }

        helper(root.left, targetSum, currentSum, new ArrayList<>(paths));
        helper(root.right, targetSum, currentSum,  new ArrayList<>(paths));
    }
    public static int pathSumHashMap(TreeNode root, int targetSum) {
        int count = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);

        count = helper(root, targetSum, 0, map);
        return count;
    }

    public static int helper(TreeNode root, int targetSum, int currentSum, Map<Integer,Integer> map){
        if(root==null) return 0;

        currentSum = currentSum + root.val;
        int count = map.getOrDefault(currentSum- targetSum , 0);

        //add to the map before calling children
        map.put(currentSum, map.getOrDefault(currentSum,0)+1);

        count = count
                + helper(root.left, targetSum, currentSum, map)
                + helper(root.right, targetSum, currentSum, map);

        //remove before going to parents another child
        map.put(currentSum, map.get(currentSum)-1);         //no need to use get or Default as we already added it in previous steps. SO we know its there.

        return count;
    }

    static int total=0;
    public static int pathSumFromAnyNode2(TreeNode root, int targetSum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        if(root==null)return 0;
        map.put(0,1);
        dfs(root , map , targetSum , 0);
        return total;
    }
    private static void dfs(TreeNode root , HashMap<Integer,Integer>map, int target , int currSum){
        if(root==null)return;
        currSum+=root.val;
        if(map.containsKey(currSum-target)){            // currSum is sum of path from root till this node. if we negate target, and we can check if remaining number
            int temp =  map.get(currSum-target);                // is in hashmap or not. so this prefix sum can help to get the required path and we increment the count.
            total+=temp;
        }
        map.put(currSum , map.getOrDefault(currSum , 0)+1); //  Increment frequency of current sum.

        dfs(root.left , map , target , currSum);        //repeat it for left and then right
        dfs(root.right , map , target , currSum);

        map.put(currSum , map.get(currSum)-1);  //remove current node frequency / removing the frequecy of parent node once we took care of its child sum including root
        /*    10                when we are at level 2 (3) node, once that subtree is done, and we are moving to right child of 5.
               /\                  we need to make sure that we are not including left child 3 of 5 again.
             5   -3                 hence we need to decrease the frequency of 3 at the end.
            /\     /\
          3  2       11
         /\  /\
        3  -2 1
         */
    }
    public static  int pathSumFromAnyNode3(TreeNode root, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        return pathSum2(root, 0, sum, map);
    }

    public static int pathSum2(TreeNode root, int runningSum, int target, Map<Integer, Integer> map) {
        if (root == null) {
            return 0;
        }

        runningSum += root.val;
        int count = map.getOrDefault(runningSum - target, 0);       //first get the count of diff of current sum and targer, (prefix value which can be removed)
        map.put(runningSum, map.getOrDefault(runningSum, 0) + 1);   //increment fre of current running sum

        count += pathSum2(root.left, runningSum, target, map)       //do same for left and right child. and add their counts
                + pathSum2(root.right, runningSum, target, map);           // to count variable.

        map.put(runningSum, map.get(runningSum) - 1);           //decrement the current node frequency to move to other subtree
        return count;
    }
    /*
                   5                            22
              ____________
             |           |
             4           8
         _________   _________
         |       |  |         |
        11     null 13        4
    ________               ________
    |       |             |       |
    7       2             5       1
*/

    static int max;
    public static int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }

    private static int maxDepth(TreeNode root) {        //post order
        if (root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        max = Math.max(max, left + right);

        return Math.max(left, right) + 1;
    }

    static int max1 = Integer.MIN_VALUE;
    public static int maxPathSum2(TreeNode root) {
        if(root==null) return 0;

        helper(root);

        return max1;
    }
    public static int helper(TreeNode root){    //post order
        if(root==null) return 0;

        int l = helper(root.left);
        int r = helper(root.right);

        int localMax = Math.max (Math.max(root.val, root.val + l),  //not l.val but just l as its int
                Math.max(root.val + r, root.val + l + r));

        max1 = Math.max(localMax, max);

        return Math.max(root.val, Math.max(root.val+l, root.val + r));
    }

    public static int maxPathSum(TreeNode root) {
        // TODO: Write your code here
        if (root == null) return 0;
        max = Integer.MIN_VALUE;
        dfs(root);
        return max;
    }

    private static int dfs(TreeNode root) {     //postorder
        if (root == null) return 0;
        int left = Math.max(dfs(root.left), 0);
        int right = Math.max(dfs(root.right), 0);
        max = Math.max(left+right+root.val, max);
        return Math.max(left, right) + root.val;
    }

    private static int max3 = Integer.MIN_VALUE;

    public static int maxPathSum3(TreeNode root){
        postOrder(root);
        return max3;
    }

    private static int postOrder(TreeNode root){
        if(root ==null) return 0;

        int left = Math.max(  postOrder(root.left)  , 0 );            //adding math.max with bounding to zero as we don't want negative values to boil up. as we are calculating max
        int right = Math.max( postOrder(root.right) , 0  ) ;

        //once we are out to recursive calls we are going to compute our new maximum
        max3 = Math.max(max3, left + right + root.val);
        return Math.max(left,right) + root.val;     //reason why we are only taking either left or right because, we want to
                                                                            // take either of the straight path and not both paths (subtrees) at a time.
    }
}



