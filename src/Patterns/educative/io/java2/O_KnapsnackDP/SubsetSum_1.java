package Patterns.educative.io.java2.O_KnapsnackDP;

class SubsetSum_1 {

    public boolean canPartition(int[] num, int sum) {
        int res = 0;
        for (int i: num) res += i;
        if (res < sum) return false;
        boolean[][] dp= new boolean[num.length][sum+1];
        for (int i = 0; i < num.length; i++) dp[i][0] = true;
        if (num[0] <= sum) dp[0][num[0]] = true;
        for (int i = 1; i < num.length; i++) {
            for (int j = 1; j < sum+1; j++) { //e.g. 2,2,3 sum=5
                if (j < num[i]){        //e.g to have sum=1 num[i=1]=2  -> 1<2 ->we can't have sum including 2. Hence copy false from above
                    dp[i][j] = dp[i-1][j];  //copy row above value
                } else {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-num[i]];// for sum=2 and nums[ | explained below
                }
                if (j == sum && dp[i][j]){
                    return true;
                }
            }
        }
        return false;
    }
    /*
                    0 1 2 3 4 5 6
   nums  [0] T  F F F  F  F  F
   nums  [1] T  F
   nums  [2] T
   nums  [3] T
   For every sum we have 2 options from recursive call.
   Either to take that number of not to take that number. (OR condition)
        -> first column T meaning that to get sum = 0 (if I include nums[ith] number) | not include that number
                                                                             = F | T = T hence its all true (we do not require any number to get sum 0)

        -> first row is false, b/c to get any sum more than 1, if i include or don't include zero 0. I cant never get that no. Hence false.
                   0 1 2 3 4 5 6
   nums  [0] T F F F  F  F  F
   nums  [1] T F ?
   nums  [2] T
   nums  [3] T
        -> To get sum =2, if I include 2 can I get the sum ?
            -> (include | not include)
            -> (If we include 2, remaining sum is sum-2=2-2=0) | (not include = F we cant get 2 if we exclude 2)
                    How to get row ?
                        so we need to check for which no to include to get
                        zero as remaining sum.
                        As we already considered nums[1] =2 (included)
                        we cant include same no again hence
                        we need to check for nums[i-1]row.  ..
                    What about col?
                        now see how we calculated remaining sum
                        2 - sum = 0 (2 is current jth element. and sum[ith] is current sum
                     row = i-1 = 1-1 = 0
                     col = 2 -nums[i]=2-sum=2-2=0
                     [row][col]=T
                     T | F = T

     */

    public static void main(String[] args) {
        SubsetSum_1 ss = new SubsetSum_1();
        int[] num = { 1, 2, 3, 7 };
        System.out.println(ss.canPartition(num, 6));
        num = new int[] { 1, 2, 7, 1, 5 };
        System.out.println(ss.canPartition(num, 10));
        num = new int[] { 1, 3, 4, 8 };
        System.out.println(ss.canPartition(num, 6));
    }
}