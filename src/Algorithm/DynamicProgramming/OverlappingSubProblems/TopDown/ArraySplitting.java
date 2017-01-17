package Algorithm.DynamicProgramming.OverlappingSubProblems.TopDown;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Nikhi on 9/26/2016.
 * Problem : https://www.hackerrank.com/challenges/array-splitting
 */
public class ArraySplitting {
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int maxScore = 0;
        if(t>=1 && t<=10){
            int size = sc.nextInt();
            if(size>=1 && size<= (int)Math.pow(2,14) && size%2 == 0){
                int[] input = new int[size];
                for(int i=0;i<size;i++) {
                    int temp = sc.nextInt();
                    if (temp >= 0 && temp <= (int) Math.pow(10, 9)) {
                        input[i] = sc.nextInt();
                    }
                }


                //findScore(input);



            }else{
                System.out.print(maxScore);
            }
        }

    }*/
    private static int findMaxDivideCount(int[] inputs) {
        int n = inputs.length;

        // Return 0 if array can't be partitioned (need at least 2 elements to split)
        if(n < 2) {
            return 0;
        }

        // Initialize rightSum as array sum
        int rightSum = 0;
        for (int i = 0; i < n; i++) {
            rightSum += inputs[i];
        }

        // Determine if array can be partitioned into equal leftSum and rightSum
        int leftSum = 0;
        int partitionIndex = 0;
        boolean isEqual = false;
        do {
            // Deduct each value added to rightSum from leftSum
            leftSum += inputs[partitionIndex];
            rightSum -= inputs[partitionIndex];

            // Check balance (i.e., are the two sums equal yet?)
            if(leftSum == rightSum){
                isEqual = true;
                break;
            }

        } while(++partitionIndex < n);

        // If sums are not equal, return 0 as current array can't be split into halves with equal sums
        if(!isEqual) {
            return 0;
        }

        // Else she gets 1 point, continue checking the left/right subarrays
        return 1 + Math.max(
                findMaxDivideCount(Arrays.copyOfRange(inputs, 0, partitionIndex + 1)),
                findMaxDivideCount(Arrays.copyOfRange(inputs, partitionIndex + 1, n))
        );
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numGames = in.nextInt();

        for (int i = 0; i < numGames; i++) {
            int n = in.nextInt();
            int[] inputs = new int[n];

            for (int j = 0; j < n; j++) {
                inputs[j] = in.nextInt();
            }

            System.out.println(findMaxDivideCount(inputs));
        }
        in.close();
    }
}

/*
Nikita just came up with a new array game. The rules are as follows:

Initially, there is an array, , containing  integers.

In each move, Nikita must partition the array into  non-empty contiguous parts such
that the sum of the elements in the left partition is equal to the sum of the elements in the right partition.
If Nikita can make such a move, she gets  point; otherwise, the game ends.

After each successful move, Nikita discards either the left partition or the right partition
and continues playing by using the remaining partition as array .

Nikita loves this game and wants your help getting the best score possible.
Given , can you find and print the maximum number of points she can score?

Input Format

The first line contains an integer, ,
denoting the number of test cases.
Each test case is described over  lines in the following format:

A line containing a single integer, , denoting the size of array .
A line of  space-separated integers describing the elements in array .
Constraints

Scoring

 for  of the test data
 for  of the test data
 for  of the test data
Output Format

For each test case, print Nikita's maximum possible score on a new line.

Sample Input

3
3
3 3 3
4
2 2 2 2
7
4 1 0 1 1 0 1
Sample Output

0
2
3
Explanation

Test Case 0:

Nikita cannot partition  into  parts having equal sums. Therefore, her maximum possible score is  and we print on a new line.

Test Case 1:

Initially,  looks like this:
split(3).png

She splits the array into  partitions having equal sums, and then discards the left partition:

split(1).png

She then splits the new array into  partitions having equal sums, and then discards the left partition:

split(2).png

At this point the array only has  element and can no longer be partitioned, so the game ends. Because Nikita successfully split the array twice, she gets  points and we print  on a new line.
 */