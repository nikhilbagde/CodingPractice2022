package Java;

import java.util.Scanner;

/**
 * Created by Nikhi on 11/17/2016.
 */
public class JavaStringsIntroduction {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();
        /* Enter your code here. Print output to STDOUT. */
        System.out.println(A.length() + B.length());                //length sum
        System.out.println( A.compareTo(B) > 0 ? "Yes" : "No");     //Yes if A is comes before B in Dictionary
        System.out.println(
                A.substring(0,1).toUpperCase() + A.substring(1) + " " +     //Convert only first letter of each string to Capital and print
                B.substring(0,1).toUpperCase() + B.substring(1)
        );
    }
}
