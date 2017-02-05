package ProjectEuler.Set2;

import java.util.Scanner;

/**
 * Created by Nikhil on 2/5/2017 3:06 PM.
 */
public class P18MaximumPathSumI {
    static int N;
    static int[][] array;
    static int[][] dp;

    public static void main(String[] args) {
        array = new int[20][20];            //since max value of N - 15
        dp = new int[20][20];            //since max value of N - 15

        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int N = scanner.nextInt();
            for (int row = 0; row < N; row++) {
                for (int col = 0; col <= row; col++) {
                    array[row][col] = scanner.nextInt();
                }
            }

            /*for (int row = 0; row < N; row++) {
                dp[row][0] = 0;
            }*/
            //dp[1][1] = array[0][0];

            for (int row = 1; row <= N; row++) { //start from 1st row
                for (int col = 1; col <= row; col++) {
                    dp[row][col] = array[row-1][col-1] /* current */
                            + Math.max(dp[row-1][col-1]/* top left*/,
                                            dp[row-1][col] /*top */     //remove top right, because we don't need it.
                                    );
                    //check top left, top , top right from dp[][] and not from original array
                    //only use original array to add value like this array[row-1][col-1] + ...Max
                }
            }
            
            //last row has all addition, find out max out of last row.
            int result = Integer.MIN_VALUE;
            for (int col = 0; col <= N; col++) {            //Changed <N to <=N
                if(dp[N][col]> result) result = dp[N][col];
            }
            System.out.println("result = " + result);
            
            /*
            //Other way without using other array
            for (int row = 1; row < N; row++) {
                for (int col = 0; col <= row; col++) {
                    int topLeft = 0;
                    if(col==0) topLeft = 0;
                    else topLeft = array[row-1][col-1];

                    int topRight = 0;
                    if(col==row) topRight=0;
                    else topRight = array[row-1][col];

                    array[row][col] += Math.max(topLeft,topRight);
                }
            }
            result = 0;
            for (int col = 0; col < N; col++) {            //Changed <N to <=N
                result = Math.max(result, array[N-1][col]);
            }
            System.out.println("result = " + result);
*/

        }
    }
}

/*
  |0 1 2 3        0 1 2 3 4
0 |3            0 0 0
1 |7 4          1 0 3
2 |2 4 6        2 0 10 7
3 |8 5 9 3      3 0 12 14 13
                4 0 22 19 23 16
 */
