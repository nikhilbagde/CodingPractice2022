package CompanyCompetetions.Amazon.InterviewQuestions;

/**
 * Created by Nikhil on 4/11/2017 3:00 PM.
 */
public class InterviwedQuestion {
    /*
               +------------+
               |            |
               |  xxxx  xx  |
               |  x   xx  x |
               |  x *    x  |
               |  xxxxxxxx  |
               |            |
               +------------+
   /**

        11110011
        10001101
        100x0010
        11111111

        00000000
        11110011
        1xxx1101
        1xxxxx10
        11111111

   **/
    public static void main(String[] args) {
        int[][] a = {{0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 1, 1},
                {1, 0, 0, 0, 1, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 1, 0},
                {1, 1, 1, 1, 1, 1, 1, 1}
        };
        paint(a, 3, 2, 1);
        System.out.println(java.util.Arrays.deepToString(a));
    }

    private static void paint(int[][] picture, int x, int y, int color) {
        // first check if picture[x][y] == color
        // paint x,y
        // paint up
        // paint left
        // paint right
        // paint down

        if (picture[x][y] == color) {
            return;
        } else {
            picture[x][y] = color;
            //up
            paint(picture, x - 1, y, color);
            //left
            paint(picture, x, y - 1, color);
            //right
            paint(picture, x, y + 1, color);
            //down
            paint(picture, x - 1, y, color);
        }


//    for(int i=; i<piture.length;i++){
        //       for(int j=0; j<picture[0].length;j++){

        //isSafe(x,y, picture){
        //     picture[i][j] =1;
        //}
//        }
//    }
    }

    private static boolean isSafe(int i, int j, int[][] picture) {
        //up
        return isUpSafe(i, j, picture) && isLeftSafe(i, j, picture) && isRightSafe(i, j, picture) && isDownSafe(i, j, picture);

    }

    private static boolean isUpSafe(int i, int j, int[][] picture) {
        for (int k = i; k >= 0; k--) {
            if (picture[k][j] == 1) return true;
        }
        return false;
    }

    private static boolean isLeftSafe(int i, int j, int[][] picture) {
        for (int k = i; k >= 0; k--) {
            if (picture[k][j] == 1) return true;
        }
        return false;
    }

    private static boolean isRightSafe(int i, int j, int[][] picture) {
        for (int k = i; k >= 0; k--) {
            if (picture[k][j] == 1) return true;
        }
        return false;
    }

    private static boolean isDownSafe(int i, int j, int[][] picture) {
        for (int k = i; k >= 0; k--) {
            if (picture[k][j] == 1) return true;
        }
        return false;
    }
}
