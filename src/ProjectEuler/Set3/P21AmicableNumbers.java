package ProjectEuler.Set3;

import org.jetbrains.annotations.Contract;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/**
 * Created by Nikhil on 2/5/2017 6:19 PM.
 * Let d(n) be defined as the sum of proper divisors of  n (numbers less than n which divide evenly into n).
 * If d(a) = b and d(b) = a , where a=! b then  and  are an amicable pair and each of
 * and  are called amicable numbers.
 *
 * For example, the proper divisors of  220 are  1,2,5,10,11,20,22,44,55,110 therefore d(220)= 284 .
 * The proper divisors of 284 are 1,2,71,142 so d(284) = 220.
 * Evaluate the sum of all the amicable numbers under .
 *
 * Input Format
 *  The first line contains an integer T , i.e., number of test cases.
 *  Next T lines will contain an integer N.
 *  1 <= N <= 10^5
 *
 */
public class P21AmicableNumbers {
    static int MAX = 100000 + 7;
    static long[] amicable;

    public static void main(String[] args) {
        amicable = new long[MAX + 1];

        amicable[0] = 0;
        for (int i = 1; i < MAX; i++) {
            amicable[i] = -1;             //means not calculated yet.
        }

        for (int i = 1; i < MAX; i++) {
            if (amicable[i] != -1) continue;      //already calculated then skip.
            int ans = sumOfAllFactors(i);
            if (i != ans && sumOfAllFactors(ans) == i) {
                amicable[i] = amicable[ans] = 1;            //set both two 1, interesting step.  So when i=ans then it will just skip.
            } else {
                amicable[i] = 0;
            }
        }

        //amicable array itself as acumulator
        for (int i = 1; i < MAX; i++) {
            amicable[i] = amicable[i - 1] + (amicable[i] == 1 ? i : 0);
        }

        //this was waste to calculate amicable sum of all number from 1 to 10^5
        //instead just set it to 1 or 0 or -1.
        // and only calculate from bottom up and then calculate same for its answer.
        //getAmicableSum();

        Scanner scanner = new Scanner(in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int N = scanner.nextInt();
            int result = 0;
            /*for (int i = 1; i < N; i++) {
                if (amicable[i] == amicable[amicable[i]] && i != amicable[i]) {
                    result += amicable[N] + amicable[amicable[N]];
                }
            }*/
            out.println("result = " + amicable[N]);
            //out.println(amicable[N]);
            //out.println("result = " + result);
        }
    }

    private static void getAmicableSum() {
        for (int i = 1; i < MAX; i++) {
            amicable[i] = sumOfAllFactors(i);
        }
    }

    @Contract(pure = true)
    private static int sumOfAllFactors(int n) {
        int sum = 1;        //System.out.println(n);
        for (int i = 2; i * i < n; i++) {             //go till square root of n and, divide it once and add divisor and divison result also.
            if (n % i == 0) {
                sum += i + n / i;             //System.out.print("fator= " + i /*+ " " +  sum*/);
            }//******Speacial Case
            if (i * i == n)         //25 = 5*5 count 5 once!
                sum += i;
        }        //System.out.println();        //System.out.println("sum" + sum);
        return sum;
    }
}
