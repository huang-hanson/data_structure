package com.hanson.java_concurren.thread;

/**
 * @author hanson
 * @date 2024/3/27 1:28
 */
public class MyCreateThread2 {
    private static void startThreadByImplements(){

        Runnable runnable = () -> System.out.println(Thread.currentThread().getName() + " thread running by implements...");

        Thread t1 = new Thread(runnable);
        t1.start();
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " thread start ....");
        startThreadByImplements();
    }
}

