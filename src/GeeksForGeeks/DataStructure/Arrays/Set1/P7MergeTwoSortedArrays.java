package GeeksForGeeks.DataStructure.Arrays.Set1;

import java.util.Arrays;

/**
 * Created by Nikhil on 2/27/2017 10:57 AM.
 * Array of size m with null elements = { 5, null, 7, null, null, 10, null}   size m
 * Another array of size n, = {6,8,12,14}
 */
public class P7MergeTwoSortedArrays {       //not completed
    public static void main(String[] args) {
        int[] arrayM = new int[8];
        arrayM[0] = 5;
        //arrayM[1] = (int) Double.NaN;     //-1 meaning is not a valid number lets say NaN - not a number.
        arrayM[2] = 7;
        //arrayM[3] = (int) Double.NaN;
        //arrayM[4] = (int) Double.NaN;
        arrayM[5] = 10;
        //arrayM[7] = (int) Double.NaN;
        int[] arrayN = {6, 8, 12, 14};

        // mergeTwoSortedArray1(arrayM, arrayN);
        mergeTwoSortedArray2(arrayM, arrayN);
    }

    /*
        { 5, null, 7, null, null, 10, null}   size m
        {6,8,12,14}
     */
    private static void mergeTwoSortedArray1(int[] arrayM, int[] arrayN) {
        int indexM = 0, indexN = 0;
        int count = 0;
        while (true) {
            System.out.println(++count);
            if (indexM >= arrayM.length || indexN >= arrayN.length) {
                break;
            }
            if (arrayM[indexM] == (int) Double.NaN) {
                arrayM[indexM] = arrayN[indexN];
                indexM++;
                indexN++;
            }
            if (arrayN[indexN] <= arrayM[indexM]) {
                int temp = arrayN[indexN];
                arrayN[indexN] = arrayM[indexM];
                arrayM[indexM] = temp;
                continue;
            }
            if (arrayN[indexN] > arrayM[indexM]) {
                indexM++;
                continue;
            }

        }
        System.out.println(Arrays.toString(arrayM));
    }

    private static void mergeTwoSortedArray2(int[] arrayM, int[] arrayN) {
        int[] result = new int[arrayM.length];
        int index = 0, indexM = 0, indexN = 0;
        while (index <= result.length) {
            if (arrayM[indexM] < arrayN[indexN]) {
                result[index] = arrayM[indexM];
                indexM++;
                index++;
            }
            if (arrayM[indexM] > arrayN[indexN]) {
                result[index] = arrayN[indexN];
                indexN++;
                index++;
            }
        }
        System.out.println("Result " + Arrays.toString(result));
    }
}
