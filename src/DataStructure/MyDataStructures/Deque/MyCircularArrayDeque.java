package DataStructure.MyDataStructures.Deque;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Created by Nikhil on 12/14/2016 11:18 PM.
 */
public class MyCircularArrayDeque<E> implements MyDeque<E> {
    private static final int CAPACITY =1000;
    private int front, rear, currentSize, size;
    private E[] queue;

    MyCircularArrayDeque(){
        this(CAPACITY);
    }
    MyCircularArrayDeque(int sizein){
        queue = (E[]) new Object[sizein];
        size = sizein;
        this.front = 0;
        rear = size-1;
        currentSize = 0;
    }

    /**
     * Read ArrayDeque
     * @param
     */


    @Override
    public void addFirst(E e) {
        if(currentSize == CAPACITY) {
            System.out.println("MyDeque is Full");
            System.exit(1);
        }
        queue[front] = e;
        front =  (front + 1)% queue.length;
        currentSize++;
    }

    @Override
    public void addLast(E e) {
        if(currentSize == CAPACITY) {
            System.out.println("MyDeque is Full");
            System.exit(1);
        }
        queue[rear] = e;
        rear = ((rear-1) + size)% queue.length;              //-1 because its a circular array.
        currentSize++;
    }

    /**
     * Case when front  = 0, front-1 % size would yield -1%10 = -1,
     * To cover this, add total size, (front-1)+ N % N = -1+10=9%10=9
     * @return E
     */
    @Override
    public E removeFirst() {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        E e = queue[front];
        queue[front] = null;
        front = ((front-1) + size)% queue.length;        //in case when front = 0
        currentSize--;
        return e;
    }

    /**
     * When rear = 9, rear+1%N = 10%10= 0
     * @return E
     */
    @Override
    public E removeLast() {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        E e = queue[rear];
        queue[rear] = null;
        rear = ((rear+1))% queue.length;          //when rear=9 special case
        currentSize--;
        return e;
    }

    @Override
    public E peekFirst() {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return queue[front];
    }

    @Override
    public E peekLast() {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return queue[rear];
    }

    @Override
    public int size() {
        return currentSize;
    }

    @Override
    public boolean isEmpty() {
        return (currentSize == 0);
    }

    @Override
    public String toString() {
        return "CDQ{" +
                "front=" + front +
                ", rear=" + rear +
                ", queue=" + Arrays.toString(queue) +
                '}';
    }
}
