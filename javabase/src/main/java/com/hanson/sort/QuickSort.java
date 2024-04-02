package com.hanson.sort;

/**
 * 快速排序
 *
 * @author hanson
 * @date 2024/3/29 11:35
 */
public class QuickSort {


    public static void main(String[] args) {
        int[] arr = {5, 2, 3, 1, 4};
        // 对数组进行冒泡排序
        QuickSort(arr, 0, arr.length - 1);
        // 打印排序后的数组
        System.out.println("排序后的数组：");
        for (int num : arr) {
            System.out.println(num + " ");
        }
    }

    public static void QuickSort(int[] arr, int l, int r) {
        int left = 0, right = arr.length - 1, key = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= key) {
                --right;
            }

            //如果值小于 key分界值 交换
            arr[left] = arr[right];
            while (left < right && arr[left] < key) {
                ++left;
            }

            //如果值大于 key分界值 交换
            arr[right] = arr[left];
        }

        arr[left] = key;

        //递归左右部分进行快排
        if (left > 0) {
            QuickSort(arr, 0, left);
        }
        if (left + 1 < right) {
            QuickSort(arr, left + 1, right);
        }
    }
}
