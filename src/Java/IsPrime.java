package Java;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by Nikhi on 11/27/2016.
 * https://www.hackerrank.com/challenges/prime-checker/forum
 */
import static java.lang.System.in;
public class IsPrime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);
        int number = sc.nextInt();

        System.out.println(isPrime(number) ? "YES" : "NO");
    }
    static boolean isPrime(int number){
        BigInteger bigInteger = BigInteger.valueOf(number);
        // passing 1 as paramter is like saying probablity of 1,
        // I could pass 50 100, which is more likely consideration.
        return bigInteger.isProbablePrime(1);
    }
}
