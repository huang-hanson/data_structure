package com.hanson.java_concurren.lock.unfairlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author hanson
 * @date 2024/3/26 20:37
 */
public class TestThread {
    private ReentrantLock reentrantLock = new ReentrantLock(false);
    private void testLock() {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(runnable);
            thread.setName("线程" + (i + 1));
            thread.start();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void testUnfair() {
        try {
            Thread.sleep(500);
            while (true) {
                System.out.println("+++++++我抢...+++++++");
                boolean isLock = reentrantLock.tryLock();
                if (isLock) {
                    System.out.println("========我抢到锁了!!!===========");
                    reentrantLock.unlock();
                    return;
                }
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + " 启动了，准备获取锁");
                reentrantLock.lock();
                System.out.println(Thread.currentThread().getName() + " 获取了锁");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
            }
        }
    };

    public static void main(String args[]) {
        TestThread testThread = new TestThread();
        testThread.testLock();
        testThread.testUnfair();
    }
}

