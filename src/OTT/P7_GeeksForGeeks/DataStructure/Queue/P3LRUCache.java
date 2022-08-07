package OTT.P7_GeeksForGeeks.DataStructure.Queue;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Nikhil on 2/26/2017 8:07 AM.
 */

public class P3LRUCache<K, V> extends LinkedHashMap<K, V> {
    private int cacheSize;

    public P3LRUCache(int cacheSize) {
        super(16, 0.75f, true);
        this.cacheSize = cacheSize;
    }

    public static void main(String[] args) {
        P3LRUCache lruCache = new P3LRUCache(7);

        //Elements will be added to cache till it is full.
        //it is doubly linked list, so first element added was the least recently used.
        lruCache.put(1, "1234");
        lruCache.put(2, "234");
        lruCache.put(3, "34");
        lruCache.put(4, "4");
        lruCache.put(5, "5678");
        lruCache.put(6, "567");

        //when tried to add 7th element, this time removeEldestEntry() gets called and it returns true,
        //And olderest entry which was with key 1 is removed. and key with 7 is added.
        lruCache.put(7, "56");


        //if tried to get value by key it doenst affect the least recently used.
        lruCache.get(7);
        lruCache.get(1);

        //But when tried to put same table in cache,
        // then it means that it was accessed second time,
        // it becomes most recently used
        // and this 1 and 4 and 8 would be put at the rear end.
        lruCache.put(1, "1234");
        lruCache.put(4, "4");

        lruCache.put(8, "56");

        for (Object entry : lruCache.entrySet()) {
            System.out.println(entry);
        }
    }

    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() >= cacheSize;
    }
}