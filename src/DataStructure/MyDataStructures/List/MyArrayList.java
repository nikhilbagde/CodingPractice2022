package DataStructure.MyDataStructures.List;

import java.util.Arrays;

/**
 * Created by Nikhi on 12/15/2016 9:44 AM.
 */
public class MyArrayList<E> implements MyList<E> {
    public static final int CAPACITY = 16;
    private E[] data;
    private int size = 0;
    MyArrayList(){
        this(CAPACITY);
    }
    public MyArrayList(int capacity){
        data = (E[]) new Object[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        checkIndex(index, size);
        return data[index];
    }

    @Override
    public E set(int index, E e) throws IndexOutOfBoundsException {
        checkIndex(index, size);
        E old = data[index];
        data[index] = e;
        return old;
    }

    @Override
    public void add(int index, E e) throws IndexOutOfBoundsException {
        checkIndex(index, size + 1);              //notice for add, we using size+1     //index = size allowed
        if(size == data.length) {
            //throw new IllegalStateException("List is Full");              // check current size == data.length
            resize(data.length *2);                                 //not 2*size :P
        }
        for (int rightMost = size-1; rightMost >=index ; rightMost--) {                  //start shirting by rightmost.
                data[rightMost+1] = data[rightMost];
        }
        data[index] = e;
        size++;
    }

    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        checkIndex(index , size);
        E oldValue = data[index];
        for (int leftMost = index; leftMost < size-1; leftMost++) {                 //shift element to left to fill hole.
            data[index] = data[index+1];
        }
        data[size-1] = null;            //set last element to null
        size--;
        return oldValue;
    }

    protected void checkIndex(int i,  int size)throws IndexOutOfBoundsException{
        if(i < 0 || i >= size) throw new IndexOutOfBoundsException("Illegal index " + i);
    }
    protected void resize(int capacity){
        E[] newArray = (E[]) new Object[capacity];
        System.arraycopy(data, 0, newArray, 0, data.length);
        data = newArray;
    }
}
