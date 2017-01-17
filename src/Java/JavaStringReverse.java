package Java;

import java.util.Scanner;

/**
 * Created by Nikhi on 11/17/2016.
 * https://www.hackerrank.com/challenges/java-string-reverse
 * How to reverse a string in one line
 */
public class JavaStringReverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        System.out.println(checkPallidrom(s) ? "Yes" : "No" );
        System.out.println(s.equals(new StringBuilder(s).reverse().toString()) ? "Yes" : "No");

    }
    public static boolean checkPallidrom(String s){
        for (int i = 0; i < s.length()/2; i++) {
            if(s.charAt(i) != s.charAt(s.length()-1 - i)){
                return false;
            }
        }
        return true;
    }
}
