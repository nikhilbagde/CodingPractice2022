package Algorithm.DynamicProgramming.OverlappingSubProblems.BottomUp;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Nikhi on 11/8/2016.
 * https://www.hackerrank.com/challenges/maxsubarray
 */
public class MaxSubArray {
    public static void main(String[] args) throws IOException {
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner reader = new Scanner(System.in);
        int testCases = reader.nextInt();

        for (int i = 0; i < testCases; i++) {
            int size = reader.nextInt();
            int[] a = new int[size];
            for (int j = 0; j < size; j++) {
               a[j] =  reader.nextInt();
            }
            int nonContineousSum = 0;
            int countineousSum = 0;
            for (int j = 0; j < a.length; j++) {
                if(a[j] > 0){
                    nonContineousSum+= a[j];
                }
            }
            System.out.println( countMaxSubArray(a, countineousSum, nonContineousSum, a.length-1) + " " + nonContineousSum);
        }
    }
    public static int countMaxSubArray(int[] a, int countineousSum, int maxSum, int lastElement){
        int index = 0;
        int contineousSum = a[index++];
        int previousHigh = contineousSum;
        while(index < a.length){
            /*if(index+1 >= a.length){
                break;
            }*/
            contineousSum += a[index++];
            if( previousHigh > contineousSum){
                contineousSum = previousHigh;
                //return contineousSum;
            }
        }
        /*if(lastElement == 0){
            return a[lastElement];
        }

        countineousSum += countMaxSubArray(a, countineousSum, maxSum, lastElement -1);
        return a[lastElement];*/
        return contineousSum;
    }
}

/*
Given an array  of  elements, find the maximum possible sum of a

Contiguous subarray
Non-contiguous (not necessarily contiguous) subarray.
Empty subarrays/subsequences should not be considered.

Input Format

First line of the input has an integer .  cases follow.
Each test case begins with an integer . In the next line,  integers follow representing the elements of array .

Constraints

The subarray and subsequences you consider should have at least one element.

Output Format

Two, space separated, integers denoting the maximum contiguous and non-contiguous subarray. At least one integer should be selected and put into the subarrays (this may be required in cases where all elements are negative).

Sample Input

2
4
1 2 3 4
6
2 -1 2 3 4 -5
Sample Output

10 10
10 11
Explanation

In the first case:
The max sum for both contiguous and non-contiguous elements is the sum of ALL the elements (as they are all positive).

In the second case:
[2 -1 2 3 4] --> This forms the contiguous sub-array with the maximum sum.
For the max sum of a not-necessarily-contiguous group of elements, simply add all the positive elements.
 */