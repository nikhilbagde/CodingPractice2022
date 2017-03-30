package Contest.CodeForces.CodeforcesRound407;

import java.util.Scanner;

import static java.lang.System.in;

/**
 * Created by Nikhil on 3/29/2017 12:37 PM.
 */
public class P3TheGreatMixing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(in);
        int k = scanner.nextInt();      //required concentration
        int n = scanner.nextInt();      //total coke brand types.
        int[] concentration = new int[n];
        for (int i = 0; i < n; ++i) {
            concentration[i] = scanner.nextInt();
        }
        for (int first = 0; first < concentration.length - 1; ++first) {
            for (int second = first + 1; second < concentration.length; ++second) {
                //System.out.println(concentration[first] + " " + concentration[second]);
                int totalConcentration = ((concentration[first] / 1000) + (concentration[second] / 1000)) / 2000;
                //if( totalConcentration == k)
            }
        }
    }
}
