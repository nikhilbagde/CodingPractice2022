package Contest.CodeForces.CodeforcesRound407;

import java.util.Scanner;

import static java.lang.System.in;

/**
 * Created by Nikhil on 3/29/2017 12:14 PM.
 */
public class FunctionsAgain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; ++i) {
            array[i] = scanner.nextInt();
        }

        int max = Integer.MIN_VALUE;
        for (int row = 0; row < array.length; ++row) {
            int accumulator = 0;
            for (int i = 0; i < row - 1; ++i) {
                accumulator += Math.abs(array[i] - array[i + 1]) * (int) Math.pow(-1, i - 1);
            }
            Math.max(accumulator, max);
        }
    }
}
