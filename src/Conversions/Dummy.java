package Conversions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    }
}
