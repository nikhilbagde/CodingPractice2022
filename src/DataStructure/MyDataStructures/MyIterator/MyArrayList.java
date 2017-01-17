package DataStructure.MyDataStructures.MyIterator;

import DataStructure.MyDataStructures.List.MyList;

import java.util.Iterator;
import java.util.NoSuchElementException;

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
    private class MyArrayIterator implements Iterator{
        private int j = 0;                  //index of next element to report
        private boolean removable = false;  // can remove be called this time ?
        @Override
        public boolean hasNext() {
            return (j< size);               //accessing private variable size, Hence good idea to have this as a inner class
        }

        @Override
        public E next() throws NoSuchElementException{
            if(j == size) throw new NoSuchElementException("No next Element!");
            removable = true;           // This element subsequently can be removed
            return data[j++];           // ++ b/c post increment j once call is done for next call for next()
        }

        public void remove() throws IllegalStateException{
            if(!removable) throw new IllegalStateException("Nothing to remove");
            MyArrayList.this.remove(j-1);           //calling remove from MyArrayList class. Implemented above
            j--;                                         //next element has been shifted to one position left after move call
            removable = false;                           //do not allow removable again until next is called.
        }
    }//Iterator class ends here

    //continuing MyArrayList class
    public Iterator<E> iterator(){
        return new MyArrayIterator();
    }
}
