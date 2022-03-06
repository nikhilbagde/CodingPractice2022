package WarmUp.Recursion;

import java.util.Arrays;

public class Patterns {
    public static void main(String[] args) {
        triangleDescending(4,0);
        triangleAscending(4,0);

        int [] arr = {5,4,3,2,1};
        bubbleSort(arr, arr.length, 0);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Print Like this:
     * ****
     * ***
     * **
     * *
     * @param r
     * @param c
     */
    static void triangleDescending(int r, int c) {
        if(r == 0) return;
        if(c < r) {
            System.out.print("*");
            triangleDescending(r, c+1);
        } else {
            System.out.println();
            triangleDescending(r - 1, 0);
        }
    }
    /**
     * Print Like this:
     * @param r
     * @param c
     */
    static void triangleAscending(int r, int c) {
        if(r == 0) return;
        if(c < r) {
            triangleAscending(r, c+1);
            System.out.print("*");
        } else {
            triangleAscending(r - 1, 0);
            System.out.println();
        }
    }

    /**
     *
     * @param r
     * @param c
     */
    static void bubbleSort(int[] arr, int r, int c) {
        if(r == 0) return;
        if(c < r) {
            if(arr[c] > arr[c+1]) {
                int temp = arr[c];
                arr[c] = arr[c+1];
                arr[c+1] = temp;
            }
            bubbleSort(arr, r, c+1);
        } else {
            bubbleSort(arr, r - 1, 0);
        }
    }
}
