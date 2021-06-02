package Patterns.educative.io.java1;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class N_KwayMerge {
    static class ListNode {
        int value;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }
    }
    public static ListNode mergeKListsIntoOneInAscendingOrder(ListNode[] lists) {
        //Create a minHeap and add all nodes to min Heap
        // Create a new linked list - then simply create a prev and head pointers and current pointer,
        // use queue!empty logic and process each node, and set prev.next = curr prev= prev.next.
        Queue<ListNode> queue = new PriorityQueue<>((a, b)-> a.value-b.value);
        for (ListNode node: lists) {
            if (node != null) queue.add(node);
        }
        ListNode result = null;
        ListNode prev = null;
        while (!queue.isEmpty()) {
            ListNode curr = queue.poll();
            if (prev == null) {
                prev = curr;
                result = curr;
            } else {
                prev.next = curr;
                prev = prev.next;
            }
            if (curr.next != null) queue.add(curr.next);
        }
        return result;
    }
    public static int findKthSmallest(List<Integer[]> lists, int k) {
        Queue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);
        for (Integer[] list: lists) {
            int n = list.length;
            for (int i = 0; i < n; i++) {           // as we are using maxHeap,
                if (maxHeap.size() == k) {            //we need to traverse through whole list one by one
                    int temp = maxHeap.poll();        // or if( list[i]< maxHeap.peek() )
                    if (list[i] < temp) maxHeap.add(list[i]);
                    else maxHeap.add(temp);
                } else maxHeap.add(list[i]);
            }
        }
        return maxHeap.peek();
    }

    public static int findKthSmallest2(List<Integer[]> lists, int k) {
        Queue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);

        for (Integer[] list : lists) {
            for (int i = 0; i < k && i<list.length ; i++) {  // k * size of lists (3)
                minHeap.offer(list[i]);
            }
        }
        int result = -1;
        while(!minHeap.isEmpty()){      // k * log k
            result = minHeap.poll();
        }
        return result;
    }
    public static int findKthSmallestInSortedMatrix(int[][] matrix, int k) {
        int n = matrix.length;
        int start = matrix[0][0], end = matrix[n-1][n-1];
        while (start < end) {       //start and end are not indexes but actual values in the matrix.
            int mid = start+(end-start)/2;
            int[] pair = new int[]{start, end};

            //we are finding how many elements are in the matrix which are less than mid.
            int count = count(matrix, mid, pair);

            //based on count, we change the search space.
            if (count == k) return pair[0];
            if (count < k) start = pair[1];
            else end = pair[0];
        }
        return -1;
    }

    private static int count(int[][] matrix, int mid, int[] pair) {
        int row = matrix.length-1;
        int col = 0;
        int count = 0;
        while (row >= 0 && col < matrix.length) {
            int curr = matrix[row][col];
            if (curr <= mid) {      // checking matrix values
                pair[0] = Math.max(curr, pair[0]);      //moving start to max of start and current
                count += (row+1);                               // count is increased here only. As we are trying to find kth largest
                col++;
            } else {
                pair[1] = Math.min(curr, pair[1]);
                row--;
            }
        }
        return count;
    }
}
