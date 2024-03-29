package OTT.P6_HackerRank.Strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Nikhi on 9/28/2016.
 * 1. learnt about creating a map, for collection of alphabets range
 * 2. how to iterate over a map : Map.Entry<Integer,Boolean> entry : map.entrySet()
 * https://www.hackerrank.com/challenges/pangrams
 * Given string check of all letter from ato z are appeared once or not.
 * If yes, print pragram or else not pargram
 *  #: checker = 0, diff = character - 'a' , diff =  1 << diff (with difference from 'a' character that much time left shirt number 1) ;  checker |= diff.  -> Idea to store all  unique values
 *  #: checker & 1 ==0 (check LSB & 1 if it is zero meaning one of chacracter was not set),     checker = checker >> 1 (right shift checker for checking all bits.)
 */
public class Pangrams {
    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
        //String input = sc.nextLine().toLowerCase().replaceAll("\\s+","");

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
        String input = "We promptly judged antique ivory buckles for the next prize".toLowerCase().replaceAll("\\s+", "");
        String input2 = "We promptly judged antique ivory buckles for the prize".toLowerCase().replaceAll("\\s+", "");


        System.out.println("Method1" + isPangams(input, map));
        System.out.println("Method1" + isPangams(input2, map));

        //Expected : pragram
        System.out.println(isPangram2(input) ? "Pragram" : "Not Pargram");

        //Expected: not pragram
        System.out.println(isPangram2(input2) ? "Pragram" : "Not Pargram");

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

    /*
    Checks if given sentence contains all letters from English Alphabets or not.
       Time: O(n) Space: O(1)
     */
    private static boolean isPangram2(String input) {
        boolean result = false;
        int checker = 0;

        for (int i = 0; i < input.length(); ++i) {
            int value = input.charAt(i) - 'a';
            value = 1 << value;
            //System.out.println(Integer.toBinaryString(value));
            //if( (checker & value) > 0) return false;
            checker = checker | value;

            System.out.println(input.charAt(i) + " " + Integer.toBinaryString(checker));
        }

        while (checker > 0) {
            if ((checker & 1) == 0) return false;
            checker = checker >> 1;
            System.out.println(Integer.toBinaryString(checker));
        }

        int i = 1, count = 26;
        while (count-- > 0) {

        }
        return true;
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