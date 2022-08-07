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

        for (int i = 2; i <= MAX; i++) {
            factorials[i] = new BigInteger(String.valueOf(i)).multiply(factorials[i-1]);
            System.out.println(i + " " + factorials[i]);
        }

        try {
            Scanner scanner = new Scanner(in);
            int T = scanner.nextInt();
            while (T-- > 0) {
                int N = scanner.nextInt();
                out.println("result = " + digitSum2(factorials[N]));
            }
        } catch (Exception e) {
            e.printStackTrace();
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

    private static long digitSum2(BigInteger number) {
        long result = 0;

        char[] temp = number.toString().toCharArray();
        System.out.println(temp.length);
        for (int i = 0; i < temp.length; i++) {
            result += temp[i] - 48;
        }
        return result;
    }

}
