public interface Throttle {
    boolean allowRequest() throws InterruptedException;
}
