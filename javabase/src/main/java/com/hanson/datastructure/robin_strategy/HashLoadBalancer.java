package com.hanson.datastructure.robin_strategy;

import java.util.Arrays;
import java.util.List;

/**
 * @author hanson
 * @date 2024/3/13 22:38
 */
public class HashLoadBalancer {

    //哈希 (Hash)：哈希算法根据请求的某些属性（如请求 IP 地址）计算哈希值，并将哈希值映射到可用的服务器列表中。
    private List<String> servers;

    public HashLoadBalancer(List<String> servers) {
        this.servers = servers;
    }

    public String chooseServer(String request) {
        int hashCode = request.hashCode();
        int index = Math.abs(hashCode) % servers.size();
        return servers.get(index);
    }

    public static void main(String[] args) {
        List<String> servers = Arrays.asList("Server1", "Server2", "Server3");
        HashLoadBalancer loadBalancer = new HashLoadBalancer(servers);

        String request1 = "Request1";
        String request2 = "Request2";
        String request3 = "Request3";

        System.out.println("Request " + request1 + " sent to: " + loadBalancer.chooseServer(request1));
        System.out.println("Request " + request2 + " sent to: " + loadBalancer.chooseServer(request2));
        System.out.println("Request " + request3 + " sent to: " + loadBalancer.chooseServer(request3));
    }
}
