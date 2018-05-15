package com.springapp.mvc.teststream;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Created by xionghuacheng on 2018/5/15.
 */
public class Test {

    public static void main(String[] args) {

//        ArrayList<Integer> integers = Lists.newArrayList(1, 2, 3, 5, 67, 78, 8, 8);
//        integers.stream().filter(t -> (t < 10)).forEach(
//             t -> System.out.println(t)
//        );
//        integers.stream().filter(t -> (t > 10)).forEach(
//                t -> System.out.println(t)
//        );


        long start = System.currentTimeMillis();

        Long sum = LongStream.rangeClosed(0L, 10000000000L)
                .parallel()
                .sum();

        System.out.println(sum);

        long end = System.currentTimeMillis();

        System.out.println("耗费的时间为: " + (end - start)); //2061-2053-2086-18926

    }
}
