package CacheImplDesignPatterns;

public interface EvictionStrategy {
    void onAccess(Node node, CacheStorage cacheStorage);

    void onEvict(CacheStorage storage);
}
