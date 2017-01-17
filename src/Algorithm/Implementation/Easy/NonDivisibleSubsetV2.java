package Algorithm.Implementation.Easy;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Nikhi on 9/23/2016.
 * https://www.hackerrank.com/challenges/non-divisible-subset
 */
public class NonDivisibleSubsetV2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int distinctIntegers = sc.nextInt();
        int divisor = sc.nextInt();

        int[] setInteger = new int[distinctIntegers];
        for (int i = 0; i < distinctIntegers; i++) {
            setInteger[i] = sc.nextInt();
        }
        int maxSubSetCount = findSubsetOfNonEvenlyDivisible(setInteger, divisor);
        System.out.println("Hence total of " + maxSubSetCount + " numbers from given set has addition which is not divisible by " + divisor);
    }
    public static int findSubsetOfNonEvenlyDivisible(int[] setIntegers, int divisor){
        Set<Integer> setOfNonDivisibleInteger = new HashSet<>();
        for (int i = 0; i < setIntegers.length - 1 ; i++) {
            for (int j = i+1; j < setIntegers.length; j++) {
                //setIntegers[]
            }
        }
        return setOfNonDivisibleInteger.size();
    }
}

/*
Test Case 1:
4 3
1 7 2 4
Expected Output : 3

Test Case 2:
6 9
422346306 940894801 696810740 862741861 85835055 313720373
Expected Output : 5

Test Case 3:
5 5
2 7 12 17 22
Expected outout 5
 */
