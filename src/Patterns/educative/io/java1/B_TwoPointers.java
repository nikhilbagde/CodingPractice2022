package Patterns.educative.io.java1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1	Introduction
 * 2	Pair with Target Sum (easy)
 * 3	Remove Duplicates (easy)
 * 4	Squaring a Sorted Array (easy)
 * 5	Triplet Sum to Zero (medium)
 * 6	Triplet Sum Close to Target (medium)
 * 7	Triplets with Smaller Sum (medium)
 * 8	Subarrays with Product Less than a Target (medium)
 * 9	Dutch National Flag Problem (medium)
 * 10	Problem Challenge 1
 * 11	Solution Review: Problem Challenge 1
 * 12	Problem Challenge 2
 * 13	Solution Review: Problem Challenge 2
 * 14	Problem Challenge 3
 * 15	Solution Review: Problem Challenge 3
 */
public class B_TwoPointers {
    static int[] pairInArray(int[] arr, int targetSum) {
        int right = arr.length-1;
        for(int left = 0; left < (arr.length)/2; left++) {
            while (left < right) {
                int sum = arr[left] + arr[right];
                if (targetSum == sum) {
                    return new int[]{left, right};
                } else if (targetSum > sum) {
                    left++;
                } else if (targetSum < sum) {
                    right--;
                }
            }
        }
        return new int[] {-1, -1};
    }

    static int[] squaringSorted(int[] arr) {
        int [] sortedSquaredArr = new int[arr.length];
        int position = arr.length-1;
        int right = arr.length-1;
        int left = 0;

        while (left <= right){
            int squaredLeft = arr[left] * arr[left];
            int squaredRight = arr[right] * arr[right];

            if (squaredLeft > squaredRight){
                sortedSquaredArr[position] = squaredLeft;
                left++;
            } else {
                sortedSquaredArr[position] = squaredRight;
                right--;
            }
            position--;
        }
        return sortedSquaredArr;
    }

