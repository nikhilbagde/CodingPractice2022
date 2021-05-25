package Patterns.educative.io.java2.D_MergeIntervals;

import java.util.*;

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
};

class ConflictingAppointments {

    public static boolean canAttendAllAppointments(Interval1[] interval1s) {
        // TODO: Write your code here
        Arrays.sort(interval1s, (a, b) -> {return a.start == b.start ? a.end-b.end : a.start-b.start;});
        for (int i = 0; i < interval1s.length-1; i++) {
            if (interval1s[i].end > interval1s[i+1].start) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Interval1[] interval1s = { new Interval1(1, 4), new Interval1(2, 5), new Interval1(7, 9) };
        boolean result = ConflictingAppointments.canAttendAllAppointments(interval1s);
        System.out.println("Can attend all appointments: " + result);

        Interval1[] intervals1 = { new Interval1(6, 7), new Interval1(2, 4), new Interval1(8, 12) };
        result = ConflictingAppointments.canAttendAllAppointments(intervals1);
        System.out.println("Can attend all appointments: " + result);

        Interval1[] intervals2 = { new Interval1(4, 5), new Interval1(2, 3), new Interval1(3, 6) };
        result = ConflictingAppointments.canAttendAllAppointments(intervals2);
        System.out.println("Can attend all appointments: " + result);
    }
}
