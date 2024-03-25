package com.hanson.jvm;

import java.util.ArrayList;

/**
 * @author hanson
 * @date 2024/3/19 20:58
 */
public class HeapTest {

    byte[] a = new byte[1024 * 100];

    public static void main(String[] args) throws InterruptedException {
        ArrayList<HeapTest> heapTests = new ArrayList<>();

        while (true) {
            heapTests.add(new HeapTest());
            Thread.sleep(10);
        }
    }
}
