package OTT.P6_HackerRank.Implementation.Easy;

import java.util.Scanner;

/**
 * Created by nbagde on 8/18/2018.
 * https://www.hackerrank.com/challenges/picking-numbers/problem
 */
public class PickingNumbers {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int n = scanner.nextInt();
        int [] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i]= scanner.nextInt();
        }
        System.out.println(pickingNumbers(a));
    }
    private static int pickingNumbers(int[] a) {
        //int count = 0;
        int[] bitArray = new int[101];
        for (int i = 0; i < a.length; i++) {
            bitArray[Math.abs(a[i])]++;
        }
        int maxCount = 0;
        for (int i = 0; i < bitArray.length-1; i++) {
            if( bitArray[i]!=0 || (bitArray[i]!=0 && bitArray[i+1]!=0)){
                maxCount = Math.max(maxCount, bitArray[i]+bitArray[i+1]);
            }
            //System.out.print(maxCount + " at " + i);
        }
        //System.out.println();
        return maxCount;
    }
}
