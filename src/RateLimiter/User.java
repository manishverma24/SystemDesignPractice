package RateLimiter;

import java.util.HashMap;
import java.util.Map;

public class User {
    Map<Integer, RateLimiter> bucket;

    public User(int id, RateLimiter rateLimiterType) {
        this.bucket = new HashMap<>();
        bucket.put(id, rateLimiterType);
    }

    void accessApplication(int id) {
        if (bucket.get(id).grantAccess())
            System.out.println("Access granted for user "+id);
        else
            System.out.println("Access denied for user "+id);
    }
}
