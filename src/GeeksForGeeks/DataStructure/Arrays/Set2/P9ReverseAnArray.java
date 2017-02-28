package GeeksForGeeks.DataStructure.Arrays.Set2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Nikhil on 2/27/2017 12:06 PM.
 */
public class P9ReverseAnArray {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};
        reverseAnArray(array);

        int[] array1 = {1, 2, 3, 4, 5, 6, 7};
        reverseAnArray2(array1);


        //testing Map
        Map<Integer, Double> map = new HashMap<>();

    }

    private static void reverseAnArray(int[] array) {
        String string = Arrays.toString(array).replaceAll("\\[|\\]|,\\s+", "");
        System.out.println(string);
        string = new StringBuilder(string).reverse().toString();
        System.out.println("string = " + string);

        char[] array2 = string.toCharArray();
        System.out.println("Arrays.toString(array2) = " + Arrays.toString(array2));
    }

    private static void reverseAnArray2(int[] array) {
        int start = 0;
        int end = array.length - 1;

        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
        System.out.println("Arrays.toString(array) = " + Arrays.toString(array));
    }


}
