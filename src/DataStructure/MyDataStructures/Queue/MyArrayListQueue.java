package DataStructure.MyDataStructures.Queue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nikhi on 12/14/2016 7:01 AM.
 */
public class MyArrayListQueue<E> implements MyQueue<E> {
    private List<E> list;
    MyArrayListQueue(){
        list = new ArrayList<>();
    }

    @Override
    public void enqueue(E e) {
        list.add(e);
    }

    @Override
    public E dequeue() {
        return list.remove(0);
    }

    @Override
    public E first() {
        return list.get(0);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean offer(E e) {
        return this.list.add(e);
    }

    @Override
    public E poll() {
        return this.list.remove(0);
    }
}
