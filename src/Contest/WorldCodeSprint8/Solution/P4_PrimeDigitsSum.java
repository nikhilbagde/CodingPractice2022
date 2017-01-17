package Contest.WorldCodeSprint8.Solution;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Nikhi on 12/17/2016 2:40 PM.
 */
public class P4_PrimeDigitsSum {
    static final int M = 1000000007;
    public static void main(String[] args) {

        try {
            Scanner in = new Scanner(System.in);

            int q = in.nextInt();
            long startTime = System.currentTimeMillis();
            assert (1 <= q && q <= 2 * Math.pow(10, 4));
            for (int a0 = 0; a0 < q; a0++) {
                int n = in.nextInt();
                assert (1 <= n && n <= 4 * Math.pow(10, 5));            //400000
                long count = 0;
                // your code goes here
                if (n != 0) {                                          //n = 6
                    StringBuilder start = new StringBuilder("1");       //100000
                    StringBuilder end = new StringBuilder();                //999999
                    for (int i = 0; i < n; i++) {                           //n=4 [1000-9999] - 3003 - 1. 3 Yes, 3 Yes
                        if (i != 0) start.append(0);                                                  //2. 3+3 = 6 not
                        end.append(9);
                    }
                    BigInteger startNum = new BigInteger(start.toString());
                    BigInteger endNum = new BigInteger(end.toString());
            /*System.out.println(start.toString());
            System.out.println(end.toString());*/
                    count = countPrimeDigitSum(Long.parseLong(start.toString()), Long.parseLong(end.toString()));
                    count = countPrimeDigitSum(startNum, endNum);
                }
                long endTime = System.currentTimeMillis();
                System.out.println("Total Time : " + (endTime - startTime) / 1000 + " Seconds!");
                System.out.println(count);
            }
        }catch (NumberFormatException e){
            e.printStackTrace();
        }
    }
    private static long countPrimeDigitSum(long start, long end){
        //Set<Integer> numberSet = new HashSet<>();
        long count = 0;
        List<Long> primeList = new ArrayList<>();
        for (long num = start; num < end; num++) {       //for 100000 to 999999
            //if(isThreeDigitSumIsPrime(num, primeList) && isFourDigitSumIsPrime(num, primeList) && isFiveDigitSumIsPrime(num, primeList)){
            if(isInDigitSumIsPrime(num, primeList, 3) && isInDigitSumIsPrime(num, primeList, 4) && isInDigitSumIsPrime(num, primeList, 5)){
                count++;
                if(count>Math.pow(10,9)){
                    //count = count % (int) (Math.pow(10,9) + 7);
                    count = count % M;
                }
            }
        }
        return count;
    }
    private static long countPrimeDigitSum(BigInteger start, BigInteger end){
        //Set<Integer> numberSet = new HashSet<>();
        long count = 0;
        List<Long> primeList = new ArrayList<>();
        for (BigInteger num = start; num.compareTo(end) >0; num.add(BigInteger.ONE)) {       //for 100000 to 999999
            //if(isThreeDigitSumIsPrime(num, primeList) && isFourDigitSumIsPrime(num, primeList) && isFiveDigitSumIsPrime(num, primeList)){
            if(isInDigitSumIsPrime(num, primeList, 3) && isInDigitSumIsPrime(num, primeList, 4) && isInDigitSumIsPrime(num, primeList, 5)){
                count++;
                if(count>Math.pow(10,9)){
                    //count = count % (int) (Math.pow(10,9) + 7);
                    count = count % M;
                }
            }
        }
        return count;
    }
  /*  private static boolean isThreeDigitSumIsPrime(long num, List<Long> primeList){
        String numString = String.valueOf(num);
        int length= String.valueOf(num).length();
        for (int index = 0; index <= length-3; index++) {        //get all subString values
            int subNumber = Integer.parseInt(numString.substring(index,  index+3));
            if(!isPrimeImproved(getDigitSum(subNumber), primeList)){
                return false;
            }
        }
        return true;
    }
    private static boolean isFourDigitSumIsPrime(long num, List<Long> primeList){
        String numString = String.valueOf(num);
        int length= String.valueOf(num).length();
        for (int index = 0; index <= length-4; index++) {        //get all subString values
            int subNumber = Integer.parseInt(numString.substring(index,  index+4));
            if(!isPrimeImproved(getDigitSum(subNumber), primeList)){
                return false;
            }
        }
        return true;
    }
    private static boolean isFiveDigitSumIsPrime(int num, List<Long> primeList){
        String numString = String.valueOf(num);
        int length= String.valueOf(num).length();
        for (int index = 0; index <= length-5; index++) {        //get all subString values
            int subNumber = Integer.parseInt(numString.substring(index,  index+5));
            if(!isPrimeImproved(getDigitSum(subNumber), primeList)){
                return false;
            }
        }
        return true;
    }*/

    private static boolean isInDigitSumIsPrime(long num, List<Long> primeList, int digitCount){
        String numString = String.valueOf(num);
        int length= String.valueOf(num).length();
        for (int index = 0; index <= length-digitCount; index++) {        //get all subString values
            int subNumber = Integer.parseInt(numString.substring(index,  index+digitCount));
            if(!isPrimeImproved(getDigitSum(subNumber), primeList)){
                return false;
            }
        }
        return true;
    }
    private static boolean isInDigitSumIsPrime(BigInteger num, List<Long> primeList, int digitCount){
        String numString = String.valueOf(num);
        int length= String.valueOf(num).length();
        for (int index = 0; index <= length-digitCount; index++) {        //get all subString values
            long subNumber = Long.parseLong(numString.substring(index,  index+digitCount));
            if(!isPrimeImproved(getDigitSum(subNumber), primeList)){
                return false;
            }
        }
        return true;
    }
    private static int getDigitSum(int num){
        int sum = 0;
        while(num>0){
            sum += num%10;
            num = num/10;
        }
        return sum;
    }

    private static long getDigitSum(long num){
        long sum = 0;
        while(num>0){
            sum += num%10;
            num = num/10;
        }
        return sum;
    }
    private static boolean isPrime(int num){
        for (int i = 2; i*i < num; i++) {
            if(num%i!=0){
                return false;
            }
        }
        return true;
    }
    private static boolean isPrimeImproved(long num, List<Long> primeList){
        if(primeList.contains(num)) return true;

        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        for (int i = 3; i * i <= num; i += 2)
            if (num % i == 0) return false;
        return true;
    }

}
