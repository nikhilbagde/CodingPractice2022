package DataStructure.MyDataStructures.Deque;

import java.util.ArrayDeque;

/**
 * Created by Nikhi on 12/15/2016 12:12 AM.
 */
public class Client {

    public static void main(String[] args) {
        //Using Build it.
        ArrayDeque<Integer> circularArrayDeque = new ArrayDeque<>();
        circularArrayDeque.addLast(5);                  System.out.println(circularArrayDeque);
        circularArrayDeque.addFirst(3);                  System.out.println(circularArrayDeque);
        circularArrayDeque.addFirst(7);                  System.out.println(circularArrayDeque);
        circularArrayDeque.addLast(5);                  System.out.println(circularArrayDeque);
        circularArrayDeque.addLast(5);                  System.out.println(circularArrayDeque);
        circularArrayDeque.addLast(5);                  System.out.println(circularArrayDeque);

        //Using my own MyDeque Implementation
        MyCircularArrayDeque<Integer> circularArrayDeque1 = new MyCircularArrayDeque(10);
        circularArrayDeque1.addLast(5);                 System.out.println(circularArrayDeque1);
        circularArrayDeque1.addFirst(3);                 System.out.println(circularArrayDeque1);
        circularArrayDeque1.addFirst(7);                 System.out.println(circularArrayDeque1);
        circularArrayDeque1.peekFirst();                 System.out.println(circularArrayDeque1);
        circularArrayDeque1.removeLast();                 System.out.println(circularArrayDeque1);
        circularArrayDeque1.size();                 System.out.println(circularArrayDeque1);
        circularArrayDeque1.removeLast();                 System.out.println(circularArrayDeque1);
        circularArrayDeque1.removeFirst();                 System.out.println(circularArrayDeque1);
        circularArrayDeque1.addFirst(6);                 System.out.println(circularArrayDeque1);
        circularArrayDeque1.peekLast();                 System.out.println(circularArrayDeque1);
        circularArrayDeque1.addFirst(8);                 System.out.println(circularArrayDeque1);
        circularArrayDeque1.isEmpty();                 System.out.println(circularArrayDeque1);
        circularArrayDeque1.peekLast();                 System.out.println(circularArrayDeque1);

        //Study of arrays.CopyTo

    }
}

/*
Example
Method      Return      Value D
addLast(5)      –       (5)
addFirst(3)     –       (3, 5)
addFirst(7)     –       (7, 3, 5)
first( )        7       (7, 3, 5)
removeLast( )   5       (7, 3)
size( )         2       (7, 3)
removeLast( )   3       (7)
removeFirst( )  7       ( )
addFirst(6)     –       (6)
last( )         6       (6)
addFirst(8)     –       (8, 6)
isEmpty( )      false   (8, 6)
last( )         6       (8, 6)
*/
