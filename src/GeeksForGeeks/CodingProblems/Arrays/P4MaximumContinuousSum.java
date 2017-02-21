package GeeksForGeeks.CodingProblems.Arrays;

/**
 * Created by Nikhil on 2/20/2017 10:42 AM.
 */
public class P4MaximumContinuousSum {
    public static void main(String[] args) {
        int[] array = {-2, -3, 4, -1, -2, 1, 5, -3};
        findMaxConSum1(array);
        findMaxConSum2DP(array);
        int result = findMaxConSum3KadaneAlgo(array);
        System.out.println("result = " + result);
    }

    private static int findMaxConSum1(int[] array) {
        int result = array[0];
        for (int i = 1; i < array.length; ++i) {
            if (result < result + array[i]) {
                result += array[i];
            }
            //incomplete!
        }
        return result;
    }

    private static int findMaxConSum2DP(int[] array) {
        int N = array.length;
        int[][] dp = new int[N + 1][N + 1];

        for (int col = 1; col < dp.length; ++col) {
            dp[0][col] = array[col - 1];
        }
        for (int row = 1; row < dp.length; ++row) {
            //     dp[row][0] = array[row-1];
        }
        for (int row = 1; row < dp.length; ++row) {
            for (int col = row; col < dp.length; ++col) {
                int sum = dp[row - 1][col] + dp[row][col - 1];
                int topCheck = dp[row - 1][col] > sum ? dp[row - 1][col] : sum;
                int tillNowSum = dp[row][col - 1] + dp[0][col] > dp[row][col] ? dp[row][col - 1] + dp[0][col] : dp[row][col];
                int top = tillNowSum > dp[row - 1][col] ? tillNowSum : dp[row - 1][col];
//              int left = top > dp[row][col-1] ? top : dp[row][col-1];
                dp[row][col] = sum;

                //didn't complete.
            }
        }
        //print2DArray(dp);

        return dp[N][N];

    }

    private static void print2DArray(int[][] array) {
        for (int row = 0; row < array.length; ++row) {
            for (int col = 0; col < array.length; ++col) {
                System.out.printf("%5d", array[row][col]);
            }
            System.out.println();
        }
    }

    private static int findMaxConSum3KadaneAlgo(int[] array) {
        int maxTillHere = 0, maxSoFar = 0;
        int[] dual = new int[2];

        for (int i = 0; i < array.length; ++i) {
            maxTillHere = maxTillHere + array[i];
            if (maxTillHere < 0) maxTillHere = 0;

            if (maxTillHere > maxSoFar) {
                maxSoFar = maxTillHere;
                if (dual[0] == 0) dual[0] = i;
                else dual[1] = i;
            }
        }
        System.out.println("Index = " + (dual[0] + 1) + ", " + (dual[1] + 1));
        return maxSoFar;
    }
}