package com.hanson.datastructure.robin_strategy;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author hanson
 * @date 2024/3/13 22:40
 */
public class WeightedLoadBalancer {

    //加权（Weighted）：加权算法根据服务器的权重来决定处理请求的概率，权重越高的服务器被选中的概率越大。
    private List<String> servers;
    private List<Integer> weights;
    private Random random;

    public WeightedLoadBalancer(List<String> servers, List<Integer> weights) {
        this.servers = servers;
        this.weights = weights;
        this.random = new Random();
    }

    public String chooseServer() {
        int totalWeight = 0;
        for (int weight : weights) {
            totalWeight += weight;
        }

        int randomNumber = random.nextInt(totalWeight);
        int cumulativeWeight = 0;
        for (int i = 0; i < servers.size(); i++) {
            cumulativeWeight += weights.get(i);
            if (randomNumber < cumulativeWeight) {
                return servers.get(i);
            }
        }

        // Should never reach here
        return null;
    }

    public static void main(String[] args) {
        List<String> servers = Arrays.asList("Server1", "Server2", "Server3");
        List<Integer> weights = Arrays.asList(3, 2, 1); // 权重分别为3、2、1
        WeightedLoadBalancer loadBalancer = new WeightedLoadBalancer(servers, weights);

        for (int i = 0; i < 10; i++) {
            String server = loadBalancer.chooseServer();
            System.out.println("Request " + (i + 1) + " sent to: " + server);
        }
    }
}
