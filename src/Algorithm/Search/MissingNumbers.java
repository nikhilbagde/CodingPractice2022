package Algorithm.Search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.in;

/**
 * Created by Nikhil on 3/24/2017 7:11 AM.
 * https://www.hackerrank.com/challenges/missing-numbers?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
 */
public class MissingNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(in);
        int[] N = new int[scanner.nextInt()];
        for (int i = 0; i < N.length; ++i) {
            N[i] = scanner.nextInt();
        }
        int[] M = new int[scanner.nextInt()];
        for (int i = 0; i < M.length; ++i) {
            M[i] = scanner.nextInt();
        }
        Arrays.sort(N);
        Arrays.sort(M);
        System.out.println("N " + Arrays.toString(N));
        System.out.println("M " + Arrays.toString(M));

        ArrayList<Integer> listN = new ArrayList<>(Arrays.asList(new Integer[N.length]));
        ArrayList<Integer> listM = new ArrayList<>(Arrays.asList(new Integer[M.length]));
        //Collections.sort(listM);
        //Collections.sort(listN);
        System.out.println("listN = " + listN);
        System.out.println("listM = " + listM);


    }
}


/*
Numeros, the Artist, had two lists  and , such that  was a permutation of .
Numeros was very proud of these lists.
Unfortunately, while transporting them from one exhibition to another,
some numbers were left out of . Can you find the missing numbers?

Notes

If a number occurs multiple times in the lists,
you must ensure that the frequency of that number in both lists is the same.
If that is not the case, then it is also a missing number.
You have to print all the missing numbers in ascending order.
Print each missing number once, even if it is missing multiple times.
The difference between maximum and minimum number in  is less than or equal to .
Input Format

There will be four lines of input:

 - the size of the first list
This is followed by  space-separated integers that make up the first list.
 - the size of the second list
This is followed by  space-separated integers that make up the second list.

Constraints

Output Format

Output the missing numbers in ascending order.

Sample Input

10
203 204 205 206 207 208 203 204 205 206
13
203 204 204 205 206 207 205 208 203 206 205 206 204
Sample Output

204 205 206
Explanation

 is present in both arrays. Its frequency in  is ,
 while its frequency in  is .
 Similarly,  and  occur twice in , but thrice in .
 So, these three numbers are our output.
 The rest of the numbers have the same frequency in both lists.
 */