package Algorithm.WarmUp;

import java.util.Scanner;

import static java.lang.System.in;

/**
 * Created by Nikhil on 2/10/2017 4:51 AM.
 */
public class P7StrairCase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(in);
        int n = scanner.nextInt();
        for (int row = 0; row < n; ++row) {
            for (int col = 0; col < n; ++col) {
                if (row + col >= n - 1) {
                    System.out.print("#");
                } else System.out.print(" ");
            }
            System.out.println();
        }
    }
}
