package com.hanson.datastructure.robin_strategy;

import java.util.Arrays;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author hanson
 * @date 2024/3/13 22:34
 */
public class ConsistentHashLoadBalancer {
    // 一致性哈希 (ConsistentHash)：一致性哈希算法将每个请求通过哈希函数映射到一个固定的范围内的值，然后根据这个值选择对应的服务器处理请求。
    private SortedMap<Integer, String> ring = new TreeMap<>();
    private List<String> servers;

    public ConsistentHashLoadBalancer(List<String> servers) {
        this.servers = servers;
        for (String server : servers) {
            int hash = server.hashCode();
            ring.put(hash, server);
        }
    }

    public String chooseServer(String request) {
        int hash = request.hashCode();
        SortedMap<Integer, String> tailMap = ring.tailMap(hash);
        if (tailMap.isEmpty()) {
            return ring.get(ring.firstKey());
        }
        return tailMap.get(tailMap.firstKey());
    }

    public static void main(String[] args) {
        List<String> servers = Arrays.asList("Server1", "Server2", "Server3");
        ConsistentHashLoadBalancer loadBalancer = new ConsistentHashLoadBalancer(servers);

        String request1 = "Request1";
        String request2 = "Request2";
        String request3 = "Request3";

        System.out.println("Request " + request1 + " sent to: " + loadBalancer.chooseServer(request1));
        System.out.println("Request " + request2 + " sent to: " + loadBalancer.chooseServer(request2));
        System.out.println("Request " + request3 + " sent to: " + loadBalancer.chooseServer(request3));
    }
}
