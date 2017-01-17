package Algorithm.ConstructiveAlgorithms;

import java.util.Scanner;

/**
 * Created by Nikhi on 12/13/2016 12:03 PM.
 */
public class FlippingTheMatrix2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();
        for (int test = 0; test < testCases; test++) {
            int n = in.nextInt();
            int sum = 0;
            int[][] matrix = new int[2 * n][2 * n];
            for (int row = 0; row < 2 * n; row++) {
                for (int col = 0; col < 2 * n; col++) {
                    int value = in.nextInt();
                    matrix[row][col] = value;
                }
            }
            for (int row = 0; row < 2 * n; row++) {
                for (int col = 0; col < 2 * n; col++) {
                    //sum += Math.max(Math.max(Math.max(arr[i][j],arr[i][2*n-j-1]),arr[2*n-i-1][j]),arr[2*n-i-1][2*n-j-1]);
                    sum += Math.max(Math.max(Math.max(matrix[row][col], matrix[row][2 * n - col - 1]), matrix[2 * n - row - 1][col]), matrix[2 * n - row - 1][2 * n - col - 1]);
                }
            }
        }
    }
}
