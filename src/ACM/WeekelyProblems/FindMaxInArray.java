package ACM.WeekelyProblems;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.in;

/**
 * Created by Nikhil on 2/7/2017 7:43 PM.
 */
public class FindMaxInArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(in);
        int N = scanner.nextInt();
        N = 10000;
        int[] array = new int[N];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println(Arrays.toString(array));
        getMaximum1(array);
        getMaximum2(array, 0, array.length / 2, array.length, array[0]);
        int start = 0;
        int end = array.length - 1;
        int mid = 0;
        while (end - start > 0) {
            mid = (start + end) / 2;
            if (array[mid] < array[mid + 1]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        System.out.println(array[end]);
            /*
            int mid = (high - low)/2;
            getMaximum3(array, low, mid, array[low]);
            getMaximum3(array, mid+1, high, array[mid+1]);*/

    }

    private static void getMaximum1(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            if (i == array.length) {
                System.out.println(array[array.length - 1]);
            }
            if (array[i] > array[i + 1]) {
                System.out.println(array[i]);
                break;
            }
        }

    }

    private static int getMaximum2(int[] array, int low, int mid, int high, int maximum) {
        mid = /*mid +*/  (low + high) / 2;
        if (mid - 1 >= 0 && mid + 1 < array.length - 1) {
            if (array[mid - 1] > array[mid]) {
                high = mid;
            }
        }
        if (array[mid] > maximum) {
            maximum = array[mid];
        }
        return maximum;
    }

    private static int getMaximum3(int[] array, int low, int high, int MAX) {
        int result = 0;
        int mid = (low + high) / 2;
        while (low > high) {
            result = Arrays.binarySearch(array, low, high, array[(low + high) / 2]);
            if (result > MAX) {
                MAX = result;
            }
        }
        return result;
    }
}
