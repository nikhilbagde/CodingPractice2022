package Patterns.educative.io.java2.M_TopKElements;

import java.util.*;

class TaskScheduler {

    public static int scheduleTasks(char[] tasks, int k) {
        Map<Character, Integer> map = new HashMap<>();
        for (char task: tasks) {
            map.put(task, map.getOrDefault(task, 0)+1);
        }
        int count = 0;
        int res = 0;
        //PQ of frequency as max Heap. E.g. Char c occurred 5 no of time. Max heap of Frequency.
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        //Queue to keep track of k distance apart task.
        Queue<Integer> buffer = new LinkedList<>();
            pq.addAll(map.values());     //Adding only values as it's PQ of Integer frequencies


        while (count != map.size()) {   // till we cover all task. we cant use while PQ not empty as we are adding idea time. So size is diff for that.
            if (pq.isEmpty()) pq.add(Integer.MAX_VALUE);        //acts as idea time.

            int mostFrequentTask = pq.poll();       //remove
            mostFrequentTask--;                         //decrease frequency
            if (mostFrequentTask == 0) count++;     //Count incremented only when task frq reaches 0
            buffer.add(mostFrequentTask);          // add to k buffer

            res++;                                              //increment final answer

            if (buffer.size() == k+1) pq.add(buffer.poll());    //if buffer size == k, add back queued item to PQ
        }
        return res;
    }

    public static void main(String[] args) {
        char[] tasks = new char[] { 'a', 'a', 'a', 'b', 'c', 'c' };
        //System.out.println("Minimum intervals needed to execute all tasks: " + TaskScheduler.scheduleTasks(tasks, 2));

        tasks = new char[] { 'a', 'b', 'a' };
        //System.out.println("Minimum intervals needed to execute all tasks: " + TaskScheduler.scheduleTasks(tasks, 3));
        
        tasks = new char[] { 'A','A','A','A','A','A','B','C','D','E','F','G' };
        System.out.println("Minimum intervals needed to execute all tasks: " + TaskScheduler.scheduleTasks(tasks, 2));
    }
}
