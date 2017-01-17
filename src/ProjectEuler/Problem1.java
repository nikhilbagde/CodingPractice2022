package ProjectEuler;

import java.util.Scanner;

/**
 * Created by Nikhi on 10/12/2016.
 */
public class Problem1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();
        long sum = 0L;
        for(int a0 = 0; a0 < testCases; a0++){
            long n = in.nextInt();
            long start = System.currentTimeMillis();
            if((isMultipleOf3(n) || isMultipleOf5(n))&& isMultipleOf15(n)){
               // sum+= i;
            }
        System.out.println(sum);
            long end = System.currentTimeMillis();
            System.out.println("Total Time taken : " + (end-start) + " Milliseconds " + (end-start)/1000 + " Seconds");
        }
    }
    private static boolean isMultipleOf3(long n){
        return false;
    }
    private static boolean isMultipleOf5(long n){
        return false;
    }
    private static boolean isMultipleOf15(long n){
        return false;
    }
}
