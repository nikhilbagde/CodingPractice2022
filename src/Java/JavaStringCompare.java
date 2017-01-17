package Java;

import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by Nikhi on 11/17/2016.
 * https://www.hackerrank.com/challenges/java-string-compare?h_r=next-challenge&h_v=zen
 * Input Format
 First line will consist a string containing english alphabets which has at most  characters. 2nd line will consist an integer .
 Output Format
 In the first line print the lexicographically minimum substring. In the second line print the lexicographically maximum substring.
 Sample Input
 welcometojava
 3
 Sample Output
 ava
 wel
 */
public class JavaStringCompare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int k = sc.nextInt();

        Set<String> set = new TreeSet<>();
        for (int i = 0; i <= s.length() - k ; i++) {
            //create set of all substring with length provided
            set.add(s.substring(i, i+k));
        }
        //Then print lexicographically first string and last string.
        //Just like it appears in a dictionary.
        System.out.println(set.toArray()[0]);
        System.out.println(set.toArray()[set.size()-1]);

    }
}
