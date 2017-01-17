package Java;

import java.util.Scanner;

/**
 * Created by Nikhil on 1/7/2017 4:02 AM.
 */
public class DecimalToBinary {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Enter any Number");
        int number = scanner.nextInt();

        printBinary(number);
    }
    private static void printBinary(int number){
        System.out.println(Integer.toBinaryString(number));
    }
}
