package CompanyCompetetions.Amazon.Interview1;

import java.util.Arrays;

/**
 * Created by Nikhil on 4/5/2017 11:42 PM.
 */
public class RotateMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
        int left = 1;
        rotate(matrix, matrix.length, left);
    }

    private static void rotate(int[][] matrix, int n, int left) {
        for (int x = 0; x < n / 2; x++) {
            if (left == 1) {
                for (int y = x; y < n - 1 - x; y++) {
                    int temp = matrix[x][y];
                    matrix[x][y] = matrix[y][n - 1 - x];
                    matrix[y][n - 1 - x] = matrix[n - 1 - x][n - 1 - y];
                    matrix[n - 1 - x][n - 1 - y] = matrix[n - 1 - y][x];
                    matrix[n - 1 - y][x] = temp;
                }
            } else {
                for (int y = x; y < n - 1 - x; y++) {
                    int temp = matrix[x][y];
                    matrix[x][y] = matrix[n - 1 - y][x];
                    matrix[n - 1 - y][x] = matrix[n - 1 - x][n - 1 - y];
                    matrix[n - 1 - x][n - 1 - y] = matrix[y][n - 1 - x];
                    matrix[y][n - 1 - x] = temp;
                }
            }
        }
        System.out.println(Arrays.deepToString(matrix));
    }

}
