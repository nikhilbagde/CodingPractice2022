package CompanyCompetetions.PayPal.Test;

import java.util.Scanner;

import static java.lang.System.in;

/**
 * Created by Nikhil on 2/9/2017 11:38 PM.
 */
public class P1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(in);
        int size = scanner.nextInt();
        String[] arr = new String[size];
        for (int i = 0; i < size; ++i) {
            arr[i] = scanner.next();
        }
        getMinimumUniqueSum(arr);
    }

    static int[] getMinimumUniqueSum(String[] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; ++i) {
            long number = Long.parseLong(arr[i]);
            // if(Math.floor(Math.sqrt(number)) -)
        }
        return new int[10];
    }
}
