package Patterns.educative.io.java1;

import java.util.*;

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "Interval{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
class Job {
    int start;
    int end;
    int cpuLoad;

    public Job(int start, int end, int cpuLoad) {
        this.start = start;
        this.end = end;
        this.cpuLoad = cpuLoad;
    }
}
public class D_MergeIntervals {
    public static List<Interval> mergeIntervals(List<Interval> intervalList) {
        List<Interval> mergedIntervals = new LinkedList<>();
        if (intervalList.size() <= 1) return intervalList;
        //Collections.sort(intervalList, (a, b) -> {return a.start == b.start ? a.end-b.end : a.start-b.start;});
        intervalList.sort((a,b) -> a.start==b.start? a.end-b.end: a.start-b.start);
        int left = intervalList.get(0).start, right = intervalList.get(0).end;
        for (Interval i: intervalList) { //INPUT: [[1,3],[2,6],[8,10],[15,18]] OUTPUT: [[1,6],[8,10],[15,18]]
            if (i.start > right) {
                mergedIntervals.add(new Interval(left, right));
                left = i.start;
                right = i.end;
            } else right = Math.max(right, i.end);
        }
        mergedIntervals.add(new Interval(left, right));
        return mergedIntervals;
    }

    public static List<Interval> insertInterval(List<Interval> intervalList, Interval newInterval) {
        List<Interval> mergedInterval1s = new ArrayList<>();
        intervalList.add(newInterval);          //Just add this line
        //Collections.sort(intervalList, (a, b) -> {return a.start == b.start ? a.end-b.end : a.start-b.start;});
        intervalList.sort((a,b) -> a.start==b.start? a.end-b.end: a.start-b.start);
        int left = intervalList.get(0).start, right = intervalList.get(0).end;
        for (Interval i: intervalList) {
            if (i.start > right) {
                mergedInterval1s.add(new Interval(left, right));
                left = i.start;
                right = i.end;
            } else right = Math.max(right, i.end);
        }
        mergedInterval1s.add(new Interval(left, right));
        return mergedInterval1s;
    }
    public static Interval[] intervalIntersection(Interval[] arr1, Interval[] arr2) {
        List<Interval> intervalsIntersection = new ArrayList<>();
        int i = 0, j = 0;
        while (i < arr1.length && j < arr2.length) {
            if ((arr1[i].start <= arr2[j].start && arr2[j].start <= arr1[i].end) ||             //arr2 [j].start  is between arr1[i].start and arr1[i].end
                    (arr2[j].start <= arr1[i].start && arr1[i].start <= arr2[j].end)) {         //arr1 [i].start  is between arr2[i].start and arr2[i].end
                intervalsIntersection.add(new Interval(Math.max(arr1[i].start, arr2[j].start), Math.min(arr1[i].end, arr2[j].end)));    //take max of start and min of end
            }
            if (arr1[i].end < arr2[j].end) i++;
            else j++;
        }
        return intervalsIntersection.toArray(new Interval[intervalsIntersection.size()]);
    }
    public static boolean canAttendMeetings(Interval[] intervals) {
        //Arrays.sort(intervals, (a, b) -> a.start - b.start); same as below
        Arrays.sort(intervals, Comparator.comparingInt(a -> a.start));
        for(int i = 0; i + 1 < intervals.length; i++){      // notice i+1< interval.length
            if(intervals[i].end > intervals[i + 1].start){
                return false;
            }
        }
        return true;
    }
    public static boolean canAttendAllAppointments(Interval[] intervals) {
        Arrays.sort(intervals, (a, b) -> a.start == b.start ? a.end-b.end : a.start-b.start);
        for (int i = 0; i < intervals.length-1; i++) {
            if (intervals[i].end > intervals[i+1].start) return false;
        }
        return true;
    }
    public static int findMinimumMeetingRooms1(List<Interval> intervalList) {
        if (intervalList.size() <= 1) return intervalList.size();

        int max = 1;
        //Collections.sort(intervalList, (a, b) -> {return a.start == b.start ? a.end-b.end : a.start-b.start;});
        intervalList.sort((a,b) -> a.start==b.start? a.end-b.end: a.start-b.start);

        /*
            Heap First sort all the time intervals according to the starting time, and then create a new minimum heap.
            Start traversing the time interval.
                If the heap is not empty and the first element is less than or equal to the start time of the current interval,
            remove the first element from the heap and push the end time of the current interval into the heap.
            Since the smallest heap is at the front, if the first element is less than or equal to the start time,
            it means that the previous meeting has ended and the meeting room can be used to start the next meeting,
            so there is no need to allocate a new meeting room. After the traversal is completed, the heap The number of elements is the number of meeting rooms needed.
         */
        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(intervalList.get(0).end);
        for (int i = 1; i < intervalList.size()-1; i++) {
            if (intervalList.get(i).start < queue.peek()) {
                queue.add(intervalList.get(i).end);
                max = Math.max(max, queue.size());
                continue;
            }
            queue.add(intervalList.get(i).end);
            while (intervalList.get(i).start >= queue.peek()) queue.poll();
        }

        return max;
    }
    public static int findMinimumMeetingRooms2(Interval[] intervals) {

        if(intervals == null || intervals.length == 0) {
            return 0;
        }
        // Sort the intervals by start time
        Arrays.sort(intervals, (i1, i2) -> i1.start - i2.start);

        // to store end time of each meeting, smaller value will be at the peek()
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        // start with the first meeting, put it to a meeting room
        int count = 1;
        heap.offer(intervals[0].end);

        for(int i = 1; i < intervals.length; i++){
            if(intervals[i].start < heap.peek()) {
                count++; // conflict, need 1 more room
            } else {
                // if the current meeting starts right after
                // there's no need for a new room, merge the interval
                heap.poll();
            }
            heap.offer(intervals[i].end); // poll then offer, conceptually merging 2 intervals
        }
        return count;
    }
    public static int findMinimumMeetingRooms3(Interval[] intervals) {
        TreeMap<Integer, Integer> m = new TreeMap<>();

        for (Interval each: intervals) {
            int start = each.start;
            int end = each.end;
            m.put(start, 1 + m.getOrDefault(start, 0));
            m.put(end, m.getOrDefault(end, 0) - 1);
        }

        int active = 0;
        int result = 0;

        // If a time is the end time of one meeting and the start time of another meeting,
        // the mapping value is decreased first and then increased and remains at 0, no new room is allocated
        for (int v: m.values()) {
            active += v;
            result = Math.max(result, active);
        }
        return result;
    }

