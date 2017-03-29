package Algorithm.Implementation.Easy;

import java.util.Scanner;

/**
 * Created by Nikhil on 3/29/2017 7:04 AM.
 */
public class P12ElectronicsShop {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int n = in.nextInt();
        int m = in.nextInt();
        int[] keyboards = new int[n];
        for (int keyboards_i = 0; keyboards_i < n; keyboards_i++) {
            keyboards[keyboards_i] = in.nextInt();
        }
        int[] pendrives = new int[m];
        for (int pendrives_i = 0; pendrives_i < m; pendrives_i++) {
            pendrives[pendrives_i] = in.nextInt();
        }
        //I thought to store addition of both (keyboard and Usb brand)
        // and then negate it from total amount and store into matrix
        // and keep count of min.
        // when its more than zero then update min all the time.
        // and when min is noted, store that location meaning brand of keyboard and usb.
        // finally just print the sum of each brand stored using location array of 2.

        int[][] matrix = new int[n][m];
        int min = Integer.MAX_VALUE;
        int[] location = new int[2];
        for (int row = 0; row < n; ++row) {
            for (int col = 0; col < m; ++col) {
                int diff = s - (keyboards[row] + pendrives[col]);
                matrix[row][col] = diff;
                if (diff >= 0 && diff < min) {
                    min = Math.min(min, diff);
                    location[0] = row;
                    location[1] = col;
                }
            }
        }
        //System.out.println(Arrays.deepToString(matrix));
        System.out.println(min == Integer.MAX_VALUE ? "-1" : keyboards[location[0]] + pendrives[location[1]]);
    }
}
