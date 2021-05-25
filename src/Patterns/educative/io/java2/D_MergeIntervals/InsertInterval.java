package Patterns.educative.io.java2.D_MergeIntervals;

import java.util.*;

class Interval1 {
    int start;
    int end;

    public Interval1(int start, int end) {
        this.start = start;
        this.end = end;
    }
};

class InsertInterval {

    public static List<Interval1> insert(List<Interval1> interval1s, Interval1 newInterval1) {
        List<Interval1> mergedInterval1s = new ArrayList<>();
        //TODO: Write your code here
        interval1s.add(newInterval1);
        Collections.sort(interval1s, (a, b) -> {return a.start == b.start ? a.end-b.end : a.start-b.start;});
        int left = interval1s.get(0).start, right = interval1s.get(0).end;
        for (Interval1 i: interval1s) {
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
        input.add(new Interval1(1, 3));
        input.add(new Interval1(5, 7));
        input.add(new Interval1(8, 12));
        System.out.print("Intervals after inserting the new interval: ");
        for (Interval1 interval1 : InsertInterval.insert(input, new Interval1(4, 6)))
            System.out.print("[" + interval1.start + "," + interval1.end + "] ");
        System.out.println();

        input = new ArrayList<Interval1>();
        input.add(new Interval1(1, 3));
        input.add(new Interval1(5, 7));
        input.add(new Interval1(8, 12));
        System.out.print("Intervals after inserting the new interval: ");
        for (Interval1 interval1 : InsertInterval.insert(input, new Interval1(4, 10)))
            System.out.print("[" + interval1.start + "," + interval1.end + "] ");
        System.out.println();

        input = new ArrayList<Interval1>();
        input.add(new Interval1(2, 3));
        input.add(new Interval1(5, 7));
        System.out.print("Intervals after inserting the new interval: ");
        for (Interval1 interval1 : InsertInterval.insert(input, new Interval1(1, 4)))
            System.out.print("[" + interval1.start + "," + interval1.end + "] ");
        System.out.println();
    }
}
