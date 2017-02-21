package DataStructure.HashMap;

/**
 * Created by Nikhil on 2/11/2017 4:03 AM.
 * Given an array A[] and a number x, check for pair in A[] with sum as x
 */
public class P1PairSumInArrayForGivenNumber {
    public static void main(String[] args) {

        int A[] = {1, 4, 45, 6, 10, 8};
        int n = 16;
        printPairs(A, n);
    }

    private static void printPairs(int[] array, int sum) {
        boolean[] map = new boolean[10000];

        for (int i = 0; i < array.length; ++i) {
            int _2nNumber = sum - array[i];
            if (_2nNumber > 0 && map[_2nNumber]) {
                System.out.println("Pair with given sum " + sum + " is (" + array[i] + ", " + _2nNumber + ")");
            }
            map[array[i]] = true;
        }
    }
}
