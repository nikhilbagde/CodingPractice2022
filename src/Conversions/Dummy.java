package Conversions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Nikhil on 1/28/2017 5:38 PM.
 */
public class Dummy {
    private static int[] arrayListToIntArray(ArrayList arrayList){
        //step 1 : to reference type integer
        Integer[] integers = new Integer[arrayList.size()];
        //step 2: Arrays.stream(referenceArray).mapToInt(Integer::intValue).toArray();
        int[] result = Arrays.stream(integers).mapToInt(Integer::intValue).toArray();
        return result;
    }
    private static String[] convertStringToArrayOfString(String name){
        return name.split("\\s+");
    }
    private static char[] convertStringToCharArray(String name){
        return name.toCharArray();
    }
    public static void main(String[] args) {
        //String to String of Array
        String name = "Tu Bin Bataye Muje Le Chal Kahi";
        String [] ArrayOfString = convertStringToArrayOfString(name);

        //String to Char of Array
        String name2  = "Tu Bin Bataye Muje Le Chal Kahi";
        char[] charArray = convertStringToCharArray(name);

        //Array of reference to ArrayList
        Integer[] integerArray =  {1,2,3,4};
        List<Integer> list1 = Arrays.asList(integerArray);

        //Integer[] to int[]
        Integer[] integerArray2 =  {1,2,3,4};
        int[] intArray1 = Arrays.stream(integerArray2).mapToInt(Integer::intValue).toArray();

        String[] stringArray1 = {"Jane","Tu","Ya","Jane","Na"};
        List<String> listOfString = Arrays.asList(stringArray1);

        //ArrayList to int Array
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(2);arrayList.add(3);arrayList.add(5);arrayList.add(7);arrayList.add(11);arrayList.add(13);arrayList.add(17);
        int[] intArray2 = arrayListToIntArray(arrayList);

        //2D jagged to 1D
        int [][] _2dJagged = {{1,2,3},{4,5,6, 5,8},{7,8,9,7}};
        int totalLenght = 0;
        for (int [] a2 : _2dJagged)
            totalLenght+= a2.length;
        int [] jaggedTo1D = new int[totalLenght];
        int index1 = 0;
        for (int row = 0; row < _2dJagged.length; row++) {
            for (int col = 0; col < _2dJagged[row].length; col++) {
                jaggedTo1D[index1++] = _2dJagged[row][col];
            }
        }
        System.out.println(Arrays.toString(jaggedTo1D));

        //Array of int to List
        int[] a = {1, 2, 3, 4};
        List<Integer> list = java.util.stream.IntStream.of(a).boxed().collect(java.util.stream.Collectors.toList());

        //Array of char to list , char[] to list
        char[] b = {'a', 'A', 'b', 'c'};
        String bb = b.toString();
        List<Character> listC = bb.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
    }
}
