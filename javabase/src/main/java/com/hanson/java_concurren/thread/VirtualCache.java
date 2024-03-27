package com.hanson.java_concurren.thread;

/**
 * @author hanson
 * @date 2024/3/27 1:38
 */
public class VirtualCache {

    static Integer integer = new Integer(0);

    public static void main(String args[]) {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                integer = 5;
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                integer = 6;
            }
        });

        t1.start();
        t2.start();
    }

}
