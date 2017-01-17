package DataStructure.MyDataStructures.List;

/**
 * Created by Nikhi on 12/15/2016 9:28 AM 10:59 AM.
 */
public interface MyList<E> {
    int size();
    boolean isEmpty();
    E get(int index) throws IndexOutOfBoundsException;
    E set(int i, E e) throws IndexOutOfBoundsException;     //returns replaced element.
    void add(int i, E e) throws IndexOutOfBoundsException;
    E remove(int i) throws IndexOutOfBoundsException;
}