    public static int findMinimumMeetingRooms4(Interval[] intervals) {

        if(intervals==null || intervals.length<=1) return 1;

        /*
         we need to find total numbers of meeting room
         e.g. [0,30], [5,10], [15,20]
          first we need to sort meeting based on start time, so that we can have a ordered sequence to decide.

          Now once its sorted on start time, we know which meeting starts earliest. We need to start from there.
          next we can check, end time, in the sense that we need to find out minimum end time interval till now,
          so that we can compare all next interval with it, as
            if current interval start time is GREATER OR EQUAL to interval  previously min end time captured,
                    then which means there is no overlap, hence we can assume that this meeting can take place in same room
                    and we just need to merge and change the ending time of interval from min captured to current end time.
            for else case, meaning current start is less that min previous end time, there is a overlap,
                    meaning we will have to arrange new meeting room, hence simply add it to min heap.

             whatever min interval we had removed from min Heap we need to add it back to the heap to compare
             remaining intervals.

             This is how we are having meeting sorted with start time,
             and using Priority queue meetings stored in min end time at top.
                comparing both we need to take decision.

            PQ will always keep interval which has minimum end time, which ends earliest.
            we need to take advantage of it to compare and decide for remaining intervals.
         */
        Arrays.sort(intervals, (a,b) -> a.start-b.start);

        PriorityQueue<Interval> pq = new PriorityQueue<>( (a,b) -> b.end-a.end);
        pq.offer(intervals[0]);

        //we are going to iterate over all intervals one by one starting from 2nd element (1st index)
        for (int i = 1; i < intervals.length ; i++) {
            Interval current  = intervals[i];
            Interval previous = pq.poll();      // remove it for comparison only

            if(current.start >= previous.end){       //no overlap, merge the intervals      | GREATER THAN EQUAL TO meting end at 2.00 pm we can start next meeting at 2.00pm
                previous.end = current.end;
            } else {
                pq.offer(current);
            }

            //adding removed interval back to queue
            pq.offer(previous);
        }
        return pq.size();       //as we are merging and adding. finally intervals
                                        // which we couldn't add and could add, makes
                                        // no of minimum meeting rooms required.
    }

    /**
     *  LINE SWEEPING ALGORITHM
     * Step 1) First we need to create a timeline in the system.
     * The timeline will be composed of two type of events - positive bandwidth (at start of interval) and negative bandwidth (at end of interval).
     * Each point on the time line will look like (time, bandwidth). For instance, you can break (1, 10, 2) as two intervals - (1, 2) & (10, -2)
     * Step 2) sort the points based on the time component.
     * Step 3) keep the count of the sum as you iterate through points.
     * The max sum will give you the max bandwidth requirement.
     *
     * INPUT:  CH1 [[1,30, 2],[31,60, 4],[61,120, 3],        CH2 * [1,20,2],[21,40,4],[41,60,5],[61,120,3],         CH3 * [1,60,4],[61,120,4]]
     * Time     1	 10   20  30  40  50  60  70   80 90  100  110   120
     * CH1      2    2    2    4     4    4    3    3    3    3     3     3
     * CH2      2    2    4    4     5    5    5    5    5    5     5     5
     * CH3      4    4    4    4     4    4    4    4    4    4     4     4
     * Sum(B) 8    8   10   12   13  13  12  12  12  12  12   12
     * @param jobs
     * @return
     */
    public static int findMaxCPUOrBandwidthLoad(List<Job> jobs) {
        List<int[]> data = new ArrayList<>();

        //Create a timeline. add and array [start, cpu] and array [end, -cpu] for each job.
        // when start and its bandwidth increased, and at end it decreases by same amount at given time.
        for (Job job: jobs) {
            data.add(new int[]{job.start, job.cpuLoad});
            data.add(new int[]{job.end, -job.cpuLoad});
        }
        //we can sort all start and end times. start to end
        Collections.sort(data, (a,b)-> {return a[0]-b[0];});

        //find max iterating over the array while keeping the accumulator.
        int max = 0;
        int curr = 0;
        for (int[] used: data) {
            curr += used[1];
            if (used[1] > 0){       //Need to add greater than zero check because of end it could be in negative. Only capture +ve max
                max = Math.max(max, curr);
            }
        }
        return max;
    }

