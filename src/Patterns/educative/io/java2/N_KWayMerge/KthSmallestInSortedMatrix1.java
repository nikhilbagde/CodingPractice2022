package Patterns.educative.io.java2.N_KWayMerge;

import java.util.*;

class KthSmallestInSortedMatrix1 {

    public static int findKthSmallest(int[][] matrix, int k) {
        // TODO: Write your code here
        int n = matrix.length;
        int len = matrix[0].length;
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < len; j++) {
                if (queue.size() == k) {
                    int num = queue.poll();
                    if (matrix[i][j] < num) queue.add(matrix[i][j]);
                    else queue.add(num);
                } else queue.add(matrix[i][j]);
            }
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        int matrix[][] = { { 2, 6, 8 }, { 3, 7, 10 }, { 5, 8, 11 } };
        int result = KthSmallestInSortedMatrix1.findKthSmallest(matrix, 5);
        System.out.print("Kth smallest number is: " + result);
    }
}

// binary search

class KthSmallestInSortedMatrix {

    public static int findKthSmallest(int[][] matrix, int k) {
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

    public static void main(String[] args) {
        int matrix[][] = { { 2, 6, 8 }, { 3, 7, 10 }, { 5, 8, 11 } };
        int result = KthSmallestInSortedMatrix1.findKthSmallest(matrix, 5);
        System.out.print("Kth smallest number is: " + result);
    }
}
