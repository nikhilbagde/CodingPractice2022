package Algorithm.DynamicProgramming.OverlappingSubProblems.TopDown;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Nikhil on 1/5/2017 7:08 PM.
 */
public class FinbonacciUsingStack {
    private static Integer[] A;
    public static void main(String[] args) {
        System.out.println("Enter Number of Terms to Calculate ");
        System.out.println(memoizedFib(new Scanner(System.in).nextInt()));
    }
    private static int memoizedFib(int n) {
        A = new Integer[n + 1];
        for (int index = 0; index <= n; index++) {
            A[index] = null;                          //Step1 : initialize an array to impossible values
        }                                           //here we are dealing with positive number,
        return lookUpFib(n);                        // so set it to negatives
    }
    private static int lookUpFib(int n){    //compute fn if not yet done
        Stack<Integer> stackRecursion = new Stack<>();
        int count = n;
        while(count>1){
            stackRecursion.push(count-1);
            count--;
        }
        A[0] = 0;
        for (int i = 1; i < n; i++) {
            A[i] = stackRecursion.pop() + A[i-1];
        }
        return A[n];        //return fn = A[n]
    }


}

