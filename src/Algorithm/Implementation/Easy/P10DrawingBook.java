package Algorithm.Implementation.Easy;

import java.util.Scanner;

/**
 * Created by Nikhil on 3/28/2017 7:14 PM.
 * https://www.hackerrank.com/challenges/drawing-book
 */
public class P10DrawingBook {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int p = in.nextInt();
        int mid = n / 2;
        if (p < mid) {
            System.out.println(p / 2);
        } else if (p > mid) {
            System.out.println(n == p ? "0" : (n - p) / 2);
        } else {
            System.out.println(p / 2);
        }
    }
}
