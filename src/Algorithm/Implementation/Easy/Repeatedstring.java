package Algorithm.Implementation.Easy;

import java.util.Scanner;

/**
 * Created by Nikhi on 9/23/2016.
 * https://www.hackerrank.com/challenges/repeated-string
 */
public class Repeatedstring {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        long n = in.nextLong();
        int fixedACount = 0;

        //first need to figure out how many a's in given string
        for(int i=0;i<s.length(); i++){
            if(s.charAt(i) == 'a'){
                fixedACount++;
            }
        }

        //Now chcek how many times string is repeating
        //Divide length of string by N
        long repeatCount =  (n/ s.length());
        long totalACount =  repeatCount * fixedACount;

        //Not done yet, if number is not totally divisible there would be some
        // number of A's we need to add to final Count
        //for that we get that mod reminder
        // use that reminder again to check how many A's in original string
        int leftOver = (int) (n % s.length());
        int leftOverACount = 0;
        for(int i = 0; i<leftOver ; i++){
            if(s.charAt(i) == 'a'){
                leftOverACount++;
            }
        }
        totalACount += leftOverACount;
        System.out.println(totalACount);

    }
}

/*
Lilah has a string, , of lowercase English letters that she repeated infinitely many times.

Given an integer, , find and print the number of letter a's in the first  letters of Lilah's infinite string.

Input Format

The first line contains a single string, .
The second line contains an integer, .

Constraints

For  of the test cases, .
Output Format

Print a single integer denoting the number of letter a's in the first  letters of the infinite string created by repeating  infinitely many times.

Sample Input 0

aba
10
Sample Output 0

7
Explanation 0
The first  letters of the infinite string are abaabaabaa. Because there are  a's, we print  on a new line.

Sample Input 1

a
1000000000000
Sample Output 1

1000000000000
Explanation 1
Because all of the first  letters of the infinite string are a, we print  on a new line.
 */