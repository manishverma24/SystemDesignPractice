package CacheImplDesignPatterns;

public class CacheMain {

    public static void main(String[] args) {

        // LRU Cache
        LRUCache cache = LRUCache.getInstance(3, new LRUEvictionStrategy());
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1)); // returns 1
        cache.put(3, 3);
        cache.put(4, 4);
        System.out.println(cache.get(2)); // return -1;
        System.out.println(cache.get(3)); // return 3;
    }
}
