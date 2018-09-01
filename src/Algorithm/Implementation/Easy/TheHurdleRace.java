package Algorithm.Implementation.Easy;

import java.util.Scanner;

/**
 * Created by nbagde on 8/19/2018.
 */
public class TheHurdleRace {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = scanner.nextInt();
        }
        int answer = hurdleRace(k, height);
        System.out.println(answer);
    }
    static int hurdleRace(int k, int[] height) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < height.length; i++) {
            max = Math.max(max, height[i]);
        }
        return max<k? 0: Math.abs(max-k);
    }
}
