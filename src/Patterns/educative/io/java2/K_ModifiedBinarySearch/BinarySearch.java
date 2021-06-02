package Patterns.educative.io.java2.K_ModifiedBinarySearch;

class BinarySearch {

    public static int search(int[] arr, int key) {
        if (arr.length == 0) return -1;
        boolean ascend = arr[0] < arr[arr.length-1];
        int start = 0, end = arr.length-1, mid = 0;
        while (start <= end) {
            mid = (start+end)/2;        //The safest way to find the middle of two numbers without getting an overflow is
                                                    // as follows: middle = start + (end-start)/2.
            if (arr[mid] == key) return mid;
            if (ascend) {
                if (arr[mid] < key) start = mid+1;
                else end = mid-1;
            } else {
                if (arr[mid] < key) end = mid-1;
                else start = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(BinarySearch.search(new int[] { 4, 6, 10 }, 10));
        System.out.println(BinarySearch.search(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 5));
        System.out.println(BinarySearch.search(new int[] { 10, 6, 4 }, 10));
        System.out.println(BinarySearch.search(new int[] { 10, 6, 4 }, 4));
    }
}