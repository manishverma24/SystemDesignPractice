package CacheImplDesignPatterns;

public class LRUEvictionStrategy implements EvictionStrategy {

    @Override
    public void onAccess(Node node, CacheStorage cacheStorage) {
        cacheStorage.removeNode(node);
        cacheStorage.addToFront(node);
    }

    @Override
    public void onEvict(CacheStorage storage) {
        Node lruNode = storage.getTail().prev;
        storage.remove(lruNode.key);
        storage.removeNode(lruNode);
    }
}
