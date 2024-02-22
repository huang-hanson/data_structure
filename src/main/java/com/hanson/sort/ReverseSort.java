package com.hanson.sort;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
* 倒排序
*
* 倒排序（逆序）是指按照相反的顺序排列元素，通常是从大到小或从后向前排序。

  将数组 [5, 2, 3, 1, 4] 进行倒排序，即从大到小排序，可以使用以下步骤：
* */
public class ReverseSort {

    /*
    * 对数组进行排序。
      将排序后的数组进行反转。
    * */
    public static void main(String[] args) {
        Integer[] arr = {5, 2, 3, 1, 4};

        // 对数组进行排序
        Arrays.sort(arr);
        System.out.println(Arrays.asList(arr));

        // 将排序后的数组进行反转
        List<Integer> list = Arrays.asList(arr);
        Collections.reverse(list);

        // 打印倒排序后的数组
        System.out.println("倒排序后的数组：" + list);

    }
}
