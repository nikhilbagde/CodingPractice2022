package Algorithm.Implementation.Easy;

import java.util.Scanner;

/**
 * Created by Nikhi on 9/21/2016.
 * https://www.hackerrank.com/challenges/cut-the-sticks
 */
public class Cutthestick {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int totalSticks = in.nextInt();
        int a[] = new int[totalSticks];
        int min;
        for(int i=0; i < totalSticks; i++){
            a[i] = in.nextInt();
            min = a[0];
            if(a[i]<min){
                min = a[i];
            }
            if(min == 0){
                //
            }
        }
        min = getMin(a);
        while(min>0){
            min = cut(min, a);
        }
    }
    public static int cut(int min, int[] a){
        int counter=0;
        for(int i=0; i<a.length ; i++){
            if(a[i]!=0){
                a[i] = a[i]-min;
                counter++;
            }
        }
        System.out.println(counter);
        return min = getMin(a);
    }
    public static int getMin(int[] a){
        int min = 0;
        for(int i = 0; i<a.length ; i++){
            if(a[i]!=0 ){
                min = a[i];
                break;
            }
        }
        for(int i =0; i<a.length ; i++){
            if(a[i]!=0){
                //min = a[i];
                if(a[i]<min){
                    min = a[i];
                }
            }
        }
        return min;
    }
}

/*
You are given  sticks, where the length of each stick is a positive integer. A cut operation is performed on the sticks such that all of them are reduced by the length of the smallest stick.

Suppose we have six sticks of the following lengths:

5 4 4 2 2 8
Then, in one cut operation we make a cut of length 2 from each of the six sticks. For the next cut operation four sticks are left (of non-zero length), whose lengths are the following:

3 2 2 6
The above step is repeated until no sticks are left.

Given the length of  sticks, print the number of sticks that are left before each subsequent cut operations.

Note: For each cut operation, you have to recalcuate the length of smallest sticks (excluding zero-length sticks).

Input Format
The first line contains a single integer .
The next line contains  integers: a0, a1,...aN-1 separated by space, where  represents the length of the  stick.

Output Format
For each operation, print the number of sticks that are cut, on separate lines.

Constraints

Sample Input 0

6
5 4 4 2 2 8
Sample Output 0

6
4
2
1
Sample Input 1

8
1 2 3 4 3 3 2 1
Sample Output 1

8
6
4
1
Explanation

Sample Case 0 :

sticks-length        length-of-cut   sticks-cut
5 4 4 2 2 8             2               6
3 2 2 _ _ 6             2               4
1 _ _ _ _ 4             1               2
_ _ _ _ _ 3             3               1
_ _ _ _ _ _           DONE            DONE
Sample Case 1

sticks-length         length-of-cut   sticks-cut
1 2 3 4 3 3 2 1         1               8
_ 1 2 3 2 2 1 _         1               6
_ _ 1 2 1 1 _ _         1               4
_ _ _ 1 _ _ _ _         1               1
_ _ _ _ _ _ _ _       DONE            DONE
 */