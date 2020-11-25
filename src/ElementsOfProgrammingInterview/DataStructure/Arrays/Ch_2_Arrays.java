package ElementsOfProgrammingInterview.DataStructure.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Ch_2_Arrays {
    public static void main(String[] args) {
        int[] arr_int = new int[20];
        int[] arr_int_2 = new int[]{1, 2, 3, 4, 5, 6, 7};

        int[] arr_clone = arr_int_2.clone();

        //Java 8
        int[] arr_int_3 = IntStream.range(0, 100).toArray();
        int[] arr_int_4 = IntStream.rangeClosed(0, 100).toArray();
        int[] arr_int_5 = IntStream.of(0, 100, 200, 400).toArray();
        int[] arr_int_6 = IntStream.of(0, 100, 200, 400).sorted().toArray();

        String[] arr_string = new String[4];
        String[] arr_string_2 = {"a", "ba", "bac"};
        String[] arr_string_3 = new String[]{"a", "ba", "bac"};

        String first = arr_string_2[2];
        IntStream intStream = first.chars();
        System.out.println("intStream = " + intStream);

        char[] arr_char = first.toCharArray();
        System.out.println("arr_char = " + arr_char);
        char character = first.charAt(1);

        String[] arr_split = first.split("a");
        System.out.println("arr_split = " + arr_split);

        String second = first.replace("a", "aa");
        System.out.println("second = " + second);

        String third = first.replaceAll("a", "aa");
        System.out.println("third = " + third);

        String fourth = first.substring(0, 1);
        System.out.println("fourth = " + fourth);

        int reuslt = first.compareTo(arr_string_2[1]);
        int index = first.indexOf("b");

        String fifth = first.concat(second);
        System.out.println("fifth = " + fifth);

        int index2 = first.codePointAt(0);

        P1_divideArrayInEvenAndOddNumbers();

        /**
         * Notes on Arrays:
         * 1. Array length by .length, collection.size() and String.length()
         * 2. Static Methods on Arrays.
         *  asList()
         *  binarySearch(A, 641)
         *  copyOf(A)
         *  copyOfRange(A, 1, 5);
         *  equals(A,B);
         *  fill(A, 42);
         *  find(A, 28);
         *  sort(A),
         *  sort(A,comp);
         *  toString().
         */
        int[] A = new int[]{2, 123, 245, 2, 34, 737, 1, 25, 34, 9324, 20, 42, 239, 4, 22, 641, 28, 23, 3, 65, 72, 28, 2123, 641};
        List<int[]> listOfArrays = Arrays.asList(A);
        System.out.println("listOfArrays = " + Arrays.toString(listOfArrays.toArray()));

        int binaryResult = Arrays.binarySearch(A, 641);
        System.out.println("binaryResult = " + binaryResult);

        int[] A_ = Arrays.copyOf(A, A.length);
        System.out.println("A_ = " + Arrays.toString(A_));

        int[] AA_ = Arrays.copyOf(A, 5);
        System.out.println("AA_ = " + Arrays.toString(AA_));

        int[] AAA_ = Arrays.copyOf(A, 8);
        System.out.println("AAA_ = " + Arrays.toString(AAA_));

        int[] A_A = Arrays.copyOfRange(A, 1, 5);
        System.out.println("A_A = " + Arrays.toString(A_A));

        boolean arrayEqual = Arrays.equals(A, A_);
        System.out.println("arrayEqual = " + arrayEqual);

        Arrays.fill(A, 3, 5, 42);
        //Arrays.fill(A, 7, 5, 43);
        System.out.println(Arrays.toString(A));


        Arrays.sort(A);
        System.out.println(Arrays.toString(A));

        P2_increamentAnAbritaryPrecisionInteger();
        P2_increamentAnAbritaryPrecisionInteger_variany();


    }

    private static void P1_divideArrayInEvenAndOddNumbers() {
        int[] arr = new int[]{1, 2, 6, 221, 23, 65, 74, 2, 895, 85, 3342, 8, 4, 232, 8};
        int nextEven = 0;
        int nextOdd = arr.length - 1;

        while (nextEven < nextOdd) {
            if (arr[nextEven] % 2 == 0) {
                nextEven++;
            } else {
                int temp = arr[nextEven];
                arr[nextEven] = arr[nextOdd];
                arr[nextOdd] = temp;
                nextOdd--;
            }
        }
        System.out.println("arr = " + java.util.Arrays.toString(arr));
    }

    /**
     * Write a program which takes as input an array of digits encoding a decimal number
     * D and updates the array to represent the number D + 1. For example, if the input
     * is (1,2,9) then you should update the array to (1,3,0). Your algorithm should work
     * even if it is implemented in a language that has finite-precision arithmetic.
     * Hint: Experiment with concrete examples.
     */
    private static void P2_increamentAnAbritaryPrecisionInteger() {
        List<Integer> A = new ArrayList<>();
        //Test

        A.add(9);//A.add(1);
        A.add(9);//A.add(2);
        A.add(9);//A.add(9);

        if (A.size() > 0) {
            A.set(A.size() - 1, A.get(A.size() - 1) + 1); // Add 1 to the last element in the array
        }
        //If last element was 9 adding 1 would have 10 as its last place.
        // Now iterate over the array from the last digit to check if it has value 10
        // If yes then add extra 1 to the digit left to that ith element

        for (int i = A.size() - 1; i > 0 && A.get(i) == 10; --i) {//making for loop faster by only focusing on && A.get(i)==10
            A.set(i, 0);
            A.set(i - 1, A.get(i - 1) + 1);
        }

        if (A.get(0) == 10) {
            //Need additional digital as most significant digit is 10 and has carry-out
            A.set(0, 0);
            A.add(0, 1);
        }
        System.out.println(Arrays.toString(A.toArray()));
    }
    // Time Complexity: O(n) n is length of A

    /**
     * Write a program which takes as input two strings s and t of bits encoding
     * binary numbers Bs and B,, respectively, and returns a new string of bits representing
     * the number Bs + Bt
     */

    private static void P2_increamentAnAbritaryPrecisionInteger_variany() {
        List<Integer> A = new ArrayList<>();
        //Test

        A.add(1);//A.add(1);
        A.add(1);//A.add(2);
        A.add(1);//A.add(9);

        A.set(A.size() - 1, A.get(A.size() - 1) + 1); // Add 1 to the last element in the array
        //If last element was 9 adding 1 would have 10 as its last place.
        // Now iterate over the array from the last digit to check if it has value 10
        // If yes then add extra 1 to the digit left to that ith element

        for (int i = A.size() - 1; i > 0 && A.get(i) == 2; --i) {//making for loop faster by only focusing on && A.get(i)==10
            A.set(i, 0);
            A.set(i - 1, A.get(i - 1) + 1);
        }

        if (A.get(0) == 2) {
            //Need additional digital as most significant digit is 10 and has carry-out
            A.set(0, 0);
            A.add(0, 1);
        }
        System.out.println(Arrays.toString(A.toArray()));
    }

    private static void P3_multiplyTwoArbitaryPreciousIntegers() {

    }
}
