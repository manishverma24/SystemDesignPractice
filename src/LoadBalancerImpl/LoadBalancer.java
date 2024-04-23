package LoadBalancerImpl;

import java.util.ArrayList;
import java.util.List;

public class LoadBalancer {

    private static LoadBalancer instance;
    private List<Server> servers;
    private LoadBalancingStrategy strategy;

    public LoadBalancer() {
        this.servers = new ArrayList<>();
    }

    public static LoadBalancer getInstance() {
        if (instance == null) {
            instance = new LoadBalancer();
        }
        return instance;
    }

    public void addServer(Server server) {
        servers.add(server);
    }

    public void removeServer(Server server) {
        servers.remove(server);
    }

    public Server getServer(Request request) {
        return strategy.getServer(servers, request);
    }

    public void setLoadBalancingStrategy(LoadBalancingStrategy strategy) {
        this.strategy = strategy;
    }

    // Other load balancer operations
}
