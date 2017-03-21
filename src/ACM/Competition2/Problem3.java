package ACM.Competition2;

import java.util.Scanner;

import static java.lang.System.in;

/**
 * Created by Nikhil on 2/28/2017 7:30 PM.
 * https://www.hackerrank.com/contests/bing-acm-feb-17/challenges/nested
 * <'1',<'2'>,<'3','4',<'5','6'>>>
 * 2 2 0
 */
public class Problem3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(in);
        String container = scanner.nextLine();
        String depthString = scanner.nextLine();

        System.out.println(container);
        System.out.println(depthString);

        String[] array = depthString.split(" ");


    }

}
