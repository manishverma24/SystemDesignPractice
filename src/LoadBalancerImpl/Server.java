package LoadBalancerImpl;

public class Server {

    private String id;
    private boolean isHealthy;

    public Server(String id) {
        this.id = id;
        this.isHealthy = true;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isHealthy() {
        return isHealthy;
    }

    public void setHealthy(boolean healthy) {
        isHealthy = healthy;
    }
}
