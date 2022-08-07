package LeetCode.Patterns.BFS;

import java.util.*;

/**
 *   Pacific ~   ~   ~   ~   ~
 *        ~  1   2   2   3  (5) *
 *        ~  3   2   3  (4) (4) *
 *        ~  2   4  (5)  3   1  *
 *        ~ (6) (7)  1   4   5  *
 *        ~ (5)  1   1   2   4  *
 *           *   *   *   *   * Atlantic
 */
public class LC_417_Pacific_Atlantic_Water_Flow {


    static int[][]dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

    public static int[][] prepareTheMatrix() {
        int[][] matrix =
                {
                        {1, 2, 2, 3, 5},
                        {3, 2, 3, 4, 4},
                        {2, 4, 5, 3, 1},
                        {6, 7, 1, 4, 5},
                        {5, 1, 1, 2, 4}
                };
        return matrix;
    }

    public static void main(String[] args) {
        int[][] matrix = prepareTheMatrix();
        List<List<Integer>> resultDFS = pacificAtlantic(matrix);
        System.out.println("resultDFS = " + resultDFS);

        int[][] matrix2 = prepareTheMatrix();
        List<int[]> resultBFS = pacificAtlanticBFS(matrix2);
        System.out.println("resultBFS = " + Arrays.toString(resultBFS.toArray()));

    }

    public static List<List<Integer>> pacificAtlantic(int[][] matrix) {
        int[][] pacific = new int[matrix.length][matrix[0].length];
        int[][] atlantic = new int[matrix.length][matrix[0].length];

        for (int col = 0; col < matrix[0].length; col++) {
            dfs(matrix, 0 , col, Integer.MIN_VALUE,  pacific);
            dfs(matrix, matrix.length-1 , col, Integer.MIN_VALUE,  atlantic);
        }


        for (int row = 0; row < matrix.length; row++) {
            dfs(matrix, row, 0, Integer.MIN_VALUE , pacific);
            dfs(matrix,  row, matrix[0].length-1, Integer.MIN_VALUE, atlantic);
        }
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < matrix.length  ; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(pacific[i][j] ==1 &&  atlantic[i][j]==1){
                    LinkedList<Integer> list = new LinkedList<>();
                    list.add(i);
                    list.add(j);
                    res.add(list);
                }
            }
        }
        return res;
    }

    public static void dfs(int [][] matrix , int row, int col, int prevVal, int[][] ocene){
        if(row<0 || col <0 || row> matrix.length-1 || col > matrix.length-1) {
            return;
        }else if(matrix[row][col] < prevVal){
            return;
        }else if(ocene[row][col]==1){
            return;
        }

        ocene[row][col] = 1;

        dfs(matrix,row-1,col, matrix[row][col], ocene);
        dfs(matrix,row+1,col, matrix[row][col], ocene);
        dfs(matrix,row,col-1, matrix[row][col], ocene);
        dfs(matrix,row,col+1, matrix[row][col], ocene);
    }

    public static List<int[]> pacificAtlanticBFS(int[][] matrix) {
        List<int[]> res = new LinkedList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return res;
        }
        int n = matrix.length, m = matrix[0].length;
        //One visited map for each ocean
        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];
        Queue<int[]> pQueue = new LinkedList<>();
        Queue<int[]> aQueue = new LinkedList<>();
        for(int i=0; i<n; i++){ //Vertical border
            pQueue.offer(new int[]{i, 0});
            aQueue.offer(new int[]{i, m-1});
            pacific[i][0] = true;
            atlantic[i][m-1] = true;
        }
        for(int i=0; i<m; i++){ //Horizontal border
            pQueue.offer(new int[]{0, i});
            aQueue.offer(new int[]{n-1, i});
            pacific[0][i] = true;
            atlantic[n-1][i] = true;
        }
        bfs(matrix, pQueue, pacific);
        bfs(matrix, aQueue, atlantic);
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(pacific[i][j] && atlantic[i][j])
                    res.add(new int[]{i,j});
            }
        }
        return res;
    }
    public static void bfs(int[][]matrix, Queue<int[]> queue, boolean[][]visited){
        int n = matrix.length, m = matrix[0].length;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for(int[] d:dir){
                int x = cur[0]+d[0];
                int y = cur[1]+d[1];
                if(x<0 || x>=n || y<0 || y>=m || visited[x][y] || matrix[x][y] < matrix[cur[0]][cur[1]]){
                    continue;
                }
                visited[x][y] = true;
                queue.offer(new int[]{x, y});
            }
        }
    }
}


/**
 Better stated problem:

 On a given 2-d array
 Moving only up, down, left, or right
 Advancing only to positions with values the same or lower as the current position value
 Return All points where BOTH:
 A path to the top || left sides of the 2-d array can be achieved
 A path to the right || bottom sides of the 2-d array can be achieved

 Explanation of solution array (using shortest paths):

 [0, 4], value 5 -- Path to Pacific (Up) -- Path to Atlantic (Right)
 [1, 3], value 4 -- Path to Pacific (Up, Up) -- Path to Atlantic (Right, Right)
 [1, 4], value 4 -- Path to Pacific (Left, Up, Up) -- Path to Atlantic (Right)
 [2, 2], value 5 -- Path to Pacific (Up, Up, Up) or (Left, Left, Left) -- Path to Atlantic (Right, Right, Right) or (Down, Down, Down)
 [3, 0], value 6 -- Path to Pacific (Left) -- Path to Atlantic (Down, Down)
 [3, 1], value 7 -- Path to Pacific (Left, Left) -- Path to Atlantic (Down, Down)
 [4, 0], value 5 -- Path to Pacific (Left) -- Path to Atlantic (Down)
 Pacific ~   ~   ~   ~   ~
 ~  1   2   2   3  (5) *
 ~  3   2   3  (4) (4) *
 ~  2   4  (5)  3   1  *
 ~ (6) (7)  1   4   5  *
 ~ (5)  1   1   2   4  *
 *   *   *   *   * Atlantic


 Points of discussion:

 Points like [3, 4] with value 5 aren't included because water can flow to either the bottom or right sides of the map, but water going up or left eventually hits a wall and never is able to reach the Pacific Ocean.
 IF point [1, 3] with value 4 was changed to a value of 3, then it would act like passage through the "ridge line" allowing many more points to reach the Pacific, and the solution array would be: [[0, 3], [0, 4], [1, 2], [1, 3], [1, 4], [2, 2], [2, 3], [3, 0], [3, 1], [3, 3], [3, 4], [4, 0]] */