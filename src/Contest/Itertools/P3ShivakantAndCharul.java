package Contest.Itertools;

import java.math.BigInteger;
import java.util.Scanner;

import static java.lang.System.in;

/**
 * Created by Nikhil on 2/14/2017 10:20 AM.
 * Shivakant has no friends. He asks charul to be his friend ,but charul likes to be friends with someone who can answer her question. Charul's question is :
 * <p>
 * Given n integers a0,a1,....,an-1 and a function F(i,j) such that
 * <p>
 * F(i,j) = (ai and aj) * (ai or aj)
 * Where and is the bitwise AND operator and or is the bitwise OR operator. Shivakant has to choose two different indices i and j such that F(i,j) is maximal and then print maximal F(i,j). Help Shivakant to impress charul.
 * <p>
 * Input Format
 * <p>
 * The first line contains a single integer denoting n . The second line contains n space-separated integers describing the respective values of a0,a1,....,an-1.
 * <p>
 * Constraints
 * <p>
 * For 30% of the test cases:
 * <p>
 * 2 ≤ n ≤ 1000
 * For 100% of the test cases:
 * <p>
 * 2 ≤ n ≤ 105
 * <p>
 * 0 ≤ ai ≤ 228
 * <p>
 * Output Format
 * <p>
 * Print the maximal F(i,j).
 * <p>
 * Sample Input 0
 * <p>
 * 5
 * 1 2 3 4 5
 * Sample Output 0
 * <p>
 * 20
 */
public class P3ShivakantAndCharul {
    static Scanner scanner = new Scanner(in);
    static int T;
    static int MAX = 100000;

    public static void main(String[] args) {
        T = scanner.nextInt();

        // approachOne();
        approachSecond();

    }

    private static void approachOne() {
        BigInteger[] bigIntegers = new BigInteger[T];
        for (int i = 0; i < T; ++i) {
            bigIntegers[i] = new BigInteger(scanner.next());
        }

        BigInteger[] anding = new BigInteger[T];
        BigInteger[] oring = new BigInteger[T];

        for (int i = 0; i < T; ++i) {
            BigInteger localMin = BigInteger.ZERO;
            for (int j = i + 1; j < T; ++j) {
                BigInteger result = bigIntegers[i].and(bigIntegers[j]);
                localMin = localMin.min(result);
            }
            anding[i] = localMin;
        }
        for (int i = 0; i < T; ++i) {
            BigInteger localMin = BigInteger.ZERO;
            for (int j = i + 1; j < T; ++j) {
                BigInteger result = bigIntegers[i].or(bigIntegers[j]);
                localMin = localMin.min(result);
            }
            oring[i] = localMin;
        }
        BigInteger result = BigInteger.ZERO;
        BigInteger localMin = BigInteger.ZERO;
        for (int row = 0; row < anding.length; ++row) {

            for (int col = 0; col < oring.length; ++col) {
                BigInteger result1 = bigIntegers[row].multiply(bigIntegers[col]);
                localMin = localMin.min(result1);
            }
        }
        System.out.println(localMin.toString());
    }

    private static void approachSecond() {
        BigInteger[] arrayBig = new BigInteger[T];

        for (int i = 0; i < T; ++i) {
            arrayBig[i] = new BigInteger(String.valueOf(scanner.nextInt()));
        }
        BigInteger resultBig = new BigInteger("0");
        for (int row = 0; row < T; ++row) {
            for (int col = row + 1; col < T; ++col) {
                BigInteger temp = arrayBig[row].and(arrayBig[col]).multiply(arrayBig[row].or(arrayBig[col]));
                resultBig = temp.compareTo(resultBig) == 1 ? temp : resultBig;
            }
        }
        System.out.println(resultBig);
    }
}
