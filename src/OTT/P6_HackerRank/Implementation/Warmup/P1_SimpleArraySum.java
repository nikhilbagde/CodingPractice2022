package OTT.P6_HackerRank.Implementation.Warmup;

import java.util.Arrays;
import java.util.Scanner;

public class P1_SimpleArraySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();

        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        int sum = Arrays.stream(array).sum();
        System.out.println(sum);
    }
}
