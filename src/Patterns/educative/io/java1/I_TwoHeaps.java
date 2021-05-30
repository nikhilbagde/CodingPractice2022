package Patterns.educative.io.java1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class I_TwoHeaps {
    List<Integer> list = new ArrayList<>();
    public void MedianOfAStream() {
        list = new ArrayList<>();
    }
    public void insertNum(int num) {
        // TODO: Write your code here
        list.add(num);
        Collections.sort(list);     //n log n
    }
    public double findMedian() {
        // TODO: Write your code here
        int size = list.size();
        if (size % 2 == 1) return (double) list.get(size/2);
        else return (double) (list.get(size/2) + list.get(size/2-1))/2;
    }

    //---
    static PriorityQueue<Integer> lowerHalf;
    static PriorityQueue<Integer> upperHalf;

    /** initialize your data structure here. */
    public static void medianFinder2() {
        lowerHalf = new PriorityQueue<>((a, b) -> b - a);
        upperHalf = new PriorityQueue<>();
    }

    public static void addNum2(int num) {
        lowerHalf.offer(num);       // log n                // maxHeap - add element to max heap
        upperHalf.offer(lowerHalf.poll());      //log n -  remove top element from max heap  and add it to min heap ( upperHalf)
        if (lowerHalf.size() < upperHalf.size()) {
            lowerHalf.offer(upperHalf.poll());      //2 log in
        }
    }

    public static double findMedian2() {
        if (upperHalf.size() == lowerHalf.size()) {
            return (upperHalf.peek() + lowerHalf.peek()) / 2.0;
        } else {
            return lowerHalf.peek() * 1.0;
        }
    }

    public static void main(String[] args) {
        I_TwoHeaps medianOfAStream = new I_TwoHeaps();
        medianOfAStream.insertNum(3);
        medianOfAStream.insertNum(1);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(5);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(4);
        System.out.println("The median is: " + medianOfAStream.findMedian());

        I_TwoHeaps medianOfAStream2 = new I_TwoHeaps();
        medianOfAStream2.medianFinder2();
        medianOfAStream.addNum2(3);
        medianOfAStream.addNum2(1);
        System.out.println("The median is: " + medianOfAStream.findMedian2());
        medianOfAStream.addNum2(5);
        System.out.println("The median is: " + medianOfAStream.findMedian2());
        medianOfAStream.addNum2(4);
        System.out.println("The median is: " + medianOfAStream.findMedian2());
    }
}
