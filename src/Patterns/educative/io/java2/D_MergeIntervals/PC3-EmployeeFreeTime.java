package Patterns.educative.io.java2.D_MergeIntervals;

import java.util.*;

class Interval4 {
    int start;
    int end;

    public Interval4(int start, int end) {
        this.start = start;
        this.end = end;
    }
};

class EmployeeFreeTime {

    public static List<Interval1> findEmployeeFreeTime(List<List<Interval1>> schedule) {
        List<Interval1> result = new ArrayList<>();
        // TODO: Write your code here
        if (schedule.size() == 0) return result;
        List<int[]> time = new ArrayList<>();
        for (List<Interval1> interval1 : schedule) {
            for (Interval1 i: interval1) {
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
                result.add(new Interval1(freeTime, i[0]));
                free = false;
            }
            if (queue.peek() == 0) {
                freeTime = i[0];
                free = true;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        List<List<Interval1>> input = new ArrayList<>();
        input.add(new ArrayList<Interval1>(Arrays.asList(new Interval1(1, 3), new Interval1(5, 6))));
        input.add(new ArrayList<Interval1>(Arrays.asList(new Interval1(2, 3), new Interval1(6, 8))));
        List<Interval1> result = EmployeeFreeTime.findEmployeeFreeTime(input);
        System.out.print("Free intervals: ");
        for (Interval1 interval1 : result)
            System.out.print("[" + interval1.start + ", " + interval1.end + "] ");
        System.out.println();

        input = new ArrayList<>();
        input.add(new ArrayList<Interval1>(Arrays.asList(new Interval1(1, 3), new Interval1(9, 12))));
        input.add(new ArrayList<Interval1>(Arrays.asList(new Interval1(2, 4))));
        input.add(new ArrayList<Interval1>(Arrays.asList(new Interval1(6, 8))));
        result = EmployeeFreeTime.findEmployeeFreeTime(input);
        System.out.print("Free intervals: ");
        for (Interval1 interval1 : result)
            System.out.print("[" + interval1.start + ", " + interval1.end + "] ");
        System.out.println();

        input = new ArrayList<>();
        input.add(new ArrayList<Interval1>(Arrays.asList(new Interval1(1, 3))));
        input.add(new ArrayList<Interval1>(Arrays.asList(new Interval1(2, 4))));
        input.add(new ArrayList<Interval1>(Arrays.asList(new Interval1(3, 5), new Interval1(7, 9))));
        result = EmployeeFreeTime.findEmployeeFreeTime(input);
        System.out.print("Free intervals: ");
        for (Interval1 interval1 : result)
            System.out.print("[" + interval1.start + ", " + interval1.end + "] ");
    }
}
