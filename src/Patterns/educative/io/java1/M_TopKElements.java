package Patterns.educative.io.java1;

import java.util.*;
import java.util.stream.Collectors;



public class M_TopKElements {
    static class Element {
        int num;
        int freq;
        int seq;

        public Element(int num, int freq, int seq) {
            this.num = num;
            this.freq = freq;
            this.seq = seq;
        }
    }
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int distFromOrigin() {
            // ignoring sqrt
            return (x * x) + (y * y);
        }
    }
    static Queue<Integer> queue = new PriorityQueue<>();
    static Queue<Integer> queue1 = new PriorityQueue<>();
    static int k1;
    int k;


    public M_TopKElements(int[] nums, int k1) {
        this.k1 = k1;
        for (int i = 0; i < nums.length; i++) {
            queue1.add(nums[i]);
        }
    }

    public static int findKthSmallestNumber(int[] nums, int k) {
        // Kth smallest meaning from smallest to kth smallest.
        if (nums.length == 0) return 0;

        // Create a max Heap -> add only first k elements  it will have top k elements, root largest.
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < k && i < nums.length; i++) {
            queue.add(nums[i]);
        }
        // keep comparing with remaining elements, if current nums's element is less than pq.peek(), remove largest and add it to pq.
        for (int i = k; i < nums.length; i++) {
            if (nums[i] < queue.peek()) {
                queue.poll();
                queue.add(nums[i]);
            }
        }
        return queue.peek();
    }

    public static int findKthLargest(int[] nums, int k) {  //O(n)
        return quickSelect(nums, nums.length - k, 0, nums.length - 1);
    }

    private static int quickSelect(int nums[], int k, int start, int end) {
        if (start > end) {      //Base case
            return nums[k];
        }

        int l = start;
        int r = end;
        int pivot = nums[start + (end - start) / 2];
        while (l <= r) {
            while (l <= r && nums[l] < pivot) l++;
            while (l <= r && nums[r] > pivot) r--;
            if (l <= r) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                l++;
                r--;
            }
        }

        if (k <= r) quickSelect(nums, k, start, r);
        if (k >= l) quickSelect(nums, k, l, end);
        return nums[k];
    }

    public static List<Point> findKClosestPoints(Point[] points, int k) {
        ArrayList<Point> result = new ArrayList<>();

        //Edge Condition
        if (points.length <= k) {
            for (int i = 0; i < points.length; i++) result.add(points[i]);
            return result;
        }
        // If we create a min heap which will solve our problem just inputting all element O(n) into the minHeap log(n) times.
        // and if we keep track of size, ? How, while adding if q size is k, I will have to poll. it will poll smallest. which we dont want.
        // Hence to eliminate this condition. we use MaxHeap.

        // In max heap, we will add first k elements O(k) * log(k).
        Queue<Point> queue = new PriorityQueue<>((a, b) -> b.distFromOrigin() - a.distFromOrigin());
        for (int i = 0; i < k; i++) {
            queue.add(points[i]);
        }

        // for all remaining elements from input, if will check if current element is less that q top
        // if it is, we are going to poll max. This will keep all min as subtree for max.
        // So we are preserving all smaller items already and only removing max one. Hence maxHeap make sense here.
        for (int i = k; i < points.length; i++) {
            if (points[i].distFromOrigin() < queue.peek().distFromOrigin()) {
                queue.poll();
                queue.add(points[i]);
            }
        }
        //Above will keep adding smaller found and replace it will largest in the heap, finally we will have kth smaller elements.
        // and if we keep removing all elements one by one, the last one is the smallest/ closest to the origin.
        for (int i = 0; i < k; i++) result.add(queue.poll());
        return result;
    }

    public static int minimumCostToConnectRopes(int[] ropeLengths) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < ropeLengths.length; i++) queue.add(ropeLengths[i]);
        int res = 0;
        while (queue.size() > 1) {
            int sum = queue.poll() + queue.poll();
            res += sum;
            queue.add(sum);
        }
        return res;
    }

    public static List<Integer> findTopKFrequentNumbersHeap(int[] nums, int k) {
        List<Integer> topNumbers = new ArrayList<>(k);
        Map<Integer, Integer> map = new HashMap<>();

        // All all frequencies into the map
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);

        }
        //Create a min map value heap. // NOTE minHeap Type <Map.Entry<Integer,Integer>>
        Queue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

        //Add k elements in the minHeap and if more than k remove it and replace the top. NOTE: "map.entrySet()"
        for (Map.Entry<Integer, Integer> curr : map.entrySet()) {        //O(n) + log(k) instead of O(n) log(n) if poll is not used in this iteration
            minHeap.add(curr);
            if (minHeap.size() > k) minHeap.poll();
        }

        //Remove all elements from PQ and add it to the result list.
        while (minHeap.size() > 0) {
            topNumbers.add(minHeap.poll().getKey());
        }
        return topNumbers;
    }
    public static List<Integer> findTopKFrequentNumbersBucket(int[] nums, int k) {          // O(n)
        List<Integer> topNumbers = new ArrayList<>(k);
        Map<Integer, Integer> map = new HashMap<>();

        // All all frequencies into the map
        for (int num : nums) {                                            //O(n)
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] bucket = new ArrayList [nums.length+1];         // This is Array of lists.
        int max = Integer.MAX_VALUE;        // max integer value is = 21 * 10 ^8 |  max k size should be equal to size of the int[]. And given that k <10^7.
                                                                    // So we should be able to create a bucket with max of int. Which will hold max k 10 ^ 8
        for(int num : map.keySet()){                                  //O(n)
            int freq = map.get(num);
            if(bucket[freq]==null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(num);
        }
        for (int i = bucket.length-1; i >=0 ; i--) {                //O(k)
            if(bucket[i]!=null){
                for (int  num : bucket[i]) {
                    topNumbers.add(num);
                    if(topNumbers.size()==k) break;
                }
            }
        }
        return topNumbers;

    }

    public static String sortCharacterByFrequency(String str) {
        Map<Character, Integer> map = new HashMap<>();

        //Note: How to create PR of Map entry . based one descending frequency values
        Queue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        //Note: how to iterate over string as char Array
        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        //For loop for Map Entry  - map.entrySet()
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            queue.add(entry);
        }
        StringBuilder sb = new StringBuilder();

        // As there can be duplicates while appending back check frequency of each character.
        while (!queue.isEmpty()) {
            Map.Entry<Character, Integer> entry = queue.poll();
            int size = entry.getValue();            // getValue()
            while (size > 0) {
                size--;
                sb.append(entry.getKey());          //getKey()
            }
        }
        return sb.toString();
    }

    public static int add(int num) {
        queue1.add(num);
        while (queue1.size() > k1) queue1.poll();
        return queue1.peek();
    }

    public static List<Integer> findClosestElements(int[] arr, int K, Integer X) {
        List<Integer> result = new ArrayList<>();
        // TODO: Write your code here
        if (arr.length <= K) return Arrays.stream(arr).boxed().collect(Collectors.toList());
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> Math.abs(b - X) - Math.abs(a - X));
        for (int i = 0; i < K; i++) {
            queue.add(arr[i]);
        }
        for (int i = K; i < arr.length; i++) {
            if (Math.abs(arr[i] - X) < Math.abs(queue.peek() - X)) {
                queue.poll();
                queue.add(arr[i]);
            }
        }
        Queue<Integer> order = new PriorityQueue<>();
        while (!queue.isEmpty()) order.add(queue.poll());
        while (!order.isEmpty()) result.add(order.poll());
        return result;
    }

    public static int maxDistinctNum(int arr[], int n, int k) {
        //We need to maximize the distinct no.
        //lets say there are few number which are repeating.
        // with k times delete, we can take into account all number more than frequency =1
        Map<Integer, Integer> map = new HashMap<>();

        // Build frequency map
        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        int result = 0;
        // Min-heap | build min heap having less frequent no at top
        // we are going to play with only count so no need to have pa of map.entry. only value (integer) should do.
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();      // This is only counts.

        // Add all number with freq=1 to result and push others to minHeap
        for (Map.Entry<Integer, Integer> p : map.entrySet()) {       //map.entrySet()
            if (p.getValue() == 1)                  //if value ==1, we have distinct no found.
                ++result;
            else
                minHeap.add(p.getValue());  // if not add to min heap
        }
        // Perform k operations | check till k is greater than 0
        while (k != 0 && !minHeap.isEmpty()) {
            // Pop the top() element
            Integer t = minHeap.poll();
            // Increment Result
            if (t == 1) {       // once we decrement k with t, t will be 1 next time, check if its 1 then add to result count
                ++result;
            } else {            // Reduce t and k | Push it again
                --t;
                --k;
                minHeap.add(t);     //after decrementing t add it back to queue, could be 1 or more than 1.
            }
        }
        return result;
    }

    public static int findSumOfElements(int[] nums, int k1, int k2) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) queue.add(num);     //n log n
        int sum = 0;
        for (int i = 0; i < k1; i++) queue.poll();
        for (int i = 0; i < k2 - k1 - 1; i++) sum += queue.poll();
        return sum;
    }

    public static String reorganizeString(String S) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : S.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Character> pq = new PriorityQueue<>((o1, o2) -> map.get(o2) - map.get(o1));
        pq.addAll(map.keySet());

        StringBuilder sb = new StringBuilder();
        while (pq.size() > 1) {
            char first = pq.poll();
            char second = pq.poll();

            sb.append(first).append(second);

            map.put(first, map.get(first) - 1);
            map.put(second, map.get(second) - 1);

            if (map.get(first) > 0) pq.offer(first);
            if (map.get(second) > 0) pq.offer(second);

            if (map.get(first) == 0) map.remove(first);
            if (map.get(second) == 0) map.remove(second);
        }

        if (!pq.isEmpty()) {
            char lastChar = pq.poll();
            if (map.get(lastChar) > 1) return "";
            sb.append(lastChar);
        }

        return sb.toString();
    }

    public static String reorganizeString2(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        //max heap
        Queue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        StringBuilder res = new StringBuilder();
        queue.addAll(map.entrySet());
        Map.Entry<Character, Integer> prev = null;
        while (!queue.isEmpty()) {
            Map.Entry<Character, Integer> curr = queue.poll();
            if (prev != null && prev.getValue() > 0) queue.add(prev);
            res.append(curr.getKey());
            curr.setValue(curr.getValue() - 1);
            prev = curr;
        }
        if (res.length() != str.length()) return "";
        return res.toString();
    }

    /*
            1. Create arr of frequency of chars , take char from s, and  negate 'a' to check the difference from char 'a'
            2. loop over arr, and find the char and index of that char of most frequent
            3. Create a new new result array -> and use most frequency index and char to put it in even locations.
             if most frequency is less that half size of string then above step is possible otherwise return blank
            4. once most frequent one is taken care, then repeat for all elements from array for loop. and out
                user prev index position, if its equal or greater than length of S, reset it to odd location 1.
                increment same index +2 time.
     */
    public static String reorganizeString3(String S) {
        //store the frequency in int array
        int[] arr = new int[26];

        for (char c : S.toCharArray()) {
            arr[c - 'a']++;
        }
        //System.out.println(Arrays.toString(arr));
        //find max character
        int max = 0;
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                index = i;
            }
        }
        //System.out.println("Max =" + max + " at index = " + index);

        //check if most frequent is more than half size of the input, meaning we cant reorganize
        if (max > (S.length() + 1) / 2) return "";

        //Create new array of same as input length and put most frequent at even location
        char[] result = new char[S.length()];
        int idx = 0;
        while (arr[index] > 0) {       //iterate over all frequency array with index of most occurring char. while its>0
            result[idx] = (char) (index + 'a');
            idx += 2;                         // set it to even location
            arr[index]--;                   // decrement the frequency
        }
        //for all characters in arr do same, handle boundary condition when idx goes greater or equal to result.length
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] > 0) {
                if (idx >= result.length) {               ///   N I K I I L ->  I _ I _ I _ we will always have remaining position to fill
                    idx = 1;
                }
                result[idx] = (char) (i + 'a');
                idx += 2;
                arr[i]--;
            }
        }
        return String.valueOf(result);
    }

    public static String reorganizeStringKDistanceApart(String str, int k) {
        if (k == 0) return str;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        Queue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        queue.addAll(map.entrySet());
        StringBuilder res = new StringBuilder();
        Queue<Map.Entry<Character, Integer>> kQueue = new LinkedList<>();
        while (!queue.isEmpty()) {
            Map.Entry<Character, Integer> curr = queue.poll();      //remove , append, decrease count, add to K queue, don't
            res.append(curr.getKey());
            curr.setValue(curr.getValue() - 1);

            kQueue.add(curr);           // Add it to another LinkedList Queue. in same order. keep adding till size becomes K

            if (kQueue.size() == k) {   //when size is k then only add back that one entry which was added 1st. FIFO to the original PQ
                Map.Entry<Character, Integer> temp = kQueue.poll();
                if (temp.getValue() > 0) queue.add(temp);
            }
        }
        if (res.length() != str.length()) return "";
        return res.toString();
    }

    // Idea of PQ + QUEUE to keep track of size of K size.
    // After CPU runs for k/n cycle, it can do a particular job, or next job or can be idea. And after those k cycle only we can re-use the same task
    public static int scheduleTasksKDistanceApart(char[] tasks, int k) {
        Map<Character, Integer> map = new HashMap<>();
        for (char task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        int count = 0;
        int res = 0;

        // In final answer we don't need to show task, but just count that final CPU count.
        // That is also one reason we don't need PQ of map.
        //PQ of frequency as max Heap. E.g. Char c occurred 5 no of time. Max heap of Frequency.
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        //Queue to keep track of k distance apart task.
        Queue<Integer> buffer = new LinkedList<>();
        pq.addAll(map.values());     //Adding only values as it's PQ of Integer frequencies
        // NOTE: not map.getValues() !! its map.values()

        //Challenge is to write this while condition.
        while (count != map.size()) {   // till we cover all task. we cant use while PQ not empty as we are adding idea time. So size is diff for that.
            if (pq.isEmpty()) pq.add(Integer.MAX_VALUE);        //acts as idea time.

            int mostFrequentTask = pq.poll();       //remove
            mostFrequentTask--;                         //decrease frequency
            if (mostFrequentTask == 0) count++;     //Count incremented only when task frq reaches 0
            buffer.add(mostFrequentTask);          // add to k buffer

            res++;                                              //increment final answer

            if (buffer.size() == k + 1) pq.add(buffer.poll());    //if buffer size == k, add back queued item to PQ
        }
        return res;
    }

    // After CPU runs for k/n cycle, it can do a particular job, or next job or can be idea. And after those k cycle only we can re-use the same task
    public static int scheduleTasksKDistanceApart2(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0)
            return -1;
        //build map to sum the amount of each task
        Map<Character, Integer> map = new HashMap<>();
        for (char t : tasks) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        //PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.addAll(map.values());

        int count = 0;

        while (!pq.isEmpty()) {
            int k = n + 1;
            Queue<Integer> kBuffer = new LinkedList<>();
            while (k > 0 && !pq.isEmpty()) {
                Integer top = pq.poll(); // most frequency task
                top--; // decrease frequency, meaning it got executed
                kBuffer.offer(top); // collect task to add back to queue
                k--;
                count++; //successfully executed task
            }

            while (kBuffer.size() > 0) {
                Integer recentlyAddedTask = kBuffer.poll();
                if (recentlyAddedTask > 0) pq.offer(recentlyAddedTask);
            }

            if (pq.isEmpty()) break;

            count = count + k; // if k > 0, then it means we need to be idle
        }
        return count;
    }

    public static int scheduleTasksKDistanceApart3(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0)
            return -1;
        //build map to sum the amount of each task
        Map<Character, Integer> map = new HashMap<>();
        for (char t : tasks) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        pq.addAll(map.values());

        Queue<Integer> kBuffer = new LinkedList<>();
        int cycles = 0;

        while (!pq.isEmpty()) {
            for (int cycleCount = 0; cycleCount < n + 1; cycleCount++) {            // n + 1 no of cycles, as its inclusive
                if (!pq.isEmpty()) {
                    int mostFrequentTask = pq.poll();
                    mostFrequentTask--;
                    kBuffer.offer(mostFrequentTask);
                }
            }
            //add back all those task which were executed back to queue for further processing to match the non adjacent condition
            int executed = kBuffer.size();
            while (!kBuffer.isEmpty()) {
                int recentlyExecutedTask = kBuffer.poll();
                if (recentlyExecutedTask > 0) pq.offer(recentlyExecutedTask);
            }

            // How many no of times we executed the task ? buffer size  otherwise, n+1
            //now we executed task executed times, executed size times.
            // for last time, pq would be empty then we executed it for executed No of times
            // otherwise we need to add cool off period given as n+1

            // while adding back to PQ if task frequency is exhausted, meaning reached 0, and pq remains empty.
            // we know that at that iteration we executed task as buffer size. Otherwise, we just need to add cool off period.
            cycles += pq.isEmpty() ? executed : n + 1;
            // consider we have 4 slots _ _ _ _ and two task x=1 and y=1 before that we executed many tasks already.
            // for for i=0 to 4, we will execute x and y and wont add back to pq and now its count is zero.
            // this time no of cycles wont be complete 4, we only processed 2 task. which is exact size of Buffer queue.
            // Hence cycle += bufferSize when pq is empty otherwise its normal n+1 which is our slot size or cool off period size.
        }
        return cycles;
    }

    static Map<Integer, Integer> map = null;
    static Queue<Element> pq = null;
    static int seq = 0;
    public static boolean initializeFreqStack() {
        map = new HashMap<>();
        pq = new PriorityQueue<>(
                (a, b) -> a.freq == b.freq
                        ? b.seq - a.seq
                        : b.freq - a.freq);
        return true;    // just for code purpose.
    }
    public static boolean  push(int val) {
        map.put(val, map.getOrDefault(val, 0) + 1);
        pq.offer(new Element(val, map.get(val), seq++));
        return true;
    }

    public static int pop() {
        if (!pq.isEmpty()) {
            Element e = pq.poll();
            if (map.get(e.num) > 1) {
                map.put(e.num, map.get(e.num) - 1);
            }
            return e.num;
        }
        return 0;
    }
    public static void main(String[] args) {
        Point[] points = new Point[]{new Point(1, 3), new Point(3, 4), new Point(2, -1), new Point(4, 1), new Point(2, 3), new Point(-1, 1)};
        List<Point> result = M_TopKElements.findKClosestPoints(points, 2);
        System.out.print("Here are the k points closest the origin: ");
        for (Point p : result)
            System.out.print("[" + p.x + " , " + p.y + "] ");
    }
}


