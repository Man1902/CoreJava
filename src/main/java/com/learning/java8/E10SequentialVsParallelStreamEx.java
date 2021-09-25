package com.learning.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class E10SequentialVsParallelStreamEx {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 50000; i++) {
            list.add(i);
        }

        Stream<Integer> sequentialStream = list.stream();
        Stream<Integer> parallelStream = list.parallelStream();

        long startTime1 = System.currentTimeMillis();
        sequentialStream
                .filter(no -> no % 2 == 0)
                .collect(Collectors.toList());
        long endTime1 = System.currentTimeMillis();

        long startTime2 = System.currentTimeMillis();
        parallelStream
                .filter(no -> no % 2 == 0)
                .collect(Collectors.toList());
        long endTime2 = System.currentTimeMillis();

        System.out.println("Time taken by Sequential Stream : " + (endTime1 - startTime1) + " ms");
        System.out.println("Time taken by Parallel Stream : " + (endTime2 - startTime2) + " ms");

    }
}
