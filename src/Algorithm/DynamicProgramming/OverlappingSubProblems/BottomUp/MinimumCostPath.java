package Algorithm.DynamicProgramming.OverlappingSubProblems.BottomUp;

/**
 * Created by Nikhil on 1/6/2017 11:12 PM.
 * The path to reach (m, n) must be through one of the 3 cells: (m-1, n-1) or (m-1, n) or (m, n-1).
 * So minimum cost to reach (m, n) can be written as “minimum of the 3 cells plus cost[m][n]”.
 * minCost(m, n) = min (minCost(m-1, n-1), minCost(m-1, n), minCost(m, n-1)) + cost[m][n]
 */
public class MinimumCostPath {
    public static void main(String[] args) {
        int[][] cost = { {1,2,3},
                         {4,8,2},
                         {1,5,3}};
        int minCost = minCost(cost, 2,2);
        System.out.println("MinimumCost to reach array position 2,2 = " + minCost);
    }
    private static int minCost(int[][]cost, int destM, int destN){
        int[][] dp = new int[destM+1][destN+1];    //destM and destN are not size its destination location
        dp[0][0] = cost[0][0];
        for (int row = 1; row <=destM ; row++) {
            dp[row][0]= dp[row-1][0]+ cost[row][0];
        }
        for (int col = 1; col <=destN ; col++) {
            dp[0][col]= dp[0][col-1]+ cost[0][col];
        }
        for (int row = 1; row <=destM ; row++) {
            for (int col = 1; col <=destN ; col++) {
                dp[row][col] = min(dp[row-1][col],dp[row][col-1],dp[row-1][col-1]) + cost[row][col];
            }
        }
        return dp[destM][destN];
    }
    private static int minCostExplained(int[][]cost, int m, int n){
        int[][] dp = new int[m+1][n+1];    //m and n are not size its destination location
        /* Step  - set d[0][0] = cost[0][0] = 1
        d = { {1,0,0},        cost = { {1,2,3},
              {0,0,0},                 {4,8,2},
              {0,0,0},                 {1,5,3}};
        */
        dp[0][0] = cost[0][0];              //dp[0][0]=1; dont forget to set first value.

        /* Step 2 - find distance from 0,0 to all col elements.
        d = { {1,0,0},        cost = { {1,2,3},
              {1+4,0,0},               {4,8,2},
              {5+1,0,0},               {1,5,3}};
        */
        for (int row = 1; row <=m ; row++) {
            dp[row][0]= dp[row-1][0]+ cost[row][0];     //for first column =
            // distance of current col = prev Col distance + current col distance from given cost matrix
        }
        /* Step 3 row copy
        d = { {1,1+2=3 ,3+3=6},     cost = { {1,2,3},
              {5,0,0},                       {4,8,2},
              {6,0,0},                       {1,5,3}};
        */
        for (int col = 1; col <=n ; col++) {
            dp[0][col]= dp[0][col-1]+ cost[0][col];     //for first row =
            // distance of current row = prev row distance + current row distance from given cost matrix
        }
        //System.arraycopy(cost[0], 1, dp[0], 1, n);

        /* Step 4 cal dis from 1,1 to other row wise and then col.
        d = { {1,3,6),               cost = {{1,2,3},
              {5,0,0},                       {4,8,2},                   8+1=9,3+2=5
              {6,0,0},                       {1,5,3}};                  5+5=10,5+3=8
        */
        for (int row = 1; row <=m ; row++) {
            for (int col = 1; col <=n ; col++) {
                dp[row][col] = min(dp[row-1][col],dp[row][col-1],dp[row-1][col-1]) + cost[row][col];
            }
        }
        /* Step 5  1,1 = min 1|3|5+8=9
        d = { {1,3,6),               cost = {{1,2,3},                 d=  1,3,6
              {5,1+8=9,3+2=5},               {4,8,2},                     5,9,5
              {6,5+5=10,5+3=8},              {1,5,3}};                    6,10,'8'
        */

        return dp[m][n];
    }
    private static int min(int a, int b, int c){
        if(a<b && a<c) return a;
        if(b<a && b<c) return b;
        return c;
    }
}
