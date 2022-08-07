package OTT.P6_HackerRank.Implementation.Easy;

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
        //check from mid if p is less or more,
        // depending upon that start flipping the pages
        // from front or end.
        // handle special case, when p=1 or p=n or p=mid
        if (p < mid) {
            System.out.println(p / 2);
        } else if (p > mid) {
            System.out.println(n == p ? "0" : (n - p) / 2);
        } else {
            System.out.println(p / 2);
        }
    }
}
