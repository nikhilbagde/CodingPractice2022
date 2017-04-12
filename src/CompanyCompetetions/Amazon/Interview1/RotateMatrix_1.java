package CompanyCompetetions.Amazon.Interview1;

/**
 * Created by Nikhil on 4/6/2017 4:12 PM.
 */
public class RotateMatrix_1 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
        int left = 0;
        rotate(matrix, matrix.length, left);
    }

    private static void rotate(int[][] M, int n, int left) {
        for (int i = 0; i < n / 2; i++) {
            if (left == 1) {
                for (int j = i; j < n - 1 - i; j++) {
                    int temp = M[i][j];
                    M[i][j] = M[j][n - 1 - i];
                    M[j][n - 1 - i] = M[n - 1 - i][n - 1 - j];
                    M[n - 1 - i][n - 1 - j] = M[n - 1 - j][i];
                    M[n - 1 - j][i] = temp;
                }
            } else {
                for (int j = i; j < n - 1 - i; j++) {
                    int temp = M[n - 1 - j][i];
                    M[i][j] = M[j][n - 1 - i];
                    M[n - 1 - j][i] = M[n - 1 - i][n - 1 - j];
                    M[n - 1 - i][n - 1 - j] = M[j][n - 1 - i];
                    M[i][j] = temp;
                }
            }
        }
        System.out.println(java.util.Arrays.deepToString(M));

    }
}
