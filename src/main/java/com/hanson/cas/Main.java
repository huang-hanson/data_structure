package com.hanson.cas;

/**
 * @author hanson
 * @date 2024/3/19 1:28
 */
public class Main {

    public static void main(String[] args) {
        Counter counter = new Counter();

        // 创建两个线程，分别对计数器进行增量更新
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        thread1.start();
        thread2.start();

        try {
            // 等待两个线程执行完成
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 输出最终计数器的值
        System.out.println("Final count: " + counter.getCount());

    }

}
