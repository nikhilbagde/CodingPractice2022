package Contest.W101hack44;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Nikhi on 12/13/2016 12:19 PM.
 */
public class PickingNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[scanner.nextInt()];
        Set<Integer> set = new HashSet<>();
         for (int index = 0; index < array.length; index++) {
            array[index] = scanner.nextInt();
         }
         for (int index = 0; index < array.length-1; index++) {
             for (int inner = index+1; inner < array.length; inner++) {
                 if(Math.abs(array[index] - array[inner]) <=1){
                     set.add(index);
                     set.add(inner);
                 }
             }
        }
        Integer[] newArray = new Integer[set.size()];
         newArray = set.toArray(newArray);
         set.clear();
        for (int index = 0; index < array.length-1; index++) {
            for (int inner = index+1; inner < array.length; inner++) {
                if(Math.abs(newArray[index] - newArray[inner]) <=1){
                    set.add(index);
                    set.add(inner);
                }
            }
        }
        System.out.println(set.size());

    }
}
