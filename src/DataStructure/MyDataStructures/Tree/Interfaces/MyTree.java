package DataStructure.MyDataStructures.Tree.Interfaces;

import DataStructure.MyDataStructures.PositionalLists.Position;

import java.util.Iterator;

/**
 * Created by Nikhi on 12/16/2016 3:21 AM.
 */
public interface MyTree<E> extends Iterable<E>{
    Position<E> root();
    Position<E> parent(Position<E> p) throws IllegalArgumentException;
    Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException;

    int numChildren(Position<E> p) throws IllegalArgumentException;

    boolean isInternal(Position<E> p) throws IllegalArgumentException;
    boolean isExternal(Position<E> p) throws IllegalArgumentException;
    boolean isRoot(Position<E> p) throws IllegalArgumentException;

    int size();
    boolean isEmpty();
    Iterator<E> iterator();             //return iterator
    Iterable<Position<E>> positions();  //return collections which is iterable.

}
