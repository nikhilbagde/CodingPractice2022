package DataStructure.MyDataStructures.PriorityQueues.Abstract;

import DataStructure.MyDataStructures.PriorityQueues.Concrete.DefaultComparator;
import DataStructure.MyDataStructures.PriorityQueues.Interfaces.MyEntry;
import DataStructure.MyDataStructures.PriorityQueues.Interfaces.MyPriorityQueue;

import java.util.Comparator;

/** This includes a nested
    PQEntry class that implements the public Entry interface.
    Our abstract class also declares and initializes an instance variable, comp, that
    stores the comparator being used for the priority queue. We then provide a protected
    method, compare, that invokes the comparator on the keys of two given entries
 * Created by Nikhi on 12/22/2016 4:36 PM.
 */
public abstract class MyAbstractPriorityQueue <K,V> implements MyPriorityQueue<K,V> {

    //Nested class. TWO ELEMENT OBJECT CLASS.
    protected static class PQEntry<K, V> implements MyEntry<K,V> {
        private K k;    //key
        private V v;    //value

        public PQEntry(K key, V value){
            k = key;
            v = value;
        }
        @Override
        public K getKey() {
            return k;
        }

        @Override
        public V getValue() {
            return v;
        }
        //utilities not exposed as part of the Entry interface.
        protected void setKey(K key) {
            k = key;
        }
        protected void setValue(V value) {
            v = value;
        }
    }

    //instance variables
    private Comparator <K> comp;
    protected MyAbstractPriorityQueue(Comparator<K> c){ comp = c;}
    protected MyAbstractPriorityQueue() {
        //when we dont provide any comparator then just create comparator with default ordering
        // which is defined by their own classes by implementing comparable interface internally
        //So we do same in default comparator class, we get comparable method compareTo implementation
        this(new DefaultComparator<K>());
    }

    //Method for comparing two keys
    //this one is custom compare.
    protected int compare(MyEntry<K,V> a, MyEntry<K,V> b){
        return comp.compare(a.getKey(), b.getKey());
    }

    protected boolean checkKey(K key) throws IllegalArgumentException{
        try{
            return (comp.compare(key,key) == 0);        //see if keys can be compared to itself
        }catch (ClassCastException e){
            throw new IllegalArgumentException("Imcompatible Keys");
        }
    }

    public boolean isEmpty(){
        //this size belong to MyPriority INTERFACE.
        //So every concrete  class would have its own implemented size method.
        return size()==0;
    }

}
