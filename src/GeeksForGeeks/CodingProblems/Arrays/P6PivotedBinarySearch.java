package GeeksForGeeks.CodingProblems.Arrays;

/**
 * Created by Nikhil on 2/21/2017 9:35 AM.
 */
public class P6PivotedBinarySearch {
    public static void main(String[] args) {
        int[] array = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int key = 10;

        findKeyInRotatedSortedArray1(array, key);       //not working!
        findKeyInRotatedSortedArray2(array, key);
    }

    private static void findKeyInRotatedSortedArray1(int[] array, int key) {
        int max = array.length - 1;
        int min = 0;

        while (min < max) {
            int mid = (min + max) / 2;
            if (array[mid] == key) {
                System.out.println("Key Found");
                break;
            }
            //if array[low] to array[mid] is sorted.
            if (key >= array[min] && key <= array[mid] && array[min] <= array[mid]) {
                if (key > array[min] && key < array[mid]) {
                    max = mid - 1;
                } else {
                    min = mid + 1;
                }
            }
            //if lower half is not sorted meaning upper half must be sorted.
            if (key >= array[mid] || key <= array[max]) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        System.out.println(key + " is found at " + min + "th index");
    }

    private static void findKeyInRotatedSortedArray2(int[] array, int key) {
        int searchedKey = search(array, 0, array.length - 1, key);
        if (searchedKey == -1) System.out.println("Key is found at " + searchedKey);
        else System.out.println("Key doest not exists in given array");
    }

    private static int search(int[] array, int l, int h, int key) {
        if (l > h) return -1;
        int mid = (l + h) / 2;
        if (array[mid] == key) return mid;

        //if lower array is sorted array
        if (array[l] <= array[mid]) {
            if (key >= array[l] && key <= array[mid]) {
                return search(array, l, mid - 1, key);
            }
            return search(array, mid + 1, h, key);
        }
        //other part must be sorted.
        if (key >= array[mid] && key <= array[h]) {
            return search(array, mid + 1, h, key);
        }
        return search(array, l, mid - 1, key);
    }
}
 