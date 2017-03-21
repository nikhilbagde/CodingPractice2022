package Algorithm.Implementation.Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Nikhil on 3/16/2017 2:11 PM.
 */
public class Test {
    static int[][] grid = new int[9][9];

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s;

        int counter = 0;
        s = in.readLine();
        for (int i = 0; i < 9; ++i) {
            Scanner scanner = new Scanner(s).useDelimiter(",");
            counter = counter + 1;
            for (int j = 0; j < 9; ++j) {
                grid[i][j] = scanner.nextInt();
            }

        }
        System.out.println(Arrays.deepToString(grid));
        boolean result = solve(grid);
        System.out.println(result ? "True" : "False");
    }

    private static boolean solve(int[][] grid) {
        for (int row = 0; row < 9; ++row) {
            for (int col = 0; col < 9; ++col) {
                int num = grid[row][col];
                if (!isSafe(row, col, num)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isSafe(int row, int col, int num) {
        //check if number is already in row, col or 3x3 box.
        return !isAlreadyInRow(grid, row, num)
                && !isAlreadyInCol(grid, col, num)
                && !isAlreadyInBox(grid, row - row % 3, col - col % 3, num);
    }

    private static boolean isAlreadyInRow(int[][] grid, int row, int num) {
        for (int col = 0; col < 9; ++col) {
            if (col != row && grid[row][col] == num) {
                return true;
            }
        }
        return false;
    }

    private static boolean isAlreadyInCol(int[][] grid, int col, int num) {
        for (int row = 0; row < 9; ++row) {
            if (row != col && grid[row][col] == num) {
                return true;
            }
        }
        return false;
    }

    private static boolean isAlreadyInBox(int[][] grid, int boxStartRow, int boxStartCol, int num) {
        for (int row = 0; row < 3; ++row) {
            for (int col = 0; col < 3; ++col) {
                if (grid[row + boxStartRow][col + boxStartCol] == num)
                    return true;
            }
        }
        return false;
    }
}

/*
1,2,3,4,5,6,7,8,9,2,3,4,5,6,7,8,9,1,3,4,5,6,7,8,9,1,2,4,5,6,7,8,9,1,2,3,5,6,7,8,9,1,2,3,4,6,7,8,9,1,2,3,4,5,7,8,9,1,2,3,4,5,6,8,9,1,2,3,4,5,6,7,9,1,2,3,4,5,6,7,8
 */