package OTT.P6_HackerRank.Implementation.Easy;

import java.util.Scanner;

/**
 * Created by Nikhil on 3/28/2017 1:34 PM.
 */
public class P4BetweenTwoSets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int setASize = scanner.nextInt();
        int setBSize = scanner.nextInt();
        int[] setA = new int[setASize];
        int[] setB = new int[setBSize];
        for (int i = 0; i < setASize; i++) {
            setA[i] = scanner.nextInt();
        }
        for (int i = 0; i < setBSize; i++) {
            setB[i] = scanner.nextInt();
        }

    }
}

/*
2 3
2 4
16 32 96
 */