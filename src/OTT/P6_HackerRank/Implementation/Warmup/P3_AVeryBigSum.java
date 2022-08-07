package OTT.P6_HackerRank.Implementation.Warmup;

import java.util.Arrays;
import java.util.Scanner;

public class P3_AVeryBigSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long[] ar = new long[arCount];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < arCount; i++) {
            long arItem = Long.parseLong(arItems[i]);
            ar[i] = arItem;
        }

        long result = aVeryBigSum(ar);
        System.out.println("result = " + result);
    }

    public static long aVeryBigSum(long[] array) {
        return Arrays.stream(array).sum();
    }
}
