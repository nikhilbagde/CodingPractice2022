package Algorithm.Strings;

import java.util.Scanner;

/**
 * Created by Nikhi on 9/28/2016.
 * https://www.hackerrank.com/challenges/camelcase
 */
public class Camelcase {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int wordCount = 1;
        for (int i = 2; i < s.length(); i++) {          //anyhow we are calculating first word as word
            if(Character.isUpperCase(s.charAt(i))){     //and that word can have at least 2 letter in it.
                wordCount++;                            // Hence start from 3rd position in string.
            }
            if((i+2)<s.length() && Character.isUpperCase(s.charAt(i+2))){
                wordCount++;
                i+=2;
            }
        }
        System.out.println(wordCount);
    }
}


/*
Alice wrote a sequence of words in CamelCase as a string of letters, , having the following properties:

It is a concatenation of one or more words consisting of English letters.
All letters in the first word are lowercase.
For each of the subsequent words, the first letter is uppercase and rest of the letters are lowercase.
Given , print the number of words in  on a new line.

Input Format

A single line containing string .

Constraints

Output Format

Print the number of words in string .

Sample Input

saveChangesInTheEditor
Sample Output

5
Explanation

String  contains five words:

save
Changes
In
The
Editor
Thus, we print  on a new line.
 */