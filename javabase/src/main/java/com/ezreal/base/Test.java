package com.ezreal.base;

public class Test {

    public static void main(String[] args) {
        // 冒泡排序
        int [] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        bubbleSort(arr);
        //快速排序
        quickSort(arr);

    }

    public static void bubbleSort(int[] arr) {
        // 冒泡排序
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void quickSort(int[] arr) {
        // 快速排序

    }


}
