package WarmUp.Recursion;

import java.util.Arrays;

public class Patterns {
    public static void main(String[] args) {
        triangleDescending(4,0);
        triangleAscending(4,0);

        int [] arr = {5,4,3,2,1};
        bubbleSort(arr, arr.length-1, 0);
        System.out.println("\n Bubble Sort arr: " + Arrays.toString(arr));

        int [] arr1 = {5,4,3,2,1};
        selectionSort(arr1, arr1.length-1, 0,0);
        System.out.println(" Selection Sort arr1 = " + Arrays.toString(arr1));
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
            bubbleSort(arr, r, c+1);        //inner for loop
        } else {
            bubbleSort(arr, r - 1, 0);     //outer for loop
        }
    }

    /**
     *
     * @param arr
     * @param row
     * @param col
     * @param maxIndex
     */
    public static void selectionSort(int[] arr, int row, int col, int maxIndex){
        if(row==0) return;

        if(col <=  row){
            if(arr[col] > arr[maxIndex]){
                maxIndex= col;
            }
            selectionSort(arr, row, col+1, maxIndex);
        } else {
            int lastElementIndex = row;

            int temp = arr[lastElementIndex];
            arr[lastElementIndex] = arr[maxIndex];
            arr[maxIndex] = temp;

            selectionSort(arr, row-1, 0, 0);
        }
    }
}
