package com.learning.java8;

import java.util.function.BiConsumer;

public class E05ExceptionHandlingEx {
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4 };
		int key = 2;
		process(arr, key, (n, k) -> System.out.println(n + k));
		key = 0;
		process(arr, key, wrapperLamda((n, k) -> System.out.println(n / k)));
	}

	private static void process(int arr[], int key, BiConsumer<Integer, Integer> biConsumer) {
		for (int no : arr) {
			biConsumer.accept(no, key);
		}
	}

	private static BiConsumer<Integer, Integer> wrapperLamda(BiConsumer<Integer, Integer> biConsumer) {
		return (n, k) -> {
			try {
				biConsumer.accept(n, k);
			} catch (Exception e) {
				System.out.println("Exception Occured");
			}
		};
	}

}
