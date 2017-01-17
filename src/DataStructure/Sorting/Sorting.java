package DataStructure.Sorting;

import java.util.Random;

/**
 * Created by Nikhi on 11/6/2016.
 */
public class Sorting {
    public static void main(String[] args) {
        int[] a = new int[10];
        Random random = new Random();
        for (int i = 0; i < a.length ; i++) {
            a[i] = random.nextInt(50)* (i + 1);
        }
        int [] b =  new int[] {10, 36, 50, 60, 70, 90, 144, 231, 205, 288, 294};

        System.out.println("Original Array");
        for (int i = 0; i < a.length; i++) {
            System.out.print(b[i] + " ");
        }
        System.out.println();


        int result = linearSearch(b, 144);
        printResult("linear", result);

        printResult("Recursive binary", binarySearchRec(b, 0, b.length-1, 144));
        printResult("Iterative binary", binarySearchItr(b, 144));

        mergeSort(a, 0, a.length);
        print(a);

    }

    public  static void print(int [] a){
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }


    public static int linearSearch(int[] a, int number ){
        for (int i = 0; i < a.length; i++) {
            if(number==a[i]){
                return i;
            }
        }
        return -1;
    }

    public static int binarySearchRec(int[] a, int low, int high, int number ){
        if(high >= 1){
            //this mid element is very importanat
            // you have to add low and then take mid+low/2 middle
            // as when you go to next recursive call, it should have right side of index.
            int mid = low + ((high - low)>>1) ;     //>>1 divide by 2

            if(number == a[mid]){
                return mid;
            }

            if(number < a[mid]){
                return binarySearchRec(a, low, mid-1, number);
            }else{
                return binarySearchRec(a, mid+1, high, number);
            }
        }
        return -1;
    }

    public static int binarySearchItr(int[] a, int number ){
        int low = 0, high = a.length-1;

        while(low <= high){                 //last condition
            int mid = low + (high-low)/2;   //add low to mid always

            if(number == a[mid]){           //check if number found at mid
                return mid;                 //it should found if its present in array finally
            }

            if(number < a[mid]){            //if number is less than mid
                high = mid - 1;             //start array search from lower half of the array index
            }else{                          // if number is greater than mid
                low = mid + 1;              //start array search from upper half of the array index
            }
        }
        return -1;                          //when low <= high, when all search exhausted then number was not found in an array.
    }


    public static void mergeSort(int [] a, int low, int high){
        if(low < high){
            int mid = (high - low) /2;

            mergeSort(a, low, mid);
            mergeSort(a, mid+1, high);

            merge(a, low, mid, high);
        }
    }
    public static void merge(int [] a, int low, int mid, int high){
        //Step1 : get size of two halfs
        int size1 =  mid - 1 + low;
        int size2 =  high - mid;

        //Step2: Create two new arrays for L and R halves
        int[] left = new int[size1];                //O(n/2)
        int[] right = new int[size2];               //O(n/2)
                                                    //Total: O(n) for both arrays

        for (int i = 0; i < size1; i++) {
            left[i] = a[low+i];
        }
        for (int i = 0; i < size2; i++) {
            right[i] = a[mid + 1 + i];
        }

        //Step3: i points to L, j points to R and, K points to main array a.
        // compare and copy back on original array.
        //merge temp arrays
        int i = 0, j = 0;
        int k = low;
        while(i < size1 && j < size2){
            if(left[i] <= right[j]){
                a[k] = left[i];
                i++;
            }else{
                a[k] =  right[j];
                j++;
            }
            k++;
        }
        while (i < size1)
        {
            a[k] = left[i];
            i++;
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (j < size2)
        {
            a[k] = right[j];
            j++;
            k++;
        }
    }

    public static void printResult(String search, int result){
        if(result == -1){
            System.out.println(search + " = Element could not found");
        }else{
            System.out.println(search + " = Element found at index " + result);
        }

    }

}
