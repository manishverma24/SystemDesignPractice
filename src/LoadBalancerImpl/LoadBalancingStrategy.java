package LoadBalancerImpl;

import java.util.List;

public interface LoadBalancingStrategy {

    Server getServer(List<Server> servers, Request request);
}
