package LeetCode.Patterns.Greedy;

import java.util.Arrays;

/**
 * @author Nikhil Bagde
 * @date 5/15/2021- 11:23 PM
 **/
public class P_452_MinNumberOfArrays {
    public static void main(String[] args) {

    }
    public static int findMinArrowShots(int[][] points) {
        if(points==null || points.length==0) return 0;

        Arrays.sort(points, (o1,o2) -> o1[0]!= o2[0] ? o1[0]-o2[0] : o1[1]-o2[1]);

        int arrow = 0;
        int prevLeft = points[0][0];
        int prevRight = points[0][1];

        for (int i = 1; i < points.length; i++) {
            int[] point = points[i];
            int currentLeft = point[0];
            int currentRight = point[1];

            if(currentLeft > prevRight){
                arrow++;
                prevLeft = currentLeft;
                prevRight = currentRight;
            } else {
                prevLeft = Math.max(currentLeft, prevLeft);
                prevRight = Math.min(currentRight, prevRight);
            }
        }
        return ++arrow;

    }
}
