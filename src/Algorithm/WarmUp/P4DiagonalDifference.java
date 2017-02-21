package Algorithm.WarmUp;

import java.util.Scanner;

import static java.lang.System.in;

/**
 * Created by Nikhil on 2/10/2017 2:13 AM.
 */
public class P4DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(in);
        int N = scanner.nextInt();
        int[][] matrix = new int[N][N];
        for (int row = 0; row < N; ++row) {
            for (int col = 0; col < N; ++col) {
                matrix[row][col] = scanner.nextInt();
            }
        }
        //System.out.println(Arrays.deepToString(matrix));
        int diagonalLR = 0;
        int diagonalRL = 0;
        for (int row = 0; row < N; ++row) {
            for (int col = 0; col < N; ++col) {
                if (row == col) {
                    diagonalLR += matrix[row][col];
                }
                if ((row + col) == N - 1)
                    diagonalRL += matrix[row][col];
            }
        }
        System.out.println(Math.abs(diagonalLR - diagonalRL));
    }
}
