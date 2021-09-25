package com.learning.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class E04CollectionEx {
	public static void main(String[] args) {
		List<Person> list = Arrays.asList(
			new Person("Charles", "Dickens", 60), 
			new Person("Lewis", "Carroll", 42),
			new Person("Thomas", "Carlyle", 51), 
			new Person("Charlotte", "Bronte", 45),
			new Person("Matthew", "Arnold", 39)
		);

		// Step 1 : Sort list by last name
		// 1) Java 7 approach
		Collections.sort(list, new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return o1.getLastName().compareTo(o2.getLastName());
			}
		});
		// 2) Java 8 Approach
		Collections.sort(list, (p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));

		// Step 2 : Print all elements
		System.out.println("Printing all Persons : ");
		printConditionally(list, p -> true,p -> System.out.println(p));

		// Step 3 : Print Conditionally
		System.out.println("\n Java 7 : Printing Person with last name beginning with C : ");
		printConditionally(list, new Predicate<Person>() {
			@Override
			public boolean test(Person person) {
				return person.getLastName().startsWith("C");
			}
		}, new Consumer<Person>() {
			@Override
			public void accept(Person p) {
				System.out.println(p.getLastName());
			}
		});

		System.out.println("\n Java 8 : Printing Person with last name beginning with C : ");
		printConditionally(list, (person) -> person.getLastName().startsWith("C"),p -> System.out.println(p.getLastName()));

		System.out.println("\n Java 7 : Printing Person with first name beginning with C : ");
		printConditionally(list, new Predicate<Person>() {
			@Override
			public boolean test(Person person) {
				return person.getFirstName().startsWith("C");
			}
		}, new Consumer<Person>() {
			@Override
			public void accept(Person p) {
				System.out.println(p.getFirstName());
			}
		});

		System.out.println("\n Java 8 : Printing Person with first name beginning with C : ");
		printConditionally(list, (person) -> person.getFirstName().startsWith("C"),p -> System.out.println(p.getFirstName()));
	}

	// Note : Predicate and Consumer are standard FunctionalInterface
	static void printConditionally(List<Person> list, Predicate<Person> predicate, Consumer<Person> consumer) {
		for (Person person : list) {
			if (predicate.test(person)) {
				// System.out.println(person); // OR
				consumer.accept(person); // we can print all details or only few based on passed behavior.
			}
		}
	}
}

class Person {
	private String firstName;
	private String lastName;
	private int age;

	public Person(String firstName, String lastName, int age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return firstName + "     " + lastName + "     " + age;
	}

}
