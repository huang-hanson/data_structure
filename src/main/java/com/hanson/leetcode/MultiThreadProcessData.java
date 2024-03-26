package com.hanson.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @author hanson
 * @date 2024/3/12 19:39
 */
public class MultiThreadProcessData {
    /*
     * 有一个List<String>中有N条数据（N比较大，比如100万条），每一天的内容都是0-9的一个随机数，写一个方法并发m个线程，
     * 每个线程批量处理n条数据，将每个数字转换成对应的中文，处理完毕再继续获取n条数据进行处理，直到原数据集所有数据处理完毕，并最终返回转换完的新数据集
     * */

    /**
     * 将数字转换成中文字符
     *
     * @param value 传入数据字
     * @return 转换中文后的值
     */
    private static String convertToChinese(String value) {
        String[] chinese = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
        return chinese[Integer.parseInt(value)];
    }

    /**
     * 数据处理线程类
     */
    static class DataProcessor implements Callable<List<String>> {
        private List<String> data;

        public DataProcessor(List<String> data) {
            this.data = data;
        }


        @Override
        public List<String> call() throws Exception {
            List<String> result = new ArrayList<>();
            for (String value : data) {
                // 将数字转换成中文，并加入计算结果
                result.add(convertToChinese(value));
            }
            return result;
        }
    }

    /**
     * 生成全是0-9数据的大小为size的数据集
     *
     * @param size 数据集大小
     * @return 数据集
     */
    private static List<String> generateOriginalData(int size) {
        Random random = new Random();
        List<String> data = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            data.add(String.valueOf(random.nextInt(10)));
        }
        return data;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 创建原始数据集List，模拟100万条数据
        List<String> originalData = generateOriginalData(1000000);

        // 设置并发数
        int m = 10;

        // 设置每个线程处理的数据条数
        int n = 1000;

        // 使用线程池创建m个线程
        ExecutorService executorService = Executors.newFixedThreadPool(m);

        // 使用 CountDownLatch来等待所有所有的线程完成任务
        CountDownLatch countDownLatch = new CountDownLatch(m);

        // 创建结果的集合
        List<String> result = new ArrayList<>();

        // 提交任务给线程池
        for (int i = 0; i < m; i++) {
            int startIndex = i * n;
            int endIndex = Math.min((i + 1) * n, originalData.size());
            List<String> subList = originalData.subList(startIndex, endIndex);

            Future<List<String>> future = executorService.submit(new DataProcessor(subList));

            // 将结果存储在结果集
            result.addAll(future.get());

            countDownLatch.countDown();
        }

        // 等待所有线程完成任务
        countDownLatch.await();

        // 关闭线程池
        executorService.shutdown();

        //输出转换后的数据集
        System.out.println("转换后的数据集：");
        for (String value : result){
            System.out.println(value);
        }
        System.out.println("数组长度：" + originalData.size());
    }
}

