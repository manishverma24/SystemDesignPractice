package RateLimiter;

import java.util.Timer;
import java.util.TimerTask;

public class FixedWindowCounterAlgo implements RateLimiter {
    private int counter;
    private int capacity;
    private int windowSizeMillis;

    public FixedWindowCounterAlgo(int capacity, int windowSizeMillis) {
        this.counter = 0;
        this.capacity = capacity;
        this.windowSizeMillis = windowSizeMillis;

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                counter = 0;
            }
        }, windowSizeMillis, windowSizeMillis);
    }

    @Override
    public boolean grantAccess() {
        System.out.print(System.currentTimeMillis()+", ");
        if (counter < capacity) {
            counter++;
            return true;
        } else
            return false;
    }
}
