package LeetCode.CompanyBased.Facebook;

import java.util.Comparator;

/**
 * @author Nikhil Bagde
 * @package LeetCode.CompanyBased.Facebook
 * @created 04/07/2021
 * @date 4/7/2021- 8:48 PM
 * @project HackerRank2017
 **/
public class P_215_KLargestElementInAnArray {
    public static void main(String[] args) {
        int [] array = {3,2,1,5,6,4};
        int k = 2;
        int result = findKthLargest(array, k);
        System.out.println("result = " + result);
    }
    public static  int findKthLargest(int[] nums, int k) {
        java.util.PriorityQueue<Integer> maxHeap
         = new java.util.PriorityQueue<>(k, Comparator.naturalOrder());

        for (int num : nums){
            if(!maxHeap.isEmpty() && maxHeap.peek() < num){
                System.out.println("Removing " + maxHeap.poll());
                maxHeap.offer(num);
            }else{
                maxHeap.offer(num);
            }
        }
        int result = 0;
        while(k>0){
            result =  maxHeap.poll();
            k--;
        }
        return result;
    }
}



/*
 215	Kth Largest Element in an Array
 Find the kth largest element in an unsorted array.
 Note that it is the kth largest element in the sorted order, not the kth distinct element.
 For example, Given [3,2,1,5,6,4] and k = 2, return 5.
 Note: You may assume k is always valid, 1 ≤ k ≤ array's length.
 */