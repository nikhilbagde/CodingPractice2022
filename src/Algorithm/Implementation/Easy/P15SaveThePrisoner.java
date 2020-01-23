package Algorithm.Implementation.Easy;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/save-the-prisoner/problem
 */
public class P15SaveThePrisoner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            int numberOfPrisoners = scanner.nextInt();
            int numberOfChocolates = scanner.nextInt();
            int startingPosition = scanner.nextInt();
            System.out.println(saveThePrisoner(numberOfPrisoners, numberOfChocolates, startingPosition));
        }
    }
    public static int saveThePrisoner(int numberOfPrisoners, int numberOfChocolates, int startingPosition) {
        if(numberOfPrisoners == numberOfChocolates) {
            return startingPosition==1? numberOfPrisoners : startingPosition-1;
        }else {
            int modValue = numberOfChocolates%  numberOfPrisoners ;
            int lastPosition = (startingPosition-1) + modValue;
            if (lastPosition > numberOfPrisoners) {
                return lastPosition-numberOfPrisoners;
            } else {
                return lastPosition==0? 1: lastPosition;
            }
        }
    }
}
