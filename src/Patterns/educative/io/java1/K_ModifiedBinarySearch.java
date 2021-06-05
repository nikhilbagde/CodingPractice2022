package Patterns.educative.io.java1;

import java.util.ArrayList;
import java.util.List;

public class K_ModifiedBinarySearch {
    static class ArrayReader {
        int[] arr;

        ArrayReader(int[] arr) {
            this.arr = arr;
        }

        public int get(int index) {
            if (index >= arr.length)
                return Integer.MAX_VALUE;
            return arr[index];
        }
    }
    static class SearchInfiniteSortedArray {

        public static int search(ArrayReader reader, int key) {
            // find the proper bounds first
            int start = 0, end = 1;
            while (reader.get(end) < key) {
                int newStart = end + 1;
                end += (end - start + 1) * 2; // increase to double the bounds size
                start = newStart;
            }
            return binarySearch(reader, key, start, end);
        }

        private static int binarySearch(ArrayReader reader, int key, int start, int end) {
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (key < reader.get(mid)) {
                    end = mid - 1;
                } else if (key > reader.get(mid)) {
                    start = mid + 1;
                } else { // found the key
                    return mid;
                }
            }

            return -1;
        }

        public static void main(String[] args) {
            ArrayReader reader = new ArrayReader(
                    new int[]{4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30});
            System.out.println(SearchInfiniteSortedArray.search(reader, 16));
            System.out.println(SearchInfiniteSortedArray.search(reader, 11));
            reader = new ArrayReader(new int[]{1, 3, 8, 10, 15});
            System.out.println(SearchInfiniteSortedArray.search(reader, 15));
            System.out.println(SearchInfiniteSortedArray.search(reader, 200));
        }
    }

    // 1. Binary Search
    public static int search(int[] arr, int key) {
        if (arr.length == 0) return -1;
        boolean ascend = arr[0] < arr[arr.length - 1];
        int start = 0, end = arr.length - 1, mid = 0;
        while (start <= end) {
            mid = (start + end) / 2;        //The safest way to find the middle of two numbers without getting an overflow is
            // as follows: middle = start + (end-start)/2.
            if (arr[mid] == key) return mid;
            if (ascend) {
                if (arr[mid] < key) start = mid + 1;
                else end = mid - 1;
            } else {
                if (arr[mid] < key) end = mid - 1;
                else start = mid + 1;
            }
        }
        return -1;
    }

    public static int searchCeilingOfANumber(int[] arr, int key) {
        if (arr.length == 0 || arr[arr.length - 1] < key) return -1;
        int start = 0, end = arr.length - 1, mid = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (arr[mid] == key) return mid;
            else if (arr[mid] < key) start = mid + 1;
            else end = mid - 1;
        }
        return start;       //return start and not -1.
    }

    public static int searchCeilingOfANumber2(int[] arr, int key) {
        return searchCeiling2(arr, key, 0, arr.length - 1);
    }

    private static int searchCeiling2(int[] arr, int key, int start, int end) {
        if (arr.length == 0 || arr[arr.length - 1] < key) return -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (key <= arr[start]) return start;
            if (key > arr[end]) return -1;

            if (key == arr[mid]) return mid;
            else if (key < arr[mid]) {
                if (mid - 1 >= start && key > arr[start - 1]) {
                    return mid;
                } else {
                    end = mid - 1;
                }
            } else if (key > arr[mid]) {
                if (mid + 1 <= end && key <= arr[mid + 1]) {
                    return mid + 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }

    public static char searchNextLetter(char[] letters, char key) {
        if (key < letters[0] || key > letters[letters.length - 1] || letters[letters.length - 1] == key)
            return letters[0];
        int start = 0, end = letters.length, mid = 0;
        while (start <= end) {
            mid = (start + end) / 2;
            if (letters[mid] > key) end = mid - 1;    //note we are not checking letters[mid] == target
            else start = mid + 1;                              // not end = mid-1 and not mid.
        }
        return letters[start];  //returning start/end value of letters
    }

    /* o(n)
     public char nextGreatestLetter(char[] letters, char target) {
        for (char c: letters)
            if (c > target) return c;
        return letters[0];
    }
     */

    public static int[] searchRange1(int[] a, int target) {
        int[] result = {-1, -1};
        if (a == null || a.length == 0)
            return result;
        result[0] = findStartPosition(a, target);
        result[1] = findEndPosition(a, target);
        return result;
    }

    public static int findStartPosition(int[] a, int target) {
        int left = 0;
        int right = a.length - 1;
        int start = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (a[mid] == target) {
                start = mid; // this is start  |  we are storing first occurrence | and overriding if again found in left side
                right = mid - 1; // lets see if there one more on the left
            } else if (target > a[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return start;
    }
    public static int[] searchRangeUsingBinarySearchLeftOrRightBias(int[] a, int target) {
        int left = findPositionOfNumber(a, target, true);
        int right = findPositionOfNumber(a, target, false);
        return new int[]{left,right};
    }
    public static int findPositionOfNumber(int[] a, int target, boolean leftBiased){        // O (log n)
        int left = 0;
        int right = a.length-1;
        int index = -1;
        while(left<=right){                 // why it is important to have equal to sign? when L=7 and R=7, it should still go inside the while loop, and update index to 7+7/2= 7 found. update from 8.
                                                         // why it is important to have equal to sign? when L=9 and R=9, it should still go inside the while loop, and update index to 9+9/2= 9 found. update from 8.
            int mid = left + (right-left)/2;        // to handle integer overflow
            if(a[mid] < target){
                left = mid +1;
            } else if( a[mid] > target){
                right = mid - 1;
            } else if( a[mid] == target) {
                //store the found location to index
                index = mid;

                //so current left and right pointers are in the range where we will find remaining index
                if(leftBiased){                             // E.g. 5 6 7 7 7 7 7 8 8 8 9 9 10
                    right = mid-1;                          //      0 1 2 3 4 5 6 7 8 9 1 2  3
                }else {                                           // 0+13=13/2=6  -> L=6+1=7  R remains at 13  | L = 7, R =13
                    left = mid +1;                          // 13+7/2= 10      ->  R=10-1=9 L remains at 7  | L= 7 , R = 9
                }                                                   // 9+7/2 = 8          -> Found stored 8 to index.   | L= 7 , R = 9
            }                                         //** L= 7 , R = 9    |   left biased, index = 8 | R = 8 (mid) -1 | L = 7 , R = 7 -> Mid found , overrider index from 8 to 7. -> R = mid-1= 6. | Loop end
        }                                             //** L= 7 , R = 9    |    right biased, index = 8 |  L = 8 (mid) +1 | L= 9 , R =9 -> mid = 9+9/2= 9. Found, index = 8 override to 9 |  L=9+1=10 | Loop ends
        return index;
    }

    public static int findEndPosition(int[] a, int target) {
        int left = 0;
        int right = a.length - 1;
        int end = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (a[mid] == target) {
                end = mid;          // this is the end | noting end | and again overriding if any index found on right.
                left = mid + 1; // lets see if there is one more on the right
            } else if (target > a[mid])
                left = mid + 1;
            else
                right = mid - 1;
        }
        return end;
    }

    public static int[] searchRange2(int[] arr, int key) {
        int[] result = new int[]{-1, -1};
        // TODO: Write your code here
        if (arr.length == 0 || arr[0] > key || arr[arr.length - 1] < key) return result;
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            result[0] = start + (end - start) / 2;
            if (arr[result[0]] == key && (result[0] == 0 || arr[result[0] - 1] != key)) break;
            if (arr[result[0]] >= key) end = result[0] - 1;
            else start = result[0] + 1;
        }
        start = 0;
        end = arr.length - 1;
        while (start <= end) {
            result[1] = start + (end - start) / 2;
            if (arr[result[1]] == key && (result[1] == arr.length - 1 || arr[result[1] + 1] != key)) break;
            if (arr[result[0]] <= key) start = result[1] + 1;
            else end = result[1] - 1;
        }
        if (arr[result[0]] != key) return new int[]{-1, -1};
        return result;
    }

    public static int searchInSortedInfiniteArray(ArrayReader reader, int key) {
        int start = 0, end = 1;
        //keep increasing search window till target is less tha reader(end)
        // if not keep updating start = end+1; end = end *2; and
        while (reader.get(end) < key) {
            start = end + 1;
            end *= 2;       //end <<=1;
        }
        //Normal BS
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (reader.get(mid) == key) return mid;
            else if (reader.get(mid) < key) start = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {

        // Initialize binary search bounds
        int left = 0;
        int right = arr.length - k;
        // Binary search against the criteria described
        while (left < right) {
            int mid = (left + right) / 2;
            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        // Create output in correct format
        List<Integer> result = new ArrayList<>();
        for (int i = left; i < left + k; i++) {
            result.add(arr[i]);
        }
        return result;
        /*
        Assume we are taking A[i] ~ A[i + k -1].
        We can binary research i
        We compare the distance between x - A[mid] and A[mid + k] - x

        Assume A[mid] ~ A[mid + k] is sliding window

        case 1: x - A[mid] < A[mid + k] - x, need to move window go left
        -------x----A[mid]-----------------A[mid + k]----------

        case 2: x - A[mid] < A[mid + k] - x, need to move window go left again
        -------A[mid]----x-----------------A[mid + k]----------

        case 3: x - A[mid] > A[mid + k] - x, need to move window go right
        -------A[mid]------------------x---A[mid + k]----------

        case 4: x - A[mid] > A[mid + k] - x, need to move window go right
        -------A[mid]---------------------A[mid + k]----x------
         */
    }

    public static int findMaxInBitonicArray(int[] arr) {
        //intuition is once we calculate mid, check arr[mid]> arr[mid+1]
        // then set end = mid else start = mid+1
        // finally return arr[end]
        if (arr.length == 0) return -1;
        int start = 0, end = arr.length - 1;
        while (start < end) {           // notice its not start<=end
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1]) end = mid;   //no check for arr[mid] == target and all
            else start = mid + 1;
        }
        return arr[end];
    }

    public static int searchInBitonicArray(int[] arr, int k) {
        //first find bitonic point
        int bitonicPoint = findMaxInBitonicArray(arr);

        if (k > arr[bitonicPoint]) return -1;
        else if (k == arr[bitonicPoint]) return bitonicPoint;
        else {
            //search in left of k
            int result = searchInAscendingSide(arr, bitonicPoint, k);
            if (result != -1) {
                return result;
            } else {
                return searchInDescendingSide(arr, bitonicPoint, k);
            }
        }
    }

    private static int searchInDescendingSide(int[] arr, int bitonicPoint, int k) {
        int start = 0, end = bitonicPoint - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == k) return mid;
            if (k < arr[mid]) start = mid + 1;
            else end = mid;
        }
        return -1;
    }

    private static int searchInAscendingSide(int[] arr, int bitonicPoint, int k) {
        int start = 0, end = bitonicPoint - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == k) return mid;
            if (k < arr[mid]) end = mid;
            else start = mid + 1;
        }
        return -1;
    }

    public static int searchInRotatedArray(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int start = 0, end = nums.length - 1;
        //when we use the condition "start <= end", we do not need to determine if nums[start] == target
        //in outside of loop, because the jumping condition is start > end, we will have the determination
        //condition if(target == nums[mid]) inside of loop
        while (start <= end) {
            //start bias
            int mid = start + (end - start) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            //if start part is monotonically increasing, or the pivot point is on the end part
            if (nums[start] <= nums[mid]) {     // NOTICE<=
                //must use "<=" at here since we need to make sure target is in the start part,
                //then safely drop the end part
                if (nums[start] <= target && target < nums[mid]) {      //NOTICE <=
                    end = mid - 1;
                } else { //end bias
                    start = mid + 1;
                }
            } else {            //if end part is monotonically increasing, or the pivot point is on the start part
                //must use "<=" at here since we need to make sure target is in the end part,
                //then safely drop the start part
                if (nums[mid] < target && target <= nums[end]) {//NOTICE <=
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    public static boolean searchInRotatedArrayWithDuplicates(int[] nums, int target) {
        // note here end is initialized to len instead of (len-1)
        int start = 0, end = nums.length;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) return true;
            if (nums[mid] > nums[start]) { // nums[start..mid] is sorted
                // check if target in left half
                if (target < nums[mid] && target >= nums[start]) end = mid;
                else start = mid + 1;
            } else if (nums[mid] < nums[start]) { // nums[mid..end] is sorted
                // check if target in right half
                if (target > nums[mid] && target < nums[start]) start = mid + 1;
                else end = mid;
            } else { // have no idea about the array, but we can exclude nums[start] because nums[start] == nums[mid]
                start++;
            }
        }
        return false;
    }
    public static int findMinInRotatedArray(int[] nums) {
        // If the list has just one element then return that element.
        if (nums.length == 1) {
            return nums[0];
        }

        // initializing left and right pointers.
        int left = 0, right = nums.length - 1;

        // if the last element is greater than the first element then there is no rotation.
        // e.g. 1 < 2 < 3 < 4 < 5 < 7. Already sorted array.
        // Hence the smallest element is first element. A[0]
        if (nums[right] > nums[0]) {
            return nums[0];
        }

        // Binary search way
        while (right >= left) {
            // Find the mid element
            int mid = left + (right - left) / 2;

            // if the mid element is greater than its next element then mid+1 element is the smallest
            // This point would be the point of change. From higher to lower value.
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }

            // if the mid element is lesser than its previous element then mid element is the smallest
            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }

            // if the mid elements value is greater than the 0th element this means
            // the least value is still somewhere to the right as we are still dealing with elements
            // greater than nums[0]
            if (nums[mid] > nums[0]) {
                left = mid + 1;
            } else {
                // if nums[0] is greater than the mid value then this means the smallest value is somewhere to
                // the left
                right = mid - 1;
            }
        }
        return -1;
    }
}




