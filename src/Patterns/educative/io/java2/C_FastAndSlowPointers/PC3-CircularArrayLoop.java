package Patterns.educative.io.java2.C_FastAndSlowPointers;

class CircularArrayLoop {

    public static boolean loopExists(int[] nums) {
        // Handle bad input
        if (nums == null || nums.length < 2) return false;

        boolean[] visit = new boolean[nums.length];
        /*
         * Check every possible start location.
         * We may start at a short-loop, for instance, but the Array
         * may still contain a valid loop.
         */
        for (int i = 0; i < nums.length; i++) {
            /*
             * We visit to true which are on known non-loop paths.
             * So, if we encounter visit == true, we know we're not on a loop path.
             * So, move to the next start location in the list.
             */
            if (visit[i]) continue;

            int fast = nextJumpIndex(nums, i);
            int slow = i;
            while (fast != slow && !visit[fast] && !visit[slow]) {
                if (nums[fast] * nums[nextJumpIndex(nums, fast)] < 0) break;
                fast = nextJumpIndex(nums, nextJumpIndex(nums, fast));
                slow = nextJumpIndex(nums, slow);
            }
            visit[i] = true;
            if (slow == nextJumpIndex(nums, slow)) {
                visit[slow] = true;
                continue;
            } else if (slow == fast) return true;
        }
        return false;
    }

    private static int nextJumpIndex(int[]nums, int curr) {
        int res = (curr+nums[curr]) % nums.length;      // Add current index value nums[curr] to current index. E.g. at index 3 we have nums[3] = -1. so 3 + (-1) = 2 ; 2%5=2
        return res >= 0 ? res : res+nums.length;        // if its a positive value then we directly take it, in case its negative we add to length. E.g. -1, we need to go back. 5-1.
    }

    public static void main(String[] args) {
        System.out.println(CircularArrayLoop.loopExists(new int[] { 1, 2, -1, 2, 2 }));
        System.out.println(CircularArrayLoop.loopExists(new int[] { 2, 2, -1, 2 }));
        System.out.println(CircularArrayLoop.loopExists(new int[] { 2, 1, -1, -2 }));
    }
}