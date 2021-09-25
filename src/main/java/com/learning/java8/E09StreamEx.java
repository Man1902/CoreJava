package com.learning.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class E09StreamEx {
	public static void main(String[] args) {
		List<Person> list = Arrays.asList(new Person("Charles", "Dickens", 60), new Person("Lewis", "Carroll", 42),
				new Person("Thomas", "Carlyle", 51), new Person("Charlotte", "Bronte", 45),
				new Person("Matthew", "Arnold", 39));

		// Source -> Intermediate operations -> Terminal operations
		// Note : Intermediate operations are lazy. it will be executed only after terminal operations start
		list.stream().filter(p -> p.getFirstName().startsWith("C")).forEach(p -> System.out.println(p));

		list.parallelStream().filter(p -> p.getLastName().startsWith("C")).forEach(p -> System.out.println(p));

		int c = (int) list.stream().filter(p -> p.getLastName().startsWith("C")).count();
		System.out.println("Count : " + c);

		Stream<Person> stream1 = list.stream();
		stream1 = stream1.filter(person -> person.getAge() > 45);
		stream1 = stream1.filter(person -> person.getFirstName().startsWith("C"));
		System.out.println("Count1 : " + stream1.count());

		

	}
}
