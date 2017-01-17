package Mathematics.Combinatorics;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Nikhi on 12/7/2016 11:23 PM.
 */
public class NCR {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long testCase = sc.nextInt();
        int a = 12;
        BigInteger bi = new BigInteger(String.valueOf(a));
        bi.isProbablePrime(100);
        if( new BigInteger(String.valueOf(a)).isProbablePrime(100))

        if(checkConstrain(testCase, "T")){
            long number = sc.nextLong();
            if(checkConstrain(number,"N")){
                calculateNCR(number, testCase);
            }
        }
    }
    private static boolean checkConstrain(long number, String mode){
        if (mode.equals("T")){
            return  1<= number && number <= 200;
        }else if(mode.equals("N")){
            return  1<= number && number < 1000;
        }
        return false;
    }
    private static long calculateNCR(long number, long testCases){
        //formula of nCr = n!/(n-r)! * r!
        // for r = 0 its always 1
        long nCr = 0;
        long[] lookUp = new long[(int) Math.pow(10,9)];
        Map<Long,Long> lookUpMap = new HashMap<>();
        for (long r = 1; r <= number; r++) {
            //nCr = factorial(number, lookUpMap) / factorial(number-r, lookUpMap) * factorial(r, lookUpMap);
            nCr = factorial(number, lookUp) / factorial(number-r, lookUp) * factorial(r, lookUp);
        }
        return nCr;
    }
    private static long factorial(long number, long[] lookUp){
        if(number == 0 || number == 1){
            return 1;
        }
        if(lookUp[(int)number]!= 0 ){
            return lookUp[(int) (number * factorial(number-1, lookUp))];
        }

        return lookUp[(int)number];
    }
    /*private static long factorial(long number, Map<Long, Long> lookUpMap) {
        if(number == 0 || number == 1){
            return 1;
        }
        if(!lookUpMap.containsKey(number)){
            return lookUpMap.put(number, number * factorial(number-1, lookUpMap));
        }

        return lookUpMap.get(number);
    }*/
}

/*
put 5 , 5 * fact(5-1), lookup
            fact (4)
                put 4, fact(3)
                        put 3, fact(2)         -> 2
                                put 2, fact(1) -> put 2, 2*1=2 -> put(2,2)

 */