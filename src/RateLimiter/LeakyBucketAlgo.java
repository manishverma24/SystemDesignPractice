package RateLimiter;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;

public class LeakyBucketAlgo implements RateLimiter {

    private final Queue<Long> bucket;
    private final int capacity;
    private final int rate;

    public LeakyBucketAlgo(int capacity, int refillRate) {
        this.capacity = capacity;
        this.rate = refillRate;
        this.bucket = new LinkedList<>();

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (!bucket.isEmpty()) {
                    bucket.poll();
                }
            }
        }, 1000 / rate, 1000 / rate);
    }

    public synchronized boolean addToken() {
        System.out.print(bucket.size()+", ");
        if (bucket.size() < capacity) {
            bucket.offer(System.currentTimeMillis());
            return true;
        }
        return false;
    }

    @Override
    public boolean grantAccess() {
        return addToken(); // OK status code
    }
}
