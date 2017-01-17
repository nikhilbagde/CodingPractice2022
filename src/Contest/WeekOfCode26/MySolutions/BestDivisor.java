package Contest.WeekOfCode26.MySolutions;

import java.math.BigInteger;
import java.util.*;

/**
 * Created by Nikhi on 12/11/2016 6:51 AM.
 */
public class BestDivisor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        System.out.println(findMaxInDigitSumNumber(getDivisor(number)));
    }
    public static Set getDivisor(int number){
        List<Integer> divisorList = new ArrayList<>();
        Set<Integer> divisorSet = new HashSet<>();
        divisorSet.add(1);
        divisorSet.add(number);
        for (int i = 2; i <= number; i++) {
            if(/*new BigInteger(String.valueOf(i)).isProbablePrime(1<<16) &&*/ !divisorSet.contains(i) && number%i==0){
                divisorSet.add(i);
                divisorSet.add(number/i);
            }
        }
        return divisorSet;
    }
    private static int findMaxInDigitSumNumber(Set<Integer> divisorSet){
        int maxSum = -1;
        int smartNumber = -1;
        for (int number:  divisorSet) {
            /*if( number <10 && number >= maxSum){
                maxSum = number;
                smartNumber = number < smartNumber ? number : smartNumber;;
            }else if( number > 10){*/
                int indigitSum = CalculateSumOfDigitsOfNumber(number);
                if(indigitSum == maxSum){
                    smartNumber = number < smartNumber ? number : smartNumber; // 500000 and 5 both have sum 5 but we choose 5
                }else if(indigitSum > maxSum){
                    maxSum = indigitSum;
                    smartNumber = number;
                }
            //}
        }
        return smartNumber;
    }
    private static int CalculateSumOfDigitsOfNumber(int number){
        int inDigitSum = 0;
        while(number >0){
            inDigitSum += number%10;
            number = number/10;
        }
        return inDigitSum;
    }
}
