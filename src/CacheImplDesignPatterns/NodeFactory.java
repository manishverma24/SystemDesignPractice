package CacheImplDesignPatterns;

public class NodeFactory {
    public static Node createNode(int key, int value) {
        return new Node(key, value);
    }
}
