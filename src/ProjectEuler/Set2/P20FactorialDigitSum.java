package ProjectEuler.Set2;

import java.math.BigInteger;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/**
 * Created by Nikhil on 2/5/2017 5:05 PM.
 */
public class P20FactorialDigitSum {
    static int MAX = 1000;
    static BigInteger[] factorials;
    public static void main(String[] args) {
        //precomputing factorials
        factorials = new BigInteger[MAX+10];
        factorials[0] = BigInteger.ONE;
        factorials[1] = BigInteger.ONE;

        for (int i = 2; i <= 100; i++) {
            factorials[i] = new BigInteger(String.valueOf(i)).multiply(factorials[i-1]);
            //System.out.println(factorials[i]);
        }

        Scanner scanner = new Scanner(in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int N = scanner.nextInt();
            out.println("result = " + digitSum(factorials[N]));
        }

    }
    private static long digitSum(BigInteger number){
        long result= 0;
        while(number.compareTo(BigInteger.ZERO) == 1){
            result = result + number.mod(BigInteger.TEN).intValue();         //***BIg Integer to int (downcast)
            number = number.divide(BigInteger.TEN);
        }
        return result;
    }

}
