package CacheImplDesignPatterns;

import java.util.HashMap;

public class CacheStorage {

    private HashMap<Integer, Node> cache;
    private int capacity;
    private Node head;
    private Node tail;

    public CacheStorage(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.head = NodeFactory.createNode(0, 0);
        this.tail = NodeFactory.createNode(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public Node get(int key) {
        return cache.get(key);
    }

    public void put(int key, Node node) {
        cache.put(key, node);
    }

    public void remove(int key) {
        cache.remove(key);
    }

    public boolean isFull() {
        return cache.size() == capacity;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public void addToFront(Node node) {
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    public void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}
