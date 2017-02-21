package DataStructure.MyDataStructures.MyIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *  for (ElementType variable : collection) {
        loopBody // may refer to ”variable”
    }
    //same as

    Iterator<ElementType> iter = collection.iterator( );
    while (iter.hasNext( )) {
        ElementType variable = iter.next( );
        loopBody // may refer to ”variable”
    }
 * Created by Nikhi on 12/15/2016 3:22 PM.
 */
public class DriverIterator<T> implements Iterator<T> {
    private Iterator iterator;
    private T nextElement;
    private boolean hasCalledNextYet = false;

    public DriverIterator(Iterator iterator) {
        this.iterator = iterator;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);

        DriverIterator it = new DriverIterator(list.iterator());
        Iterator newIterator = it.getIterator();
    }

    public boolean hasNext() {
        return iterator.hasNext();
    }

    public T next() {
        nextElement = iterator.hasNext() ? (T) iterator.next() : null;
        hasCalledNextYet = true;
        return nextElement;
    }

    public T peek() {
        return hasCalledNextYet ? nextElement : null;
    }

    public Iterator getIterator() {
        return iterator;
    }

    static class IteratorTest {
    }
}
