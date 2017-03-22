package Algorithm.Implementation.Medium;

/**
 * Created by Nikhil on 3/14/2017 4:51 PM.
 */
public class Soduku2 {
    static int N = 9;
    static int[][] grid = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
            {5, 2, 0, 0, 0, 0, 0, 0, 0},
            {0, 8, 7, 0, 0, 0, 0, 3, 1},
            {0, 0, 3, 0, 1, 0, 0, 8, 0},
            {9, 0, 0, 8, 6, 3, 0, 0, 5},
            {0, 5, 0, 0, 9, 0, 6, 0, 0},
            {1, 3, 0, 0, 0, 0, 2, 5, 0},
            {0, 0, 0, 0, 0, 0, 0, 7, 4},
            {0, 0, 5, 2, 0, 6, 3, 0, 0}};


    public static void main(String[] args) {

        /*if(solveSoduku(grid)){
            printGrid(grid);
        }else{
            System.out.println("No Solution");
        }*/

        if (solveSoduku2(grid)) {
            printGrid(grid);
        } else {
            System.out.println("No Solution");
        }
    }
/*

    private static boolean solveSoduku(int[][] grid) {
        int row = 0, col = 0;

        if (!isEmptyPositon(grid, row, col)) {
            return true;
        }
        for (int num = 1; num <= 9; ++num) {
            if (isPossible(grid, row, col, num)) {
                //put current assumption
                grid[row][col] = num;
                //with this assumption solve remaining
                if (solveSoduku(grid))
                    return true;
                //if assumption is wrong, reverse decision.
                grid[row][col] = 0;
            }
        }
        return false;
    }

*/

    private static boolean solveSoduku2(int[][] grid) {
        int[] temp = findUnassignedColOrRow(grid);
        if (temp != null) {
            int row = temp[0];
            int col = temp[1];

            for (int num = 1; num <= 9; ++num) {
                if (isSafe(row, col, num)) {
                    grid[row][col] = num;
                    System.out.printf("Grid[%d][%d] = %d\n", row, col, num);
                    if (solveSoduku2(grid)) {
                        return true;
                    }
                    grid[row][col] = 0;
                }
            }
        } else return true;

        return false;
    }

    private static boolean isSafe(int row, int col, int num) {
        return checkRow2(row, col, num) && checkCol2(row, col, num) && checkGrid2(row, col, num);
    }

    private static boolean checkRow2(int row, int col, int num) {
        for (int colIndex = 0; colIndex < grid.length; ++colIndex) {
            if (grid[row][colIndex] == num) return false;
        }
        return true;
    }

    private static boolean checkCol2(int row, int col, int num) {
        for (int rowIndex = 0; rowIndex < grid.length; ++rowIndex) {
            if (grid[rowIndex][col] == num) return false;
        }
        return true;
    }

    private static boolean checkGrid2(int row, int col, int num) {
        row = row - (row % 3);
        col = col - (col % 3);
        for (int rowIndex = 0; rowIndex < 3; ++rowIndex) {
            for (int colIndex = 0; colIndex < 3; ++colIndex) {
                if (grid[rowIndex + row][colIndex + col] == num) return false;
            }
        }
        return true;
    }


    private static int[] findUnassignedColOrRow(int[][] grid) {
        int[] temp = new int[2];
        for (int row = 0; row < grid.length; ++row) {
            for (int col = 0; col < grid.length; ++col) {
                if (grid[row][col] == 0) {
                    temp[0] = row;
                    temp[1] = col;
                    return temp;
                }
            }
        }
        return null;
    }

    private static boolean isEmptyPositon(int[][] grid, int row, int col) {
        for (row = 0; row < N; ++row) {
            for (col = 0; col < N; ++col) {
                if (grid[row][col] == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isPossible(int[][] grid, int row, int col, int num) {
        //check if number is already in row, col or 3x3 box.
        return isAlreadyInRow(grid, row, num)
                && isAlreadyInCol(grid, col, num)
                && isAlreadyInBox(grid, row - row % 3, col - col % 3, num);
    }

    private static boolean isAlreadyInRow(int[][] grid, int row, int num) {
        for (int col = 0; col < N; ++col) {
            if (grid[row][col] == num) {
                return true;
            }
        }
        return false;
    }

    private static boolean isAlreadyInCol(int[][] grid, int col, int num) {
        for (int row = 0; row < N; ++row) {
            if (grid[row][col] == num) {
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

    private static void printGrid(int[][] grid) {
        for (int row = 0; row < N; ++row) {
            for (int col = 0; col < N; ++col) {
                System.out.printf("%2d", grid[row][col]);
            }
            System.out.println();
        }
    }
}
