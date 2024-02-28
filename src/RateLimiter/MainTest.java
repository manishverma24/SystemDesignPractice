package RateLimiter;

public class MainTest {
    public static void main(String[] args) {

        RateLimiter tokenRateLimiter = RateLimiterFactory.getRateLimiter(RateLimiterType.TOKEN_BUCKET);
        RateLimiter leakyRateLimiter = RateLimiterFactory.getRateLimiter(RateLimiterType.LEAKY_BUCKET);
        RateLimiter fixedRateLimiter = RateLimiterFactory.getRateLimiter(RateLimiterType.FIXED_WINDOW);
        RateLimiter slidingRateLimiter = RateLimiterFactory.getRateLimiter(RateLimiterType.SLIDING_WINDOW_LOG);

        for (int i=1; i<=8; i++) {
            User user = new User(i, slidingRateLimiter);
            user.accessApplication(i);
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i=1; i<=8; i++) {
            User user = new User(i, slidingRateLimiter);
            user.accessApplication(i);
        }
    }
}
