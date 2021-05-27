package Patterns.educative.io.java2.D_MergeIntervals;

import java.util.*;

class Interval3 {
    int start;
    int end;

    public Interval3(int start, int end) {
        this.start = start;
        this.end = end;
    }
};

class MergeIntervals {

    public static List<Interval1> merge(List<Interval1> intervals) {
        List<Interval1> mergedInterval1s = new LinkedList<>();
        if (intervals.size() <= 1) return intervals;
        Collections.sort(intervals, (a, b) -> {return a.start == b.start ? a.end-b.end : a.start-b.start;});
        int left = intervals.get(0).start, right = intervals.get(0).end;
        for (Interval1 i: intervals) {
            if (i.start > right) {
                mergedInterval1s.add(new Interval1(left, right));
                left = i.start;
                right = i.end;
            } else right = Math.max(right, i.end);
        }
        mergedInterval1s.add(new Interval1(left, right));
        return mergedInterval1s;
    }

    public static void main(String[] args) {
        List<Interval1> input = new ArrayList<Interval1>();
        input.add(new Interval1(1, 4));
        input.add(new Interval1(2, 5));
        input.add(new Interval1(7, 9));
        System.out.print("Merged intervals: ");
        for (Interval1 interval1 : MergeIntervals.merge(input))
            System.out.print("[" + interval1.start + "," + interval1.end + "] ");
        System.out.println();

        input = new ArrayList<Interval1>();
        input.add(new Interval1(6, 7));
        input.add(new Interval1(2, 4));
        input.add(new Interval1(5, 9));
        System.out.print("Merged intervals: ");
        for (Interval1 interval1 : MergeIntervals.merge(input))
            System.out.print("[" + interval1.start + "," + interval1.end + "] ");
        System.out.println();

        input = new ArrayList<Interval1>();
        input.add(new Interval1(1, 4));
        input.add(new Interval1(2, 6));
        input.add(new Interval1(3, 5));
        System.out.print("Merged intervals: ");
        for (Interval1 interval1 : MergeIntervals.merge(input))
            System.out.print("[" + interval1.start + "," + interval1.end + "] ");
        System.out.println();
    }
}