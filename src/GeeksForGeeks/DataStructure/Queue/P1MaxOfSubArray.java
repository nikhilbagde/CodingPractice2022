package GeeksForGeeks.DataStructure.Queue;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Nikhil on 2/25/2017 6:21 PM.
 * Given an array and an integer k, find the maximum for each and every contiguous subarray of size k.
 * Examples:
 * <p>
 * Input :
 * arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}
 * k = 3
 * Output :
 * 3 3 4 5 5 5 6
 * <p>
 * Input :
 * arr[] = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13}
 * k = 4
 * Output :
 * 10 10 10 15 15 90 90
 */
public class P1MaxOfSubArray {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        int[] array1 = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13};
        int k = 3;
        maxConSubArray(array, k);
        System.out.println();
        maxConSubArray(array1, 4);
    }

    private static void maxConSubArray(int[] array, int k) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(array[0]);
        for (int i = 1; i < array.length; ++i) {
            if (queue.size() == k) {
                PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o1 > o2 ? -1 : (o1 < o2) ? 1 : 0);
                priorityQueue.addAll(queue);
                System.out.println("Maximum from " + ((i - k) + 1) + " to " + (i) + " is " + priorityQueue.poll());
                queue.poll();
            }
            if (queue.size() < k) queue.offer(array[i]);
        }
    }
}
