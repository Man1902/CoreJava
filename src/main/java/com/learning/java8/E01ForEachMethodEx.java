package com.learning.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class E01ForEachMethodEx {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        // 1) traversing with Consumer interface implementation
        PrintCollectionValueConsumer consumer = new PrintCollectionValueConsumer();
        list.forEach(consumer);

        // 2) takes Consumer as an input using Lamda expression
        list.forEach(p -> System.out.println(p));

        // 3) traversing through forEach method of Iterable with anonymous class
        list.forEach(new Consumer<Integer>() {
            public void accept(Integer number) {
                System.out.println("forEach anonymous class Value::" + number);
            }
        });
    }
}

//Consumer implementation that can be reused
class PrintCollectionValueConsumer implements Consumer<Integer> {
    public void accept(Integer number) {
        System.out.println("Consumer impl Value :" + number);
    }
}