package DataStructure.MyDataStructures.Tree.Concrete;

import DataStructure.MyDataStructures.PositionalLists.Position;
import DataStructure.MyDataStructures.Tree.Abstract.MyAbstractTree;
import DataStructure.MyDataStructures.Tree.Interfaces.MyBinaryTree;

import java.util.Iterator;

/**
 * Created by Nikhi on 12/16/2016 4:34 AM.
 */
public class MyAbstractBinaryTree <E> extends MyAbstractTree<E> implements MyBinaryTree<E> {
    @Override
    public Position<E> root() {
        return null;
    }

    @Override
    public Position<E> parent(Position<E> p) throws IllegalArgumentException {
        return null;
    }

    @Override
    public Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException {
        return null;
    }

    @Override
    public int numChildren(Position<E> p) throws IllegalArgumentException {
        return 0;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Iterable<Position<E>> positions() {
        return null;
    }

    @Override
    public Position<E> right(Position<E> p) throws IllegalArgumentException {
        return null;
    }

    @Override
    public Position<E> left(Position<E> p) throws IllegalArgumentException {
        return null;
    }

    @Override
    public Position<E> sublings(Position<E> p) throws IllegalArgumentException {
        return null;
    }
}
