package RateLimiter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SlidingWindowLogAlgo implements RateLimiter {

    List<Date> timestamps;
    private int capacity;
    private long windowSizeMillis;

    public SlidingWindowLogAlgo(int capacity, long windowSizeMillis) {
        this.timestamps = new ArrayList<>();
        this.capacity = capacity;
        this.windowSizeMillis = windowSizeMillis;
    }

    @Override
    public synchronized boolean grantAccess() {
        this.timestamps.add(new Date());
        filterPreviousWindow();
        if (this.timestamps.size() > this.capacity) {
            return false;
        }
        return true;
    }

    private synchronized void filterPreviousWindow() {
        Date windowStart = new Date(System.currentTimeMillis() - windowSizeMillis);
        this.timestamps.removeIf(timeStamp -> timeStamp.before(windowStart));
    }
}
