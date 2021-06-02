package Patterns.educative.io.java2.N_KWayMerge;

import java.util.*;

class KthSmallestInMSortedArrays {

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

    public static void main(String[] args) {
        Integer[] l1 = new Integer[] { 2, 6, 8 };
        Integer[] l2 = new Integer[] { 3, 6, 7 };
        Integer[] l3 = new Integer[] { 1, 3, 4 };
        List<Integer[]> lists = new ArrayList<Integer[]>();
        lists.add(l1);
        lists.add(l2);
        lists.add(l3);
        int result = KthSmallestInMSortedArrays.findKthSmallest(lists, 5);
        System.out.print("Kth smallest number is: " + result);
    }
}
