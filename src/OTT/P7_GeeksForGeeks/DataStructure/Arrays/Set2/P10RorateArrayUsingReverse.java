package OTT.P7_GeeksForGeeks.DataStructure.Arrays.Set2;

import java.util.Arrays;

/**
 * Created by Nikhil on 2/27/2017 7:29 PM.
 */
public class P10RorateArrayUsingReverse {
    private static void rotateArrayUsingReverse(int[] array, int rotationPoint) {
        reverse(0, rotationPoint, array);
        reverse(rotationPoint + 1, array.length - 1, array);
        reverse(0, array.length - 1, array);        //important step
        System.out.println(Arrays.toString(array));
    }

    private static void reverse(int start, int end, int[] array) {
        while (start < end) {
            array[start] = array[start] ^ array[end];
            array[end] = array[start] ^ array[end];
            array[start] = array[start] ^ array[end];
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int rotationPoint = 2;                      //at [3]
        rotateArrayUsingReverse(array, rotationPoint);
    }
}
