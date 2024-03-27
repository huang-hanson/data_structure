package com.hanson.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author hanson
 * @date 2024/3/19 1:28
 */
public class Counter {

    private AtomicInteger count;

    public Counter() {
        count = new AtomicInteger(0); // 初始化计数器为0
    }

    public int getCount() {
        return count.get(); // 获取当前计数器的值
    }

    public boolean increment() {
        int oldValue = count.get(); // 获取当前计数器的值作为旧值
        int newValue = oldValue + 1; // 计算新值

        // 使用CAS操作尝试更新计数器的值
        // compareAndSet方法会比较当前值与旧值，如果相等则替换为新值，返回true；否则返回false
        return count.compareAndSet(oldValue, newValue);
    }

}
