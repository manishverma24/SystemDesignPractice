package RateLimiter;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class SlidingWindowCounter implements RateLimiter {
    Queue<Integer> slidingWindow;
    private final int capacity;
    int time;

    public SlidingWindowCounter(int capacity, int time) {
        this.capacity = capacity;
        this.time = time;
        this.slidingWindow = new ConcurrentLinkedQueue<>();
    }

    @Override
    public boolean grantAccess() {
        long currentTime = System.currentTimeMillis();
        updateQueue(currentTime);
        if (slidingWindow.size() < capacity) {
            slidingWindow.offer((int) currentTime);
            return true;
        }
        return false;
    }

    private void updateQueue(long currentTime) {
        if (slidingWindow.isEmpty())
            return;
        long time = (currentTime - slidingWindow.peek()) / 1000;
        while (time >= this.time) {
            slidingWindow.poll();
            if (slidingWindow.isEmpty())
                return;
            time = (currentTime - slidingWindow.peek()) / 1000;
        }
    }
}