    /**
     * Input: schedule = [[[1,2],[5,6]],[[1,3]],[[4,10]]]     *
     * Output: [[3,4]]     *
     * Explanation: There are a total of three employees, and all common free time intervals would be [-inf, 1], [3, 4], [10, inf].
     *
     * We discard any intervals that contain inf as they aren’t finite.     *
     * Example 2:     *
     * Input: schedule = [[[1,3],[6,7]],[[2,4]],[[2,5],[9,12]]]     *
     * Output: [[5,6],[7,9]]
     * @param schedule
     * @return
     */
    public static List<Interval> findEmployeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> result = new ArrayList<>();
        if (schedule.size() == 0) return result;

        List<int[]> time = new ArrayList<>();
        for (List<Interval> interval1 : schedule) {
            for (Interval i: interval1) {
                time.add(new int[]{i.start, -1});
                time.add(new int[]{i.end, 1});
            }
        }
        Collections.sort(time, (a,b)->{return a[0]==b[0] ? a[1]-b[1] : a[0]-b[0];});
        Queue<Integer> queue = new PriorityQueue<>();
        boolean free = false;
        int freeTime = 0;
        queue.add(0);
        for (int[] i: time) {
            if (i[1] == -1) queue.add(-1);
            else queue.remove(-1);
            if (free) {
                result.add(new Interval(freeTime, i[0]));
                free = false;
            }
            if (queue.peek() == 0) {
                freeTime = i[0];
                free = true;
            }
        }
        return result;
    }
    public static List<Interval> findEmployeeFreeTime2(List<List<Interval>> schedule) {
        List<Interval> flatSchedule = new ArrayList<>();
        for(List<Interval> intervals : schedule){
            flatSchedule.addAll(intervals);
        }
        flatSchedule.sort( (a,b) -> a.start==b.start? a.end-b.end : a.start-b.start);

        int prevLeft = flatSchedule.get(0).start;
        int prevRight = flatSchedule.get(0).end;

        List<Interval> mergedInterval = new ArrayList<>();
        for (int i = 1; i < flatSchedule.size() ; i++) {
            Interval current = flatSchedule.get(i);
            if(current.start > prevRight){  // no overlap
                mergedInterval.add( new Interval(prevLeft, prevRight));
                prevLeft = current.start;
                prevRight = current.end;
            } else { //overlap
                prevRight = Math.max(prevLeft, current.end);
            }
        }
        mergedInterval.add(new Interval(prevLeft, prevRight)); // for last element

        //now we have flattened, merged, non-overlapping interval list,
        if(mergedInterval.size()<=1) return Collections.emptyList();

        List<Interval> freeTimeList = new ArrayList<>();
        for (int i = 0; i < mergedInterval.size()-1; i++) {
            Interval nonIntersectingInterval
                    = new Interval(mergedInterval.get(i).end, mergedInterval.get(i+1).start);
            freeTimeList.add(nonIntersectingInterval);
        }
        return freeTimeList;
    }
    public static void main(String[] args) {
        List<Interval> input = new ArrayList<>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 5));
        input.add(new Interval(7, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval1 : D_MergeIntervals.mergeIntervals(input))
            System.out.print("[" + interval1.start + "," + interval1.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(6, 7));
        input.add(new Interval(2, 4));
        input.add(new Interval(5, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval1 : D_MergeIntervals.mergeIntervals(input))
            System.out.print("[" + interval1.start + "," + interval1.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 6));
        input.add(new Interval(3, 5));
        System.out.print("Merged intervals: ");
        for (Interval interval1 : D_MergeIntervals.mergeIntervals(input))
            System.out.print("[" + interval1.start + "," + interval1.end + "] ");
        System.out.println();
        
        //----------------------------------

        Interval[] input1 = new Interval[] { new Interval(1, 3), new Interval(5, 6), new Interval(7, 9) };
        Interval[] input2 = new Interval[] { new Interval(2, 3), new Interval(5, 7) };
        Interval[] result = D_MergeIntervals.intervalIntersection(input1, input2);
        System.out.print("Intervals Intersection: ");
        for (Interval interval1 : result)
            System.out.print("[" + interval1.start + "," + interval1.end + "] ");
        System.out.println();

        input1 = new Interval[] { new Interval(1, 3), new Interval(5, 7), new Interval(9, 12) };
        input2 = new Interval[] { new Interval(5, 10) };
        result = D_MergeIntervals.intervalIntersection(input1, input2);
        System.out.print("Intervals Intersection: ");
        for (Interval interval1 : result)
            System.out.print("[" + interval1.start + "," + interval1.end + "] ");
    }
}
