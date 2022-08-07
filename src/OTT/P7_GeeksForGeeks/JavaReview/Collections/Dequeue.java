package OTT.P7_GeeksForGeeks.JavaReview.Collections;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by Nikhil on 1/20/2017 6:27 AM.
 */
public class Dequeue {
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();

        deque.add(1);                                               //1. Elements added : add, offer, addFirst, offerFist, addLast, offerLast
        deque.offer(2);                                         // remove, poll
                                                                    // peek
        deque.addFirst(3);
        deque.addLast(0);

        System.out.println(deque);                                  //2. print dequeue

        Iterator iterator = deque.iterator();                       //3. Natural order iterator
        Iterator iteratorReverse = deque.descendingIterator();      //4. desending order iterator

        while (iterator.hasNext()){
            System.out.print(" " + iterator.next() + " ");
        }
        System.out.println();
        while (iteratorReverse.hasNext()){
            System.out.print(" " + iteratorReverse.next() + " ");
        }



    }
}
