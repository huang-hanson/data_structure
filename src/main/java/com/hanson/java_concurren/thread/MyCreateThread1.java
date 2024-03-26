package com.hanson.java_concurren.thread;

/**
 * @author hanson
 * @date 2024/3/27 1:23
 */
public class MyCreateThread1 {

    static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " thread running by extends...");
        }
    }

    private static void startThreadExtends(){
        MyThread t2 = new MyThread();
        t2.start();
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " thread start ....");
        startThreadExtends();
    }
}
