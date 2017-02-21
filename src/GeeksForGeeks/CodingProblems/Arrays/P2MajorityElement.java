package GeeksForGeeks.CodingProblems.Arrays;

/**
 * Created by Nikhil on 2/20/2017 8:56 AM.
 * Majority Element: A majority element in an array A[]
 * of size n is an element that appears more than n/2
 * times (and hence there is at most one such element).
 */
public class P2MajorityElement {
    public static void main(String[] args) {
        int[] array = {3, 3, 4, 2, 4, 4, 2, 4, 4};
        int element = findMajorityElement(array);
        boolean result = verify(array, element);
        System.out.println("element = " + element);
        System.out.println("result = " + result);
    }

    private static int findMajorityElement(int[] array) {
        int majorityIndex = 0;     //assume first element is majority element
        int count = 1;              //default count set to 1 as first element is assumed to be majority element
        for (int currentElementIndex = 1; currentElementIndex < array.length; ++currentElementIndex) {
            if (array[majorityIndex] == array[currentElementIndex]) count++;
            else count--;

            if (count == 0) {
                majorityIndex = currentElementIndex;            //if count = 0, then set current element is majority element
                count = 1;                                      //and reset counter to 1.
            }
        }
        return array[majorityIndex];
    }

    private static boolean verify(int[] array, int element) {
        int count = 0;
        for (int i = 0; i < array.length; ++i) {
            if (array[i] == element) count++;
            if (count > array.length / 2) return true;
        }
        return false;
    }

}

