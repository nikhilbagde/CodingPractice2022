package DataStructure.MyDataStructures.PositionalLists;

/**
 * Created by Nikhi on 12/15/2016 1:31 PM.
 */
public interface PositionalList<E> {
    int size();
    boolean isEmpty();
    Position<E> first();                //return a position
    Position<E> last();

    /** Returns the Position immediately before Position p (or null, if p is first). */
    Position<E> before(Position<E> p) throws IllegalArgumentException;
    /** Returns the Position immediately after Position p (or null, if p is last). */
    Position<E> after(Position<E> p) throws IllegalArgumentException;

    Position<E> addFirst(E e);  //returns new position
    Position<E> addLast(E e);   //returns new position
    Position<E> addBefore(E e, Position<E> p) throws IllegalArgumentException;
    Position<E> addAfter(E e, Position<E> p) throws IllegalArgumentException;

    E set(E e, Position<E> p) throws IllegalArgumentException;
    E remove(Position<E> p) throws IllegalArgumentException;

}
