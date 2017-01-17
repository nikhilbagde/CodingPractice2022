package Algorithm;

import java.util.Scanner;

/**
 * Created by Nikhi on 9/30/2016.
 */
public class Solution3 {
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
            a>>=1;
        }
        return count;
    }
}
