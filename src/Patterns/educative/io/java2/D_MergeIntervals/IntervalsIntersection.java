package Patterns.educative.io.java2.D_MergeIntervals;

import java.util.*;

class Interval2 {
    int start;
    int end;

    public Interval2(int start, int end) {
        this.start = start;
        this.end = end;
    }
};

class IntervalsIntersection {

    public static Interval1[] merge(Interval1[] arr1, Interval1[] arr2) {
        List<Interval1> intervalsIntersection = new ArrayList<Interval1>();
        // TODO: Write your code here
        int i = 0, j = 0;
        while (i < arr1.length && j < arr2.length) {
            if ((arr1[i].start <= arr2[j].start && arr2[j].start <= arr1[i].end) ||
                (arr2[j].start <= arr1[i].start && arr1[i].start <= arr2[j].end)) {
                intervalsIntersection.add(new Interval1(Math.max(arr1[i].start, arr2[j].start), Math.min(arr1[i].end, arr2[j].end)));
            }
            if (arr1[i].end < arr2[j].end) i++;
            else j++;
        }
        return intervalsIntersection.toArray(new Interval1[intervalsIntersection.size()]);
    }

    public static void main(String[] args) {
        Interval1[] input1 = new Interval1[] { new Interval1(1, 3), new Interval1(5, 6), new Interval1(7, 9) };
        Interval1[] input2 = new Interval1[] { new Interval1(2, 3), new Interval1(5, 7) };
        Interval1[] result = IntervalsIntersection.merge(input1, input2);
        System.out.print("Intervals Intersection: ");
        for (Interval1 interval1 : result)
            System.out.print("[" + interval1.start + "," + interval1.end + "] ");
        System.out.println();

        input1 = new Interval1[] { new Interval1(1, 3), new Interval1(5, 7), new Interval1(9, 12) };
        input2 = new Interval1[] { new Interval1(5, 10) };
        result = IntervalsIntersection.merge(input1, input2);
        System.out.print("Intervals Intersection: ");
        for (Interval1 interval1 : result)
            System.out.print("[" + interval1.start + "," + interval1.end + "] ");
    }
}
