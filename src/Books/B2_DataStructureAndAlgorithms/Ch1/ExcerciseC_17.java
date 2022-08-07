package Books.B2_DataStructureAndAlgorithms.Ch1;

import java.util.Arrays;
import java.util.Random;

/**
 * C-1.17 Write a short Java method that takes an array of int values and determines if there
 * is a pair of distinct elements of the array whose product is even.
 */
public class ExcerciseC_17 {
    public static void main(String[] args) {
        int[] array = new Random().ints(100, 1, 101).toArray();
        System.out.println(Arrays.toString(array));
        /**
         * Even number
         * 1 * 1 = 1    o*o= o
         * 1 * 2 = 2    o*e= e
         * 2 * 2 = 4    e*e= e
         * 2 * 3 = 6    e*o= e
         */

        findPairWithGivenProduct(array);

    }

    public static void findPairWithGivenProduct(int[] array) {
        if (array.length < 2) {
            return;
        }

        /*Arrays.sort(array);
        System.out.println(Arrays.toString(array));*/

        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            long product = array[left] * array[right];
            if (array[left] != array[right] && (product) % 2 == 0) {
                System.out.println(array[left] + "*" + array[right] + "=" + product + " it is even");
            }
            left++;
            right--;

        }

    }
}
