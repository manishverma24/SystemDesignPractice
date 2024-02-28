package RateLimiter;

import java.util.Timer;
import java.util.TimerTask;

public class TokenBucketAlgo implements RateLimiter {
    private int tokens;
    private final int capacity;

    public TokenBucketAlgo(int capacity, int refillRate) {
        this.tokens = capacity;
        this.capacity = capacity;

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                add(refillRate);
            }
        }, 1000, 1000);
    }

    private synchronized void add(int refillRate) {
        int refilledTokensCount = this.tokens + refillRate;
        this.tokens = Math.min(refilledTokensCount, this.capacity);
    }

    @Override
    public synchronized boolean grantAccess() {
        if (this.tokens > 0) {
            this.tokens--;
            return true;
        }
        return false;
    }
}
