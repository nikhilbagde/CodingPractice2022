package CompanyCompetetions.Amazon.Interview1;

/**
 * Created by Nikhil on 4/6/2017 2:48 PM.
 */
public class LRU<K, V> extends java.util.LinkedHashMap<K, V> {
    private int cacheSize;

    public LRU(int cacheSize) {
        super(16, 0.75f, true);
        this.cacheSize = cacheSize;
    }

    public static void main(String[] args) {
        LRU<String, String> lruCache = new LRU(8);
        lruCache.put("1", "A");
        lruCache.put("2", "B");
        lruCache.put("3", "C");
        lruCache.put("4", "D");
        lruCache.put("5", "E");
        lruCache.put("6", "F");
        lruCache.put("7", "G");
        lruCache.put("8", "H");

        for (Object entry : lruCache.entrySet()) {
            System.out.println(entry);
        }
        lruCache.put("9", "I");
        lruCache.put("10", "J");

        System.out.println("Later");
        for (Object entry : lruCache.entrySet()) {
            System.out.println(entry);
        }
    }

    protected boolean removeEldestEntry(java.util.Map.Entry<K, V> entry) {
        return size() > cacheSize;
    }
}
