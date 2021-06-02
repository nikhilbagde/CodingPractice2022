package Patterns.educative.io.java2.M_TopKElements;

import java.util.*;

class Point {
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

class KClosestPointsToOrigin {

    public static List<Point> findClosestPoints(Point[] points, int k) {
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
        Queue<Point> queue = new PriorityQueue<>((a,b) -> b.distFromOrigin()-a.distFromOrigin());
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

    public static void main(String[] args) {
        Point[] points = new Point[] { new Point(1, 3), new Point(3, 4), new Point(2, -1), new Point(4,1) , new Point(2,3), new Point(-1,1)  };
        List<Point> result = KClosestPointsToOrigin.findClosestPoints(points, 2);
        System.out.print("Here are the k points closest the origin: ");
        for (Point p : result)
            System.out.print("[" + p.x + " , " + p.y + "] ");
    }
}
