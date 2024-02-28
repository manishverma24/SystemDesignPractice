import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
public class RateLimiter implements Throttle, Enter {
    private final int maxRequestsPerSecond;
    private final AtomicInteger currentTokens;
    private final ScheduledExecutorService scheduler;
    private long lastRefillTime = System.currentTimeMillis();
    private final long refillIntervalSeconds;

    public RateLimiter(int maxRequestsPerSecond, int refillIntervalSeconds) {
        if (maxRequestsPerSecond <= 0 || refillIntervalSeconds <= 0) {
            throw new IllegalArgumentException("Max requests must be greater than 0");
        }
        this.maxRequestsPerSecond = maxRequestsPerSecond;
        this.currentTokens = new AtomicInteger(maxRequestsPerSecond);
        this.refillIntervalSeconds = refillIntervalSeconds * 1000L;
        this.scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(this::refillTokens, 0, refillIntervalSeconds, TimeUnit.SECONDS);
    }

    public synchronized void shutdown() {
        scheduler.shutdown();
        try {
            if (!scheduler.awaitTermination(5, TimeUnit.SECONDS)) {
                scheduler.shutdownNow();
            }
        } catch (InterruptedException e) {
                throw new RuntimeException(e);
        }
    }

    @Override
    public synchronized void refillTokens() {
        long elapsedTime = System.currentTimeMillis() - lastRefillTime;
        lastRefillTime = System.currentTimeMillis();
        int tokensToAdd = (int) Math.min(elapsedTime / refillIntervalSeconds * maxRequestsPerSecond, maxRequestsPerSecond);
        currentTokens.addAndGet(tokensToAdd);
    }

    @Override
    public synchronized boolean allowRequest() {
        if (currentTokens.get() > 0) {
                currentTokens.decrementAndGet();
                return true;
        }
        return false;
    }
}
