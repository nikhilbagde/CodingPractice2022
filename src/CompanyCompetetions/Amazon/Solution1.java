package Algorithm;

import java.util.Scanner;

/**
 * Created by Nikhil on 4/29/2016.
 */
public class Solution1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[scanner.nextInt()];
        int product=0;
        for (int i = 0; i < array.length; i++) {
            product += scanner.nextInt();
        }
        System.out.println(product);
    }
}
