package Books.DataStructureAndAlgorithms.Ch1;

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
        System.out.println(bigInteger.multiply(bigInteger.add(new BigInteger("1"))).divide(new BigInteger("2")));
    }
}
