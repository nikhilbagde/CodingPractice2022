package Books.DataStructureAndAlgorithms.Ch1;

import java.util.Scanner;

/*
R-1.6 Write a short Java method that takes an integer n and returns the sum of all the
odd positive integers less than or equal to n.
 */
public class Excercise6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n == 0) {
            System.out.println(0);
        } else if (n == 1) {
            System.out.println(1);
        } else {
            /*
             if n is even = it will have n/2 odd numbers
             E.g 8 = 1 3 5 7 = 4 odd numbers.                       8/2=4       total =  4 * 4 = 16
             E.g 9 = 1 3 5 7 9 = 5 odd numbers =                    9/2=4+1     total = 25 = 5 * 5
             E.g. 25 = 1 3 5 7 9 11 13 15 17 19 21 23 25 = 13 =     25/2 + 1    total = 169 = 13 * 13
             */

            if (n % 2 == 0) {
                System.out.println((n / 2) * (n / 2));
            } else {
                System.out.println((n / 2 + 1) * (n / 2 + 1));
            }
        }

         /*
            =1+3+5+7
            =1+(2+1)+(3+2)+(4+3)          we can write again as..
            =[1+2+3+4] +[1+2+3]
            =[Sum of n natural numbers]+[Sum of (n-1) natural numbers]
            =n(n+1)/2 + (n-1) [(n-1)+1]/2    By solving it,we find
            =[n^2+n]/2+[n^2-n]/2      again we can simplify as
            =(2n^2)/2
            =n^2
         */
    }

}


/*2 + 4 + 6 + 8 + 10 = 30
        1  =  1
        1 +  2 =  3
        1 + 2 + 3 =  6
        1 +2+3+4 =10

     1   1 = 1
 > 2  1 + 3 = 4      = 1 + (2^2-1)
     3   1+3+5= 9   =  1 + (2^3)
     4  1+3+5+7=16 = 2^4
     5   1+3+5+7+9=25 = (2^5) - 8 (2^3)
     6   1 3 5 7 9 11 = 36 = 2^6
     7   1 3 5 7 9 11 13 = 49
        */