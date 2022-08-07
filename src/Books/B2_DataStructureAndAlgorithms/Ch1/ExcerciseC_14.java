package Books.B2_DataStructureAndAlgorithms.Ch1;

import java.util.Arrays;
import java.util.Collections;

/**
 * C-1.14 Write a pseudocode description of a method that reverses an array of n integers,
 * so that the numbers are listed in the opposite order than they were before, and
 * compare this method to an equivalent Java method for doing the same thing.
 */
public class ExcerciseC_14 {
    public static void main(String[] args) {
        Integer[] arrayOfInt = {1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

        Collections.reverse(Arrays.asList(arrayOfInt));
        System.out.println(Arrays.toString(arrayOfInt));
    }
}
