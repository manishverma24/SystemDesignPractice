package CacheImpl;

import java.util.HashMap;

public class LRUCacheWithTTL {

    public static class CacheNode {
        int key;
        int value;
        CacheNode prev;
        CacheNode next;
        long timeStamp;

        public CacheNode(int key, int value) {
            this.key = key;
            this.value = value;
            timeStamp = System.currentTimeMillis();
        }
    }

    private HashMap<Integer, CacheNode> cache;
    private int capacity;
    private CacheNode head;
    private CacheNode tail;
    private long ttlInMillis;

    public LRUCacheWithTTL(int capacity, long ttlInMillis) {
        this.capacity = capacity;
        this.ttlInMillis = ttlInMillis;
        cache = new HashMap<>();
        head = new CacheNode(0, 0);
        tail = new CacheNode(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            CacheNode node = cache.get(key);
            if (isExpired(node)) {
                cache.remove(key);
                remove(node);
                return -1; // Cache entry has expired
            }
            remove(node);
            addToFront(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            CacheNode node = cache.get(key);
            node.value = value;
            remove(node);
            addToFront(node);
        } else {
            if (cache.size() == capacity) {
                cache.remove(tail.prev.key);
                remove(tail.prev);
            }
            CacheNode newNode = new CacheNode(key, value);
            cache.put(key, newNode);
            addToFront(newNode);
        }
    }

    private boolean isExpired(CacheNode node) {
        return System.currentTimeMillis() - node.timeStamp > ttlInMillis;
    }

    private void remove(CacheNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToFront(CacheNode node) {
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
        node.timeStamp = System.currentTimeMillis();
    }
}
