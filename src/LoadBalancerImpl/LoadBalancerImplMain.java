package LoadBalancerImpl;

public class LoadBalancerImplMain {
    public static void main(String[] args) {
        // create servers
        Server server1 = new Server("server1");
        Server server2 = new Server("server2");

        // create load balancer
        LoadBalancer loadBalancer = LoadBalancer.getInstance();
        loadBalancer.addServer(server1);
        loadBalancer.addServer(server2);

        // set load balancing strategy
        LoadBalancingStrategy roundRobin = new RoundRobinStrategy();
        loadBalancer.setLoadBalancingStrategy(roundRobin);

        // create requests
        Request request1 = new Request();
        Request request2 = new Request();
        Request request3 = new Request();
        Request request4 = new Request();

        // Get server for request1
        Server selectedServer1 = loadBalancer.getServer(request1);
        System.out.println("Selected server for request1: " + selectedServer1.getId());

        // Get server for request2
        Server selectedServer2 = loadBalancer.getServer(request2);
        System.out.println("Selected server for request2: " + selectedServer2.getId());

        Server selectedServer3 = loadBalancer.getServer(request3);
        System.out.println("Selected server for request3: " + selectedServer3.getId());

        Server selectedServer4 = loadBalancer.getServer(request4);
        System.out.println("Selected server for request3: " + selectedServer4.getId());
    }
}
