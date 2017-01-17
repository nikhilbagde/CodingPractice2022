package Algorithm.Implementation.Easy;

import java.util.Scanner;

/**
 * Created by Nikhi on 9/22/2016.
 * https://www.hackerrank.com/challenges/divisible-sum-pairs
 */
public class Divisiblesumpairs {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        if(n>=2 && n <= 100 && k>= 1 && k <= 100){
            int counter = 0;
            for(int i = 0; i < n-1 ; i++){
                for(int j= i+1; j< n-1; j++){
                    if((a[i]+a[j]) %k == 0){
                        counter++;
                    }
                }
            }
            System.out.println(counter);
        }
    }
}

/*
You are given an array of  integers, , and a positive integer, . Find and print the number of pairs where  and  +  is evenly divisible by .

Input Format

The first line contains  space-separated integers,  and , respectively.
The second line contains  space-separated integers describing the respective values of .

Constraints

Output Format

Print the number of  pairs where  and  +  is evenly divisible by .

Sample Input

6 3
1 3 2 6 1 2
Sample Output

 5
Explanation

Here are the  valid pairs:


 */