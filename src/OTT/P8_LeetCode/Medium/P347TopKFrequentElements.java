package LeetCode.Medium;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * Created by Nikhil on 4/4/2017 1:34 AM.
 */
public class P347TopKFrequentElements {
    public static void main(String[] args) {
        int[] a = {1, 1, 1, 2, 2, 3};  //k=2    //expected : [1,2]
        int[] b = {1, 2};  //k=2            //expected : [1,2]
        int[] c = {3, 0, 1, 0};  //k=1        //expected : [0]

        System.out.println(topKFrequent(a, 2));
    }

    private static List<Integer> topKFrequent(int[] nums, int k) {
        if (nums.length == k) {
            List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
            return list;
        }
        //Step 1: Create a frequency map
        java.util.Map<Integer, Integer> map = new java.util.HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        //Step 2: Create a PQ
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((o1, o2) ->
                o1.getValue() > o2.getValue() ? -1 : (o1.getValue() < o2.getValue() ? 1 : 0));

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            minHeap.offer(entry);
        }

        //Step 3: Create a list, add only those values which are greater than k. index of bucket.
        java.util.List<Integer> result = new java.util.ArrayList<>();
        while (!minHeap.isEmpty() && k-- > 0) {
            result.add(minHeap.poll().getKey());
        }

        return result;
    }
}


//Step 2: Create array of List of [index = frequencies and value = numbers] bucket
        /*List<Integer>[] arrayOfLists = new List[nums.length+1];
        for(int key: map.keySet()){
            int frequency = map.get(key);
            if(arrayOfLists[frequency]==null){
                arrayOfLists[frequency] = new java.util.ArrayList<>();
            }
            arrayOfLists[frequency].add(key);
            // [null  3  2  1  null]
            // [0     1  2  3  4   ]
        }*/

