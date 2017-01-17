package Algorithm.DynamicProgramming.OverlappingSubProblems.BottomUp;

import java.util.Scanner;

/**
 * Created by Nikhil on 1/5/2017 9:21 PM.
 * Step 1: Create a table 1D or 2D here we need 1D (Tabular Approach)
 * Step 2: initialize DS with base values
 * Step 3: Go to up from bottom and calculate big Problem value using already stores values in step 2.
 */
public class FibinnaciUsingBottomUp {
    static Scanner scanner = new Scanner(System.in);
    static int A[];
    public static void main(String[] args) {
        System.out.println("Enter the number");
        findFibonacci(scanner.nextInt());
    }
    private static void findFibonacci(int n){
        A = new int[n+1];
        A[0] = 0;
        A[1] = 1;

        for (int i = 2; i <= n ; i++) {
            A[i] = A[i-1] + A[i-2];
        }
        System.out.println(A[n]);
    }
}
