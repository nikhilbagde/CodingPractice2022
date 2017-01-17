package DataStructure.MyDataStructures.Queue;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * Created by Nikhi on 12/14/2016 11:15 PM.
 */
public class MyCircularArrayQueue<E> implements MyQueue<E> {
    private E[] data;
    private int f;
    private int currentSize = 0;
    private int size;
    private static final int CAPACITY =1000;

    public MyCircularArrayQueue() {
        this(CAPACITY);
    }

    public MyCircularArrayQueue(int sizein) {
        data = (E[]) new Object[sizein];
        this.f = 0;
        size = sizein;
    }

    /**
     * (f + currentSize) % data.length will give next location to add element
     * It is same as having back pointer. But we use circular array hence not needed.
     * Check: Consider capacity =10, currentSize = 3, first element at location 5.
     *          its elements are stored at 5,6, and 7. So next element we computer,
     *          (5+3)%10 = 8 itself.
     * Check: Consider capacity =10, currentSize = 3, first element at location 8.
     *         its elements are stored at 8,9, and 0. So next element we computer,
     *         (8+3)%10 = 1. Next element is stored at index 1.
     * @param e
     * @throws IllegalStateException
     */
    @Override
    public void enqueue(E e) throws IllegalStateException{
        if(currentSize == data.length) throw new IllegalStateException("MyStack is Full");
        int nextIndex = (f + currentSize) % data.length;     //to keep bound index under size of array, (Circular Array)
        data[nextIndex]= e;
        currentSize++;
    }

    @Override
    public E dequeue() {
        if(isEmpty()) throw new NoSuchElementException();
        E value = data[f];
        data[f] = null;
        f = (f+1) % data.length;            //update f and current size, at a time we delete only 1 element hence +1
        currentSize--;
        return value;
    }

    @Override
    public E first() {
        if(isEmpty()) return null;
        return data[f];
    }

    @Override
    public int size() {
        return currentSize;
    }

    @Override
    public boolean isEmpty() {
        return (currentSize == 0);
    }

    public E remove(){
        return dequeue();
    }

    public void add(E e){
        enqueue(e);
    }

    /*
    offer is same a add or enqueue but it only wont throw any exception
     */
    @Override
    public boolean offer(E e){
        if(currentSize == data.length) return false;            //notice it returns true or false.
        int nextlocation = (f + currentSize) % data.length;     //to keep bound index under size of array, (Circular Array)
        data[nextlocation]= e;
        currentSize++;
        return true;
    }
    /*
    poll is same as dequeue and remove but only difference is, it does not throw any exception
    but instead return null
     */
    @Override
    public E poll(){
        if(isEmpty()) return null;          //this is the only different in returning null
        E value = data[f];
        data[f] = null;
        f = (f+1) % data.length;            //update f and current size, at a time we delete only 1 element hence +1
        currentSize--;
        return value;
    }

    @Override
    public String toString() {
        return "MyCircularArrayQueue{" +
                "data=" + Arrays.toString(data) +
                ", f=" + f +
                ", currentSize=" + currentSize +
                ", size=" + size +
                '}';
    }
}
