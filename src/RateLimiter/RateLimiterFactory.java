package RateLimiter;

public class RateLimiterFactory {
    public static RateLimiter getRateLimiter(RateLimiterType rateLimiterType) {
        switch (rateLimiterType) {
            case TOKEN_BUCKET:
                return new TokenBucketAlgo(5, 1); // reffill rate is 1 token per second
            case LEAKY_BUCKET:
                return new LeakyBucketAlgo(5, 1); // tokens remove rate is 1 token per second
            case FIXED_WINDOW:
                return new FixedWindowCounterAlgo(5, 1000); // fixed window times
            case SLIDING_WINDOW_LOG:
                return new SlidingWindowLogAlgo(5, 1000); // fixed window times
            default:
                throw new IllegalArgumentException("Invalid rate limit type: "+rateLimiterType);
        }
    }
}
