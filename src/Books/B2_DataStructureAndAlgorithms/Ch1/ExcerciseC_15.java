package Books.B2_DataStructureAndAlgorithms.Ch1;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Random;

/**
 * C-1.15 Write a pseudocode description of a method for finding the smallest and largest
 * numbers in an array of integers and compare that to a Java method that would do
 * the same thing.
 * <p>
 * https://www.deadcoderising.com/how-to-generate-a-stream-of-random-numbers-in-java/
 */
public class ExcerciseC_15 {
    public static void main(String[] args) {
        //How to generate random numbers of steam? - new Random().ints();
        //How to generate random numbers of array using steams. - new Random().ints(size,start,end).toArray();
        int[] array = new Random()
                .ints(30, 1, 101)
                .toArray();
        System.out.println(Arrays.toString(array));

        // How to convert from Array to Stream.
        // How to find max element from an array using streams.
        // https://howtodoinjava.com/java8/java-stream-max/
        OptionalInt optinalMax = Arrays.stream(array).max();
        OptionalInt optinalMin = Arrays.stream(array).min();

        // How to print optionalInt value. - getAsInt();
        // https://docs.oracle.com/javase/8/docs/api/java/util/OptionalInt.html
        System.out.println("Max = " + (optinalMax.isPresent() ? optinalMax.getAsInt() : ""));
        System.out.println("Min = " + (optinalMin.isPresent() ? optinalMin.getAsInt() : ""));

    }
}
