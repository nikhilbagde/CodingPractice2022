package CompanyCompetetions.Amazon.Interview1;

import java.util.Map;

/**
 * Created by Nikhil on 4/6/2017 3:17 PM.
 * Given a sorted array arr[] and a value X,
 * find the k closest elements to X in arr[].Examples:
 */
public class KClosestPoint {
    public static void main(String[] args) {
        int[] a = {12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56};
        int X = 35, K = 4;
        int result[] = findClosestK(a, X, K);
        System.out.println(java.util.Arrays.toString(result));
    }

    private static int[] findClosestK(int[] a, int x, int k) {
        java.util.Map<Integer, Integer> map = new java.util.LinkedHashMap<>();
        for (int i = 0; i < a.length; i++) {
            map.put(Math.abs(a[i] - x), i);
        }
        java.util.PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new java.util.PriorityQueue<>((o1, o2) ->
                o1.getKey() > o2.getKey() ? 1 : (o1.getKey() < o2.getKey() ? -1 : 0));

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            minHeap.offer(entry);
        }
        int Xposition = -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) Xposition = i;
        }
        int[] result = new int[k];
        int index = 0;
        minHeap.poll();

        while (k-- > 0) {
            //System.out.println(minHeap.peek().getValue() < Xposition ? x-minHeap.poll().getKey() : x+minHeap.poll().getKey());
            result[index++] = minHeap.peek().getValue() < Xposition ? x - minHeap.poll().getKey() : x + minHeap.poll().getKey();
        }
        return result;
    }
}

/*
Input: K = 4, X = 35
arr[] = {12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56}
Output: 30 39 42 45
 */