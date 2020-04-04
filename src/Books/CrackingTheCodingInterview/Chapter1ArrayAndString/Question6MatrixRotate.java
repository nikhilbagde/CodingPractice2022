package Books.CrackingTheCodingInterview.Chapter1ArrayAndString;

import java.util.Arrays;

/**
 * Created by Nikhil on 10/27/2016.
 * Matrix, with 4 bytes values each
 * Rotate 90 degree
 * [ 01 02 03 04 ]      [ 01 02 03 04 ]
 * [ 05 06 07 08 ] ->   [ 05 06 07 08 ]
 * [ 09 10 11 12 ]      [ 09 10 11 12 ]
 * [ 13 14 15 16 ]      [ 13 14 15 16 ]
 */
public class Question6MatrixRotate {
    public static void main(String[] args) {
        int[][] matrix = {  {1, 2, 3, 4},
                            {5, 6, 7, 8},
                            {9, 10, 11, 12},
                            {13, 14, 15, 16}};
        rotate(matrix, matrix.length);
        System.out.println(Arrays.deepToString(matrix));
    }
    // O(n^2) always and this is best we can do.
    private static void rotate(int[][] matrix, int n){
        for (int layer = 0; layer < n/2; layer++) {
            int start = layer;
            int end = n-1 - layer;
            for (int i = start; i < end; i++) {
                int offset =  i - start;

                int top = matrix[start][i];
                matrix[start][i] = matrix[end - offset][start];
                matrix[end - offset][start] = matrix[end][start];
                matrix[end][start] = matrix[i][end];
                matrix[i][end] = top;
            }
        }
    }
    private static void rotateExplained(int[][] matrix, int n){
        for (int layer = 0; layer < n/2; layer++) {                     //For all rotate case this outer loop would be there. 0->n/2
            int start = layer;                                          //We are doing element by element, so store index of first element
            int end = n-1 - layer;                                      //Store index of last element to move.
            for (int i = start; i < end; i++) {                         //Iterate through elements -> depends upon outer/inner loop.
                int offset =  i - start;                                //already saved end = n-1 - layer. (it will iterate accodinding to
                                                                                //which inner cycle is going on.
                int top = matrix[start][i];                             //start (ROW) static, i changing (COL) (First row)
                matrix[start][i] = matrix[end - offset][start];
                matrix[end - offset][start] = matrix[end][start];
                matrix[end][start] = matrix[i][end];
                matrix[i][end] = top;
            }
        }
    }
}
