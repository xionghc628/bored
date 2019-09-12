package com.springapp.mvc.sort;

import com.alibaba.fastjson.JSON;

import java.util.Random;

/*******************************************************
 * Copyright (C) 2019 iQIYI.COM - All Rights Reserved
 *
 * <p>This file is part of bored.
 * Unauthorized copy of this file, via any medium is strictly prohibited.
 * Proprietary and Confidential.
 *
 * <p>Author(s): xionghuacheng
 * Created: 2019/9/11
 *******************************************************/
public class QuickSort {

    public static void main(String[] args) {
        int[] ints = new int[100];
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            ints[i] = random.nextInt(500);
        }
        sort(ints, 0, ints.length - 1);
        System.out.println(JSON.toJSONString(ints));
    }

    private static void sort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int temp = array[start];

        int i = start + 1;
        int j = end;
        while (i < j) {
            int a1 = array[i];
            if (a1 <= temp) {
                i++;
            }
            int a2 = array[j];
            if (a2 >= temp) {
                j--;
            }
            if (a1 > temp && a2 < temp) {
                swap(array, i, j);
            }
        }
        int i1 = array[i];
        if (i1 < temp) {
            swap(array, start, i);
            sort(array, start, i - 1);
            sort(array, j + 1, end);
        } else {
            swap(array, start, i - 1);
            sort(array, start, i - 2);
            sort(array, j, end);
        }
    }


    private static void swap(int[] array, int i, int j) {
        int ss = array[i];
        array[i] = array[j];
        array[j] = ss;
    }


}
