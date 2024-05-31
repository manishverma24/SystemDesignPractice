package CacheImplDesignPatterns;

/*
* Use a doubly linkedList, whenever a items add or get, it will be
* added to head, and the older element will be in tail, whenever cache
* is full, we remove the tail element to create a space for new element
* */
public class LRUCache {

    private static LRUCache instance;
    private CacheStorage cacheStorage;
    private EvictionStrategy evictionStrategy;

    private LRUCache(int capacity, EvictionStrategy evictionStrategy) {
        this.cacheStorage = new CacheStorage(capacity);
        this.evictionStrategy = evictionStrategy;
    }

    public static LRUCache getInstance(int capacity, EvictionStrategy evictionStrategy) {
        if (instance == null) {
            instance = new LRUCache(capacity, evictionStrategy);
        }
        return instance;
    }

    public int get(int key) {
        Node node = cacheStorage.get(key);
        if (node != null) {
            evictionStrategy.onAccess(node, cacheStorage);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node node = cacheStorage.get(key);
        if (node != null) {
            node.value = value;
            evictionStrategy.onAccess(node, cacheStorage);
        } else {
            if (cacheStorage.isFull()) {
                evictionStrategy.onEvict(cacheStorage);
            }
            Node newNode = NodeFactory.createNode(key, value);
            cacheStorage.put(key, newNode);
            cacheStorage.addToFront(newNode);
        }
    }
}
