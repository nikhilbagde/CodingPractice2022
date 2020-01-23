package Java.CompetitiveProgrammingTricks;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by nbagde on 8/20/2018.
 */
public class FasterSorting {

    public static void main(String[] args) {


    /*Method 1: Use objects (wrapper class)

    We will use the wrapper class Long of the primitive datatype long.
    Given an array long[] arr we will introdue an array Long[] arr_obj.
    While long[] arr is sorted with quicksort Long[] arr_obj is sorted with mergesort which has a worst-case runtime of .
    In Java an array with objects is sorted with mergesort when using Arrays.sort().*/
        long[] arr = {5,3,4,2,1};
        int n = arr.length;
        Long[] arr_obj = new Long[n];
        for(int i=0; i<n; ++i){
            arr_obj[i] = new Long(arr[i]);
        }
        Arrays.sort(arr_obj);

       /* Method 2: shuffling the array before quicksort

        We can still use quick sort but in order to avoid the worst-case runtime of O(n2) for an almost sorted array we will first shuffle it and then apply quicksort.*/

        long[] arr1 = {1,2,3,5,4};
        shuffleArray(arr1);
        Arrays.sort(arr1);
// after sorting print arr



    }
    static void shuffleArray(long[] arr){
        int n = arr.length;
        Random rnd = new Random();
        for(int i=0; i<n; ++i){
            long tmp = arr[i];
            int randomPos = i + rnd.nextInt(n-i);
            arr[i] = arr[randomPos];
            arr[randomPos] = tmp;
        }
    }

// after sorting print arr_obj
}

