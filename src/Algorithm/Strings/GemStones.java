package Algorithm.Strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Nikhil on 9/29/2016.
 * 1. How to convert String to Set ? -> Set<String> gemSet1 = new HashSet<String>(Arrays.asList(a, where a is array of strings));
 * 2. Set1 and Set2 both are of character type, and Set1.retainAll(Set2) will give intersection of two sets.
 * 3. Awesome.
 *  * https://www.hackerrank.com/challenges/gem-stones
 */

public class GemStones {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        String[] a = new String[number];

        //you could have used sc.nextLine() and then .split("\\s+") to return a String of array separated by space
        for (int i = 0; i < number; i++) {
            //use Sc.next() to get token as a string for each line
            // sc.nextLine() gives whole line.
            a[i] = sc.next();
        }
        System.out.println(getNumberGems(a));
        sc.close();
    }
    private static int getNumberGems(String[] a){
        Set<Character> gemSet = new HashSet<>();
        char[] firstString = a[0].toCharArray();

        //Set<Character> gemSet1 = new HashSet<Character>(Arrays.asList(firstString));
        // "abcdde" , baccd , eeabg
        for (char letter : firstString) {
            //"abcdde"
            // Only add first characterset to set.
            gemSet.add(letter);
        }
        //Iterate over each other string from array of Strings
        // abcdde , "baccd , eeabg"
        for (int j = 1; j<a.length; j++) {
            Set<Character> gemSet2 = new HashSet<>();
            //accd
            char[] strC = a[j].toCharArray();
            for (char letter : strC) {
                gemSet2.add(letter);
            }
            //Now find all character which are in gemSet2 and keep only those,
            // and store them back into getSet
            // Keep doing this with all string hence its set and gemSet
            // finally will have common letter only
            gemSet.retainAll(gemSet2);
        }
        return gemSet.size();
    }
}

/*
John has discovered various rocks. Each rock is composed of various elements, and each element is represented by a lower-case Latin letter from 'a' to 'z'. An element can be present multiple times in a rock. An element is called a gem-element if it occurs at least once in each of the rocks.

Given the list of  rocks with their compositions, display the number of gem-elements that exist in those rocks.

Input Format

The first line consists of an integer, , the number of rocks.
Each of the next  lines contains a rock's composition. Each composition consists of lower-case letters of English alphabet.

Constraints

Each composition consists of only lower-case Latin letters ('a'-'z').
 length of each composition

Output Format

Print the number of gem-elements that are common in these rocks. If there are none, print 0.

Sample Input

3
abcdde
baccd
eeabg
Sample Output

2
Explanation

Only "a" and "b" are the two kinds of gem-elements, since these are the only characters that occur in every rock's composition.
 */