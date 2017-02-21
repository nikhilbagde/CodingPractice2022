package ProjectEuler.Set3;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/**
 * Created by Nikhil on 2/8/2017 4:57 PM.
 */
public class P27QuadraticPrimes {
    static int MAX = 2000 + 7;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(in);
        int N = scanner.nextInt();

        int best = -1, besta = 0, bestb = 0;
        // n*n + a*n + b = prime number.
        for (int b = 0; b <= N; ++b) {                  //b can have maximum value so it make sense to have out most loop of b.
            if (isPrime(b)) continue;
            for (int a = -b; a <= N; ++a) {
                for (int n = 0; n < b; ++n) {
                    int prime = n * n + a * n + b;
                    if (!isPrime(prime)) {
                        if (n > best) {
                            best = n;
                            besta = a;
                            bestb = b;
                        }
                        break;
                    }
                }
            }
        }
        out.println(besta + " " + bestb);
    }

    private static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i < n; ++i) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
