package Algorithm.Implementation.Easy;

import java.io.BufferedReader;
import java.util.Scanner;

/**
 * Created by Nikhil on 1/1/2017 6:49 PM.
 * 1. Integer reverse
 * 2. Is number whole or is it float, just take modulo and equate to 0.
 */
public class BeautifulDaysAtTheMovies {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int start = scanner.nextInt();
        int end = scanner.nextInt();
        long k = scanner.nextLong();
        int count = 0;
        for (int i = start; i <= end; i++) {
            int reversed = Integer.parseInt(new StringBuilder(String.valueOf(i)).reverse().toString());
            int difference = Math.abs(reversed - i);
            if(difference%k == 0){
                count++;
            }
        }
        System.out.println(count);
    }
}
