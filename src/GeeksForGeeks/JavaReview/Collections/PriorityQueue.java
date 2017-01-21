package GeeksForGeeks.JavaReview.Collections;

import java.util.Iterator;

/**
 * Created by Nikhil on 1/20/2017 6:01 AM.
 */
public class PriorityQueue {
    public static void main(String[] args) {
        java.util.PriorityQueue<Integer> namePQ = new java.util.PriorityQueue<>(((o1, o2) -> o1>o2?1:(o1<o2)?-1:0));
        //java.util.PriorityQueue<Integer> namePQ = new java.util.PriorityQueue<>(((o1, o2) -> o1>o2?1:(o1<o2)?-1:0));
        java.util.PriorityQueue<Integer> defaultOrdering = new java.util.PriorityQueue<>();
        java.util.PriorityQueue<Integer> asending = new java.util.PriorityQueue<>(((o1, o2) -> o1>o2?1:(o1<o2)?-1:0));
        java.util.PriorityQueue<Integer> desending = new java.util.PriorityQueue<>(((o1, o2) -> o1>o2?-1:(o1<o2)?1:0));
        defaultOrdering.add(5);
        defaultOrdering.add(4);
        defaultOrdering.add(2);
        defaultOrdering.add(1);
        defaultOrdering.add(0);
        defaultOrdering.add(6);
        defaultOrdering.add(3);

        desending.add(5);
        desending.add(4);
        desending.add(2);
        desending.add(1);
        desending.add(0);
        desending.add(6);
        desending.add(3);

        //defualt ordering
        Iterator<Integer> iterator = defaultOrdering.iterator();
        Iterator<Integer> iterator2 = defaultOrdering.iterator();
        while (iterator.hasNext()){
            System.out.println("iterator.next() = " + iterator.next());
        }
        System.out.println(defaultOrdering);

        for (int i = 0; i < defaultOrdering.size()+i; i++) {
            System.out.println(defaultOrdering.poll());
        }

        //descending PQ
        System.out.println("Desending");
        for (int i = 0; i < desending.size()+i; i++) {
            System.out.println(desending.poll());
        }



    }
}
