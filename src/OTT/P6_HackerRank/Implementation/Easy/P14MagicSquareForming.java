package OTT.P6_HackerRank.Implementation.Easy;

import java.util.Scanner;

import static java.lang.System.in;

/**
 * Created by Nikhil on 3/29/2017 9:12 AM.
 * https://www.hackerrank.com/challenges/magic-square-forming
 */
public class P14MagicSquareForming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(in);
        int[][] matrix = new int[3][3];
        int[] rowNotBal = new int[3];
        int[] colNotBal = new int[3];

        for (int row = 0; row < 3; ++row) {
            int horizontal = 0;
            for (int col = 0; col < 3; ++col) {
                matrix[row][col] = scanner.nextInt();
                horizontal += matrix[row][col];
            }
            if (horizontal != 15) {
                rowNotBal[row] = row;
            }
        }

        for (int col = 0; col < 3; ++col) {
            int vertical = 0;
            for (int row = 0; row < 3; ++row) {
                vertical += matrix[row][col];
            }
            if (vertical != 15) {
                colNotBal[col] = col;
            }
        }


    }
}
