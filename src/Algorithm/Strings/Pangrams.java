package Algorithm.Strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Nikhi on 9/28/2016.
 * 1. learnt about creating a map, for collection of alphabets range
 * 2. how to iterate over a map : Map.Entry<Integer,Boolean> entry : map.entrySet()
 * https://www.hackerrank.com/challenges/pangrams
 * Given string check of all letter from ato z are appeared once or not.
 * If yes, print pragram or else not pargram
 */
public class Pangrams {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().toLowerCase().replaceAll("\\s+","");

        Map<Integer,Boolean> map = new HashMap<>();
        /*int v1 = 'a'; //97
        int v2 = 'z'; //122
        int v3 = 'A'; //65
        int v4 = 'Z'; //90
        System.out.println(v1 + " " + v2 + " " + v3 + " " + v4);
        */
        for (int i = 97; i <  123; i++) {
            map.put(i, false);
        }
        System.out.println(isPangams(input, map));

    }
    private static String isPangams(String input, Map<Integer, Boolean> map){
        for (int i = 0; i < input.length(); i++) {
            if(map.containsKey((int) input.charAt(i))){
                map.put((int) input.charAt(i), true);
            }
        }
        for ( Map.Entry<Integer,Boolean> entry : map.entrySet() ) {
            //check if any value in map is false.
            if(!entry.getValue()){
                return "not pangram";
            }
            if(map.containsValue(false)){
                return "not pangram";
            }
        }
        return "pangram";
    }
}


/*
Roy wanted to increase his typing speed for programming contests. So, his friend advised him to type the sentence "The quick brown fox jumps over the lazy dog" repeatedly, because it is a pangram. (Pangrams are sentences constructed by using every letter of the alphabet at least once.)

After typing the sentence several times, Roy became bored with it. So he started to look for other pangrams.

Given a sentence , tell Roy if it is a pangram or not.

Input Format

Input consists of a string .

Constraints
Length of  can be at most   and it may contain spaces, lower case and upper case letters. Lower-case and upper-case instances of a letter are considered the same.

Output Format

Output a line containing pangram if  is a pangram, otherwise output not pangram.

Sample Input

Input #1

We promptly judged antique ivory buckles for the next prize
Input #2

We promptly judged antique ivory buckles for the prize
Sample Output

Output #1

pangram
Output #2

not pangram
Explanation

In the first test case, the answer is pangram because the sentence contains all the letters of the English alphabet.

Submissions: 79710
Max Score: 20
Difficulty: Easy
Rate This Challenge:

Need Help?
String Basics
Alphabets
Set
More
Current Buffer (saved locally, editable)

JavaReview 8

 */