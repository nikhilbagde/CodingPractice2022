package ProjectEuler.Set3;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/**
 * Created by Nikhil on 2/8/2017 5:51 AM.
 */

//Didnt complete!
public class P26ReciprocalCycles {
    static int MAX = 10000 + 7;
    static double[] array;

    public static void main(String[] args) {
        array = new double[MAX];
        for (int i = 2; i < MAX; i++) {
            array[i] = 1 / i;
        }
        System.out.println(Arrays.toString(array));
        Scanner scanner = new Scanner(in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int N = scanner.nextInt();
            int result = 1;
            out.println("result = " + result);
        }


    }
}
