package com.learning.java8;

public class E01Greeter {
	public void greet(Greeting greeting) {
		greeting.peform();
	}

	public static void main(String[] args) {
		E01Greeter greeter = new E01Greeter();
		// Approach 1 :
		Greeting greetingImpl = new GreetingImpl();
		greeter.greet(greetingImpl);

		// Approach 2
		Greeting greeting = new Greeting() {
			@Override
			public void peform() {
				System.out.println("Hello World from greeting Annonumous Impl");
			}
		};
		greeter.greet(greeting);

		// Approach 3
		Greeting greetingLamda = () -> System.out.println("Hello World Using greeting Lamda Expression");
		greeter.greet(greetingLamda);

		// Approach 4
		greeter.greet(() -> System.out.println("Hello World Using Inline Lamda Expression"));
	}
}

@FunctionalInterface // Optional 
interface Greeting {
	void peform();
}

class GreetingImpl implements Greeting {
	@Override
	public void peform() {
		System.out.println("Hello World from GreetingImpl");
	}
}
