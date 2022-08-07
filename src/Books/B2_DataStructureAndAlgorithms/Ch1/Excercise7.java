package Books.B2_DataStructureAndAlgorithms.Ch1;

import java.util.Scanner;

/**
 * R-1.7 Write a short Java method that takes an integer n and returns the sum of the
 * squares of all positive integers less than or equal to
 */
public class Excercise7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println((n * (n + 1) * (2 * n + 1)) / 6);
    }
}

/**
 * https://brilliant.org/wiki/sum-of-n-n2-or-n3/
 * sum of squares of N integer = { n(n+1)(2n+1) } / 6
 * sum of cubes of N integer = {n^2(n+1)^2 } / 4
 */
