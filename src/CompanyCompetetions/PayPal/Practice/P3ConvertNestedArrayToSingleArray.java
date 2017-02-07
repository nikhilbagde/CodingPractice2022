package CompanyCompetetions.PayPal.Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Nikhil on 2/6/2017 5:31 PM.
 */
public class P3ConvertNestedArrayToSingleArray {
    public static void main(String[] args) {
        int [] a = {1,2,3};
        int [] b = {4,5,6};
        int [] c = {7,8,9};
        int [][] d = { {1,2,3}, {3,4,5}, {6,7,8}};

        int[] abc = new int[a.length*3];
        int index = 0;
        for (int i = 0; i < a.length ; i++) {
            abc[index++] = a[i];
            abc[index++] = b[i];
            abc[index++] = c[i];
        }
        System.out.println(Arrays.toString(abc));

        List<Integer> list = new ArrayList<>();
        for (int row = 0; row < d.length; row++) {
            for (int col = 0; col < d[row].length; col++) {
                list.add(d[row][col]);
            }
        }
        System.out.println( list);
        Integer[] objIntArray = new Integer[list.size()];
        //int[] combinedof2D = Arrays.stream(objIntArray).mapToInt(Integer::intValue).toArray();
        //System.out.println(Arrays.toString(combinedof2D)); throwing expextion


        //Jagged array to 1D array
        int [][] _2dJagged = {{1,2,3},{4,5,6, 5,8},{7,8,9,7}};

        int totalLenght = 0;
        for (int [] a2 : _2dJagged) {
            totalLenght+= a2.length;
        }
        int [] jaggedTo1D = new int[totalLenght];
        int index1 = 0;
        for (int row = 0; row < _2dJagged.length; row++) {
            for (int col = 0; col < _2dJagged[row].length; col++) {
                jaggedTo1D[index1++] = _2dJagged[row][col];
            }
        }
        System.out.println(Arrays.toString(jaggedTo1D));

    }

}
