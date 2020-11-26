package Books.ElementsOfProgrammingInterview.DataStructure.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

        P3_multiplyTwoArbitaryPreciousIntegers();

        P4_advancingThroudhAnArray();

        P5_deleteDuplicatesFromSortedArray();
        P6_computeMaxProfite();


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
        List<Integer> num1 = Arrays.asList(1, 9, 3, 7, 0, 7, 7, 2, 1);
        List<Integer> num2 = Arrays.asList(-7, 6, 1, 8, 3, 8, 2, 5, 7, 2, 8, 7);

        final int sign = num1.get(0) < 0 ^ num2.get(0) < 0 ? -1 : 1;    //both + or both -, 00, 11 -> 0  1-, then 1 EXOR

        //Now we got the sign, set absolute values back to num1 and num2
        num1.set(0, Math.abs(num1.get(0)));
        num2.set(0, Math.abs(num2.get(0)));

        List<Integer> result =
                new ArrayList<>(Collections.nCopies(num1.size() + num2.size(), 0));

        for (int i = num1.size() - 1; i >= 0; --i) {
            for (int j = num2.size() - 1; j >= 0; --j) {
                result.set(i + j + 1, result.get(i + j + 1) + num1.get(i) * num2.get(j)); // set multiplication first
                result.set(i + j, result.get(i + j) + result.get(i + j + 1) / 10);      //set carry-in
                result.set(i + j + 1, result.get(i + j + 1) % 10);      //set back reminder

            }
        }

        //Remove leading zeros
        int first_non_zero = 0;
        while (first_non_zero < result.size() && result.get(first_non_zero) == 0) {
            ++first_non_zero;
        }

        result = result.subList(first_non_zero, result.size());

        if (result.isEmpty()) {
            System.out.println(Arrays.asList(0));
        }
        result.set(0, result.get(0) * sign);

        System.out.println("result = " + Arrays.toString(result.toArray()));
    }
    //Time complexity O(mn) where m and n are length of the arrays.

    /**
     * In a particular board game, a player has to try to advance through a sequence of
     * positions. Each position has a nonnegative integer associated with it, representing
     * the maximum you can advance from that position in one move. You begin at the first
     * position, and win by getting to the last position
     * <p>
     * For example, let A = (3,3,1,0, 2, 0,1}
     * represent the board game, i.e., the ith entry in A is the maximum we can advance
     * from i. Then the game can be won by the following sequence of advances through
     * A: take 1 step from A[0] to A[1], then 3 steps from A[l] to A[4], then 2 steps from
     * A[4] to A[6], which is the last position. Note that A[0] = 3 > 1, A[l] = 3 > 3, and
     * A[4] = 2 > 2, so all moves are valid.
     * If A instead was (3, 2, 0,0, 2, 0,1), it would not
     * possible to advance past position 3, so the game cannot be won.
     * <p>
     * A = [3 3 1 0 2 0 1]
     * 0 1 2 3 4 5 6
     * <p>
     * So to win we need to be on position 6th.
     * ith element value is maximum jumps I can take from ith position
     * e.g. A[0] =  3:, so means I can take 1/2/3 jumps from 0th position.
     * So that I can move to 1 2 or 3rd position of A (A[1]/A[2]/A[3]).
     */
    private static void P4_advancingThroudhAnArray() {
        //int A[] = {3,3,1,0, 2, 0,1};
        int[] A = {3, 2, 0, 0, 2, 0, 1};

        int j = A.length - 1;
        int i = j - 1;

        while (j >= 0 && i >= 0) {
            if (A[i] >= j - i) {
                j = i;
                i = j - 1;
            } else {
                i--;
            }
        }
        System.out.println(j == 0 ? "Winning is possible" : "Winning is not possible");

    }
    /**
     * Variant: Write a program to compute the minimum number of steps needed to ad¬
     * vance to the last location
     */

    /**
     * This problem is concerned with deleting repeated elements from a sorted array.
     * For example, for the array (2,3,5,5,7,11,11,11,13), then after deletion, the array is
     * (2,3,5,7,11,13,0,0,0).
     */

    private static void P5_deleteDuplicatesFromSortedArray() {
        int[] A = new int[]{2, 3, 5, 5, 7, 11, 11, 11, 13};


    }

    /**
     * This problem is concerned with the problem of optimally buying and selling a stock
     * once, as described on Page 2. As an example, consider the following sequence of
     * stock prices: (310,315, 275, 295, 260, 270, 290, 230, 255, 250). The maximum profit that
     * can be made with one buy and one sell is 30—buy at 260 and sell at 290. Note that
     * 260 is not the lowest price, nor 290 the highest price.
     * <p>
     * PROBLEM: Write a program that takes an array denoting the daily stock price, and returns the
     * maximum profit that could be made by buying and then selling one share of that
     * stock.
     */

    private static void P6_computeMaxProfite() {
        List<Double> prices = Arrays.asList(310.00, 315.00, 275.00, 295.00, 260.00, 270.00, 290.00, 230.00, 255.00, 250.00);

        //Approach 1: two pointer method
        double maxProfile = 0.0;
        int i = 0;
        while (i < prices.size() - 1) {
            int j = i + 1;
            while (prices.get(j) > prices.get(j - 1) && prices.get(j) > prices.get(i)) { //check with previous and original value  e.g. 310, 315, 314 scenario
                maxProfile = Math.max(maxProfile, prices.get(j) - prices.get(i));
                j++;
            }
            i = j;
        }
        System.out.println("maxProfile = " + maxProfile);

        //Time: O(n^2) Space O(1)

        //Approach 2: Adding another array with low value
        List<Double> prices_2 = Arrays.asList(310.00, 315.00, 275.00, 295.00, 260.00, 270.00, 290.00, 230.00, 255.00, 250.00);
        List<Double> prices_3 = new ArrayList<>();      //Bug fix : Cant clone it. = prices_2.clone()
        // or new ArrayList<>(prices_2.size()) does not take size argurmanet

        prices_3.add(prices_2.get(0));                  //BUG fix: prices_3.set changed to add, cant set in non initialize list.
        double rememberValue = prices_2.get(0);

        for (int j = 1; j < prices_2.size(); j++) {
            if (rememberValue < prices_2.get(j)) {
                prices_3.add(rememberValue);
            } else {
                rememberValue = prices_2.get(j);
                prices_3.add(rememberValue);        //Bug fix: remembered value was missed to add to price_3 when initially found
            }
        }
        System.out.println(Arrays.toString(prices_3.toArray()));

        maxProfile = 0.0;
        List<Double> profit = new ArrayList<>();
        for (int j = 0; j < prices_2.size(); j++) {
            profit.add(prices_2.get(j) - prices_3.get(j));
            maxProfile = Math.max(maxProfile, profit.get(j));
        }
        System.out.println("maxProfile = " + maxProfile);
        //Time: O(N), Space: O(n^2)

        //Approach 3:
        List<Double> prices_4 = Arrays.asList(310.00, 315.00, 275.00, 295.00, 260.00, 270.00, 290.00, 230.00, 255.00, 250.00);
        double minPrice = Double.MAX_VALUE, maxProfit = 0.0;
        for (Double price : prices_4) {
            maxProfit = Math.max(maxProfit, price - minPrice);
            minPrice = Math.min(minPrice, price);
        }
        //Time: O(n) Space: O(1)
    }





}
