package OTT.P7_GeeksForGeeks.DataStructure.Arrays.Set1;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Nikhil on 2/20/2017 6:08 PM.
 * You are given a list of n-1 integers and these integers are in the range of 1 to n.
 * There are no duplicates in list.
 * One of the integers is missing in the list.
 * Write an efficient code to find the missing integer.
 */
public class P5MissingElement {
    public static void main(String[] args) {
        int[] array = {1, 2, 4, 6, 3, 7, 8};

        findMissingElement1(array);

        int reuslt = findMissingElement2(array, 8);
        System.out.println("reuslt = " + reuslt);

        int[] array1 = {1, 2, 4, 6, 3, 7, 8};
        int result1 = findMissingElement3(array1);
        System.out.println("result1 = " + result1);

        int[] array2 = {1, 2, 4, 6, 3, 7, 8};
        int result2 = missingNumberPractice(array2);
        System.out.println("result2 = " + result2);
    }

    private static int findMissingElement1(int[] array) {
        int result = 0;
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < array.length; ++i) {
            map.put(array[i], map.containsKey(array[i]) ? map.get(array[i]) : true);
        }
        return result;
    }

    //o(n) integer overflow problem if large numbers are used.
    private static int findMissingElement2(int[] array, int n) {
        int sum = (n * (n + 1)) / 2;
        for (int i = 0; i < array.length; ++i) {
            sum -= array[i];
        }
        return sum;
    }

    // o(n) fastest
    private static int findMissingElement3(int[] array) {
        int X1 = array[0];  //do XOR of all array elements.
        for (int i = 1; i < array.length; ++i) {
            X1 = X1 ^ array[i];
        }
        int X2 = 1;         //to XOR of 1 to n+1
        for (int i = 2; i <= array.length; ++i) {
            X2 = X2 ^ i;
        }
        return X1 ^ X2;
    }

    private static int missingNumberPractice(int[] array) {
        int reuslt = 0;

        int exOrOfAllElementsinArray = array[0];
        for (int i = 1; i < array.length; ++i) {
            exOrOfAllElementsinArray ^= array[i];
        }

        int exOrOfNumbersFromOneToMax = 1;
        for (int i = 2; i <= array.length + 1; ++i) {
            exOrOfNumbersFromOneToMax ^= i;
        }

        reuslt = exOrOfAllElementsinArray ^ exOrOfNumbersFromOneToMax;
        return reuslt;
    }
}
