package com.hanson.datastructure.robin_strategy;

import java.util.Arrays;
import java.util.List;

/**
 * @author hanson
 * @date 2024/3/13 22:31
 */
public class RoundRobinLoadBalancer {

    // 轮询 (RoundRobin)：轮询算法按照顺序依次选择可用的服务器来处理请求。
    private List<String> servers;
    private int currentIndex;

    public RoundRobinLoadBalancer(List<String> servers) {
        this.servers = servers;
        this.currentIndex = 0;
    }

    public synchronized String chooseServer() {
        String server = servers.get(currentIndex);
        currentIndex = (currentIndex + 1) % servers.size();
        return server;
    }

    public static void main(String[] args) {
        List<String> servers = Arrays.asList("Server1", "Server2", "Server3");
        RoundRobinLoadBalancer loadBalancer = new RoundRobinLoadBalancer(servers);

        for (int i = 0; i < 10; i++) {
            String server = loadBalancer.chooseServer();
            System.out.println("Request " + (i + 1) + " sent to: " + server);
        }
    }

}
