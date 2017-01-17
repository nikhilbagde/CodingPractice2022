package Algorithm.DynamicProgramming.OverlappingSubProblems.TopDown;

import java.util.Scanner;

/**
 * Created by Nikhil on 12/29/2016 12:07 AM.
 * Step 1: Initialize memoized data structure.
 * Step 2: Use recursion to solve subProblem and use above DS to reduce number of recursion calls.
 */
public class FibonnaciUsingMemorization {
    private static int[] A;
    public static void main(String[] args) {
        System.out.println("Enter Number of Terms to Calculate ");
        System.out.println(memorizedFib(new Scanner(System.in).nextInt()));
    }
    private static int memorizedFib(int n) {
        A = new int[n + 1];
        for (int index = 0; index <= n; index++) {
            A[index] = -1;                          //Step1 : initialize an array to impossible values
        }                                           //here we are dealing with positive number,
        return lookUpFib(n);                        // so set it to negatives
    }
    private static int lookUpFib(int n){    //compute fn if not yet done
        if(A[n] == -1){     //initial value
            if(n<=1){       //base case
                A[n] = n;   //store solution
            }else{          //solve and store general case
                A[n] = (lookUpFib(n-1) + lookUpFib(n-2));
            }
        }
        return A[n];        //return fn = A[n]
    }

}
