package DataStructure.MyDataStructures.Map.Iterfaces;

/**
 * Created by Nikhi on 12/26/2016 1:06 PM.
 */
public interface MyMap<K,V> {
    int size();
    boolean isEmpty();

    V get(K key);
    V put(K key, V value);
    V remove(K key);

    Iterable<K> keySet();
    Iterable<V> values();
    Iterable<MyEntry<K,V>> entrySet();
}
