package OTT.P7_GeeksForGeeks.DataStructure.Arrays.Set1;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Nikhil on 2/20/2017 10:11 AM.
 * Given an array of positive integers.
 * All numbers occur even number of times except one number which occurs odd number of times.
 * Find the number in O(n) time & constant space.
 * Example:
 * I/P = [1, 2, 3, 2, 3, 1, 3]
 * O/P = 3
 */
public class P3OldOccurringNumber {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 2, 3, 1, 3};

        int result = checkOldOccurringNumber1(array);
        System.out.println("result = " + result);

        int result2 = checkOldOccurringNumber2(array);
        System.out.println("result2 = " + result2);
    }

    private static int checkOldOccurringNumber1(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; ++i) {
            map.put(array[i], map.containsKey(array[i]) ? map.get(array[i]) + 1 : 1);
        }
        //System.out.println(map);
        for (Map.Entry<Integer, Integer> entrySet : map.entrySet()) {
            if ((entrySet.getValue() & 1) == 1) return entrySet.getKey();
        }
        return 0;
    }

    //works only when there is one element whose occurrence is ODD.
    private static int checkOldOccurringNumber2(int[] array) {
        int result = 0;
        for (int i = 0; i < array.length; ++i) {
            //System.out.println( result + " = " + Integer.toBinaryString(result) + " " + array[i] + " = " + Integer.toBinaryString(array[i]));
            result = result ^ array[i];
            //System.out.println(result + " "  + Integer.toBinaryString(result));
        }
        return result;
    }
}
