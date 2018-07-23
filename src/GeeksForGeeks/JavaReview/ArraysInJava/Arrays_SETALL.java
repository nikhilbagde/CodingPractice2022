package GeeksForGeeks.JavaReview.ArraysInJava;

import java.util.Arrays;
import java.util.OptionalInt;

/**
 * Created by Nikhil on 3/3/2017 1:06 AM.
 */
public class Arrays_SETALL {
    public static void main(String[] args) {
        int[] input = new int[100];
        int[] input1 = new int[100];
        int[] input2 = new int[100];
        Arrays.setAll(input, i -> i);
        Arrays.setAll(input1, i -> i * 2);
        Arrays.setAll(input2, i -> i == 0 ? 0 : (i == 1 ? 1 : (i - 1) + (i - 2)));
        System.out.println("Arrays.toString(input) = " + Arrays.toString(input));
        System.out.println("Arrays.toString(input) = " + Arrays.toString(input1));
        System.out.println("Arrays.toString(input) = " + Arrays.toString(input2));      //Fibonnaci Series

        //
        OptionalInt sum = Arrays.stream(input)
                .reduce((a, b) -> a + b);
        System.out.println(sum);

    }
}
