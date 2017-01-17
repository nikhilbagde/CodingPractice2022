package Algorithm.Strings;

import java.util.Scanner;

/**
 * Created by Nikhi on 9/29/2016.
 *  https://www.hackerrank.com/challenges/beautiful-binary-string
 *? HOw to convert String to array ?
 */
public class BeautifulBinaryString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        String input = sc.next();
        char[] a = input.toCharArray();
        System.out.println((input.length() - input.replaceAll("010", "").length())/3);
        // Consider, Original length  = 0
        // Contain 2 times "010"
        // after replace length =
        // XXXX010XXX010XXX 10 -> to  XXXX_ _ _ XXX _ _ _ XXX - (3*2 times)
        // -> Say new length 6, 10 - 6/3= "2" times it was found
        //
        //hence take difference of 10 -  (6(total length) /3) (gives how many times that length appeared.
    }
}


/*
Alice has a binary string, , of length . She thinks a binary string is beautiful if and only if it doesn't contain the substring .

In one step, Alice can change a  to a  (or vice-versa). Count and print the minimum number of steps needed to make Alice see the string as beautiful.

Input Format

The first line contains an integer,  (the length of binary string ).
The second line contains a single binary string, , of length .

Constraints

Each character in .
Output Format

Print the minimum number of steps needed to make the string beautiful.

Sample Input 0

7
0101010
Sample Output 0

2
Sample Input 1

5
01100
Sample Output 1

0
Sample Input 2

10
0100101010
Sample Output 2

3
Explanation

Sample Case 0:

In this sample,

The figure below shows a way to get rid of each instance of :

binary.png

Because we were able to make the string beautiful by changing  characters ( and ), we print .

Sample Case 1:

In this sample

The substring  does not occur in , so the string is already beautiful and we print .
 */