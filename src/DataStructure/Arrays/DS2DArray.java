package DataStructure.Arrays;
import java.util.Scanner;

/**
 * Created by Nikhil on 12/31/2015.
 */

/*
enter image description here
5x4 array
num []----> [0]--->[1,2,3,4]
            [1]--->[1,2,3,4]
            [2]--->[1,2,3,4]
            [3]--->[1,2,3,4]
            [4]--->[1,2,3,4]
            [5]--->[1,2,3,4]

This image is what you call 2D array, as you can see, it's actually an array of arrays.

nums.length
will return the length of the blue array (which is the number of the rows).

Now if you want to get the number of columns,
you should access one row by nums[0] for example,
and then do nums[0].length, which will yield 4.

Now, simply replace nums with array...
 */
public class DS2DArray {
    public static void main(String args[]) {
        int[][] array = new int[6][6];
        Scanner sc = new Scanner(System.in);
        for( int row=0; row<6; row++){
            for(int col=0; col<6; col++){
                array[row][col]=sc.nextInt();
            }
        }
        /*for( int row=0; row<9; row++){
            for(int col=0; col<9; col++){
                System.out.print(array[row][col] + " ");
            }
            System.out.println();
        }*/
        /*int sum=0;
        int counter=0;
        for( int row=0; row<3; row++){
            for(int col=0; col<3; col++){
                (row==1) ? sum += array[1][2] : sum += array[row][col];
                *//*counter++;
                if(counter==3)
                    break;*//*
            }
        }*/
        int row=0, col=0;
        int sum=0;
        //sum =array[0][0]+array[0][1]+array[0][2]+array[1][1]+array[2][0]+array[2][1]+array[2][2];
        int total=-100000;

/*
        for(row=0; row<=6; row++){
            for(col=0;col<=6;col++) {
                sum = array[row][col] + array[row][col + 1] + array[row][col + 2] + array[row + 1][col + 1] + array[row + 2][col] + array[row + 2][col + 1] + array[row + 2][col + 2];
                if(sum>total) {
                    total = sum;
                    sum = 0;
                }
            }
        }
*/

        for(row=0; row<=array.length-3; row++){
            for(col=0;col<=(array[0].length)-3;col++) {
                sum = array[row][col] + array[row][col + 1] + array[row][col + 2] + array[row + 1][col + 1] + array[row + 2][col] + array[row + 2][col + 1] + array[row + 2][col + 2];
                if(sum>total) {
                    total = sum;
                    sum = 0;
                }
            }
        }
        System.out.println(total);





    }
}
/*
Problem Statement

You are given a 2D array with dimensions 6*6. An hourglass in an array is defined as a portion shaped like this:

a b c
  d
e f g
For example, if we create an hourglass using the number 1 within an array full of zeros, it may look like this:

1 1 1 0 0 0
0 1 0 0 0 0
1 1 1 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
Actually, there are many hourglasses in the array above. The three topmost hourglasses are the following:

1 1 1     1 1 0     1 0 0
  1         0         0
1 1 1     1 1 0     1 0 0
The sum of an hourglass is the sum of all the numbers within it. The sum for the hourglasses above are 7, 4, and 2, respectively.

In this problem, you have to print the largest sum among all the hourglasses in the array.

Note: If you have already solved the problem "JavaReview 2D array" in the data structures chapter of the JavaReview domain, you may skip this challenge.

Input Format

There will be exactly 6 lines of input, each containing 6 integers separated by spaces. Each integer will be between -9 and 9, inclusively.

Output Format

Print the answer to this problem on a single line.

Sample Input

1 1 1 0 0 0
0 1 0 0 0 0
1 1 1 0 0 0
0 0 2 4 4 0
0 0 0 2 0 0
0 0 1 2 4 0
Sample Output

19

Explanation

The hourglass possessing the largest sum is:

2 4 4
  2
1 2 4


 */

