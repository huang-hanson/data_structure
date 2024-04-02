package com.hanson.sort;

/*
* 下面是冒泡排序的基本步骤：

    1.从列表的第一个元素开始，依次比较相邻的两个元素。
    2.如果第一个元素比第二个元素大（或者小，根据排序顺序决定），则交换它们的位置。
    3.继续向后遍历，重复执行步骤 1 和步骤 2，直到列表末尾。
    4.重复以上步骤，每次遍历都将最大（或者最小）的元素“浮动”到合适的位置。
    5.当没有任何元素需要交换时，排序完成。
* */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {5, 2, 3, 1, 4};
        // 对数组进行冒泡排序
        bubbleSort(arr);
        // 打印排序后的数组
        System.out.println("排序后的数组：");
        for (int num : arr) {
            System.out.println(num + " ");
        }
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
