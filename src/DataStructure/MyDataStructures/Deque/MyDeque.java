package DataStructure.MyDataStructures.Deque;

/**
 * The deque abstract data type is more general than both the stack and the queue
    ADTs. The extra generality can be useful in some applications. For example, we
    described a restaurant using a queue to maintain a waitlist. Occasionally, the first
    person might be removed from the queue only to find that a table was not available;
    typically, the restaurant will reinsert the person at the first position in the queue. It
    may also be that a customer at the end of the queue may grow impatient and leave
    the restaurant. (We will need an even more general data structure if we want to
    model customers leaving the queue from other positions.)
 * Created by Nikhi on 12/14/2016 11:07 PM.
 */
public interface MyDeque<E> {
    //update methods
    public abstract void addFirst(E e);
    public abstract void addLast(E e);
    public abstract E removeFirst();
    public abstract E removeLast();
    //accessor methods
    public abstract E peekFirst();
    public abstract E peekLast();
    public abstract int size();
    public abstract boolean isEmpty();

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