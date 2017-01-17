package Contest.WeekOfCode26.MySolutions;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Nikhi on 12/11/2016 10:20 AM.
 */
public class PrimeNumberTwins {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        assert (1<= n && n<= m && m <= Math.pow(10,9));
        assert (m-n <= Math.pow(10,6));
        List<Integer> primeList = new java.util.ArrayList<>();
        //int [] memeorisePrime = new int[Integer.MAX_VALUE];
        //Arrays.fill(memeorisePrime,-1);
        for (int i = n; i <= m; i++) {
            //check if i is prime
            if(checkPrime(i /*memeorisePrime*/)){
                //store it in array
                primeList.add(i);
            }
        }
        //from array get pairs whose difference is two.
        Collections.sort(primeList);
        System.out.println(findPairWithDifferenceTwo(primeList));
        long finishTime = System.currentTimeMillis();
        long tottalTimeTakeninSeconds = (finishTime - startTime)/1000;
        long tottalTimeTakeninMilli = (finishTime - startTime);
        System.out.println("It took " + tottalTimeTakeninMilli  + " Milli Seconds");
        System.out.println("It took " + tottalTimeTakeninSeconds + " Seconds");

    }
    private static boolean checkPrime(int isPrime/*, int[] memorisedPrime*/){
        //100 = 10 * 10. if 100 has 1 factor less than 10 then its not a prime.
        /*if(memorisedPrime[isPrime]==1){
            return true;
        }*/
        //for (int numbers = 2; numbers <= Math.sqrt(isPrime); numbers++) {
        for (int numbers = 2; numbers*numbers <= isPrime; numbers++) {
            if(isPrime%numbers == 0){
                //System.out.println(isPrime + "Not Prime!");
                return false;
            }
        }
        //System.out.println(isPrime + "Its prime");
        //memorisedPrime[isPrime] = 1;
        return true;
    }
    private static int findPairWithDifferenceTwo(List<Integer> list){
        int pairCounter = 0;
        for (int i = 0; i < list.size()-1; i++) {
            if(Math.abs(list.get(i)-list.get(i+1)) == 2){
                pairCounter++;
            }
        }
        return pairCounter;
    }
}

/*
Test case m = 999000000  n = 1000000000
999000000
1000000000
 */