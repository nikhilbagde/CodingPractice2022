package Java;

import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by Nikhil on 1/7/2017 4:04 AM.
 */
public class DecimalToDifferentBase {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Enter any Number");
        int number = scanner.nextInt();
        System.out.println("Enter Base value");
        int base = scanner.nextInt();

        printInGivenBase(number, base);
    }
    private static void printInGivenBase(int number, int base){
        System.out.println(Integer.toString(number, base));
    }
}
