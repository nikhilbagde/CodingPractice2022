package Algorithm.DynamicProgramming.OverlappingSubProblems.BottomUp;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by Nikhi on 9/25/2016.
 */

public class FibonacciBigInteger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger t1 = new BigInteger(String.valueOf(sc.nextInt()));
        BigInteger t2 = new BigInteger(String.valueOf(sc.nextInt()));
        int n = sc.nextInt();
        BigInteger t3 = new BigInteger("");

        if(t1.compareTo(BigInteger.ZERO) == 1 && t2.compareTo(new BigInteger("2")) == -1 && n>=3 && n<=20){
            for(int i=0;i<n;i++){
                t3 = t1.add(t2.pow(2));
                t1 = t2;
                t2 = t3;
            }
            System.out.print(t3.toString());
        }
    }
}
