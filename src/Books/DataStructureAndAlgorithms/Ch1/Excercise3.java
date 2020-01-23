package Books.DataStructureAndAlgorithms.Ch1;

import java.util.Scanner;

/*
Write a short Java method, isMultiple, that takes two long values, n and m, and
returns true if and only if n is a multiple of m, that is, n = mi for some integer
 */
public class Excercise3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.hasNextLong() ?  scanner.nextLong() : 0;
        long m = scanner.hasNextLong() ?  scanner.nextLong() : 0;

        System.out.println(isMultiple(n, m));
    }

    public static boolean isMultiple(long n, long m){
        return n % m == 0;
    }
}
