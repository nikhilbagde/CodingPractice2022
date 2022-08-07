package LeetCode.Easy;

import java.util.Arrays;

/**
 * Created by Nikhil on 3/30/2017 8:07 PM.
 */
public class P463IslandPerimeter {
    public static void main(String[] args) {
        int[][] grid = {{0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}};
        //System.out.println(islandPerimeter(grid));
        getCommonSideCount("1011", "1111");

    }

    private static int islandPerimeter(int[][] grid) {

        if (grid.length == 0) return 0;

        //for 1 cell = (permiter =4) ----
        //for 2 cell = (permiter =6) ------
        //for 3 cell = (permiter =8) --------
        //for 4 cell = (permiter =10) ----------
        // depends upong max number of cells can grid have in one row.
        //int[] fixedPrermiter = {0, 4, 6, 8, 10};
        int[] fixedPrermiter1 = new int[grid[0].length + 1];

        for (int i = 1; i < fixedPrermiter1.length; ++i) {
            fixedPrermiter1[i] = (i * 2) + 2;
        }
        System.out.println(Arrays.toString(fixedPrermiter1));

        //go level by level and check for last level after first level
        // get total perimeter first,
        // check for common side from current to last level
        // 0-1 (min =0), last level 1 block - current level 1 block = delete 2 sides.
        // 1-1 deleted 2 sides
        // 1-2 -> min=1, delete 2 sides (min*2)
        // 2-2 -> min 2, delete 4 sides (min*2)
        // 1-3 -> min 1, delete 2 sides (min*2)
        // 2-3 -> min 2, delete 4 sides (min*2)
        // 3-3 -> min 3, delete 6 sides (min*2)

        int lastCount = 0, perimeter = 0;
        for (int row = 0; row < grid.length; ++row) {
            int oneCount = 0;
            for (int col = 0; col < grid[row].length; ++col) {
                if (grid[row][col] == 1)
                    oneCount++;
            }
            perimeter += fixedPrermiter1[oneCount];  //4-> (4+8)=12 -> 10+4=14 -> 12+6=18
            if (row > 0) perimeter -= Math.min(lastCount, oneCount) * 2;   // NA -> 12-2=10 -> 14-2=12 -> 18-2=16
            lastCount = oneCount;                   //1-> 3 -> 1 -> 2
        }
        return perimeter;
    }

    private static int getCommonSideCount(String last, String current) {
        int count = 0;
        //0=48 1=49
        int temp = Integer.parseInt(last);
        int temp2 = Integer.parseInt(current);

        System.out.println(temp);
        System.out.println(temp2);
        int result = temp & temp2;
        System.out.println(Integer.toBinaryString(result)
        );

        int checker = last.charAt(0) == '0' ? 0 : 1;
        for (int i = 1; i < last.length(); i++) {
            int num = last.charAt(i) == '0' ? 0 : 1;
            num = num << 1;
            checker |= num;
            System.out.println(Integer.toBinaryString(num));
        }
        System.out.println(Integer.toBinaryString(checker));
        return count;
    }

    //working
    private static int islandPerimeter2(int[][] grid) {
        int island = 0, neighbours = 0;
        for (int row = 0; row < grid.length; ++row) {
            for (int col = 0; col < grid[row].length; ++col) {
                if (grid[row][col] == 1) {
                    island++;

                    if (row < grid.length - 1 && grid[row + 1][col] == 1) neighbours++;
                    if (col < grid[row].length - 1 && grid[row][col + 1] == 1) neighbours++;
                }
            }
        }
        return island * 4 - neighbours * 2;
    }
}

/*
Failed:
Input : [[0,1,1],[1,1,0]]
Output: 8 Expected:10
 */