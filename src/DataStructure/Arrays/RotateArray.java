package DataStructure.Arrays;

import java.util.Arrays;

/**
 * Created by Nikhil on 1/9/2017 8:39 AM.
 */
public class RotateArray {
    public static void main(String[] args) {
        int [] array = {1,2,3,4,5,6,7};
        int k = 3;

        rotateArray1(array, k);

    }
    // Space=O(n) Time=O(n)
    private static int[] rotateArray1(int[] array, int k){
        if(k>array.length) k = k%array.length;
        int [] result = new int[array.length];
        for (int i = 0; i < k; i++) {
            result[i] = array[ (array.length - k) + i];     //difference = (length - k) fixed + i=0,1,2..k
        }
        int j = 0;
        for (int i = k; i < array.length ; i++) {
            result[i] = array[j++];
        }
        System.arraycopy(result, 0, array, 0, array.length);
        System.out.println(Arrays.toString(array));
        return array;
    }
    //Space: O(1) Time: O(n*k)
    private static void bubbleRotateArray2(int[] array, int k){
        for (int i = 0; i < k; i++) {
            for (int j = array.length; j >0 ; j--) {
                int temp = array[j];
                array[j] = array[j-1];
                array[j-1] = temp;
            }
        }
        System.out.println(Arrays.toString(array));
    }
    private static void rotateArray3(int[] array, int k){
        if(k > array.length) k = k%array.length;
        int firstPartLength = array.length - k;      //7-3=5 012 3456

    }
}
