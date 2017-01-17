package DataStructure.MyDataStructures.Map.Concrete;

import DataStructure.MyDataStructures.Map.Abstract.MyAbstractMap;
import DataStructure.MyDataStructures.Map.Iterfaces.MyEntry;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Nikhil on 12/26/2016 2:38 PM 2:07 PM.
 */
public class MyUnSortedTableMap<K, V> extends MyAbstractMap<K, V> {

    private ArrayList<MyMapEntry<K, V>> table = new ArrayList<>();

    /*
    Each of the fundamental methods get(k), put(k, v), and remove(k) requires an
    initial scan of the array to determine whether an entry with key equal to k exists.
    For this reason, we provide a nonpublic utility, findIndex(key), that returns the
    index at which such an entry is found, or −1 if no such entry is found.
     */
    //In arrayList remove function when we remove any item it shifts all elements to left.
    // We don't want that, we instead try to replace last element with removed Item
    // as order does not matter here.
    private int findIndex(K key) {
        for (int j = 0; j < table.size(); j++)
            if (table.get(j).getKey().equals(key))      //cross verify key. iterating over entire arrayList.
                return j;   //return index.
        return -1;  // special value denotes that key was not found
    }

    /**
     * Here in concrete class we will implement
     * 1. size()
     * 2. put()
     * 3. get()
     * 4. remove()  - filling hole with last element value
     * 5. entrySet()
     */


    //1-4
    @Override
    public int size() {
        return table.size();
    }

    @Override
    public V get(K key) {
        int index = findIndex(key);
        if (index == -1) return null;
        return table.get(index).getValue();     //get array index->value
    }

    @Override
    public V put(K key, V value) {
        int index = findIndex(key);
        if (index == -1) {        //key is not present good! So add new entry.
            table.add(new MyMapEntry<K, V>(key, value));       //add new object from protected class from abstract.
        }
        return table.get(index).setValue(value);    //key already exists return new value with/after setting.
    }

    @Override
    public V remove(K key) {
        int index = findIndex(key);
        if (index == -1) return null;

        int n = size();
        V result = table.get(index).getValue(); //table.get(index) ->gives Map Entry -> getValues
        if (index != n - 1) {       //if it's not last element.
            table.set(index, table.get(n - 1));   //replace hole with last element,
            // instead of using arraylist remove where it shifts all element to left
            // which is  not efficient.
            table.remove(n - 1);            //remove last entry of table. as it already moved to the hole.
        }
        return result;
    }

    //5. entrySet()
    private class EntryIterator implements Iterator<MyEntry<K, V>> {
        private int j = 0;              //index of next element to report.

        // Normally we keep removable flag. But we are not supporting it here.
        @Override
        public boolean hasNext() {
            return j < table.size();     //j to keep track if its last value.
        }

        @Override
        public MyEntry<K, V> next() {
            if (j == table.size()) throw new NoSuchElementException();
            return table.get(j++);          //get next value and then increment value of J to keep a track
        }

        public void remove(){
            throw new UnsupportedOperationException();
        }
    }

    private class EntryIterable implements Iterable<MyEntry<K, V>> {
        @Override
        public Iterator<MyEntry<K, V>> iterator() {
            return new EntryIterator();         //calls above class IterATOR one
        }
    }

    @Override
    public Iterable<MyEntry<K, V>> entrySet() {
        return new EntryIterable();             //calls above class IterABLE
    }
}
