package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Nikhi on 11/9/2016.
 */
public class ACM2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line;

        //Using buffer reader to read whole line.
        // Could not use Scanner.nextInt() as I didnt know where to stop!!!
        // Store given sequence of building as per it is visited.
        //       1 2 3 4 5 6 7 8
        // Given 4 5 7 6 8 2 1 3
        // from 1st bulding to 4, from 4 to 6, from 6 to 2... like wise until we again reach to 1. Or otherwise.
        line  = bf.readLine();

        String[] newLine  = line.split("\\s+");
        //store given numbers as a string. Numbers can be anything between 2 to 30. (Integers)
        //line = line.replaceAll(" ", "");
        //char[] array = line.toCharArray();



        //Testing Given constrain.
        /*if(array.length < 2 && array.length >30){
            System.out.println("NO");
            System.exit(1);
        }*/

        //Converting char array to int for further computation
        int[] arrayInt = new int[newLine.length+1];
        for (int i = 0; i < newLine.length; i++) {
            //arrayInt[i+1] = Character.getNumericValue(array[i]);
            arrayInt[i+1] = Integer.parseInt(newLine[i]);
        }

        //List to store path from 1st building to last.
        List<Integer> list = new LinkedList<>();
        list.add(1);                                    // We start from 1st building

        //Find path from 1st building and store path in list.
        findPath(arrayInt[1], arrayInt, list);

        //check if list contains all building numbers
        // from 1 to whatever max building number as per input.
        int flag = 0;
        for (int i = 1; i < arrayInt.length; i++) {
            if(!(list.contains(arrayInt[i]))){
                flag = 1;
                // if it doenst contain even single building then just print NO
                System.out.println("NO");
                break;
            }
        }
        //otherwise print whole path. Hence used linkedList.
        if(flag != 1){
            for (int a: list) {
                System.out.print(a + " ");
            }
        }
    }
    public static List<Integer> findPath (int value, int[] arrayInt, List<Integer> list){
        //base case we have to find if it come back to 1.
        if(value == 1){
            return list;
        }
        list.add(value);
        findPath(arrayInt[value], arrayInt, list);
        return list;
    }
}
