package CompanyCompetetions.Amazon.Interview2.Top12Problems;


import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author Nikhil
 * Given array is [1, 23, 12, 9, 30, 2, 50]
 * and you are asked for the largest 3 elements
 * i.e., k = 3 then your program should print 50, 30 and 23.
 */
public class P1_KLargestElmentsFromArray {
    public static void main(String[] args) {
        int [] a = {1, 23, 12, 9, 30, 2, 50};
        int k = 3;
        System.out.println(Arrays.toString(findKLargest(a,k)));
    }
    private static int[] findKLargest(int[] a,int k){
        int p = k;
        if(a.length == 0) return new int[] {};
        int[] result = null;

        PriorityQueue<Integer> minPriorityQueue = new PriorityQueue<>((o1, o2) -> o1 > o2 ? 1 : (o1 < o2 ? -1: 0));
        PriorityQueue<Integer> maxPriorityQueue = new PriorityQueue<>((o1, o2) -> o1 > o2 ? -1 : (o1 < o2 ? 1: 0));
        for (Integer i : a) {
            minPriorityQueue.offer(i);
            maxPriorityQueue.offer(i);
        }
        result = new int[k];
        int[] result2 = new int[k];

        int index = 0;
        while(k-->0 && minPriorityQueue.size()>k) {
            result[index] = minPriorityQueue.poll();
            result2[index] = maxPriorityQueue.poll();
            index++;
        }
        System.out.println("Smallest " + p + " Elements = " + Arrays.toString(result) + " \n" + "Largest " + p + " Elements = " + Arrays.toString(result2));
        return result2;
    }
}
