package Algorithm.Implementation.Easy;

import java.util.Scanner;

/**
 * Created by Nikhil on 3/28/2017 6:42 PM.
 */
public class P7MigratoryBirds {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] birds = new int[n];
        for (int types_i = 0; types_i < n; types_i++) {
            birds[types_i] = in.nextInt();
        }

        int[] type = new int[5];    //fixed type of birds 1,2,3,4,5

        for (int i = 0; i < birds.length; ++i) {
            type[birds[i] - 1]++;
        }
        int max = type[0];
        for (int i = 0; i < type.length; ++i) {
            max = Math.max(max, type[i]);
        }
        for (int i = 0; i < type.length; ++i) {
            if (max == type[i]) {
                System.out.println(i + 1);
                break;
            }
        }
    }
}
