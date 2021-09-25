package com.learning.java8;

public class E08MethodReferenceEx {
	public static void main(String[] args) {
		// Thread t = new Thread(() -> printMessage()); // OR
		Thread t = new Thread(E08MethodReferenceEx::printMessage);
		t.start();
	}

	public static void printMessage() {
		System.out.println("Hello Learner");
	}

}
