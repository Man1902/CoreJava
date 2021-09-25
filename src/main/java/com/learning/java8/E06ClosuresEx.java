package com.learning.java8;

public class E06ClosuresEx {
	public static void main(String[] args) {
		int a = 10;
		int b = 20; // must be final or effectively final

		process(a, i -> System.out.println(i + b));
	}

	private static void process(int i, Process p) {
		p.process(i);
	}
}

interface Process {
	void process(int i);
}
