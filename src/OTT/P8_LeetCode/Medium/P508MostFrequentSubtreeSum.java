package LeetCode.Medium;

public class P508MostFrequentSubtreeSum {
    static java.util.Map<Integer, Integer> sumToCountMap;
    static int maxCount;

    public static void main(String[] args) {
        findFrequentTreeSum(new TreeNode(1));
    }

    private static int[] findFrequentTreeSum(TreeNode root) {
        maxCount = 0;
        sumToCountMap = new java.util.HashMap<>();
        postOrder(root);

        //now we have map full of Sum <-> count.
        java.util.List<Integer> result1 = new java.util.ArrayList<>();
        for (int key : sumToCountMap.keySet()) {
            //find key with max count.
            if (sumToCountMap.get(key) == maxCount) {
                result1.add(key);
            }
        }
        int[] result = new int[result1.size()];
        for (int i = 0; i < result1.size(); i++) {
            result[i] = result1.get(i);
        }

        return result;
    }

    //All is about this post order method.
    private static int postOrder(TreeNode root) {        //return 0 not null.
        if (root == null) return 0;
        int left = postOrder(root.left);
        int right = postOrder(root.right);
        int sum = left + right + root.val;
        //extra work. Putting to map and all.
        int newCount = sumToCountMap.getOrDefault(sum, 0) + 1;
        sumToCountMap.put(sum, newCount);
        maxCount = Math.max(newCount, maxCount);

        return sum;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
