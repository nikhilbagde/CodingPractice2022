package DataStructure.MyDataStructures.PriorityQueues.Concrete;

import java.util.Comparator;

/** For convenience, we also allow a default priority queue to instead rely on the
     natural ordering for the given keys (assuming those keys come from a comparable
     class). In that case, we build our own instance of a DefaultComparator class
 * Created by Nikhi on 12/22/2016 4:30 PM.
 */
public class DefaultComparator <E> implements Comparator <E> {
    @Override
    public int compare(E o1, E o2) throws ClassCastException{
        return ((Comparable<E>) o1).compareTo(o2);
    }
}
