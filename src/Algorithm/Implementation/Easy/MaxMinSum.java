package Algorithm.Implementation.Easy;

/**
 * Created by Nikhi on 12/8/2016 1:19 AM.
 */
public class MaxMinSum {
    public static void main(String[] args) {
        java.util.Scanner in = new java.util.Scanner(System.in);
        long a = in.nextLong();
        long b = in.nextLong();
        long c = in.nextLong();
        long d = in.nextLong();
        long e = in.nextLong();
        java.util.List<Long> list = new java.util.ArrayList<Long>();
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);list.add(e);
        java.util.Collections.sort(list);
        long min = -1, max =-1;
        for (int i = 0; i < list.size(); i++) {
            max += i==0? 0: list.get(i);
            min += i == list.size()-1 ? 0 : list.get(i);
        }
    }
}
