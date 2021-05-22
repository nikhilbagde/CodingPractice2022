package Patterns.educative.io;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class B_TwoPointers {
    static int[] pairInArray(int[] arr, int targetSum) {
        int right = arr.length-1;
        for(int left = 0; left < (arr.length)/2; left++) {
            while (left < right) {
                int sum = arr[left] + arr[right];
                if (targetSum == sum) {
                    return new int[]{left, right};
                } else if (targetSum > sum) {
                    left++;
                } else if (targetSum < sum) {
                    right--;
                }
            }
        }
        return new int[] {-1, -1};
    }

    static int[] squaringSorted(int[] arr) {
        int [] sortedSquaredArr = new int[arr.length];
        int position = arr.length-1;
        int right = arr.length-1;
        int left = 0;

        while (left <= right){
            int squaredLeft = arr[left] * arr[left];
            int squaredRight = arr[right] * arr[right];

            if (squaredLeft > squaredRight){
                sortedSquaredArr[position] = squaredLeft;
                left++;
            } else {
                sortedSquaredArr[position] = squaredRight;
                right--;
            }
            position--;
        }
        return sortedSquaredArr;
    }

    static int[] squaringSortedBookSolution(int[] arr) {
        int n = arr.length;
        int[] squares = new int[n];
        int highestSquareIdx = n - 1;
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int leftSquare = arr[left] * arr[left];
            int rightSquare = arr[right] * arr[right];
            if (leftSquare > rightSquare) {
                squares[highestSquareIdx--] = leftSquare;
                left++;
            } else {
                squares[highestSquareIdx--] = rightSquare;
                right--;
            }
        }
        return squares;
    }

    static List<List<Integer>> tripletSumToZero(int[] arr) {
        int ignore = Integer.MAX_VALUE;
        List<List<Integer>> arrays = new ArrayList<>();
        for(int pointerOne = 0; pointerOne < arr.length-2; pointerOne++){
            int leftValue = arr[pointerOne];
            for(int pointerTwo = pointerOne + 1; pointerTwo < arr.length-1; pointerTwo++) {
                int midValue = arr[pointerTwo];
                int total = midValue + leftValue;
                for (int pointerThree = pointerTwo + 1; pointerThree < arr.length; pointerThree++) {
                    int rightValue = arr[pointerThree];
                    boolean match = false;

                    if (total + rightValue == 0) {
                        List<Integer> values = Arrays.asList(rightValue, midValue, leftValue);
                        arrays.add(values);
                        match = true;
                        if (midValue == rightValue || rightValue == leftValue) {
                            arr[pointerThree] = ignore;
                        } else if (midValue == leftValue) {
                            arr[pointerTwo] = ignore;
                        }
                    }
                    if (match) break;
                }
            }
        }
        return arrays;
    }
}
