package DataStructure.MyDataStructures.Map.Abstract;

import DataStructure.MyDataStructures.Map.Iterfaces.MyEntry;
import DataStructure.MyDataStructures.Map.Iterfaces.MyMap;

import java.util.Iterator;

/**
 * Created by Nikhil on 12/26/2016 1:24 PM.
 * In this abstract class we will implement
 * 1. IsEmpty()
 * 2. Iterable<K> keySet();
 * 3. Iterable<V> values();
 *
 * Leave out, for concrete implementation,
 * 1. size()
 * 2. put(), get(), remove()
 * 3. entrySet()
 */
public abstract class MyAbstractMap <K,V> implements MyMap<K,V> {
    public boolean isEmpty(){
        return size()==0;
    }

    //Map has a MapEntry which implements Entry
    protected static class MyMapEntry<K,V> implements MyEntry<K,V> {
        private K k;
        private V v;

        public MyMapEntry(K key, V value){
            k = key;
            v =  value;
        }

        @Override
        public K getKey() {
            return k;
        }

        @Override
        public V getValue() {
            return v;
        }

        public void setKey(K k) {
            this.k = k;
        }

        public V setValue(V v) {        //Setter of value once done setting return old value.
            V old = v;
            this.v = v;
            return old;
        }
    }

    /**
     * MAP ITERFACE
     * 1. Iterable<K> keySet();
       2. Iterable<V> values();
       3. Iterable<MyEntry<K,V>> entrySet();
     */

    //1. keySet()
    //For public keySet() method  | meaning we want to construct iterator for Key
    // Indirectly we use EntrySet() only and call Iterator on it.
    // And while returning next just return key.
    private class KeyIterator implements Iterator<K>{       //this is keyITERATOR
        private Iterator<MyEntry<K,V>> entries = entrySet().iterator();     //this will be implemented in concrete class.

        public boolean hasNext(){
            return entries.hasNext();       //just call original hasNext of Iterator class from java.util
        }
        public K next(){
            return entries.next().getKey();     //notice it returns key as we are iterating over keys.
        }
        public void remove(){
            throw new UnsupportedOperationException();      //while iterating over keys, we don't support remove operating
        }

    }

    private class KeyIterable implements Iterable<K>{      //iterABLE
        @Override
        public Iterator<K> iterator() {
            return new KeyIterator();               //return object of above class.
        }
    }

    //back to abstract class
    public Iterable<K> keySet(){
        return new KeyIterable();                   //return above class object which return iterABLE class object.
    }

    //2. values()
    private class ValuesIterator implements Iterator<V>{
        private Iterator<MyEntry<K,V>> entries = entrySet().iterator();

        public boolean hasNext(){
            return entries.hasNext();       //just call original hasNext of Iterator class from java.util
        }
        public V next(){
            return entries.next().getValue();     //notice it returns value as we are iterating over values.
        }
        public void remove(){
            throw new UnsupportedOperationException();      //while iterating over values, we don't support remove operating
        }
    }
    private class ValuesIterable implements Iterable<V>{
        @Override
        public Iterator<V> iterator() {
            return new ValuesIterator();
        }
    }
    public Iterable<V> values(){
        return new ValuesIterable();
    }
}
