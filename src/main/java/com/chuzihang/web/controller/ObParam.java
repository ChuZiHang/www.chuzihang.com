package com.chuzihang.web.controller;

import java.util.Arrays;

/**
 * Created by Q_先生 on 2018/11/26.
 */
public class ObParam {

    static class DataClass {
        public int i = 100;
    }

    public static class ObClass {
        public static void main(String[] args) {
            ObClass ob = new ObClass();
            ob.amethod();
        }

        public void amethod() {
            int i = 99;
            DataClass v = new DataClass();
            v.i = 99;
            another(v, i);
            System.out.println("v.i==============" + v.i);
            System.out.println("i================" + i);
        }

        private void another(DataClass v, int i) {
            i = 10;
            v.i = 200;
            DataClass vh = new DataClass();
            v = vh;
            System.out.println(v.i + " " + i);
        }
    }


    /**
     * 快速排序（挖坑法递归）     * @param arr   待排序数组     * @param low   左边界     * @param high  右边界
     */
    public static void sort(int arr[], int low, int high) {
        if (arr == null || arr.length <= 0) {
            return;
        }
        if (low >= high) {
            return;
        }
        int left = low;
        int right = high;
        int temp = arr[left]; //挖坑1：保存基准的值
        while (left < right) {
            while (left < right && arr[right] >= temp) {
                right--;
            }
            arr[left] = arr[right]; //坑2：从后向前找到比基准小的元素，插入到基准位置坑1中
            while (left < right && arr[left] <= temp) {
                left++;
            }
            arr[right] = arr[left]; //坑3：从前往后找到比基准大的元素，放到刚才挖的坑2中
        }
        arr[left] = temp; //基准值填补到坑3中，准备分治递归快排
        System.out.println("Sorting: " + Arrays. toString(arr));
        sort(arr, low, left - 1);
        sort(arr, left + 1, high);
    }
}
