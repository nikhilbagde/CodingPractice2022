package LeetCode.Patterns.BFS;

/**
 * @author Nikhil Bagde
 * @package LeetCode.Patterns.BFS
 * @created 10/21/2020
 * @date 10/21/2020- 9:02 PM
 * @project IdeaProjects
 **/
public class LC_200_Number_of_Islands {

    public static char[][]  prepareGrid(){
        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        return grid;
    }

    public static void main(String[] args) {
        char[][]grid = prepareGrid();
        int count = numIslandsDFS(grid);
        System.out.println("count = " + count);
    }
    public static int numIslandsDFS(char[][] grid) {
        if(grid==null) return 0;

       // boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]=='1'){
                    dfsNoOfIslands(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public static void dfsNoOfIslands(char[][] grid, int row, int col){
        if(row<0 || col < 0 || row> grid.length-1 || col> grid[0].length-1 || grid[row][col]=='0'){
            return;
        }
        grid[row][col]='0';
        
        dfsNoOfIslands(grid, row-1, col);
        dfsNoOfIslands(grid, row+1, col);
        dfsNoOfIslands(grid, row, col-1);
        dfsNoOfIslands(grid, row, col+1);
    }
}
