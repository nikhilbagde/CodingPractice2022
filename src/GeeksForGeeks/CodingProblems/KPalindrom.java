package GeeksForGeeks.CodingProblems;

import java.util.Scanner;

/**
 * Created by Nikhil on 9/14/2016.
 */
public class KPalindrom {
    public static void main(String[] args) {
        System.out.println(is_k_pallin("abcdecba", 1));

    }
    public static boolean is_k_pallin(String s,int k){
        int diffCounter = 0;

        for(int i= s.length()-1 ; i>= s.length()/2 ; i--){
            if(s.charAt(i) != s.charAt( (s.length()-1) -i)){
                diffCounter++;
            }
        }
        return diffCounter == k;
    }



}


/*A string is k pallindrome if it can be transformed into a palindrome on removing at most k characters from it. Your task is to complete the function is_k_pallin which takes two arguments a string str and a number N . Your function should return true if the string is k pallindrome else it should return false.

Input:
The first line of input is an integer T denoting the number of test cases . Then T test cases follow . Each test case  contains a string str and an integer N separated by space.

Output:
The output will be 1 if the string is  k pallindrome else 0 .

Constraints:
1<=T<=100
1<=length of str<=100
1<=N<=20

Example:
Input
2
abcdecba 1
acdcb  1
Output
1
0

**For More Examples Use Expected Output**


Contributor: Amit Khandelwal
*/