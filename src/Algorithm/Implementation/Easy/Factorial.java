package Algorithm.Implementation.Easy;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by Nikhi on 12/23/2016 6:08 PM.
 */
public class Factorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        BigInteger factorial = new BigInteger("1");
        while(N>1){
            factorial = factorial.multiply(BigInteger.valueOf(N));
            N--;
        }
        System.out.println(factorial);
    }
}
