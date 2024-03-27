package com.hanson.datastructure.robin_strategy;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * 轮询分为随机 (Random),轮询 (RoundRobin),一致性哈希 (ConsistentHash),哈希 (Hash),加权（Weighted）
 *
 * @author hanson
 * @date 2024/3/13 22:22
 */
public class RandomLoadBalancer {
    // 随机 (Random)：随机算法简单地从可用的服务器列表中随机选择一个服务器来处理请求。
    private List<String> servers;

    private Random random;

    public RandomLoadBalancer(List<String> servers) {
        this.servers = servers;
        this.random = new Random();
    }

    public String chooseServer() {
        int index = random.nextInt(servers.size());
        return servers.get(index);
    }

    public static void main(String[] args) {
        List<String> servers = Arrays.asList("Server1", "Server2", "Server3");
        RandomLoadBalancer randomLoadBalancer = new RandomLoadBalancer(servers);

        for (int i = 0; i < 10; i++) {
            String server = randomLoadBalancer.chooseServer();
            System.out.println("Request " + (i + 1) + " sent to: " + server);
        }
    }
}
