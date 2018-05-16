package com.springapp.mvc.testconcurrent;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * fork join 实现快排
 *
 * @author hanchunyang
 * @date 2018/5/16
 **/
public class ForkJoinMergeSort extends RecursiveAction {

    private int start;

    private int end;

    private int[] list;


    public ForkJoinMergeSort(int[] list, int start, int end) {

        this.list = list;
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {

        if (start < end) {
            int center = (end + start) >>> 1;
            ForkJoinMergeSort left = new ForkJoinMergeSort(list, start, center);
            left.fork();
            ForkJoinMergeSort right = new ForkJoinMergeSort(list, center + 1, end);
            right.fork();
            left.join();
            right.join();
            merge(list, start, center, end);
        }
    }

    private void merge(int[] list, int low, int middle, int high) {

        int[] tmpArr = new int[list.length];
        int tmp = low;
        int i = low;
        int lowIndex = low;
        int highIndex = middle + 1;
        while (lowIndex <= middle && highIndex <= high) {
            if (list[lowIndex] < list[highIndex]) {
                tmpArr[i++] = list[lowIndex++];
            } else {
                tmpArr[i++] = list[highIndex++];
            }
        }
        while (lowIndex <= middle) {
            tmpArr[i++] = list[lowIndex++];
        }
        while (highIndex <= high) {
            tmpArr[i++] = list[highIndex++];
        }
        while (tmp <= high) {
            list[tmp] = tmpArr[tmp++];
        }
    }

    public static void main(String[] args) throws Exception {

        int[] list = {1, 2, 4, 2, 5, 3, 8, 7, 6, 9};
        ForkJoinMergeSort search = new ForkJoinMergeSort(list, 0, list.length - 1);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(search);
        for (int i : search.list) {
            System.out.println(i);
        }
    }
}
