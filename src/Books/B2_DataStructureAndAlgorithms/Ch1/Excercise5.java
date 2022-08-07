package Books.B2_DataStructureAndAlgorithms.Ch1;

import java.math.BigInteger;
import java.util.Scanner;

/*
Write a short Java method that takes an integer n and returns the sum of all
positive integers less than or equal to n.
 */
public class Excercise5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger bigInteger = new BigInteger(String.valueOf(scanner.nextInt()));
        /*
        Sum of N integer = n*(n+1)/2
        e.g. 5
        1 + 2 + 3 + 4 + 5 = 15
        5*6/2=15

        E.g. 7
        1+2+3+4+5+6+7= 28
        7*8/2=28
         */
        System.out.println(bigInteger.multiply(bigInteger.add(new BigInteger("1"))).divide(new BigInteger("2")));
    }
}
