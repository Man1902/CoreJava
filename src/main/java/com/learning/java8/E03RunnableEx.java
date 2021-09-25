package com.learning.java8;

public class E03RunnableEx {
	public static void main(String[] args) {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Java 7 approach");
			}
		});
		thread.start();

		Thread lamdaThread = new Thread(() -> System.out.println("Java 8 approach using Lamda Expression"));
		lamdaThread.start();
	}

}