    static int[] squaringSortedBookSolution(int[] arr) {
        int n = arr.length;
        int[] squares = new int[n];
        int highestSquareIdx = n - 1;
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int leftSquare = arr[left] * arr[left];
            int rightSquare = arr[right] * arr[right];
            if (leftSquare > rightSquare) {
                squares[highestSquareIdx--] = leftSquare;
                left++;
            } else {
                squares[highestSquareIdx--] = rightSquare;
                right--;
            }
        }
        return squares;
    }

    static List<List<Integer>> tripletSumToZero(int[] arr) {
        int ignore = Integer.MAX_VALUE;
        List<List<Integer>> arrays = new ArrayList<>();
        for(int pointerOne = 0; pointerOne < arr.length-2; pointerOne++){
            int leftValue = arr[pointerOne];
            for(int pointerTwo = pointerOne + 1; pointerTwo < arr.length-1; pointerTwo++) {
                int midValue = arr[pointerTwo];
                int total = midValue + leftValue;
                for (int pointerThree = pointerTwo + 1; pointerThree < arr.length; pointerThree++) {
                    int rightValue = arr[pointerThree];
                    boolean match = false;

                    if (total + rightValue == 0) {
                        List<Integer> values = Arrays.asList(rightValue, midValue, leftValue);
                        arrays.add(values);
                        match = true;
                        if (midValue == rightValue || rightValue == leftValue) {
                            arr[pointerThree] = ignore;
                        } else if (midValue == leftValue) {
                            arr[pointerTwo] = ignore;
                        }
                    }
                    if (match) break;
                }
            }
        }
        return arrays;
    }

    public static List<List<Integer>> tripletSumToZeroBook(int[] arr) {
        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(arr);
        if (arr.length < 3) return triplets;
        for (int i = 0; i < arr.length-2; i++) {
            //handle duplicate ith value
            if (i > 0 && arr[i] == arr[i-1]) continue;
            int start = i+1;
            int end = arr.length-1;
            while (start < end) {
                if (arr[start] + arr[end] + arr[i] == 0){
                    triplets.add(Arrays.asList(arr[i], arr[start++], arr[end--]));
                    while (start < end && arr[start] == arr[start-1]) start++;      //handle duplicate start index value
                    while (start < end && arr[end] == arr[end+1]) end--;        //handle duplicate end index  value
                }
                else if (arr[start]+arr[end]+arr[i] < 0) start++;
                else end--;
            }
        }
        return triplets;
    }

    public static int tripletSumCloseToTarget(int[] arr, int targetSum) {
        // TODO: Write your code here
        if (arr.length < 3) return -1;
        int res = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length-2; i++) {
            int start = i+1;
            int end = arr.length-1;
            while (start < end) {
                int diff = targetSum - arr[i]-arr[start]-arr[end];
                if (diff == 0) return targetSum;
                if (diff > 0) start++;
                else end--;
                if (Math.abs(diff) < Math.abs(res)) res = diff;
            }
        }
        return targetSum-res;
    }

    public static int tripletWithSmallerSum(int[] arr, int target) {
        // TODO: Write your code here
        if (arr.length < 3) return 0;
        Arrays.sort(arr);
        int count = 0;
        for (int i = 0; i < arr.length-2; i++) {
            int start = i+1;
            int end = arr.length-1;
            while (start < end) {
                if (arr[i]+arr[start]+arr[end] < target) {
                    count += (end-start);
                    start++;
                } else end--;
            }
        }
        return count;
    }

    /**
     *
     * @param arr
     * @param target
     * @return
     */
    public static List<List<Integer>> subarrayProductLessThanK(int[] arr, int target) {
        List<List<Integer>> subarrays = new ArrayList<>();

        if (arr.length == 0) return subarrays;
        //Keep a left pointer
        //for each left pointer create a right pointer = left + 1 and keep adding its multiplication to temp product.
        for (int left = 0; left < arr.length; left++) {
            int right = left+1;

            //accumulator for a product.
            int prod = arr[left];

            List<Integer> temp = new ArrayList<>();
            temp.add(arr[left]);

            //Accumulative product will be check for each left element.
            while (prod < target) {             //while prod started from left pointer and keep added from right pointer is less than targer
                // first add current elements as List
                subarrays.add(new ArrayList<>(temp));
                // Now before adding right pointer element check index
                if (right < arr.length) {
                    //Add right element to temp List
                    temp.add(arr[right]);
                    // accumulate the product to check it in while loop
                    prod *= arr[right++];
                }
                else break;
            }
        }
        return subarrays;
    }

    public static int subarrayProductLessThanKAccepted(int[] nums, int k) {
        if (k <= 1) return 0;
        int prod = 1, ans = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];
            while (prod >= k) prod /= nums[left++];
            ans += right - left + 1;
        }
        return ans;
    }

    public static int[] dutchFlagSortColors(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int j = 0;
            while (j < arr.length-1-i) {
                if (arr[j] > arr[j+1]) swap(arr,j,j+1);
                j++;
            }
        }
        return arr;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public static List<List<Integer>> searchQuadruplets(int[] arr, int target) {
        List<List<Integer>> quadruplets = new ArrayList<>();
        if (arr.length < 4) return quadruplets;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length-3; i++) {
            //duplicate check
            if (i > 0 && arr[i] == arr[i-1]) continue;
            find(quadruplets, arr, target-arr[i], i);// passing target - nums[i]. rest of problem become 3 sum
        }
        return quadruplets;
    }

    private static void find(List<List<Integer>> quadruplets, int[] arr, int target, int curr) {
        for (int i = curr+1; i < arr.length-2; i++) {
            if (i > curr+1 && arr[i] == arr[i-1]) continue;  // Take CARE of duplicates
            int start = i+1;
            int end = arr.length-1;
            while (start < end) {
                if (arr[start]+arr[end]+arr[i] == target) { // b/c we have already passed target - nums[i] so this is remaining
                    List<Integer> temp = new ArrayList<>(Arrays.asList(arr[curr], arr[i],arr[start++],arr[end--])); //add all four elements  CREATE a new ARRAY LIST
                    //take care of duplicates
                    while (start < end && arr[start] == arr[start-1]) start++;
                    while (start < end && arr[end] == arr[end+1]) end--;
                    quadruplets.add(temp);
                } else if (arr[start]+arr[end]+arr[i] < target) start++;
                else end--;
            }
        }
        return;
    }
}
