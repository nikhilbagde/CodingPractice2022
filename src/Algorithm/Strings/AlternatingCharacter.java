package Algorithm.Strings;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Nikhi on 9/29/2016.
 * https://www.hackerrank.com/challenges/alternating-characters
 */
public class AlternatingCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCount = sc.nextInt();
        String[] a = new String[testCount];

        for (int i = 0; i < testCount; i++) {
            a[i] = sc.next();
        }

        deleteAlternativeCharacter(a);
    }
    private static void deleteAlternativeCharacter(String [] a){
        for (String input : a) {

            int noDeletetion_2 = 0;
            for (int i = 0; i < input.length(); i++) {
                while(i+1< input.length() && input.charAt(i) == input.charAt(i+1)){
                    noDeletetion_2++;
                    i++;
                }
            }
            System.out.println(noDeletetion_2);

            /*int noOfDeletions = 0;
            char[] chars = input.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char currChar = chars[i];
                char nextChar = i + 1 == chars.length ? 'c' : chars[i + 1];

                if (currChar == nextChar) {
                    noOfDeletions++;
                }
            }*/
            //System.out.println(noOfDeletions);


        }
        /*for (String str: a) {
            if(str.length()==1){
                return;
            }
            int originalLength = str.length();
            str = str.replace("AA","A");
            str = str.replace("BB","B");
            int newLenght = str.length();

            int numberOfRemoval = originalLength-newLenght;
            System.out.println(numberOfRemoval);
            StringBuilder  strB = new StringBuilder(str);
            *//*int count=0, i=0;
            do{
                if(strB.charAt(i) == strB.charAt(i+1)){
                    strB.deleteCharAt(i);
                    i=0;
                    count++;
                }else{
                    i++;
                }
            }while(i<strB.length()-1);
            System.out.println(count);
        *//*}*/
    }
}


/*
Shashank likes strings in which consecutive characters are different. For example, he likes ABABA, while he doesn't like ABAA. Given a string containing characters  and  only, he wants to change it into a string he likes. To do this, he is allowed to delete the characters in the string.

Your task is to find the minimum number of required deletions.

Input Format

The first line contains an integer , i.e. the number of test cases.
The next  lines contain a string each.

Output Format

For each test case, print the minimum number of deletions required.

Constraints


 length of string

Sample Input

5
AAAA
BBBBB
ABABABAB
BABABA
AAABBB
Sample Output

3
4
0
0
4
Explanation

AAAA  A, 3 deletions
BBBBB  B, 4 deletions
ABABABAB  ABABABAB, 0 deletions
BABABA  BABABA, 0 deletions
AAABBB  AB, 4 deletions because to convert it to AB we need to delete 2 A's and 2 B's
 */