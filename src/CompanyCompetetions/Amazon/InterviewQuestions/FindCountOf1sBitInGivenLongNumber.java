package CompanyCompetetions.Amazon.InterviewQuestions;

import java.util.Scanner;

/**
 * Created by Nikhil on 9/30/2016.
 * Find number of 1's in bit version of given number
 */
public class FindCountOf1sBitInGivenLongNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();

        System.out.println(numSetBits(a));
    }
    public static int numSetBits(long a){
        int count = 0;
        while(a>0){
            if( (a&1)!= 0){
                count++;
            }
            System.out.println(Long.toBinaryString(a));
            a>>=1;
        }
        return count;
    }
}
