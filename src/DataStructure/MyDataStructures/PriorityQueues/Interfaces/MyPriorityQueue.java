package DataStructure.MyDataStructures.PriorityQueues.Interfaces;

/**
 * Created by Nikhi on 12/22/2016 4:18 PM.
 */
public interface MyPriorityQueue<K,V>{
    int size();
    MyEntry <K,V> min();
    MyEntry <K,V> removeMin();
    MyEntry <K,V> insert(K key, V value);
    boolean isEmpty();
}
