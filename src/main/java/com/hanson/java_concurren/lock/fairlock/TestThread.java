package com.hanson.java_concurren.lock.fairlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author hanson
 * @date 2024/3/26 19:52
 */
public class TestThread {

    private ReentrantLock reentrantLock = new ReentrantLock(true);

    private void testLock() {
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(runnable);
            thread.setName("线程" + (i + 1));
            thread.start();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + "启动了，准备获取锁");
                reentrantLock.lock();
                System.out.println(Thread.currentThread().getName() + "获取了锁");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
                System.out.println(Thread.currentThread().getName() + "释放了锁");
            }
        }
    };

    public static void main(String[] args) {
        TestThread testThread = new TestThread();
        testThread.testLock();
    }

}
