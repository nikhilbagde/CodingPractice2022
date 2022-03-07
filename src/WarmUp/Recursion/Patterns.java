package WarmUp.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Patterns {
    public static void main(String[] args) {
        triangleDescending(4,0);
        triangleAscending(4,0);

        System.out.println("\n");

        int [] arr = {5,4,3,2,1};
        bubbleSort(arr, arr.length-1, 0);
        //passing row as arr.length-1 as
        // otherwise if(arr[c] > arr[c+1]) next element logic will fail
        System.out.println("\n Bubble Sort arr: " + Arrays.toString(arr));

        arr = new int[] {5,4,3,2,1};
        bubbleSortIterative(arr);
        System.out.println(" Bubble Sort Iterative arr: " + Arrays.toString(arr));

        arr = new int[] {5,4,3,2,1};
        selectionSort(arr, arr.length-1, 0,0);
        //passing row as arr.length
        // as we need to do comparison of columns till last element  if(col <=  row)
        System.out.println(" Selection Sort arr = " + Arrays.toString(arr));

        arr = new int[] {5,4,3,2,1};
        selectionSort2(arr, arr.length, 0,0);   //passing row as arr.length instead of length-1
        System.out.println(" Selection Sort 2 arr = " + Arrays.toString(arr));


        arr = new int[] {5,4,3,2,1};
        selectionSortIterative(arr);   //passing row as arr.length instead of length-1
        System.out.println(" Selection Sort Iterative arr = " + Arrays.toString(arr));



        arr = new int[] {5,4,3,2,1};
        arr = mergeSort(arr);   // original array is never modified but for now storing returned array to same array.
        System.out.println(" Merged Sort arr = " + Arrays.toString(arr));

        arr = new int[] {5,4,3,2,1};
        mergeSortInPlace(arr, 0, arr.length);
        System.out.println(" Merged Sort In-place arr = " + Arrays.toString(arr));

        arr = new int[] {5,4,3,2,1};
        insertionSort(arr);
        System.out.println(" Insertion Sort arr = " + Arrays.toString(arr));

        /* ******************************************STRING**************************************************/
        String input = "baacasavacd";
        System.out.print( " Without return value for recursion = " );
        skipCharFromaString("", input);
        String ans = skipCharFromAStringWithReturnValue(input);
        System.out.println(" Skip given character from the String ans = " + ans);

        input = "bacacapplescs";
        System.out.print( " Without return value for recursion = " );
        skipStringFromAString("", input);
        ans = skipStringFromAStringWithReturnValue(input);
        System.out.println(" Skip given String from the String ans = " + ans);

        input = "abc";
        System.out.println( " Without return value for recursion = " );
        printAllSubsetsOfAString(input, "");
        List<String> allSubSets =  new ArrayList<>();
        subStringWithArgument(input, "", allSubSets);
        System.out.println(" \n   allSubSets with Argument object= " + allSubSets);

        allSubSets.clear();
        allSubSets = subStringWithReturnValue(input,"");
        System.out.println(" allSubSets with Return object = " + allSubSets);




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
    
    public static void bubbleSortIterative(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 1; j < arr.length-i; j++) {
                if(arr[j-1] > arr[j]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
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

        if(col <=  row){                                // <= as we need to check all element to find max
            if(arr[col] > arr[maxIndex]){
                maxIndex= col;
            }
            selectionSort(arr, row, col+1, maxIndex);   //call function call for next column
        } else {
            int lastElementIndex = row;                     // last element is current nth row element

            int temp = arr[lastElementIndex];
            arr[lastElementIndex] = arr[maxIndex];
            arr[maxIndex] = temp;

            selectionSort(arr, row-1, 0, 0);    //reset column to 0 and max index = 0 and decrement row
        }
    }

    public static void selectionSort2(int[] arr, int row, int col, int maxIndex){
        if(row==0) return;

        if(col <  row){                                // <= as we need to check all element to find max
            if(arr[col] > arr[maxIndex]){
                maxIndex= col;
            }
            selectionSort2(arr, row, col+1, maxIndex);   //call function call for next column
        } else {
            int lastElementIndex = row-1;                     // last element is current nth row element

            int temp = arr[lastElementIndex];
            arr[lastElementIndex] = arr[maxIndex];
            arr[maxIndex] = temp;

            selectionSort2(arr, row-1, 0, 0);    //reset column to 0 and max index = 0 and decrement row
        }
    }

    public static void selectionSortIterative(int [] arr){
        for (int i = 0; i < arr.length; i++) {
            int lastIndex = arr.length-1 -  i; // negate i as at every stage we need to shift last element one by one based on ith value.
            int maxIndex = getMaxIndex(arr, 0, lastIndex);

            int temp = arr[lastIndex];
            arr[lastIndex] = arr[maxIndex];
            arr[maxIndex] = temp;
        }
    }

    private static int getMaxIndex(int[] arr, int start, int end) {
        int maxIndex = start;
        for (int i = start; i <= end; i++) {
            if(arr[i]> arr[maxIndex]){
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static int[] mergeSort(int [] arr){ //returning new array
        if(arr.length==1) return arr;           // This is a base condition, when only 1 element is remaining there is nothing to divide.
        int mid = arr.length/2;

        int[] leftArray = mergeSort(Arrays.copyOfRange(arr, 0, mid));  //3rd parameter is not inclusive
        int[] rightArray = mergeSort(Arrays.copyOfRange(arr, mid,arr.length )); // hence, adding it as starting index.

        return merge(leftArray, rightArray);
    }

    private static int[] merge(int[] leftArray, int[] rightArray) {
        int i=0, j=0, k=0;
        int[] mergedArray = new int[leftArray.length+ rightArray.length];

        while(i<leftArray.length && j< rightArray.length){ // we are moving for both indexes together
            if(leftArray[i] < rightArray[j]){               // there might be chance that both arrays are not of same size
                mergedArray[k++] = leftArray[i++];
            }else {
                mergedArray[k++] = rightArray[j++];
            }
        }
        while(i<leftArray.length){      // for condition when both arrays are not same size, copy remaining
            mergedArray[k++] = leftArray[i++];
        }
        while(j<rightArray.length){     // copy remaining. Either of this and above will run.
            mergedArray[k++] = rightArray[j++];
        }
        return mergedArray;
    }

    /**
     * In above, we create a new array
     * Here we are going to use existing array and instead of having left and right array,
     * we are going to use index of same array.
     * @param arr
     * @param start
     * @param end
     */
    public static void mergeSortInPlace(int [] arr, int start, int end){ //returning nothing as its in-place.
        if(end-start==1) return ;
       int mid = (start+ end)/2;       // not end-start /2

        mergeSortInPlace(arr, start, mid);
        mergeSortInPlace(arr, mid, end);

        mergeInPlace(arr, start, mid, end);
    }

    private static void mergeInPlace(int[] arr, int start, int mid, int end) {
        int i=start, j=mid, k=0;  /// position of i are j are changed to start from start-index and mid-index.
        int[] mergedArray = new int[end- start];

        while(i<mid && j< end){
            if(arr[i] < arr[j]){
                mergedArray[k++] = arr[i++];
            }else {
                mergedArray[k++] = arr[j++];
            }
        }
        while(i<mid){
            mergedArray[k++] = arr[i++];
        }
        while(j<end){
            mergedArray[k++] = arr[j++];
        }

        for (int l = 0; l < mergedArray.length; l++) {
            arr[start+l] = mergedArray[l];
        }
    }

    public static void insertionSort(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j >0; j--) {
                if(arr[j-1]> arr[j]){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                } else {
                    break; //This prevents to check further array element if we find last two element are already sorted. No need to check previous array, as we are storing from
                    // first two positions, hence previous array is always sorted.
                }
            }
        }
    }

    public static void quickSort(int[] arr, int low, int high){
        int pivot = (high-low) + low/2;

        int start = low;
        int end = high;

        while(start<=end){
            while(arr[start]< arr[pivot]){
                start++;
            }
            while(arr[end]> arr[pivot]){
                end--;
            }
            if(start<end){
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end]= temp;
            }
            start++;
            end--;
        }
        quickSort(arr, low, start);        //wrong I don' t understand.
        quickSort(arr, high, end);      //wrong
    }

    /**
     * Given a String babbaca  remove all 'a' characters and return remaining string
     * @param preString
     * @param postString
     */
    public static void skipCharFromaString(String preString, String postString){
        if(postString.isEmpty()){
            System.out.println(preString);          //Up up up stack and print at the end. Notihng to pass to previous stack
            return;
        }
        /*if(postString.charAt(0)=='a'){
            skipString(preString, postString.substring(1));     //dont add current character in preString
        } else {
            skipString(preString + postString.charAt(0), postString.substring(1)); // Add current character in preString
        }*/
        char currentChar = postString.charAt(0);
        if(currentChar=='a'){
            skipCharFromaString(preString, postString.substring(1));     //dont add current character in preString
        } else {
            skipCharFromaString(preString + currentChar, postString.substring(1)); // Add current character in preString
        }
    }

    /**
     * In this method we are using return type. So all recursive call will have return in front of them.
     * Here we are build the value from first call stack.
     * We are adding the current character when its not 'a'.
     * Eventually when we have considered all characters from input string and when its blank we do't need to add
     * any character to currently built string.
     * At final stack of recursion it will just return "" blank to original call and its like appending nothing
     *  t ch + ""
     *  Stack will keep dropping to original stack and keep returning the string to mail
     * @param decreasing
     * @return
     */
    private static String skipCharFromAStringWithReturnValue(String decreasing) {
        if(decreasing.isEmpty()) {
            return "";
        }
        char currentChar = decreasing.charAt(0);
        if(currentChar=='a'){
            return skipCharFromAStringWithReturnValue(decreasing.substring(1));
        }else {
            return currentChar + skipCharFromAStringWithReturnValue(decreasing.substring(1));
        }
    }

    /**
     * Skip String "apple" from "bacacaappleas"
     * @param accumulator
     * @param input
     */
    private static void skipStringFromAString(String accumulator, String input) {
        if(input.isEmpty()){
            System.out.println(accumulator);
            return;
        }

        if(input.startsWith("apple")){
            skipCharFromaString(accumulator, input.substring("apple".length()));
        } else {
            skipStringFromAString(accumulator +  input.charAt(0), input.substring(1));
        }
    }

    /**
     * Skip String "apple" from "bacacaappleas" with return value
     * @param input
     */
    private static String skipStringFromAStringWithReturnValue(String input) {
        if(input.isEmpty()){
            return "";
        }

        if(input.startsWith("apple")){
            return skipStringFromAStringWithReturnValue( input.substring("apple".length()));
        } else {
            return input.charAt(0) + skipStringFromAStringWithReturnValue( input.substring(1));
        }
    }

    private static void printAllSubsetsOfAString(String input, String accumulator){
        if(input.isEmpty()) {
            System.out.print("[" + accumulator + "],");
            return;
        }
        char ch = input.charAt(0);
        printAllSubsetsOfAString(input.substring(1), accumulator);  //not to include it
        printAllSubsetsOfAString(input.substring(1), accumulator + ch);  //to include it
    }

    /**
     * Top-down approach final value is added the end of the stack
     * and nothing is passed to the calling method.
     * @param input
     * @param accumulator
     * @param result
     */
    private static void subStringWithArgument(String input, String accumulator, List<String> result) {
        if(input.isEmpty()){
            result.add("["+accumulator+"] ");
            return;
        }
        char ch = input.charAt(0);
        subStringWithArgument(input.substring(1), accumulator+ch, result);
        subStringWithArgument(input.substring(1), accumulator, result);
    }

    private static List<String> subStringWithReturnValue(String input, String accumulator) {
        if(input.isEmpty()){
            List<String> result = new ArrayList<>();
            result.add("["+accumulator+"] ");
            return result;
        }
        char ch = input.charAt(0);
        List<String> finalList = new ArrayList<>();
        finalList.addAll(subStringWithReturnValue(input.substring(1), accumulator+ch));
        finalList.addAll(subStringWithReturnValue(input.substring(1), accumulator));
        return finalList;
    }

}
