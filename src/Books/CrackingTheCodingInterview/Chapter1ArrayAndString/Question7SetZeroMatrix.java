package Books.CrackingTheCodingInterview.Chapter1ArrayAndString;

/**
 * Created by Nikhil on 1/16/2017 11:56 AM.
 */
public class Question7SetZeroMatrix {
    public static void main(String[] args) {

    }
    private static void setZero(int[][] matrix){
        boolean[] rows = new boolean[matrix.length];
        boolean[] cols = new boolean[matrix[0].length];
        //O(mn)
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(matrix[row][col] == 0){
                    rows[row] = true;
                    cols[col] = true;
                }
            }
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(rows[row] == true || cols[col] == true){
                    matrix[row][col] = 0;
                }
            }
        }
    }
}
