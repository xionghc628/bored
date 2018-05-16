package com.springapp.mvc.testconcurrent;

import java.util.concurrent.*;

/**
 * fork join 实现快排
 *
 * @author hanchunyang
 * @date 2018/5/16
 **/
public class ForkJoinQuickSort extends RecursiveAction {

    private int start;

    private int end;

    private int[] list;


    public ForkJoinQuickSort(int[] list, int start, int end) {

        this.list = list;
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {

        if (start < end) {
            int middle = getMiddle(list, start, end);
            ForkJoinQuickSort left = new ForkJoinQuickSort(list, start, middle - 1);
            left.fork();
            ForkJoinQuickSort right = new ForkJoinQuickSort(list, middle + 1, end);
            right.fork();
            left.join();
            right.join();
        }
    }

    private int getMiddle(int[] list, int low, int high) {

        int tmp = list[low];
        while (low < high) {
            while (low < high && tmp <= list[high]) {
                high--;
            }
            list[low] = list[high];
            while (low < high && tmp >= list[low]) {
                low++;
            }
            list[high] = list[low];
        }
        list[low] = tmp;
        return low;
    }

    public static void main(String[] args) throws Exception{
        int[] list = {1,2,4,2,5,3,8,7,6,9};
        ForkJoinQuickSort search = new ForkJoinQuickSort(list,0,list.length-1);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(search);
        for (int i:search.list) {
            System.out.println(i);
        }
    }
}
