package OTT.P6_HackerRank.Implementation.Easy;

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

        //fixed type of birds 1,2,3,4,5
        //created an array with index zero to hold these types frequencies.
        int[] type = new int[5];

        for (int i = 0; i < birds.length; ++i) {
            type[birds[i] - 1]++;       //-1 to handle bound so 5th type frequency would be increased and stored in type[4].
        }
        int max = type[0];  // to find max, consider 1st to be max.
        for (int i = 0; i < type.length; ++i) {
            max = Math.max(max, type[i]);   //check for max.
        }
        //we have max,
        //Now we can iterate through array and when you hit max just print that index+1 which is type number
        //To handle condition of if two type has same frequency, we are suppose to print max with lower id.
        // as we have stored in an array. and find first max only condition is handled automatically.
        for (int i = 0; i < type.length; ++i) {
            if (max == type[i]) {
                System.out.println(i + 1);
                break;
            }
        }
    }
}
