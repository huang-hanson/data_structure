package com.hanson.dijkstra;

/**
 * @author hanson
 * @date 2024/3/25 18:02
 */
public class DijkstraTest {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] weight = {
                {0, 10, 12, -1, -1, -1},
                {-1, 0, -1, 16, 25, -1},
                {4, 3, 0, 12, -1, 8},
                {-1, -1, -1, 0, 7, -1},
                {-1, -1, -1, -1, 0, -1},
                {-1, -1, -1, 2, -1, 0}};
        String[] str = {"V1", "V2", "V3", "V4", "V5", "V6"};
        int len = str.length;
        Dijkstra dijkstra = new Dijkstra(len);
        //依次让各点当源点，并调用dijkstra函数
        for (int i = 0; i < str.length; i++) {
            dijkstra.dijkstra(weight, str, i);
        }
    }
}
