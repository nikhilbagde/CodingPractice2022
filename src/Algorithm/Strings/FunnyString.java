package Algorithm.Strings;

import java.util.Scanner;

/**
 * Created by Nikhil on 9/29/2016.
 * 1. Quickest way to reverse a string
 * String a = abcd, String b = new StringBuilder(a).reverse().toString(); b= dcba;
 * Improve this solution by only using 1 String, and 2 loops 1 going forward and another backwards.
 * https://www.hackerrank.com/challenges/funny-string
 */
public class FunnyString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        int flag = 0;
        for (int i = 0; i < testCases; i++) {
            String a = sc.next();
            String rev = new StringBuilder(a).reverse().toString();
            for (int j = 1; j < a.length(); j++) {
                //acxz
                if(Math.abs(a.charAt(j)-a.charAt(j-1)) != Math.abs(rev.charAt(j)- rev.charAt(j-1))) {
                    System.out.println("Not Funny");
                    flag = 1;
                    break;
                }
            }
            if(flag ==0) System.out.println("Funny");
        }
    }
}

// Not working yet